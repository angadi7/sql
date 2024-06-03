package com.Day23;

class PrintNumbers implements Runnable {
    private String threadName;

    PrintNumbers(String name) {
        threadName = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        }
        System.out.println(threadName + " exiting.");
    }
}

public class PrintNumbersAssign {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintNumbers("Thread 1"));
        Thread thread2 = new Thread(new PrintNumbers("Thread 2"));

        thread1.start();
        thread2.start();
    }
}
