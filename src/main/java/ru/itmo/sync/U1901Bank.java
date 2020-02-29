package ru.itmo.sync;

class U1901Bank {
    int intTo, intFrom = 220;

    synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.printf("Before Thread=%s, from=%d, to=%d\n", Thread.currentThread().getName(), intFrom, intTo);
        intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        intTo += intTransaction;
        System.out.printf("After Thread=%s, from=%d, to=%d\n", Thread.currentThread().getName(), intFrom, intTo);
    }
}