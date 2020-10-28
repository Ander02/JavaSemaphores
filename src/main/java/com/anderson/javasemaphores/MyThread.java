package com.anderson.javasemaphores;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Anderson Pessoa
 */
public class MyThread extends Thread {

    private Semaphore semaphore;
    private String threadName;

    public MyThread() {

    }

    public MyThread(Semaphore semaphore, String threadName) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        System.out.println("Thread - " + threadName);
        for (int i = 0; i < 10; i++) {

            try {
                semaphore.acquire();

                Shared.count++;
                System.out.println("The shared count in the thread " + threadName + " is " + Shared.count);

            } catch (Exception e) {
                System.out.println("Error on Thread - " + threadName + ": " + e.getMessage());
            } finally {
                semaphore.release();
            }
        }

    }
}
