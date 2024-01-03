package com.edu.nju.test3;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName()+ "HelloWorld");
        }
    }
}
