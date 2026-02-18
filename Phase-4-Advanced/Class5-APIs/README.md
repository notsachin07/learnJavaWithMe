# Class 5: Working with APIs 🌐

Welcome to **Phase 4, Class 5**! In this final class of Phase 4, you'll learn how to make HTTP requests, parse JSON, and interact with web APIs - connecting your Java programs to the world!

---

## Table of Contents
1. [Why APIs?](#why-apis)
2. [HTTP Basics](#http-basics)
3. [HttpClient (Java 11+)](#httpclient-java-11)
4. [Making GET Requests](#making-get-requests)
5. [Making POST Requests](#making-post-requests)
6. [Parsing JSON](#parsing-json)
7. [Working with JSON Libraries](#working-with-json-libraries)
8. [Error Handling](#error-handling)
9. [Async Requests](#async-requests)
10. [Building a REST Client](#building-a-rest-client)
11. [Best Practices](#best-practices)
12. [Summary](#summary)

---

## Why APIs?

APIs (Application Programming Interfaces) let your programs:
- Fetch weather data
- Get stock prices
- Post to social media
- Access databases
- Integrate with any web service

---

## HTTP Basics

### HTTP Methods

| Method | Purpose |
|--------|---------|
| GET | Retrieve data |
| POST | Create new data |
| PUT | Update existing data |
| DELETE | Remove data |
| PATCH | Partial update |

### HTTP Status Codes

| Code | Meaning |
|------|---------|
| 200 | OK - Success |
| 201 | Created |
| 400 | Bad Request |
| 401 | Unauthorized |
| 404 | Not Found |
| 500 | Server Error |

### Request Structure

```
GET /api/users/123 HTTP/1.1
Host: api.example.com
Authorization: Bearer token123
Content-Type: application/json
```

---

## HttpClient (Java 11+)

Java 11 introduced a modern HTTP client.

### Basic Setup

```java
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

HttpClient client = HttpClient.newHttpClient();
```

### Client Configuration

```java
HttpClient client = HttpClient.newBuilder()
    .version(HttpClient.Version.HTTP_2)
    .connectTimeout(Duration.ofSeconds(10))
    .followRedirects(HttpClient.Redirect.NORMAL)
    .build();
```

---

## Making GET Requests

### Simple GET

```java
HttpClient client = HttpClient.newHttpClient();

HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/users"))
    .GET()
    .build();

HttpResponse<String> response = client.send(
    request, 
    HttpResponse.BodyHandlers.ofString()
);

System.out.println("Status: " + response.statusCode());
System.out.println("Body: " + response.body());
```

### GET with Headers

```java
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .header("Accept", "application/json")
    .header("Authorization", "Bearer your-token-here")
    .GET()
    .build();
```

### GET with Query Parameters

```java
String baseUrl = "https://api.example.com/search";
String query = URLEncoder.encode("java programming", StandardCharsets.UTF_8);
String url = baseUrl + "?q=" + query + "&limit=10";

HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create(url))
    .GET()
    .build();
```

---

## Making POST Requests

### POST with JSON Body

```java
String json = """
    {
        "name": "John Doe",
        "email": "john@example.com"
    }
    """;

HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/users"))
    .header("Content-Type", "application/json")
    .POST(HttpRequest.BodyPublishers.ofString(json))
    .build();

HttpResponse<String> response = client.send(
    request,
    HttpResponse.BodyHandlers.ofString()
);
```

### POST with Form Data

```java
String formData = "username=john&password=secret";

HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/login"))
    .header("Content-Type", "application/x-www-form-urlencoded")
    .POST(HttpRequest.BodyPublishers.ofString(formData))
    .build();
```

### PUT and DELETE

```java
// PUT - Update
HttpRequest putRequest = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/users/123"))
    .header("Content-Type", "application/json")
    .PUT(HttpRequest.BodyPublishers.ofString(updatedJson))
    .build();

// DELETE
HttpRequest deleteRequest = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/users/123"))
    .DELETE()
    .build();
```

---

## Parsing JSON

### Manual JSON Parsing (Simple)

For simple JSON, you can parse manually:

```java
// Simple JSON: {"name": "John", "age": 30}
String json = response.body();

// Extract value (basic approach)
int nameStart = json.indexOf("\"name\":\"") + 8;
int nameEnd = json.indexOf("\"", nameStart);
String name = json.substring(nameStart, nameEnd);
```

### Using Regular Expressions

```java
import java.util.regex.*;

String json = "{\"id\": 123, \"name\": \"John\"}";

Pattern pattern = Pattern.compile("\"name\":\\s*\"([^\"]+)\"");
Matcher matcher = pattern.matcher(json);
if (matcher.find()) {
    String name = matcher.group(1);  // "John"
}
```

---

## Working with JSON Libraries

### Option 1: Gson (Google)

Add to your project (or download the JAR):
```
// Maven: com.google.code.gson:gson:2.10.1
```

```java
import com.google.gson.Gson;

// Define a class matching JSON structure
class User {
    String name;
    String email;
    int age;
}

// Parse JSON to object
Gson gson = new Gson();
User user = gson.fromJson(jsonString, User.class);
System.out.println(user.name);

// Convert object to JSON
String json = gson.toJson(user);
```

### Option 2: Jackson

```java
import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper mapper = new ObjectMapper();

// JSON to Object
User user = mapper.readValue(jsonString, User.class);

// Object to JSON
String json = mapper.writeValueAsString(user);
```

### Parsing JSON Arrays

```java
// JSON: [{"name": "Alice"}, {"name": "Bob"}]
Gson gson = new Gson();
User[] users = gson.fromJson(jsonArray, User[].class);

// Or as a List
Type listType = new TypeToken<List<User>>(){}.getType();
List<User> userList = gson.fromJson(jsonArray, listType);
```

### Parsing Nested JSON

```java
// JSON: {"user": {"name": "John", "address": {"city": "NYC"}}}
class Address {
    String city;
    String street;
}

class User {
    String name;
    Address address;
}

class Response {
    User user;
}

Response response = gson.fromJson(json, Response.class);
String city = response.user.address.city;  // "NYC"
```

---

## Error Handling

### Handling HTTP Errors

```java
try {
    HttpResponse<String> response = client.send(request, 
        HttpResponse.BodyHandlers.ofString());
    
    int status = response.statusCode();
    
    if (status >= 200 && status < 300) {
        // Success
        processResponse(response.body());
    } else if (status == 401) {
        throw new AuthenticationException("Invalid credentials");
    } else if (status == 404) {
        throw new NotFoundException("Resource not found");
    } else if (status >= 500) {
        throw new ServerException("Server error: " + status);
    } else {
        throw new ApiException("Unexpected status: " + status);
    }
    
} catch (IOException e) {
    System.err.println("Network error: " + e.getMessage());
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
    System.err.println("Request interrupted");
}
```

### Timeout Handling

```java
HttpClient client = HttpClient.newBuilder()
    .connectTimeout(Duration.ofSeconds(5))
    .build();

HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create(url))
    .timeout(Duration.ofSeconds(10))
    .GET()
    .build();

try {
    HttpResponse<String> response = client.send(request,
        HttpResponse.BodyHandlers.ofString());
} catch (HttpTimeoutException e) {
    System.err.println("Request timed out");
}
```

---

## Async Requests

### sendAsync()

```java
CompletableFuture<HttpResponse<String>> future = client.sendAsync(
    request,
    HttpResponse.BodyHandlers.ofString()
);

// Non-blocking - do other work here

// Get result when ready
HttpResponse<String> response = future.join();
```

### With Callbacks

```java
client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
    .thenApply(HttpResponse::body)
    .thenAccept(body -> System.out.println("Response: " + body))
    .exceptionally(e -> {
        System.err.println("Error: " + e.getMessage());
        return null;
    });
```

### Multiple Concurrent Requests

```java
List<URI> urls = List.of(
    URI.create("https://api.example.com/user/1"),
    URI.create("https://api.example.com/user/2"),
    URI.create("https://api.example.com/user/3")
);

List<CompletableFuture<String>> futures = urls.stream()
    .map(uri -> HttpRequest.newBuilder(uri).GET().build())
    .map(req -> client.sendAsync(req, HttpResponse.BodyHandlers.ofString()))
    .map(future -> future.thenApply(HttpResponse::body))
    .collect(Collectors.toList());

// Wait for all to complete
CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

// Get results
List<String> results = futures.stream()
    .map(CompletableFuture::join)
    .collect(Collectors.toList());
```

---

## Building a REST Client

### Generic API Client

```java
public class ApiClient {
    private final HttpClient client;
    private final String baseUrl;
    private final Gson gson;

    public ApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();
        this.gson = new Gson();
    }

    public <T> T get(String endpoint, Class<T> responseType) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + endpoint))
            .header("Accept", "application/json")
            .GET()
            .build();

        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());
        
        checkStatus(response);
        return gson.fromJson(response.body(), responseType);
    }

    public <T> T post(String endpoint, Object body, Class<T> responseType) 
            throws Exception {
        String json = gson.toJson(body);
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + endpoint))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();

        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());
        
        checkStatus(response);
        return gson.fromJson(response.body(), responseType);
    }

    private void checkStatus(HttpResponse<?> response) throws ApiException {
        int status = response.statusCode();
        if (status < 200 || status >= 300) {
            throw new ApiException("Request failed with status: " + status);
        }
    }
}

// Usage
ApiClient api = new ApiClient("https://api.example.com");
User user = api.get("/users/123", User.class);
User created = api.post("/users", newUser, User.class);
```

---

## Best Practices

### ✅ Do

1. **Reuse HttpClient** - Create once, use many times
2. **Set timeouts** - Both connect and request timeouts
3. **Handle errors** - Check status codes, catch exceptions
4. **Use async** for multiple requests
5. **Close resources** - Streams, connections
6. **Validate input** - Sanitize URLs, escape parameters

### ❌ Don't

1. **Don't hardcode credentials** - Use environment variables
2. **Don't ignore SSL** - Validate certificates
3. **Don't block UI** - Use async for GUI applications
4. **Don't retry infinitely** - Implement exponential backoff

### Environment Variables for API Keys

```java
String apiKey = System.getenv("API_KEY");
if (apiKey == null || apiKey.isEmpty()) {
    throw new IllegalStateException("API_KEY environment variable not set");
}

HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create(url))
    .header("Authorization", "Bearer " + apiKey)
    .GET()
    .build();
```

### Retry with Exponential Backoff

```java
public HttpResponse<String> sendWithRetry(HttpRequest request, int maxRetries) 
        throws Exception {
    int attempt = 0;
    while (true) {
        try {
            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
            
            if (response.statusCode() < 500) {
                return response;  // Success or client error
            }
            
            // Server error - retry
            if (++attempt >= maxRetries) {
                return response;
            }
        } catch (IOException e) {
            if (++attempt >= maxRetries) {
                throw e;
            }
        }
        
        // Exponential backoff
        long delay = (long) Math.pow(2, attempt) * 1000;
        Thread.sleep(delay);
    }
}
```

---

## Summary

| Concept | Description |
|---------|-------------|
| HttpClient | Modern HTTP client (Java 11+) |
| HttpRequest | Build requests with URI, headers, body |
| HttpResponse | Contains status code, headers, body |
| GET | Retrieve data |
| POST | Send data to create resources |
| JSON Parsing | Use Gson or Jackson libraries |
| Async | `sendAsync()` for non-blocking requests |
| Error Handling | Check status codes, handle exceptions |

### Quick Reference

```java
// Create client
HttpClient client = HttpClient.newHttpClient();

// GET request
HttpRequest get = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .GET()
    .build();

// POST request
HttpRequest post = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .header("Content-Type", "application/json")
    .POST(HttpRequest.BodyPublishers.ofString(json))
    .build();

// Send and get response
HttpResponse<String> response = client.send(get,
    HttpResponse.BodyHandlers.ofString());

// Parse JSON
Gson gson = new Gson();
MyClass obj = gson.fromJson(response.body(), MyClass.class);
```

---

**Congratulations!** 🎉 You've completed **Phase 4: Advanced Features**!

You now have the skills to:
- Handle exceptions gracefully
- Work with dynamic collections
- Read and write files
- Use functional programming with streams
- Connect to web APIs

**Next Phase: More advanced topics await!** 🚀
