# 🧵 Class 1: Multithreading & Concurrency

## Introduction

Welcome to **Multithreading & Concurrency** - one of the most powerful and important concepts in professional Java development! Multithreading allows your programs to execute multiple tasks simultaneously, dramatically improving performance for computationally intensive or I/O-bound applications.

Think of a restaurant kitchen: instead of one chef doing everything sequentially (take order → prep ingredients → cook → plate → serve), multiple chefs work in parallel on different orders. That's multithreading!

---

## 📚 Table of Contents

1. [What is a Thread?](#what-is-a-thread)
2. [Creating Threads](#creating-threads)
3. [Thread States & Lifecycle](#thread-states--lifecycle)
4. [Thread Methods](#thread-methods)
5. [Synchronization](#synchronization)
6. [Thread Safety Problems](#thread-safety-problems)
7. [The synchronized Keyword](#the-synchronized-keyword)
8. [Locks and ReentrantLock](#locks-and-reentrantlock)
9. [ExecutorService & Thread Pools](#executorservice--thread-pools)
10. [Callable and Future](#callable-and-future)
11. [Concurrent Collections](#concurrent-collections)
12. [Common Concurrency Utilities](#common-concurrency-utilities)
13. [Best Practices](#best-practices)
14. [Summary](#summary)

---

## What is a Thread?

A **thread** is the smallest unit of execution within a process. Every Java program has at least one thread - the **main thread** - which starts executing from the `main()` method.

### Process vs Thread

```
┌─────────────────────────────────────────────────┐
│                    PROCESS                       │
│  (Your Java Application - separate memory)       │
│                                                  │
│   ┌─────────┐  ┌─────────┐  ┌─────────┐        │
│   │ Thread 1│  │ Thread 2│  │ Thread 3│        │
│   │ (main)  │  │(worker) │  │(worker) │        │
│   └─────────┘  └─────────┘  └─────────┘        │
│         │            │            │             │
│         └────────────┼────────────┘             │
│                      ▼                          │
│              Shared Memory                      │
│         (heap, static variables)                │
└─────────────────────────────────────────────────┘
```

**Key differences:**
- **Process:** Independent program with its own memory space
- **Thread:** Lightweight execution unit that shares memory with other threads in the same process

### Why Use Multithreading?

1. **Better Performance:** Utilize multiple CPU cores
2. **Responsiveness:** Keep UI responsive while doing background work
3. **Resource Sharing:** Threads share memory, making communication efficient
4. **Simplified Modeling:** Some problems are naturally concurrent (servers handling multiple clients)

---

## Creating Threads

Java provides two primary ways to create threads:

### Method 1: Extending the Thread Class

```java
// Define a thread by extending Thread
class MyThread extends Thread {
    
    private String threadName;
    
    public MyThread(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        // This code runs in the new thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": Count " + i);
            try {
                Thread.sleep(500);  // Pause for 500ms
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted!");
            }
        }
        System.out.println(threadName + " finished!");
    }
}

// Using the thread
public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Main thread starting...");
        
        // Create thread objects
        MyThread thread1 = new MyThread("Thread-A");
        MyThread thread2 = new MyThread("Thread-B");
        
        // Start the threads (calls run() in new thread)
        thread1.start();
        thread2.start();
        
        System.out.println("Main thread continues...");
        
        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All threads completed!");
    }
}
```

**Line-by-line breakdown:**

```java
class MyThread extends Thread {
```
- Creates a new class that inherits from `Thread`
- Your class becomes a thread that can run independently

```java
@Override
public void run() {
```
- Override the `run()` method to define what the thread does
- This is the entry point for the thread's execution

```java
Thread.sleep(500);
```
- Pauses the current thread for 500 milliseconds
- Must handle `InterruptedException`

```java
thread1.start();
```
- **IMPORTANT:** Always use `start()`, not `run()`!
- `start()` creates a new thread and calls `run()` in that thread
- Calling `run()` directly executes in the current thread (no multithreading!)

```java
thread1.join();
```
- Makes the current thread wait until `thread1` finishes
- Useful for coordinating thread completion

### Method 2: Implementing Runnable (Preferred!)

```java
// Define a task by implementing Runnable
class CounterTask implements Runnable {
    
    private String taskName;
    private int count;
    
    public CounterTask(String name, int count) {
        this.taskName = name;
        this.count = count;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(taskName + ": " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

// Using Runnable with Thread
public class RunnableExample {
    public static void main(String[] args) {
        // Create Runnable tasks
        Runnable task1 = new CounterTask("Counter-A", 5);
        Runnable task2 = new CounterTask("Counter-B", 3);
        
        // Wrap in Thread objects
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        
        // Start threads
        thread1.start();
        thread2.start();
    }
}
```

### Why Runnable is Preferred

1. **Separation of concerns:** Task logic is separate from thread mechanics
2. **Flexibility:** Can extend another class while implementing Runnable
3. **Reusability:** Same Runnable can be executed by different threads
4. **Thread pools:** ExecutorService works with Runnable/Callable

### Method 3: Lambda Expressions (Java 8+)

Since `Runnable` is a functional interface (one abstract method), you can use lambdas:

```java
public class LambdaThreadExample {
    public static void main(String[] args) {
        
        // Using lambda for simple tasks
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda thread: " + i);
            }
        });
        
        // Even shorter for single statements
        Thread thread2 = new Thread(() -> System.out.println("Quick task!"));
        
        thread1.start();
        thread2.start();
    }
}
```

---

## Thread States & Lifecycle

A thread goes through various states during its lifetime:

```
                    ┌──────────────┐
                    │     NEW      │
                    │ (created)    │
                    └──────┬───────┘
                           │ start()
                           ▼
                    ┌──────────────┐
              ┌────►│   RUNNABLE   │◄────┐
              │     │ (ready/run)  │     │
              │     └──────┬───────┘     │
              │            │             │
    notify()  │            │             │ sleep done
    /timeout  │            ▼             │ I/O complete
              │     ┌──────────────┐     │
              │     │   WAITING/   │     │
              └─────│ TIMED_WAITING├─────┘
                    │  (blocked)   │
                    └──────────────┘
                           │
                           │ run() completes
                           ▼
                    ┌──────────────┐
                    │  TERMINATED  │
                    │   (dead)     │
                    └──────────────┘
```

### Thread States Explained

| State | Description |
|-------|-------------|
| **NEW** | Thread created but `start()` not called |
| **RUNNABLE** | Thread executing or ready to execute |
| **BLOCKED** | Waiting to acquire a lock |
| **WAITING** | Waiting indefinitely for another thread |
| **TIMED_WAITING** | Waiting for a specified time |
| **TERMINATED** | Thread has finished execution |

```java
public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        System.out.println("After creation: " + thread.getState());  // NEW
        
        thread.start();
        System.out.println("After start: " + thread.getState());     // RUNNABLE
        
        Thread.sleep(500);
        System.out.println("While sleeping: " + thread.getState());  // TIMED_WAITING
        
        thread.join();
        System.out.println("After completion: " + thread.getState()); // TERMINATED
    }
}
```

---

## Thread Methods

### Essential Thread Methods

```java
public class ThreadMethodsDemo {
    public static void main(String[] args) throws InterruptedException {
        
        Thread worker = new Thread(() -> {
            System.out.println("Worker running...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Worker interrupted!");
            }
        }, "WorkerThread");  // Named thread
        
        // Get thread info BEFORE starting
        System.out.println("Name: " + worker.getName());
        System.out.println("ID: " + worker.getId());
        System.out.println("Priority: " + worker.getPriority());
        System.out.println("Is Alive: " + worker.isAlive());  // false
        
        worker.start();
        
        System.out.println("Is Alive after start: " + worker.isAlive());  // true
        
        // Current thread info
        Thread main = Thread.currentThread();
        System.out.println("Current thread: " + main.getName());  // main
        
        // Wait for worker to finish
        worker.join();
        System.out.println("Worker finished, isAlive: " + worker.isAlive());  // false
    }
}
```

### Common Thread Methods Reference

| Method | Description |
|--------|-------------|
| `start()` | Begins thread execution |
| `run()` | Contains the code to execute (don't call directly!) |
| `sleep(ms)` | Pauses thread for specified milliseconds |
| `join()` | Waits for thread to complete |
| `join(ms)` | Waits up to specified milliseconds |
| `interrupt()` | Requests thread interruption |
| `isInterrupted()` | Checks if thread was interrupted |
| `isAlive()` | Returns true if thread is running |
| `getName()` / `setName()` | Get/set thread name |
| `getPriority()` / `setPriority()` | Get/set thread priority (1-10) |
| `currentThread()` | Returns reference to current thread |
| `yield()` | Hints scheduler to give other threads a chance |

### Thread Priority

```java
public class PriorityDemo {
    public static void main(String[] args) {
        Thread low = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Low priority: " + i);
            }
        });
        
        Thread high = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("High priority: " + i);
            }
        });
        
        // Set priorities (1 = MIN, 5 = NORMAL, 10 = MAX)
        low.setPriority(Thread.MIN_PRIORITY);     // 1
        high.setPriority(Thread.MAX_PRIORITY);    // 10
        
        low.start();
        high.start();
        
        // Note: Priority is just a HINT to the scheduler
        // Results may vary based on OS and JVM!
    }
}
```

---

## Thread Safety Problems

When multiple threads access shared data, problems can occur:

### Race Condition Example

```java
class BankAccount {
    private int balance = 1000;
    
    public int getBalance() {
        return balance;
    }
    
    // NOT THREAD-SAFE!
    public void withdraw(int amount) {
        if (balance >= amount) {
            // Simulate processing time
            try { Thread.sleep(100); } catch (Exception e) {}
            
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + 
                " withdrew " + amount + ", balance: " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        
        // Two people trying to withdraw at the same time
        Thread person1 = new Thread(() -> account.withdraw(800), "Person1");
        Thread person2 = new Thread(() -> account.withdraw(800), "Person2");
        
        person1.start();
        person2.start();
        
        person1.join();
        person2.join();
        
        // Both might succeed, resulting in negative balance!
        System.out.println("Final balance: " + account.getBalance());
    }
}
```

**The Problem:**
```
Time    Thread 1              Thread 2              Balance
────────────────────────────────────────────────────────────
1       Check: 1000 >= 800?                         1000
2                             Check: 1000 >= 800?   1000
3       Yes! Withdrawing...                         1000
4                             Yes! Withdrawing...   1000
5       balance = 200                               200
6                             balance = -600        -600  ❌
```

Both threads saw the original balance of 1000 and both withdrew!

### Common Thread Safety Issues

1. **Race Condition:** Multiple threads read-modify-write the same data
2. **Data Race:** Unsynchronized access to shared mutable data
3. **Deadlock:** Threads waiting for each other indefinitely
4. **Starvation:** Thread never gets CPU time
5. **Livelock:** Threads keep responding to each other without progress

---

## The synchronized Keyword

The `synchronized` keyword ensures only one thread can execute a block of code at a time:

### Synchronized Method

```java
class SafeBankAccount {
    private int balance = 1000;
    
    public int getBalance() {
        return balance;
    }
    
    // Only ONE thread can execute this at a time
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            try { Thread.sleep(100); } catch (Exception e) {}
            
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + 
                " withdrew " + amount + ", balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + 
                ": Insufficient funds!");
        }
    }
    
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + 
            " deposited " + amount + ", balance: " + balance);
    }
}
```

### Synchronized Block (More Fine-Grained)

```java
class Counter {
    private int count = 0;
    private final Object lock = new Object();  // Lock object
    
    public void increment() {
        // Only this block is synchronized
        synchronized (lock) {
            count++;
        }
        // Other code can run concurrently
        doSomethingElse();
    }
    
    public void decrement() {
        synchronized (lock) {
            count--;
        }
    }
    
    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
    
    private void doSomethingElse() {
        // This runs without holding the lock
    }
}
```

### Synchronized on `this`

```java
class Example {
    public synchronized void method1() {
        // Synchronized on 'this'
    }
    
    public void method2() {
        synchronized (this) {
            // Same as above
        }
    }
}
```

### Static Synchronized Methods

```java
class StaticCounter {
    private static int count = 0;
    
    // Synchronized on the Class object
    public static synchronized void increment() {
        count++;
    }
    
    // Equivalent to:
    public static void decrement() {
        synchronized (StaticCounter.class) {
            count--;
        }
    }
}
```

---

## Locks and ReentrantLock

`ReentrantLock` provides more control than `synchronized`:

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockBankAccount {
    private int balance = 1000;
    private final Lock lock = new ReentrantLock();
    
    public void withdraw(int amount) {
        lock.lock();  // Acquire the lock
        try {
            if (balance >= amount) {
                Thread.sleep(100);
                balance -= amount;
                System.out.println("Withdrew " + amount + 
                    ", balance: " + balance);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();  // ALWAYS unlock in finally!
        }
    }
    
    public boolean tryWithdraw(int amount) {
        // Try to acquire lock without blocking
        if (lock.tryLock()) {
            try {
                if (balance >= amount) {
                    balance -= amount;
                    return true;
                }
            } finally {
                lock.unlock();
            }
        }
        return false;  // Couldn't acquire lock or insufficient funds
    }
    
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
```

### Lock vs synchronized

| Feature | synchronized | ReentrantLock |
|---------|--------------|---------------|
| Ease of use | Simple | More verbose |
| Automatic unlock | Yes | No (need finally) |
| Try lock | No | Yes (`tryLock()`) |
| Timed lock | No | Yes (`tryLock(time, unit)`) |
| Interruptible | No | Yes (`lockInterruptibly()`) |
| Fair locking | No | Yes (constructor option) |
| Multiple conditions | No | Yes (`newCondition()`) |

### ReadWriteLock

For scenarios with many readers and few writers:

```java
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Cache {
    private final Map<String, String> data = new HashMap<>();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    
    public String get(String key) {
        rwLock.readLock().lock();  // Multiple readers allowed
        try {
            return data.get(key);
        } finally {
            rwLock.readLock().unlock();
        }
    }
    
    public void put(String key, String value) {
        rwLock.writeLock().lock();  // Exclusive access
        try {
            data.put(key, value);
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
```

---

## ExecutorService & Thread Pools

Creating threads manually is expensive. Thread pools reuse threads efficiently:

### Why Thread Pools?

```
Without Pool:                    With Pool:
─────────────────               ─────────────────
Task 1 → Create Thread          Task 1 ─┐
Task 2 → Create Thread          Task 2 ─┼→ [Thread Pool] → Reuse threads
Task 3 → Create Thread          Task 3 ─┤   (fixed size)
...                             Task 4 ─┘
Task N → Create Thread (slow!)  
```

### Creating Thread Pools

```java
import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {
        // Fixed thread pool - exactly N threads
        ExecutorService fixedPool = Executors.newFixedThreadPool(4);
        
        // Cached thread pool - creates threads as needed, reuses idle ones
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        
        // Single thread executor - one thread, tasks queue up
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        
        // Scheduled executor - for delayed/periodic tasks
        ScheduledExecutorService scheduledPool = 
            Executors.newScheduledThreadPool(2);
        
        // Submit tasks to fixed pool
        for (int i = 1; i <= 10; i++) {
            final int taskNum = i;
            fixedPool.submit(() -> {
                System.out.println("Task " + taskNum + " running on " + 
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        // IMPORTANT: Always shut down executors!
        fixedPool.shutdown();  // No new tasks, finish existing
        
        try {
            // Wait up to 60 seconds for completion
            if (!fixedPool.awaitTermination(60, TimeUnit.SECONDS)) {
                fixedPool.shutdownNow();  // Force shutdown
            }
        } catch (InterruptedException e) {
            fixedPool.shutdownNow();
        }
        
        // Clean up other pools
        cachedPool.shutdown();
        singlePool.shutdown();
        scheduledPool.shutdown();
    }
}
```

### Executor Types Comparison

| Type | Threads | Use Case |
|------|---------|----------|
| `newFixedThreadPool(n)` | Fixed n | Known workload, CPU-bound tasks |
| `newCachedThreadPool()` | Dynamic (0-∞) | Many short-lived tasks |
| `newSingleThreadExecutor()` | 1 | Sequential task execution |
| `newScheduledThreadPool(n)` | Fixed n | Delayed/periodic tasks |
| `newWorkStealingPool()` | CPU cores | Parallel recursive tasks |

### Scheduled Executor

```java
import java.util.concurrent.*;

public class ScheduledDemo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = 
            Executors.newScheduledThreadPool(2);
        
        // Run once after 3 seconds
        scheduler.schedule(
            () -> System.out.println("Delayed task!"),
            3, TimeUnit.SECONDS
        );
        
        // Run every 2 seconds (after initial 1 second delay)
        scheduler.scheduleAtFixedRate(
            () -> System.out.println("Periodic task at " + 
                System.currentTimeMillis()),
            1, 2, TimeUnit.SECONDS
        );
        
        // Run with 2 second delay BETWEEN completions
        scheduler.scheduleWithFixedDelay(
            () -> {
                System.out.println("Fixed delay task");
                try { Thread.sleep(500); } catch (Exception e) {}
            },
            1, 2, TimeUnit.SECONDS
        );
        
        // Let it run for 10 seconds
        Thread.sleep(10000);
        scheduler.shutdown();
    }
}
```

---

## Callable and Future

`Callable` is like `Runnable` but can return a result and throw exceptions:

```java
import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Callable that returns a result
        Callable<Integer> sumTask = () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            Thread.sleep(1000);  // Simulate work
            return sum;
        };
        
        // Submit and get a Future
        Future<Integer> future = executor.submit(sumTask);
        
        System.out.println("Task submitted, doing other work...");
        
        // Check if done (non-blocking)
        System.out.println("Is done? " + future.isDone());
        
        // Get result (blocks until complete)
        Integer result = future.get();  // Or future.get(5, TimeUnit.SECONDS)
        System.out.println("Result: " + result);
        
        // Submit multiple tasks
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            futures.add(executor.submit(() -> {
                Thread.sleep(num * 100);
                return "Task " + num + " complete";
            }));
        }
        
        // Collect results
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }
        
        executor.shutdown();
    }
}
```

### Future Methods

| Method | Description |
|--------|-------------|
| `get()` | Blocks until result is available |
| `get(timeout, unit)` | Blocks with timeout |
| `isDone()` | Returns true if task completed |
| `isCancelled()` | Returns true if task was cancelled |
| `cancel(mayInterrupt)` | Attempts to cancel the task |

### InvokeAll and InvokeAny

```java
import java.util.concurrent.*;
import java.util.*;

public class InvokeDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        List<Callable<String>> tasks = Arrays.asList(
            () -> { Thread.sleep(2000); return "Task 1"; },
            () -> { Thread.sleep(1000); return "Task 2"; },
            () -> { Thread.sleep(3000); return "Task 3"; }
        );
        
        // invokeAll - wait for ALL tasks to complete
        System.out.println("Running invokeAll...");
        List<Future<String>> allResults = executor.invokeAll(tasks);
        for (Future<String> f : allResults) {
            System.out.println(f.get());
        }
        
        // invokeAny - return result of FIRST completed task
        System.out.println("\nRunning invokeAny...");
        String firstResult = executor.invokeAny(tasks);
        System.out.println("First completed: " + firstResult);
        
        executor.shutdown();
    }
}
```

---

## Concurrent Collections

Standard collections are NOT thread-safe. Use concurrent versions:

### ConcurrentHashMap

```java
import java.util.concurrent.*;

public class ConcurrentMapDemo {
    public static void main(String[] args) throws InterruptedException {
        // Thread-safe map
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        
        // Atomic operations
        map.put("count", 0);
        
        // Create threads that increment the counter
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                // Atomic compute operation
                map.compute("count", (key, value) -> value + 1);
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("Final count: " + map.get("count"));  // Always 1000!
        
        // Other atomic operations
        map.putIfAbsent("new", 1);        // Only if key doesn't exist
        map.computeIfAbsent("calc", k -> k.length());  // Compute if absent
        map.merge("count", 10, Integer::sum);  // Merge with existing
    }
}
```

### CopyOnWriteArrayList

For lists with many reads and few writes:

```java
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {
    public static void main(String[] args) {
        // Thread-safe list (creates new copy on each write)
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        
        list.add("A");
        list.add("B");
        list.add("C");
        
        // Safe iteration - won't throw ConcurrentModificationException
        for (String item : list) {
            System.out.println(item);
            list.add("New");  // Writes happen on a copy
        }
        
        System.out.println("Final list: " + list);
    }
}
```

### BlockingQueue

For producer-consumer patterns:

```java
import java.util.concurrent.*;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
        
        // Producer
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String item = "Item-" + i;
                    queue.put(item);  // Blocks if queue is full
                    System.out.println("Produced: " + item);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String item = queue.take();  // Blocks if queue is empty
                    System.out.println("Consumed: " + item);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        producer.start();
        consumer.start();
    }
}
```

### Concurrent Collections Overview

| Collection | Thread-Safe Version | Notes |
|------------|--------------------|----- |
| `HashMap` | `ConcurrentHashMap` | Lock striping, no nulls |
| `ArrayList` | `CopyOnWriteArrayList` | Best for read-heavy |
| `HashSet` | `CopyOnWriteArraySet` | Best for read-heavy |
| `TreeMap` | `ConcurrentSkipListMap` | Sorted, concurrent |
| `LinkedList` | `ConcurrentLinkedQueue` | Non-blocking |
| `PriorityQueue` | `PriorityBlockingQueue` | Blocking priority queue |

---

## Common Concurrency Utilities

### CountDownLatch

Wait for multiple events to complete:

```java
import java.util.concurrent.*;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int workerCount = 3;
        CountDownLatch latch = new CountDownLatch(workerCount);
        
        for (int i = 1; i <= workerCount; i++) {
            final int workerId = i;
            new Thread(() -> {
                System.out.println("Worker " + workerId + " starting...");
                try {
                    Thread.sleep(workerId * 1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Worker " + workerId + " done!");
                latch.countDown();  // Decrement count
            }).start();
        }
        
        System.out.println("Main waiting for workers...");
        latch.await();  // Block until count reaches 0
        System.out.println("All workers finished!");
    }
}
```

### Semaphore

Limit concurrent access to a resource:

```java
import java.util.concurrent.*;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // Only 3 threads can access at a time
        Semaphore semaphore = new Semaphore(3);
        
        for (int i = 1; i <= 10; i++) {
            final int userId = i;
            new Thread(() -> {
                try {
                    System.out.println("User " + userId + " waiting...");
                    semaphore.acquire();  // Get permit (blocks if none available)
                    System.out.println("User " + userId + " accessing resource");
                    Thread.sleep(2000);  // Use resource
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println("User " + userId + " releasing");
                    semaphore.release();  // Return permit
                }
            }).start();
        }
    }
}
```

### CyclicBarrier

Synchronize threads at a common point:

```java
import java.util.concurrent.*;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int parties = 3;
        
        CyclicBarrier barrier = new CyclicBarrier(parties, () -> {
            // Runs when all parties arrive
            System.out.println("=== All threads reached barrier! ===");
        });
        
        for (int i = 1; i <= parties; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + threadId + " working...");
                    Thread.sleep(threadId * 1000);
                    System.out.println("Thread " + threadId + " waiting at barrier");
                    barrier.await();  // Wait for others
                    System.out.println("Thread " + threadId + " continuing");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
```

### Atomic Variables

Lock-free thread-safe variables:

```java
import java.util.concurrent.atomic.*;

public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        AtomicLong bigCounter = new AtomicLong(0);
        AtomicBoolean flag = new AtomicBoolean(false);
        AtomicReference<String> ref = new AtomicReference<>("initial");
        
        // Atomic operations
        counter.incrementAndGet();    // ++counter
        counter.getAndIncrement();    // counter++
        counter.addAndGet(5);         // counter += 5
        counter.compareAndSet(6, 10); // If counter==6, set to 10
        
        // Thread-safe without synchronization
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 10000; i++) {
            executor.submit(counter::incrementAndGet);
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("Counter: " + counter.get());  // Always 10006!
    }
}
```

---

## Best Practices

### 1. Always Handle InterruptedException Properly

```java
// BAD - swallowing the interrupt
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    // Do nothing - interrupt is lost!
}

// GOOD - restore interrupt status
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();  // Restore flag
    return;  // Exit gracefully
}
```

### 2. Always Unlock in Finally

```java
Lock lock = new ReentrantLock();

lock.lock();
try {
    // Critical section
} finally {
    lock.unlock();  // ALWAYS in finally!
}
```

### 3. Always Shutdown ExecutorService

```java
ExecutorService executor = Executors.newFixedThreadPool(4);

try {
    // Submit tasks
} finally {
    executor.shutdown();
    try {
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    } catch (InterruptedException e) {
        executor.shutdownNow();
    }
}
```

### 4. Prefer Higher-Level Concurrency Utilities

```java
// Instead of raw Thread
new Thread(() -> doWork()).start();

// Prefer ExecutorService
ExecutorService executor = Executors.newCachedThreadPool();
executor.submit(() -> doWork());
```

### 5. Minimize Lock Scope

```java
// BAD - lock held too long
synchronized (lock) {
    data = fetchFromDatabase();  // Slow operation
    processData(data);
}

// GOOD - minimal lock scope
Object data = fetchFromDatabase();  // Outside lock
synchronized (lock) {
    processData(data);  // Only critical section
}
```

### 6. Avoid Nested Locks (Prevent Deadlock)

```java
// DEADLOCK RISK!
synchronized (lockA) {
    synchronized (lockB) {
        // ...
    }
}

// Another thread might do:
synchronized (lockB) {
    synchronized (lockA) {
        // DEADLOCK!
    }
}

// Solution: Always acquire locks in consistent order
```

---

## Summary

### Key Concepts Learned

| Concept | Description |
|---------|-------------|
| **Thread** | Unit of execution within a process |
| **Runnable** | Interface for defining thread tasks |
| **Synchronized** | Keyword for mutual exclusion |
| **Lock** | More flexible synchronization mechanism |
| **ExecutorService** | Thread pool management |
| **Future** | Represents async computation result |
| **Concurrent Collections** | Thread-safe data structures |

### When to Use What

| Scenario | Solution |
|----------|----------|
| Simple background task | `ExecutorService.submit(runnable)` |
| Need return value | `Callable` + `Future` |
| Producer-consumer | `BlockingQueue` |
| Read-heavy shared map | `ConcurrentHashMap` |
| Wait for multiple tasks | `CountDownLatch` |
| Limit concurrent access | `Semaphore` |
| Simple counter | `AtomicInteger` |

### Thread Safety Checklist

- [ ] Identify shared mutable state
- [ ] Use thread-safe collections or synchronization
- [ ] Keep lock scope minimal
- [ ] Handle `InterruptedException` properly
- [ ] Shutdown executors in finally blocks
- [ ] Avoid nested locks
- [ ] Test with multiple threads!

---

## 🎯 What's Next?

Now that you understand multithreading, you're ready for:
- **Class 2: Databases & JDBC** - Persist data with SQL databases

---

## 📚 Additional Resources

- [Java Concurrency Tutorial (Oracle)](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Java Concurrent Package](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html)
- [Effective Java - Concurrency Chapter](https://www.oreilly.com/library/view/effective-java/9780134686097/)

---

**Practice makes perfect! Complete the exercises in `Exercises.md` to master multithreading!** 🧵
