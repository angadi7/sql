package com.Day23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeNumberCalculator {

    public static void main(String[] args) {
        int maxNumber = 100000;  // Calculate primes up to this number
        int numberOfThreads = 4;  // Number of threads in the pool
        String outputPath = "primes.txt";  // Output file path

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        ConcurrentLinkedQueue<Integer> primeNumbers = new ConcurrentLinkedQueue<>();

        // Create a list of tasks to find prime numbers
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 2; i <= maxNumber; i++) {
            int number = i;
            futures.add(CompletableFuture.runAsync(() -> {
                if (isPrime(number)) {
                    primeNumbers.add(number);
                }
            }, executorService));
        }

        // Combine all futures to ensure all tasks are completed
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        // Write results to file once all calculations are done
        allOf.thenRunAsync(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
                for (Integer prime : primeNumbers) {
                    writer.write(prime + System.lineSeparator());
                }
                System.out.println("Primes written to file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).join();

        // Shutdown the executor service
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

