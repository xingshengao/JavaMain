import com.edu.nju.test.A;
import com.edu.nju.test.B;
import com.sun.security.jgss.GSSUtil;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author XsaDeleteMemory
 * @date 2023/12/25 14:40
 */

public class JavaMain {
    public static final long mod = (long) (1e9 + 7);


    public static void solve() {
        HashMap<Integer, Integer> m = new HashMap<>();
        TreeSet<Integer> S = new TreeSet<>();
        TreeMap<Long, Long> tm = new TreeMap<>();
        double dNum = 1.0d;
        System.out.println(dNum);
        String s;
        Set<Integer> s1 = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(a);
        int[] arr1 = {1, 2, 3};
        String[] aa = {"", "a", "b"};
        System.out.println(a); // 数组的地址值
        // 基本数据类型->栈存储
        // 引用数据类型->堆存储
        for (int j : arr1) {
            System.out.println(j);
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

    // 正则表达式
    public static void myReg() {
        System.out.println("abcdefg".matches("[a-z]{2,88}"));
        String regexPhoneNumber = "1[3-9]\\d{9}"; // 第一位是1, 第二位是3-6, 后面9位是任意数字
        String myPhone = "18801597122";
        System.out.println(myPhone.matches("1[3-9]\\d{9}"));
        String regexFixedPhone = "0" + // 第一位是0
                "\\d{2,3}" +// 区位号长度2-3
                "-?" + // 可以有-, 也可以没有
                "[0-9^0]" + // 电话号码不能用0开头
                "\\d{4,9}"; // 5-10位的号码减去第一位, 4-9;
        System.out.println("03194882808".matches(regexFixedPhone));
        // 邮箱
        String regexEmail = "\\w+" +
                "@" +
                "[\\w&&[^_]]{2,6}" + // .左边不能出现下划线
                "." +
                "[a-zA-Z]{2,3}"; // 字母2-3次数
        System.out.println("2211916133@qq.com".matches(regexEmail));
        // 24小时制时间
        String timeRegex = "([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
        System.out.println("15:88:31".matches(timeRegex));

        // 正则表达式对象
        Pattern p = Pattern.compile("([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d"); // 24小时时间
        String str = "fhudiasfbiufbdifu15:15:48dsabyudi00:00:00你好没用的东西15:59:56";
        // 文本匹配器对象, 找到符合规则的子串
        Matcher m = p.matcher(str);
        while (m.find()) {
            String s1 = m.group();
            System.out.println(s1);
        }
    }

    public static void date() {
        Date d = new Date((4846854185448941L));
        System.out.println(d);
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cd = Calendar.getInstance();
        System.out.println(cd);
    }

    public static void array() {
        int[] arr = {1, 2, 3, 43, 4};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
//        solve();
        System.out.println(System.currentTimeMillis());
        Student st1 = new Student("ddd", 2);
        System.out.println(st1.toString());
        Student st2 = new Student();
        System.out.println(st2.toString());
        BigInteger bg = new BigInteger("489478948948489414564787215645648561561859181");
        System.out.println(bg);
        BigInteger ab = new BigInteger(5, new Random());
        BigInteger c = bg.multiply(ab);
        System.out.println(c);
        myReg(); // 正则表达式
        Instant is = Instant.now();
        System.out.println(is);
        Boolean ok = false;
        System.out.println(ok);
        array();
        // 包装类排序
        Integer[] arr1 = {1, 2, 3, 4, 5, 7};
//        Arrays.sort(arr1, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1; // 降序排序
//            }
//        });
        Arrays.sort(arr1, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(arr1));
        Iterator<Integer> it = Arrays.stream(arr1).iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(155);
        list.forEach(a-> System.out.println(a));
    }

}
