package com.edu.nju.test3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int s = 0;
        for (int i = 0; i < 100; i++) {
            s += i;
        }
        return s;
    }
}
