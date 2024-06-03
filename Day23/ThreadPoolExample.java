package com.Day23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Create a fixed-size thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit 10 tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executor.submit(() -> {
                try {
                    // Simulate complex calculation by sleeping for a random time
                    System.out.println("Task " + taskId + " started.");
                    long duration = (long) (Math.random() * 5);
                    TimeUnit.SECONDS.sleep(duration);
                    System.out.println("Task " + taskId + " completed in " + duration + " seconds.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Task " + taskId + " was interrupted.");
                }
            });
        }

        // Shutdown the executor service
        executor.shutdown();
        try {
            // Wait for all tasks to complete before exiting
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
