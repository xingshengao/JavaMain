package com.edu.nju.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDemo {
    public static int cmp(int o1, int o2) {
        return o2 - o1;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("222");
        Stream<String> st = list.stream(); // 获取流水线
        // 使用终结方法打印
        st.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 简写为Lambda
        list.forEach(System.out::println);

        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("aaa", 1);
        mp.put("bbb", 2);
        // 获取stream流
        mp.keySet().forEach(System.out::println); // 健
        mp.entrySet().forEach(System.out::println);
        // 键值对对象
        Integer[] arr = {1, 2, 3, 4, 5, 66667777, 8788, 8999};
        Arrays.sort(arr, StreamDemo::cmp);
        System.out.println(Arrays.toString(arr));

    }
}
