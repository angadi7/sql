package com.Day23;

class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". Current balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Current balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + ". Insufficient funds. Current balance: " + balance);
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class BankCustomer implements Runnable {
    private final BankAccount account;

    public BankCustomer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
            account.withdraw(50);
        }
    }
}

public class bankaccountassign {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Thread customer1 = new Thread(new BankCustomer(account), "Customer 1");
        Thread customer2 = new Thread(new BankCustomer(account), "Customer 2");

        customer1.start();
        customer2.start();

        try {
            customer1.join();
            customer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}

