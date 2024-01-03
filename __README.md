* 如果一个构造方法都没写, JVM虚拟机会默认给一个空参构造方法

* 构造方法至少写两个, 一个是无参构造, 一个是全参构造

* 标准 java类,每个私有成员函数都需要有set和get方法

* 插件PTG 直接生成标准javaBean类

* `this`的作用区分局部变量和成员变量, 本质代表方法调用者的地址值

* 成员变量: 类中方法外的变量, 成员变量: 方法内的变量

## `StringBuilder`

`append()`可以添加基本类型
`reverse()`
`length()`
`toString()`
`print()`
## `StringJoiner`
`StringJoiner sj = new StringJoiner("---");` 以---分割
`StringJoiner sj = new StringJoiner(", ", "[", "]");`间隔开始结束
`add()`
## `ArrayList`
`add()`
`remove()`
`change()`
## `static`静态变量 and 静态方法

静态方法只能访问静态，非静态方法可以访问所有， 静态方法没有this关键字



## 继承

```java
public class Son extends Father {
    
}

```

Son 是子类， 派生类
Father是父类， 基类超类

java只支持单继承， 不支持多继承， 即一个子类只能有一个父类

java支持多层继承

java所有类都直接或者间接继承于Object类
什么可以继承

构造方法：非私有不能， 私有不能

成员变量：非私有能， 私有能

成员方法：非私有能， 私有不能
继承中的访问：就近原则
`super`关键字， 子类访问父类的成员变量
子类构造方法默认先访问父类的无参构造，再执行自己
子类构造方法的第一行语句默认都是`super()`, 不写也存在，且必须在第一行
如果想调用父类的有参构造，必须手动写super
```java
调用父类的带参构造
 super(name, size)；
```
## 多态
同类型的对象， 表现出不同的形态
`父类类型 对象名称 = 子类对象`
多态的前提 有继承、实现关系；有父类引用指向子类对象；有方法的重写
多态调用，成员变量：编译看左边， 运行和看左边； 成员方法：编译看左边，运行也看右边
优势：解耦合，便于维护；定义方法时，以父类型作为参数，可以接受所有子类对象

```java
 a instanceof B // 判断对象a是不是类B地一个实例
```
## 包
* 使用同一个包的类时，不需要导入包
* 使用java.lang包中的类不需要导入包
* 其它情况都需要导包
* 使用两个包的同名类，需要使用全类名
## final
final修饰方法，表示该方法是最终方法不能被重写
final修饰类，表示该类是最终了类不能被继承
final修饰的变量， 存储的值不能改变
final修饰引用类型， 那么变量存储的地址值不能发生改变， 对象内部的可以改变
## 权限修饰符
private: 只能同一个类
默认：自己类， 同一个包的其他类
protected 同一个包 同一个包的其他类 其它包的子类
public 同一个包 同一个包的其他类 其它包的子类 其他包的无关类
## 静态代码块
随着类的加载而执行的， 并且只执行一次， 比如上次周赛静态生成回文数的代码`static{语句}`
```java
    static long[] A = new long[109999];
    // 生成1e9内的回文数字
    static {
        int idx = 0;
        for (long i = 1; i <= 100000; ++i) {
            long p = i;
            for (long x = i / 10; x > 0; x /= 10) {
                p = p * 10 + x % 10;
            }
            if (p < 1000000000) {
                A[idx++] = p;
            }
            p = i;
            for (long x = i; x > 0; x /= 10) {
                p = p * 10 + x % 10;
            }
            if (p < 1000000000) {
                A[idx++] = p;
            }
        }
        Arrays.sort(A);
    }
```
## 抽象类&&抽象方法

抽象方法: 子类的某个方法可能不一样, 在父类声明为抽象方法

抽象类: 一个类中存在抽象方法, 那么该类就必须声明为抽象类

抽象方法`public abstract int dp(int i, int j);`

抽象类定义`public abstract class A {}`

抽象类不能实例化, 抽象类的子类要么重写所有抽象类的抽象方法, 要么是抽象类

## 接口

定义`public interface 接口名 {}`

接口不能实例化, 接口和类是实现关系 关键字implements 

`public class 类名 implements 接口名{}`

接口的子类(实现类) : 重写接口中的所有抽象方法, 或者是抽象类

一个类可以实现多个接口`public   class implements 接口名1 接口名2{}`

实现类可以继承一个类的同时实现多个接口

`public class 类名 extends 父类 implements 接口名1, 接口名2 {}`

