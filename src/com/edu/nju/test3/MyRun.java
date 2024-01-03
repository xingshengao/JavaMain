package com.edu.nju.test3;

public class MyRun implements Runnable {
    @Override
    public void run() {
        // 获取当前进程的对象
        Thread t = Thread.currentThread();
        for (int i = 0; i < 100; ++i) {
            System.out.println(t.getName() + "HelloWorld");

        }
    }
}
