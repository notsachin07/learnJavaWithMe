/**
 * Class 5: Working with APIs - Complete Example
 *
 * Demonstrates:
 * - HttpClient for HTTP requests
 * - GET and POST requests
 * - JSON parsing (manual and with simple helper)
 * - Error handling
 * - Async requests
 *
 * Note: This demo uses JSONPlaceholder (https://jsonplaceholder.typicode.com)
 * a free fake API for testing.
 *
 * How to compile and run:
 * $ javac APIDemo.java
 * $ java APIDemo
 */

import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.regex.*;

public class APIDemo {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final HttpClient client = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10))
        .build();

    public static void main(String[] args) {
        System.out.println("========== WORKING WITH APIs DEMO ==========\n");
        System.out.println("Using JSONPlaceholder API: " + BASE_URL);
        System.out.println();

        // ================================================
        // DEMONSTRATION 1: SIMPLE GET REQUEST
        // ================================================
        System.out.println("1. SIMPLE GET REQUEST");
        System.out.println("─────────────────────────────────────────");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/1"))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body (first 200 chars):");
            String body = response.body();
            System.out.println(body.substring(0, Math.min(200, body.length())) + "...");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 2: GET WITH HEADERS
        // ================================================
        System.out.println("2. GET WITH HEADERS");
        System.out.println("─────────────────────────────────────────");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/1"))
                .header("Accept", "application/json")
                .header("User-Agent", "Java-APIDemo/1.0")
                .GET()
                .build();

            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

            System.out.println("Request Headers sent:");
            request.headers().map().forEach((k, v) -> 
                System.out.println("  " + k + ": " + v));

            System.out.println("\nResponse Status: " + response.statusCode());
            
            // Parse some data manually
            String json = response.body();
            String name = extractJsonValue(json, "name");
            String email = extractJsonValue(json, "email");
            System.out.println("User Name: " + name);
            System.out.println("User Email: " + email);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 3: GET LIST OF ITEMS
        // ================================================
        System.out.println("3. GET LIST OF ITEMS");
        System.out.println("─────────────────────────────────────────");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts?_limit=5"))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

            System.out.println("Fetched posts (showing titles):");
            
            // Simple parsing of array items
            Pattern pattern = Pattern.compile("\"title\":\\s*\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(response.body());
            int count = 0;
            while (matcher.find() && count < 5) {
                System.out.println("  " + (++count) + ". " + matcher.group(1));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 4: POST REQUEST
        // ================================================
        System.out.println("4. POST REQUEST");
        System.out.println("─────────────────────────────────────────");

        try {
            String jsonBody = """
                {
                    "title": "My New Post",
                    "body": "This is the content of my post.",
                    "userId": 1
                }
                """;

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

            System.out.println("POST Status: " + response.statusCode());
            System.out.println("Created resource:");
            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 5: PUT REQUEST (UPDATE)
        // ================================================
        System.out.println("5. PUT REQUEST (UPDATE)");
        System.out.println("─────────────────────────────────────────");

        try {
            String updateJson = """
                {
                    "id": 1,
                    "title": "Updated Title",
                    "body": "Updated content.",
                    "userId": 1
                }
                """;

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/1"))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(updateJson))
                .build();

            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

            System.out.println("PUT Status: " + response.statusCode());
            System.out.println("Updated resource:");
            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 6: DELETE REQUEST
        // ================================================
        System.out.println("6. DELETE REQUEST");
        System.out.println("─────────────────────────────────────────");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/1"))
                .DELETE()
                .build();

            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

            System.out.println("DELETE Status: " + response.statusCode());
            System.out.println("Response: " + (response.body().isEmpty() ? "(empty)" : response.body()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 7: ERROR HANDLING
        // ================================================
        System.out.println("7. ERROR HANDLING");
        System.out.println("─────────────────────────────────────────");

        try {
            // Request non-existent resource
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/99999"))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

            int status = response.statusCode();
            System.out.println("Status Code: " + status);

            if (status == 200) {
                System.out.println("Success!");
            } else if (status == 404) {
                System.out.println("Resource not found (404)");
            } else if (status >= 400 && status < 500) {
                System.out.println("Client error: " + status);
            } else if (status >= 500) {
                System.out.println("Server error: " + status);
            }
        } catch (java.net.ConnectException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 8: ASYNC REQUEST
        // ================================================
        System.out.println("8. ASYNC REQUEST");
        System.out.println("─────────────────────────────────────────");

        HttpRequest asyncRequest = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "/posts/2"))
            .GET()
            .build();

        System.out.println("Sending async request...");
        
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(
            asyncRequest,
            HttpResponse.BodyHandlers.ofString()
        );

        System.out.println("Request sent! Doing other work...");
        
        // Simulate other work
        for (int i = 0; i < 3; i++) {
            System.out.println("  Working... " + (i + 1));
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }

        // Now wait for result
        try {
            HttpResponse<String> response = future.join();
            System.out.println("Async response received!");
            System.out.println("Status: " + response.statusCode());
            String title = extractJsonValue(response.body(), "title");
            System.out.println("Title: " + title);
        } catch (Exception e) {
            System.out.println("Async error: " + e.getMessage());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 9: MULTIPLE CONCURRENT REQUESTS
        // ================================================
        System.out.println("9. MULTIPLE CONCURRENT REQUESTS");
        System.out.println("─────────────────────────────────────────");

        List<Integer> userIds = Arrays.asList(1, 2, 3, 4, 5);
        
        System.out.println("Fetching " + userIds.size() + " users concurrently...");
        long startTime = System.currentTimeMillis();

        List<CompletableFuture<String>> futures = userIds.stream()
            .map(id -> HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/" + id))
                .GET()
                .build())
            .map(req -> client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> extractJsonValue(body, "name")))
            .toList();

        // Wait for all to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long endTime = System.currentTimeMillis();
        System.out.println("All requests completed in " + (endTime - startTime) + "ms");
        
        System.out.println("User names:");
        for (int i = 0; i < futures.size(); i++) {
            System.out.println("  User " + userIds.get(i) + ": " + futures.get(i).join());
        }
        System.out.println();


        // ================================================
        // DEMONSTRATION 10: BUILDING A SIMPLE API CLIENT
        // ================================================
        System.out.println("10. SIMPLE API CLIENT PATTERN");
        System.out.println("─────────────────────────────────────────");

        SimpleApiClient apiClient = new SimpleApiClient(BASE_URL);
        
        try {
            // Get a post
            String post = apiClient.get("/posts/3");
            System.out.println("GET /posts/3:");
            System.out.println("  Title: " + extractJsonValue(post, "title"));

            // Create a post
            String newPost = apiClient.post("/posts", """
                {"title": "Test Post", "body": "Content", "userId": 1}
                """);
            System.out.println("\nPOST /posts:");
            System.out.println("  Created ID: " + extractJsonValue(newPost, "id"));

        } catch (Exception e) {
            System.out.println("API Error: " + e.getMessage());
        }


        System.out.println("\n========== END OF DEMO ==========");
    }


    // =========================================================
    // HELPER METHOD: Extract JSON value
    // =========================================================
    private static String extractJsonValue(String json, String key) {
        // Handle both string and number values
        Pattern stringPattern = Pattern.compile("\"" + key + "\":\\s*\"([^\"]+)\"");
        Matcher stringMatcher = stringPattern.matcher(json);
        if (stringMatcher.find()) {
            return stringMatcher.group(1);
        }
        
        Pattern numberPattern = Pattern.compile("\"" + key + "\":\\s*([0-9]+)");
        Matcher numberMatcher = numberPattern.matcher(json);
        if (numberMatcher.find()) {
            return numberMatcher.group(1);
        }
        
        return "(not found)";
    }
}


// =========================================================
// SIMPLE API CLIENT CLASS
// =========================================================
class SimpleApiClient {
    private final HttpClient client;
    private final String baseUrl;

    public SimpleApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    }

    public String get(String endpoint) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + endpoint))
            .header("Accept", "application/json")
            .GET()
            .build();

        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());
        
        checkStatus(response);
        return response.body();
    }

    public String post(String endpoint, String jsonBody) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + endpoint))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();

        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());
        
        checkStatus(response);
        return response.body();
    }

    private void checkStatus(HttpResponse<?> response) throws Exception {
        int status = response.statusCode();
        if (status < 200 || status >= 300) {
            throw new Exception("HTTP Error: " + status);
        }
    }
}