接口中成员变量: 只能是常量, 默认是`public static final`

没有构造方法

成员方法: 只能是抽象方法, 默认修饰符`public abstract`

JDK7以前接口只能定义抽象方法

JDK8的新特性: 接口中可以定义有方法体的方法

JDK9的新特性: 接口中可以定义私有方法

接口和接口之间的关系: 可以单继承也可以多继承

## JDK8接口新增的方法

JDK8允许在接口中定义默认方法, 需要使用`default`关键字, 作用是解决接口升级的问题`public default 返回值类型 方法名(参数列表) {}`

JDK8允许在接口中新增静态方法`public static 返回值类型 方法名(){}`注意静态方法只能通过接口名调用, 不能通过类名或者对象名字调用

## JDK9接口新增的私有方法

私有方法可以是静态的, 也可以是非静态的

接口代表规则是行为的抽象, 要想让哪个类拥有一个行为, 那么让这个类实现对用的接口就可以了,

当一个方法的参数是接口时, 可以传递接口所有实现类的对象, 这种方式被称为接口多态

## 适配器设计模式

当一个接口中的抽象方法过多, 但是我只需要使用一部分, 就可以采用适配器设计模式

编写中间类`XXXAdapter` 实现对应的接口, 对接口中的抽象方法进行空实现

让真正的实现类继承中间类, 并重写需要用的方法

为了避免其它类创建适配器的对象, 中间的适配器类用用abstract修饰

## 内部类

为了让外部获取内部类对象, 写一个get方法 `Object obj = outer.getInter()`

JDK16前内部类不能有静态变量吗, JDK17后才可以

静态内部类, 静态方法: 外部类名.内部类名.方法();, 非静态方法, 先创建对象再对象调用

局部内部类, 类定义在方法里面

**匿名内部类**: 本质是隐藏了名字的内部类

```java
new 类名或接口名() {
    重写方法
};
```

使用场景接口的实现类只需要使用一次, 可以使用匿名内部类简化代码

例如 在InnnerClassDemo7类的main()方法中使用PersonDemo类的pd对象调用method(Person p)方法，向person接口变量p传递一个匿名子类对象，重写Person接口的study()方法

```java
package cn.num07;
 
interface Person {
    void study();
}
 
class PersonDemo {	
    public void method(Person p) { 
        p.study();
    }
}
 
public class InnerClassDemo7 {
    public static void main(String[] args) {
        PersonDemo pd = new PersonDemo();
        pd.method(new Person() { // 向 person 接口变量 p 传递一个匿名子类对象
            @Override
            public void study() { // 重写 Person 接口的 study() 方法
                System.out.println("我正在学习Java编程语言");
            }
        });
    }
}
```

## Math

```java
Math.PI;
Math.max();
Math.seil(); // 向上取整
Math.floor(); // 向下取整
Math.round(); // 四舍五入
```

## System

```java
exit(); // 关闭当前虚拟机
long currentTimeMills(); // 当前系统事件的毫秒值形式, 从1970年1月1日00:00:00开始计算的
```

## RunTime

```java
// 当前虚拟机的运行环境
// 非静态
Runteme rt = Runtime.getRuntime(); // 获取系统运行环境对象
exit();
availableProcessors(); // 获取CPU的线程数
maxMemory(); // JVM可以从系统获取总内存大小
totalMemory(); // JVM已经从系统获取总内存大小(Byte)
freeMemory(); // JVM升序内存
exec(""); // 运行cmd命令
```

## Object&&Objectc

Object顶级父类, 所有类直接间接继承Object

```java
Object(); // 空参构造
toString(); // 重写ToString, 打印对象
euals(); // 不重写, 比较的是地址值, 重写比较的是属性
clone(); // 对象克隆, A对象的属性值完全拷贝给B对象
// 这个clone是浅克隆
```

浅克隆: 不管对象的属性是基本数据类型还是引用数据类型, 都完全拷贝过来

深克隆: 基本数据类型拷贝过来, 引用数据类型会重新创建新的,即修改被克隆对象的任何属性都不会影响到克隆出来的对象

## BigInteger && BigDecimal

大整数和大小数

```java
BigInterger(int a, new Random()); // [0~2^a -1]的随机大整数
BigInterger(string s); // 获取指定的大整数
BigInterger(string s, int radix); // 获取指定的大整数, 指定进制
add();
subtract();
multiply();
divide();
max(); min();
equals();
intValue(); // 转int
```

 bigDecimal类似

## 正则表达式

