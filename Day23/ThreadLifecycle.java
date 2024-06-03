package com.Day23;

class ThreadLifecycle implements Runnable {
    private final Object lock = new Object();

    @Override
    public void run() {
        try {
            // Thread is now RUNNABLE
            System.out.println(Thread.currentThread().getName() + " - State: RUNNABLE");

            // Simulate TIMED_WAITING state using sleep()
            System.out.println(Thread.currentThread().getName() + " - Going to sleep (TIMED_WAITING) for 2 seconds.");
            Thread.sleep(2000);

            synchronized (lock) {
                // Simulate WAITING state using wait()
                System.out.println(Thread.currentThread().getName() + " - Waiting (WAITING) for notification.");
                lock.wait();
            }

            // Simulate BLOCKED state by trying to acquire a lock held by another thread
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " - Acquired lock (RUNNABLE).");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread is now TERMINATED
        System.out.println(Thread.currentThread().getName() + " - State: TERMINATED");
    }

    public void notifyThread() {
        synchronized (lock) {
            lock.notify();
        }
    }

    public static void main(String[] args) {
        ThreadLifecycle runnable = new ThreadLifecycle();
        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");

        // Thread is in NEW state
        System.out.println(thread1.getName() + " - State: " + thread1.getState());
        System.out.println(thread2.getName() + " - State: " + thread2.getState());

        thread1.start();
        thread2.start();

        try {
            // Ensure thread1 is in TIMED_WAITING
            Thread.sleep(1000);

            // Notify thread1 to move it from WAITING to RUNNABLE
            runnable.notifyThread();

            // Ensure thread2 is in BLOCKED state by joining thread1
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

