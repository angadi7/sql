package com.Day23;

import java.util.LinkedList;

public class ProducerConsumer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity = 5;

    public void produce() throws InterruptedException {
        int item = 0;
        while (true) {
            synchronized (this) {
                // Wait if the buffer is full
                while (buffer.size() == capacity) {
                    wait();
                }

                System.out.println("Producer produced: " + item);
                buffer.add(item++);

                // Notify the consumer that an item is available
                notify();

                // Introduce some delay for demonstration purposes
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // Wait if the buffer is empty
                while (buffer.size() == 0) {
                    wait();
                }

                int item = buffer.removeFirst();
                System.out.println("Consumer consumed: " + item);

                // Notify the producer that buffer is empty now
                notify();

                // Introduce some delay for demonstration purposes
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        final ProducerConsumer pc = new ProducerConsumer();

        // Creating producer thread
        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Creating consumer thread
        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Starting both threads
        producerThread.start();
        consumerThread.start();
    }
}

