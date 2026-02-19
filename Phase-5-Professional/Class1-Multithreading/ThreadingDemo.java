/**
 * ============================================
 * MULTITHREADING & CONCURRENCY DEMONSTRATION
 * ============================================
 * 
 * This file demonstrates all major concepts of Java threading:
 * 1. Creating threads (Thread class vs Runnable)
 * 2. Thread lifecycle and states
 * 3. Synchronization and thread safety
 * 4. Locks and ReentrantLock
 * 5. ExecutorService and thread pools
 * 6. Callable and Future
 * 7. Concurrent collections
 * 8. Concurrency utilities (CountDownLatch, Semaphore, etc.)
 * 
 * @author Learn Java With Me
 */

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.util.*;

public class ThreadingDemo {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║     MULTITHREADING & CONCURRENCY DEMONSTRATION           ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        
        // Run each demonstration
        demo1_CreatingThreads();
        demo2_ThreadMethods();
        demo3_RaceConditionProblem();
        demo4_SynchronizedSolution();
        demo5_ReentrantLockDemo();
        demo6_ExecutorServiceBasics();
        demo7_CallableAndFuture();
        demo8_ConcurrentCollections();
        demo9_CountDownLatchDemo();
        demo10_AtomicVariables();
        
        System.out.println("\n✅ All demonstrations completed!");
    }
    
    /**
     * DEMO 1: Creating Threads - Two Ways
     */
    public static void demo1_CreatingThreads() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 1: Creating Threads");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Method 1: Extending Thread class
        class CounterThread extends Thread {
            private String name;
            
            CounterThread(String name) {
                this.name = name;
            }
            
            @Override
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("  " + name + " counts: " + i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        
        System.out.println("Method 1: Extending Thread class");
        CounterThread thread1 = new CounterThread("Thread-A");
        thread1.start();
        
        try { thread1.join(); } catch (InterruptedException e) {}
        
        // Method 2: Implementing Runnable
        System.out.println("\nMethod 2: Implementing Runnable");
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("  Runnable counts: " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        
        Thread thread2 = new Thread(task);
        thread2.start();
        
        try { thread2.join(); } catch (InterruptedException e) {}
        
        // Method 3: Lambda (shortest)
        System.out.println("\nMethod 3: Lambda expression");
        Thread thread3 = new Thread(() -> System.out.println("  Lambda thread says hello!"));
        thread3.start();
        
        try { thread3.join(); } catch (InterruptedException e) {}
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 2: Thread Methods and Properties
     */
    public static void demo2_ThreadMethods() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 2: Thread Methods and Properties");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "MyWorkerThread");
        
        // Before starting
        System.out.println("Before start():");
        System.out.println("  Name: " + worker.getName());
        System.out.println("  ID: " + worker.getId());
        System.out.println("  State: " + worker.getState());  // NEW
        System.out.println("  Priority: " + worker.getPriority());
        System.out.println("  Is Alive: " + worker.isAlive());  // false
        
        worker.start();
        
        System.out.println("\nAfter start():");
        System.out.println("  State: " + worker.getState());  // RUNNABLE
        System.out.println("  Is Alive: " + worker.isAlive());  // true
        
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        
        System.out.println("\nWhile sleeping:");
        System.out.println("  State: " + worker.getState());  // TIMED_WAITING
        
        try { worker.join(); } catch (InterruptedException e) {}
        
        System.out.println("\nAfter completion:");
        System.out.println("  State: " + worker.getState());  // TERMINATED
        System.out.println("  Is Alive: " + worker.isAlive());  // false
        
        // Current thread info
        Thread main = Thread.currentThread();
        System.out.println("\nMain thread info:");
        System.out.println("  Name: " + main.getName());
        System.out.println("  ID: " + main.getId());
        
        System.out.println("\n");
    }
    
    /**
     * DEMO 3: Race Condition Problem
     */
    public static void demo3_RaceConditionProblem() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 3: Race Condition Problem (NOT Thread-Safe!)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        class UnsafeCounter {
            private int count = 0;
            
            public void increment() {
                count++;  // NOT atomic! (read-modify-write)
            }
            
            public int getCount() {
                return count;
            }
        }
        
        UnsafeCounter counter = new UnsafeCounter();
        int numThreads = 10;
        int incrementsPerThread = 1000;
        int expectedTotal = numThreads * incrementsPerThread;
        
        Thread[] threads = new Thread[numThreads];
        
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
        }
        
        // Start all threads
        for (Thread t : threads) {
            t.start();
        }
        
        // Wait for all threads
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        
        System.out.println("Expected count: " + expectedTotal);
        System.out.println("Actual count:   " + counter.getCount());
        System.out.println("Lost updates:   " + (expectedTotal - counter.getCount()));
        System.out.println("\n⚠️  Race condition caused lost increments!\n");
        System.out.println("\n");
    }
    
    /**
     * DEMO 4: Synchronized Solution
     */
    public static void demo4_SynchronizedSolution() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 4: Synchronized Solution (Thread-Safe)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        class SafeCounter {
            private int count = 0;
            
            public synchronized void increment() {
                count++;  // Now thread-safe!
            }
            
            public synchronized int getCount() {
                return count;
            }
        }
        
        SafeCounter counter = new SafeCounter();
        int numThreads = 10;
        int incrementsPerThread = 1000;
        int expectedTotal = numThreads * incrementsPerThread;
        
        Thread[] threads = new Thread[numThreads];
        
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
        }
        
        for (Thread t : threads) {
            t.start();
        }
        
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        
        System.out.println("Expected count: " + expectedTotal);
        System.out.println("Actual count:   " + counter.getCount());
        System.out.println("\n✅ Synchronized keyword prevents race conditions!\n");
        System.out.println("\n");
    }
    
    /**
     * DEMO 5: ReentrantLock
     */
    public static void demo5_ReentrantLockDemo() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 5: ReentrantLock (More Flexible Locking)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        class BankAccount {
            private int balance = 1000;
            private final Lock lock = new ReentrantLock();
            
            public boolean withdraw(int amount) {
                lock.lock();
                try {
                    if (balance >= amount) {
                        // Simulate processing
                        try { Thread.sleep(10); } catch (InterruptedException e) {}
                        balance -= amount;
                        return true;
                    }
                    return false;
                } finally {
                    lock.unlock();  // ALWAYS in finally!
                }
            }
            
            public void deposit(int amount) {
                lock.lock();
                try {
                    balance += amount;
                } finally {
                    lock.unlock();
                }
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
        
        BankAccount account = new BankAccount();
        System.out.println("Initial balance: $" + account.getBalance());
        
        // Concurrent withdrawals
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int threadNum = i + 1;
            threads[i] = new Thread(() -> {
                boolean success = account.withdraw(300);
                System.out.println("  Thread " + threadNum + " withdraw $300: " + 
                    (success ? "✓ Success" : "✗ Failed"));
            });
        }
        
        for (Thread t : threads) {
            t.start();
        }
        
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        
        System.out.println("Final balance: $" + account.getBalance());
        System.out.println("\n✅ ReentrantLock ensures thread-safe transactions!\n");
        System.out.println("\n");
    }
    
    /**
     * DEMO 6: ExecutorService Basics
     */
    public static void demo6_ExecutorServiceBasics() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 6: ExecutorService & Thread Pools");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        System.out.println("Submitting 6 tasks to a pool of 3 threads:\n");
        
        for (int i = 1; i <= 6; i++) {
            final int taskNum = i;
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("  Task " + taskNum + " started on " + threadName);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("  Task " + taskNum + " completed on " + threadName);
            });
        }
        
        // Proper shutdown
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        
        System.out.println("\n✅ All tasks completed! Thread pool shut down.\n");
        System.out.println("\n");
    }
    
    /**
     * DEMO 7: Callable and Future
     */
    public static void demo7_CallableAndFuture() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 7: Callable and Future (Return Values from Threads)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Callable returns a value
        Callable<Integer> sumTask = () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            Thread.sleep(500);  // Simulate computation
            return sum;
        };
        
        Callable<Integer> productTask = () -> {
            int product = 1;
            for (int i = 1; i <= 10; i++) {
                product *= i;
            }
            Thread.sleep(300);
            return product;
        };
        
        // Submit tasks and get Futures
        Future<Integer> sumFuture = executor.submit(sumTask);
        Future<Integer> productFuture = executor.submit(productTask);
        
        System.out.println("Tasks submitted, doing other work...");
        System.out.println("Sum isDone: " + sumFuture.isDone());
        
        try {
            // get() blocks until result is available
            Integer sum = sumFuture.get();
            Integer product = productFuture.get();
            
            System.out.println("\nResults:");
            System.out.println("  Sum of 1 to 100: " + sum);
            System.out.println("  Product of 1 to 10 (10!): " + product);
            
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
        System.out.println("\n✅ Callable allows threads to return values!\n");
        System.out.println("\n");
    }
    
    /**
     * DEMO 8: Concurrent Collections
     */
    public static void demo8_ConcurrentCollections() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 8: Concurrent Collections");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // ConcurrentHashMap - thread-safe map
        ConcurrentHashMap<String, Integer> wordCount = new ConcurrentHashMap<>();
        
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for (String word : words) {
            executor.submit(() -> {
                // Atomic merge operation
                wordCount.merge(word, 1, Integer::sum);
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {}
        
        System.out.println("Thread-safe word count:");
        wordCount.forEach((word, count) -> {
            System.out.println("  " + word + ": " + count);
        });
        
        // BlockingQueue - producer-consumer
        System.out.println("\nBlockingQueue demo:");
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        
        // Producer
        new Thread(() -> {
            try {
                for (int i = 1; i <= 3; i++) {
                    String item = "Item-" + i;
                    queue.put(item);
                    System.out.println("  Produced: " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        
        // Consumer
        new Thread(() -> {
            try {
                Thread.sleep(500);  // Delay consumer
                for (int i = 1; i <= 3; i++) {
                    String item = queue.take();
                    System.out.println("  Consumed: " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        
        try { Thread.sleep(1500); } catch (InterruptedException e) {}
        
        System.out.println("\n✅ Concurrent collections are thread-safe by design!\n");
        System.out.println("\n");
    }
    
    /**
     * DEMO 9: CountDownLatch
     */
    public static void demo9_CountDownLatchDemo() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 9: CountDownLatch (Wait for Multiple Events)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        int serviceCount = 3;
        CountDownLatch latch = new CountDownLatch(serviceCount);
        
        String[] services = {"Database", "Cache", "MessageQueue"};
        
        System.out.println("Starting application - waiting for services...\n");
        
        for (String service : services) {
            new Thread(() -> {
                try {
                    // Simulate service startup time
                    Thread.sleep((long)(Math.random() * 1000 + 500));
                    System.out.println("  ✓ " + service + " service started");
                    latch.countDown();  // Decrement count
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
        
        try {
            latch.await();  // Block until count reaches 0
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n✅ All services started! Application ready.\n");
        System.out.println("\n");
    }
    
    /**
     * DEMO 10: Atomic Variables
     */
    public static void demo10_AtomicVariables() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("DEMO 10: Atomic Variables (Lock-Free Thread Safety)");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        AtomicInteger counter = new AtomicInteger(0);
        AtomicLong bigCounter = new AtomicLong(0);
        AtomicBoolean flag = new AtomicBoolean(false);
        
        int numThreads = 10;
        int incrementsPerThread = 1000;
        
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        
        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.incrementAndGet();  // Atomic increment
                }
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {}
        
        System.out.println("Expected: " + (numThreads * incrementsPerThread));
        System.out.println("Actual:   " + counter.get());
        
        // Atomic operations
        System.out.println("\nAtomic operations:");
        System.out.println("  incrementAndGet: " + counter.incrementAndGet());
        System.out.println("  addAndGet(5):    " + counter.addAndGet(5));
        System.out.println("  compareAndSet:   " + counter.compareAndSet(10006, 0));
        System.out.println("  After CAS:       " + counter.get());
        
        System.out.println("\n✅ Atomic variables provide lock-free thread safety!\n");
    }
}

// ============================================
// ADDITIONAL HELPER CLASSES FOR DEMONSTRATIONS
// ============================================

/**
 * Example: Thread-Safe Singleton using double-checked locking
 */
class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    private static final Object lock = new Object();
    
    private ThreadSafeSingleton() {}
    
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

/**
 * Example: Producer-Consumer Pattern
 */
class ProducerConsumerExample {
    private final BlockingQueue<Integer> queue;
    
    public ProducerConsumerExample(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }
    
    public void produce(int value) throws InterruptedException {
        queue.put(value);  // Blocks if queue is full
    }
    
    public int consume() throws InterruptedException {
        return queue.take();  // Blocks if queue is empty
    }
}

/**
 * Example: Read-Write Lock Usage
 */
class ThreadSafeCache<K, V> {
    private final Map<K, V> cache = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    
    public V get(K key) {
        lock.readLock().lock();  // Multiple readers allowed
        try {
            return cache.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }
    
    public void put(K key, V value) {
        lock.writeLock().lock();  // Exclusive access
        try {
            cache.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    public int size() {
        lock.readLock().lock();
        try {
            return cache.size();
        } finally {
            lock.readLock().unlock();
        }
    }
}
