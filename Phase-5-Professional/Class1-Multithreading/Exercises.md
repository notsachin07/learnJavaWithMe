# 🧵 Class 1: Multithreading & Concurrency - Exercises

Practice threading concepts from basic thread creation to advanced concurrent utilities!

---

## 📝 Exercise Format

Each exercise includes:
- **Objective**: What you'll accomplish
- **Requirements**: Specific implementation details
- **Hints**: Helpful tips if you get stuck
- **Expected Output**: Sample program output

---

## 🟢 Easy Exercises

### Exercise 1: Thread Greeter
**Objective:** Create multiple threads that greet the user.

**Requirements:**
1. Create a `GreeterThread` class that extends `Thread`
2. The constructor takes a name and a greeting message
3. The `run()` method prints the greeting 3 times with 500ms delays
4. Create and start 3 different greeter threads
5. Wait for all threads to complete before printing "All greetings done!"

**Hints:**
- Use `Thread.sleep(500)` for delays
- Use `join()` to wait for thread completion
- Handle `InterruptedException` properly

**Expected Output:**
```
Starting greeting threads...
Alice says: Hello!
Bob says: Hi there!
Charlie says: Hey!
Alice says: Hello!
Charlie says: Hey!
Bob says: Hi there!
... (order varies due to threading)
All greetings done!
```

---

### Exercise 2: Number Printer with Runnable
**Objective:** Use Runnable interface to print numbers from different ranges.

**Requirements:**
1. Create a `RangePrinter` class implementing `Runnable`
2. Constructor takes: name, start number, end number
3. `run()` prints numbers from start to end with 200ms delays
4. Create 3 threads printing: 1-5, 10-15, 100-105
5. Start all threads and let them run concurrently

**Hints:**
- Implement `Runnable` instead of extending `Thread`
- Pass the `Runnable` to `new Thread(runnable)`
- Include the printer name in output

**Expected Output:**
```
Counter1: 1
Counter2: 10
Counter3: 100
Counter1: 2
Counter2: 11
Counter3: 101
... (interleaved output)
```

---

### Exercise 3: Thread Information Display
**Objective:** Display various thread properties and states.

**Requirements:**
1. Create a main program that:
   - Displays current (main) thread info: name, ID, priority, state
   - Creates a custom thread that sleeps for 2 seconds
   - Shows the custom thread's state: before start, after start, while sleeping, after completion
2. Use meaningful output formatting

**Hints:**
- Use `Thread.currentThread()` for main thread
- Use `thread.getState()` to check states
- States will be: NEW → RUNNABLE → TIMED_WAITING → TERMINATED

**Expected Output:**
```
=== Main Thread Info ===
Name: main
ID: 1
Priority: 5
State: RUNNABLE

=== Custom Thread Lifecycle ===
Before start: NEW
After start: RUNNABLE
While sleeping: TIMED_WAITING
After completion: TERMINATED
```

---

## 🟡 Medium Exercises

### Exercise 4: Thread-Safe Counter
**Objective:** Fix a race condition using synchronization.

**Requirements:**
1. Create a `Counter` class with an `int count` field
2. Add `increment()` and `getCount()` methods
3. First, demonstrate the race condition with 5 threads each incrementing 10000 times
4. Then fix it using the `synchronized` keyword
5. Compare results: without sync (incorrect) vs with sync (50000)

**Hints:**
- Make both methods `synchronized`
- Use `join()` to wait for all threads
- Print expected vs actual count

**Expected Output:**
```
=== Without Synchronization ===
Expected: 50000
Actual: 47823  (varies, usually less)
Lost updates: 2177

=== With Synchronization ===
Expected: 50000
Actual: 50000
Lost updates: 0 ✓
```

---

### Exercise 5: Bank Transfer with Locks
**Objective:** Implement thread-safe money transfers between accounts.

**Requirements:**
1. Create a `BankAccount` class with:
   - `balance` field
   - `deposit(amount)` method
   - `withdraw(amount)` method (returns boolean)
   - `getBalance()` method
2. Use `ReentrantLock` for thread safety
3. Create 2 accounts with $1000 each
4. Perform 10 concurrent transfers of $100 between accounts
5. Verify total money remains $2000

