package com.anderson.javasemaphores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Anderson Pessoa
 */
public class Program {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);
        List<MyThread> threads = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            threads.add(new MyThread(semaphore, "#" + i));
        }

        threads.forEach((MyThread thread) -> {
                thread.start();
        });
    }
}
