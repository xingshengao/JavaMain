package com.edu.nju.test3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadMemo {
    // 多线程方法一:
    // 自己定义一个类, 继承Thread类
    // 重写run方法
    // 创建子类对象, 启动线程
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable(); // (表示多线程要执行的任务)
        FutureTask<Integer> ft = new FutureTask<>(mc); // 管理多线程运行的结果
        Thread t1 = new Thread(ft);
        t1.start();

        // 获取结果
        Integer a = ft.get();
        System.out.println(a);
    }
}
