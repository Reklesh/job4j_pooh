package ru.job4j.pooh;

public class Condition {
    private volatile boolean flag = false;

    public synchronized void on() {
        flag = true;
        notify();
    }

    public synchronized void off() {
        flag = false;
        notify();
    }

    public synchronized void await() throws InterruptedException {
        while (!flag) {
            wait();
        }
    }

    public boolean check() {
        return flag;
    }
}
