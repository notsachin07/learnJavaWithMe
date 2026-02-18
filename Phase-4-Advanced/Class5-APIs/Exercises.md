# Class 5: Working with APIs - Exercises 🌐

Connect your Java programs to the world through web APIs!

---

## 🟢 Easy Exercises

### Exercise 1: Basic GET Request
**Goal:** Make your first API call.

**Requirements:**
1. Use HttpClient to fetch data from JSONPlaceholder
2. GET `https://jsonplaceholder.typicode.com/posts/1`
3. Print the status code
4. Print the response body

**Expected Output:**
```
Status: 200
Response:
{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere...",
  "body": "quia et suscipit..."
}
```

---

### Exercise 2: Fetch Multiple Items
**Goal:** Get a list of resources.

**Requirements:**
1. GET `https://jsonplaceholder.typicode.com/users`
2. Parse the JSON array
3. Print each user's name and email

**Expected Output:**
```
Users:
1. Leanne Graham - Sincere@april.biz
2. Ervin Howell - Shanna@melissa.tv
3. Clementine Bauch - Nathan@yesenia.net
...
```

---

### Exercise 3: POST Request
**Goal:** Send data to an API.

**Requirements:**
1. POST to `https://jsonplaceholder.typicode.com/posts`
2. Send JSON body: `{"title": "My Title", "body": "Content", "userId": 1}`
3. Print the created resource (includes new ID)

**Expected Output:**
```
Created:
{
  "title": "My Title",
  "body": "Content",
  "userId": 1,
  "id": 101
}
```

---

## 🟡 Medium Exercises

### Exercise 4: Weather API Client
**Goal:** Build a simple weather client.

**Requirements:**
1. Use a free weather API (e.g., wttr.in)
2. Accept city name as input
3. Fetch current weather
4. Display temperature, conditions, humidity

**API:** `https://wttr.in/{city}?format=j1`

**Expected Output:**
```
Weather for: London
Temperature: 15°C
Conditions: Partly cloudy
Humidity: 65%
Wind: 12 km/h
```

---

### Exercise 5: API with Authentication
**Goal:** Handle API keys and headers.

**Requirements:**
1. Create an account for a free API (GitHub API works without key for basic use)
2. GET `https://api.github.com/users/{username}`
3. Add proper User-Agent header (required by GitHub)
4. Parse and display user info

**Expected Output:**
```
GitHub User: octocat
Name: The Octocat
Public Repos: 8
Followers: 6000
Created: 2011-01-25
```

---

### Exercise 6: Error Handler
**Goal:** Robust error handling for APIs.

**Requirements:**
1. Create a method that handles all HTTP status codes
2. Implement retry logic for 5xx errors
3. Parse error messages from JSON responses
4. Test with various endpoints (valid, 404, etc.)

**Implementation:**
```java
public ApiResponse makeRequest(String url) {
    // Handle:
    // - 2xx: Success
    // - 4xx: Client errors (don't retry)
    // - 5xx: Server errors (retry up to 3 times)
    // - Timeouts
    // - Connection failures
}
```

---

## 🔴 Hard Exercises

### Exercise 7: REST API Wrapper
**Goal:** Create a complete API client library.

**Requirements:**
1. Create `RestClient` class with:
   - Base URL configuration
   - Default headers
   - GET, POST, PUT, DELETE methods
   - JSON serialization/deserialization
   - Error handling
   - Timeout configuration

2. Create model classes for JSONPlaceholder:
   - Post, User, Comment

3. Implement typed methods:
   - `getPost(int id)` → Post
   - `getPosts()` → List<Post>
   - `createPost(Post)` → Post
   - `getUser(int id)` → User

**Usage:**
```java
RestClient client = new RestClient("https://jsonplaceholder.typicode.com");

Post post = client.getPost(1);
System.out.println(post.getTitle());

List<Post> posts = client.getPosts();
posts.forEach(p -> System.out.println(p.getId() + ": " + p.getTitle()));

Post newPost = new Post("Title", "Body", 1);
Post created = client.createPost(newPost);
System.out.println("Created with ID: " + created.getId());
```

---

### Exercise 8: Async API Dashboard
**Goal:** Fetch and aggregate data from multiple endpoints concurrently.

**Requirements:**
1. Create dashboard that fetches:
   - User info
   - User's posts
   - Comments on user's posts
   - User's todos
2. Use CompletableFuture for concurrent requests
3. Display aggregated statistics
4. Measure and display total fetch time

**Expected Output:**
```
=== Dashboard for User: Leanne Graham ===

Loading data...
[====================================] 100%
Fetched all data in 245ms

Profile:
  Email: Sincere@april.biz
  Company: Romaguera-Crona

Posts: 10 total
  Most commented: "qui est esse" (5 comments)
  Total comments received: 50

Todos: 20 total
  Completed: 9 (45%)
  Pending: 11 (55%)
```

---

### Exercise 9: API Rate Limiter
**Goal:** Implement rate limiting for API calls.

**Requirements:**
1. Create `RateLimitedClient` class
2. Configure max requests per time window
3. Queue requests that exceed limit
4. Track remaining quota
5. Implement exponential backoff for 429 errors

**Features:**
- Token bucket or sliding window algorithm
- Thread-safe implementation
- Configurable limits
- Stats and monitoring

**Usage:**
```java
RateLimitedClient client = new RateLimitedClient()
    .maxRequests(100)
    .perWindow(Duration.ofMinutes(1))
    .build();

// These should be rate-limited automatically
for (int i = 0; i < 200; i++) {
    client.get("/posts/" + i);
}

// Check stats
System.out.println("Requests made: " + client.getRequestCount());
System.out.println("Requests queued: " + client.getQueuedCount());
System.out.println("Time waited: " + client.getTotalWaitTime());
```

---

## ✅ Bonus Challenge

Create a **CLI Weather & News Aggregator**:

**Features:**
1. **Weather** - Current conditions for any city
2. **News** - Top headlines (use NewsAPI or similar)
3. **Quotes** - Random inspirational quote
4. **GitHub** - Trending repositories
5. **Caching** - Cache responses for 5 minutes
6. **Config** - Save API keys securely

**CLI Interface:**
```
$ java WeatherNews --city "London"

╔═══════════════════════════════════════════════════════╗
║                  Good Morning! ☀️                      ║
╠═══════════════════════════════════════════════════════╣
║ WEATHER - London                                      ║
║   🌡️ Temperature: 18°C (feels like 16°C)             ║
║   ☁️ Conditions: Partly Cloudy                        ║
║   💨 Wind: 15 km/h NW                                 ║
╠═══════════════════════════════════════════════════════╣
║ TOP NEWS                                              ║
║   1. Tech Giants Report Quarterly Earnings            ║
║   2. Climate Summit Reaches Agreement                 ║
║   3. Sports: Championship Finals Tonight              ║
╠═══════════════════════════════════════════════════════╣
║ QUOTE OF THE DAY                                      ║
║   "The only way to do great work is to love what      ║
║    you do." - Steve Jobs                              ║
╠═══════════════════════════════════════════════════════╣
║ TRENDING ON GITHUB                                    ║
║   ⭐ 2.5k  rust-lang/rust                             ║
║   ⭐ 1.8k  microsoft/vscode                           ║
║   ⭐ 1.2k  facebook/react                             ║
╚═══════════════════════════════════════════════════════╝

Data cached. Refresh in 4:32
```

**Technical Requirements:**
- Handle multiple APIs concurrently
- Graceful error handling (show partial data if one API fails)
- Local caching with TTL
- Pretty console output with colors (ANSI codes)
- Configuration file for API keys

---

Happy coding! 💻