**Hints:**
- Always use try-finally with locks
- Lock before checking balance
- A transfer is a withdraw from one + deposit to another

**Expected Output:**
```
Initial: Account A=$1000, Account B=$1000, Total=$2000

Performing 10 random transfers...
Transfer $100: A -> B (A=$900, B=$1100)
Transfer $100: B -> A (A=$1000, B=$1000)
...

Final: Account A=$800, Account B=$1200, Total=$2000 ✓
```

---

### Exercise 6: ExecutorService Task Manager
**Objective:** Use thread pools to manage multiple tasks.

**Requirements:**
1. Create a fixed thread pool with 3 threads
2. Submit 10 tasks that each:
   - Print task number and thread name when starting
   - Sleep for a random time (500-1500ms)
   - Print task number when completing
3. Use proper shutdown sequence
4. Measure and print total execution time

**Hints:**
- Use `Executors.newFixedThreadPool(3)`
- Use `System.currentTimeMillis()` for timing
- Call `shutdown()` then `awaitTermination()`

**Expected Output:**
```
Starting 10 tasks with 3-thread pool...

Task 1 started on pool-1-thread-1
Task 2 started on pool-1-thread-2
Task 3 started on pool-1-thread-3
Task 1 completed (took 823ms)
Task 4 started on pool-1-thread-1
...

All tasks completed!
Total time: 4521ms
(Compare: sequential would take ~10000ms)
```

---

## 🔴 Hard Exercises

### Exercise 7: Parallel Sum with Callable
**Objective:** Calculate a large sum using parallel computation.

**Requirements:**
1. Calculate the sum of numbers 1 to 10,000,000
2. Split the work into 4 parallel tasks using `Callable<Long>`
3. Each task sums its portion (e.g., 1-2.5M, 2.5M-5M, etc.)
4. Collect results using `Future<Long>`
5. Combine partial sums for final result
6. Compare time: single-threaded vs parallel

**Hints:**
- Use `Executors.newFixedThreadPool(4)`
- Each `Callable` returns the sum of its range
- Sum of 1 to n = n * (n + 1) / 2 (for verification)

**Expected Output:**
```
Calculating sum of 1 to 10,000,000...

Single-threaded:
  Result: 50000005000000
  Time: 45ms

Parallel (4 threads):
  Task 1 (1-2500000): 3125001250000
  Task 2 (2500001-5000000): 9375002500000
  Task 3 (5000001-7500000): 15625003750000
  Task 4 (7500001-10000000): 21874997500000
  Result: 50000005000000
  Time: 15ms

Speedup: 3.0x
```

---

### Exercise 8: Producer-Consumer with BlockingQueue
**Objective:** Implement a producer-consumer pattern.

**Requirements:**
1. Create a `BlockingQueue` with capacity 5
2. Create 2 producer threads that each produce 10 items
3. Create 3 consumer threads that consume items
4. Producers create items with random delays (100-300ms)
5. Consumers process items with random delays (200-500ms)
6. Use poison pills (special value) to signal completion
7. Track and display statistics: items produced, consumed, queue size

**Hints:**
- Use `LinkedBlockingQueue<String>` or `ArrayBlockingQueue`
- `put()` blocks if queue is full
- `take()` blocks if queue is empty
- Use a special "DONE" string as poison pill

**Expected Output:**
```
Starting Producer-Consumer...

[Producer-1] Produced: Item-1
[Producer-2] Produced: Item-1
[Consumer-1] Consumed: Item-1 (queue size: 1)
[Producer-1] Produced: Item-2
[Consumer-2] Consumed: Item-1 (queue size: 1)
...

=== Statistics ===
Total produced: 20
Total consumed: 20
Final queue size: 0
All work completed successfully!
```

---

### Exercise 9: Concurrent Web Scraper Simulation
**Objective:** Simulate fetching data from multiple URLs concurrently.

**Requirements:**
1. Create a list of 10 "URLs" (simulated as strings)
2. Use `ExecutorService` with `invokeAll()` to "fetch" all URLs
3. Each fetch:
   - Takes random time (500-2000ms) to simulate network
   - Has 20% chance of "failure" (throw exception)
   - Returns page "content" (simulated string)
4. Handle failures gracefully - continue with other URLs
5. Display results: successful fetches, failed fetches, total time

