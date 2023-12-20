
import org.w3c.dom.ls.LSInput;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

/**
 * @author xsa_DeleteMemory
 * @date 2023/12/19 19:51
 */

public class JavaMain {
    public static final long mod = (long) (1e9 + 7);



    public static void change(int[] arr) { // 引用传递
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
        }
    }

    public static void solve() {
        HashMap<Integer, Integer> m = new HashMap<>();
        TreeSet<Integer> S = new TreeSet<>();
        TreeMap<Long, Long> tm = new TreeMap<>();
        double dNum = 1.0d;
        System.out.println(dNum);
        String s;
        Set<Integer> s1 = new TreeSet<>();
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        System.out.println(a);
        int[] arr1 = {1, 2, 3};
        String[] a = {"", "a", "b"};
        System.out.println(a); // 数组的地址值
        // 基本数据类型->栈存储
        // 引用数据类型->堆存储
        change(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        StringBuilder sb = new StringBuilder("投币");
        sb.reverse();
        sb.append(111);
        System.out.println(sb);
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add("dad");
        sj.add("fff");
        System.out.println(sj);

    }

    public static void main(String[] args) {
        solve();

    }


}
