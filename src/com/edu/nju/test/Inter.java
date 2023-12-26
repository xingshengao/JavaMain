package com.edu.nju.test;

/**
 * @author XsaDeleteMemory
 * @date 2023/12/21 16:55
 */
public interface Inter {
    public static final int a = 1000000007;
    public static void ff(){
        System.out.println("接口静态方法");
    }
    public default void fff() {
        System.out.println("接口默认方法");
    }
}
