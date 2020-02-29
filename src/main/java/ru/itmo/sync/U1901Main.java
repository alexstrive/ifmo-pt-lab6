package ru.itmo.sync;

public class U1901Main {
    public static void main(String... args) {
        var mainBank = new U1901Bank();
        var threadOne = new U1901Thread(mainBank, 100, 2000);
        threadOne.setName("Bank Thread 1");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        var threadTwo = new U1901Thread(mainBank, 50, 300);
        threadTwo.setName("Bank Thread 2");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();

        System.out.println("Current thread: " + Thread.currentThread().getName());
    }
}