**Hints:**
- Use `Callable<String>` for each fetch task
- Use `Random` for simulating delays and failures
- Catch `ExecutionException` when calling `future.get()`

**Expected Output:**
```
Fetching 10 URLs concurrently...

Results:
  ✓ url1.com: "Content from url1" (took 1234ms)
  ✗ url2.com: FAILED (Connection timeout)
  ✓ url3.com: "Content from url3" (took 678ms)
  ...

=== Summary ===
Successful: 8
Failed: 2
Total time: 2156ms (vs ~12000ms sequential)
```

---

## 🏆 Bonus Challenge: Thread Pool Monitor

**Objective:** Build a monitoring system for a thread pool.

**Requirements:**
1. Create a custom `ThreadPoolExecutor` with:
   - Core pool size: 2
   - Maximum pool size: 5
   - Queue capacity: 10
   - Keep-alive time: 60 seconds

2. Create a monitor thread that every second displays:
   - Active threads
   - Pool size
   - Queue size
   - Completed tasks
   - Total tasks

3. Submit 20 tasks with varying execution times

4. Implement graceful shutdown with statistics

**Hints:**
- Use `ThreadPoolExecutor` constructor directly
- Use `LinkedBlockingQueue` for the work queue
- `executor.getActiveCount()`, `getPoolSize()`, `getQueue().size()`
- Use `ScheduledExecutorService` for the monitor

**Expected Output:**
```
=== Thread Pool Monitor ===

[00:01] Active: 2 | Pool: 2 | Queue: 8 | Done: 0/20
[00:02] Active: 2 | Pool: 2 | Queue: 6 | Done: 4/20
[00:03] Active: 3 | Pool: 3 | Queue: 5 | Done: 7/20
[00:04] Active: 5 | Pool: 5 | Queue: 0 | Done: 12/20
[00:05] Active: 3 | Pool: 5 | Queue: 0 | Done: 17/20
[00:06] Active: 0 | Pool: 5 | Queue: 0 | Done: 20/20

=== Final Statistics ===
Total tasks: 20
Completed: 20
Average time per task: 456ms
Total execution time: 6.2s
Peak pool size: 5
```

---

## 📊 Exercise Checklist

| Exercise | Difficulty | Concepts | Completed |
|----------|------------|----------|-----------|
| 1. Thread Greeter | 🟢 Easy | Thread class, start(), join() | ⬜ |
| 2. Number Printer | 🟢 Easy | Runnable interface | ⬜ |
| 3. Thread Info | 🟢 Easy | Thread states, methods | ⬜ |
| 4. Safe Counter | 🟡 Medium | Race conditions, synchronized | ⬜ |
| 5. Bank Transfer | 🟡 Medium | ReentrantLock | ⬜ |
| 6. Task Manager | 🟡 Medium | ExecutorService, thread pools | ⬜ |
| 7. Parallel Sum | 🔴 Hard | Callable, Future, parallel computation | ⬜ |
| 8. Producer-Consumer | 🔴 Hard | BlockingQueue, coordination | ⬜ |
| 9. Web Scraper | 🔴 Hard | invokeAll, exception handling | ⬜ |
| 🏆 Pool Monitor | Bonus | ThreadPoolExecutor, monitoring | ⬜ |

---

## 💡 Tips for Success

1. **Start simple** - Get basic threading working before adding synchronization
2. **Use proper shutdown** - Always shut down ExecutorService
3. **Handle interrupts** - Restore interrupt status or handle appropriately
4. **Test with delays** - Add `sleep()` to make race conditions visible
5. **Print thread names** - Helps debug concurrent execution
6. **Use meaningful names** - Name your threads for easier debugging

---

## 🔧 Common Debugging Strategies

### Race Conditions
```java
// Add delays to expose race conditions
public void increment() {
    int temp = count;
    Thread.sleep(1);  // Makes race condition obvious
    count = temp + 1;
}
```

### Deadlocks
```java
// Use jstack or IDE debugger to detect
// Look for threads in BLOCKED state
// Check lock acquisition order
```

### Thread Leaks
```java
// Always check executor shutdown
if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
    System.out.println("WARNING: Threads still running!");
    executor.shutdownNow();
}
```

---

**Master these exercises to handle any concurrent programming challenge!** 🧵