校验字符串是否满足一定的要求

### 字符类, 只匹配一个字符;

```java

[abc] // 只能是abc中的一个
[^abc] // 除了abc之外的任何字符
[a-zA-Z]
[a-d[m-p]] // a-d或者是m-p之间
[a-z&&[def]] // 取交集a-z和def的交集
[a-z&&[^bc]] // a-z和非bc的交集
[a-z&&[m-p]]
```

### 预定义字符, 只匹配一个字符

```java
. 任何字符;
\d 一个数字;
\D 非数字;
\s 一个空白字符  比如\t \n \x0B \f \r;
\S 非空白字符;
\w [a-zA-Z_0-9]字母数字下划线;
\W 非单词字符
```

### 数量词

```java
X? X, 一次或0次;
X* X, 零次或多次;
X+ X, 一次或多次;
X{n} X, 正好n次;
X{n,} X, 至少n次数;
X{n, m} X,[n :m]次数;
忽略单个字母的大小写((?i)a);
(?i)忽略后面字符的大小写;
() 分组;
```

例子

```java
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
    }
```

### 正则表达式对象

```java
// 正则表达式对象
Pattern p = Pattern.compile("([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d"); // 24小时时间
String str = "fhudiasfbiufbdifu15:15:48dsabyudi00:00:00你好没用的东西15:59:56";
// 文本匹配器对象, 找到符合规则的子串
Matcher m = p.matcher(str);
while (m.find()) {
    String s1 = m.group();
    System.out.println(s1);
}
```

### 捕获分组和非捕获分组

```java
\\组号 把第x组的内容再用一次;
判断以恶搞字符串的开始字符和结束字符是否一致:
String regex = "(.).+\\1";
判断一个字符的开始部分和结束部分是否一致:
String regex = "(.+.).+\\1";

```

## Date类

```java
Date d = new Date(); // 创建对象表示当前时间
Date d = new Date(long date); // 创建对象某个时间
```

## SimpleDateFormat

简单格式的日期

## Calendar类

年月日, 日历类

## JDK8新增时间相关类

```java
Instant时间戳类;
Instant obj = new Instant.now(); // 当前时间
// 根据秒/毫秒/纳秒获取instant对象
Instant obj = Instant.ofEpochMilli(0L);
日历:
LocalDate; LocalTime; LocalDateTime;
工具类;
Duration;时间间隔(秒);
Period日期间隔(年月日);
ChronoUnit(日期间隔)
```

## 包装类

Integer

Long

Boolean

`toBinaryString(int i)`得到二进制字符串

`parseXXX()`类型转换

## Arrays

```java
Arrays.toString(int[] arr); // 打印普通数组
arrays.binarySearch(数组, 要查找的元素);
Arrays.fill(数组, 元素);
Arrays.sort(); 
Arrays.sort();
Arrays.sort(数组, 排序规则);
// 包装类排序
Integer[] arr = {1, 2, 3, 4, 5, 7};
Arrays.sort(arr, new Comparator<Integer>() {
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; // 降序排序
    }
});
// 使用lambda表达式
Arrays.sort(arr, (Integer o1, Integer o2)->{
        return o2 - o1; // 降序排序
    }
);



```

## Lambda表达式

```java
() -> {
    
}
()内为形参
->固定格式
{}方法体
```

可以简化匿名内部类的书写

只能简化函数式接口的匿名内部类的书写

函数式接口: 有且仅有一个抽象方法的接口

```java
例如:
Arrays.sort(arr1, (Integer o1, Integer o2) -> {
    	return o2 - o1; // 降序排序
	}
);
```

()内的参数类型可以省略不写

只有一个参数 参数类型可以省略不写, ()也可省略

Lambda表达式的方法体只有一行, 大括号分号return都可以省略不写, 需要同时省略

```java
简化版本;
Arrays.sort(arr1, (o1, o2) -> o2 - o1);
```

##  单列集合顶层接口`Collection`

List: ArrayList, LinedList Vector

Set: TreeSet, Hashset: LinkedHashSet

## 迭代器遍历

```java
Iterator<String> it = list.iterator();
while (it.hasNext) {
    String str = it.next();
    sout(str);
}
```

## 增强for遍历

所有的单列集合和数组才可以用增强for遍历

修改增强for中的变量不会改变集合原本的数据

```java
for (Integer a : arr) {
    
}
```

## Lambda表达式遍历

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(100);
list.add(155);
list.forEach(a-> System.out.println(a));
```

