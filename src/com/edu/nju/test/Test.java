package com.edu.nju.test;

/**
 * @author xsa_DeleteMemory
 * @date $ $
 */
public class Test {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        A a = new C();
        System.out.println(b.f());
        System.out.println(c.f());
        System.out.println(a.f());
        System.out.println(c.a);
        Inter.ff();
        c.fff();
    }
}
