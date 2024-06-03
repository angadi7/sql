package com.Day23;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCode {
    
    // Thread-safe Counter class
    static class Counter {
        private AtomicInteger count = new AtomicInteger(0);

        public void increment() {
            count.incrementAndGet();
        }

        public void decrement() {
            count.decrementAndGet();
        }

        public int getValue() {
            return count.get();
        }
    }

    // Immutable Data class
    static final class ImmutableData {
        private final int value;

        public ImmutableData(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Thread-safe counter
        Counter counter = new Counter();

        // Immutable data instance
        ImmutableData immutableData = new ImmutableData(42);

        // Creating multiple threads to increment and decrement the counter
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        });

        // Start the threads
        incrementThread.start();
        decrementThread.start();

        // Wait for both threads to finish
        incrementThread.join();
        decrementThread.join();

        // Print the final value of the counter
        System.out.println("Final counter value: " + counter.getValue());

        // Using the immutable data
        System.out.println("Immutable data value: " + immutableData.getValue());
    }
}

