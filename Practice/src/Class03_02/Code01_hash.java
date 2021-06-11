package Class03_02;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;

/**
 * @Auther: xucg
 * @Date: 2021/6/11 - 06 - 11 - 10:48 上午
 * @Description: 哈希表
 * 1)哈希表在使用层面上可以理解为一种集合结构
 * 2)如果只有key，没有伴随数据value，可以使用HashSet结构
 * 3)如果既有key，又有伴随数据value，可以使用HashMap结构
 * 4)有无伴随数据，是HashMap和HashSet唯一的区别，实际结构是一回事
 * 5)使用哈希表增(put)、删(remove)、改(put)和查(get)的操作，可以认为时间复杂度为 O(1)，但是常数时间比较大
 * 6)放入哈希表的东西，如果是基础类型，内部按值传递，内存占用是这个东西的大小
 * 7)放入哈希表的东西，如果不是基础类型，内部按引用传递，内存占用是8字节
 *
 * 注意：在正常使用时，Integer: -128~127, 值传递, 超过这个范围引用传递，在hashMap中仍然按照值传递
 * String其他地方是引用传递，Hash表里是值传递。
 */
public class Code01_hash {
    public static class Xu{
        int value;
        public Xu(int v){
            this.value = v;
        }
    }
    public static void main(String[] args) {
        HashMap<Integer, String> test = new HashMap<>();
        // HashMap key 基础类型按照值传递
        Integer a = 19000;
        Integer b = 19000;
        // == 是比较引用地址
        System.out.println(a == b);

        test.put(a,"我是a");
        // HashMap允许key和value都是null
        test.put(null,null);
        System.out.println(test.containsKey(b));

        // HashMap key传递String,证明HashMap也是按照"值传递"传递String类型的值
        HashMap<String,String> test01 = new HashMap<>();
        String s1 = "hhhha";
        String s2 = "hhhha";
        test01.put(s1,"我是s1");
        System.out.println(test01.containsKey(s2));

        // HashMap key传递int 不支持，需要基本数据类型的包装类
        // HashMap<int,String> 不支持！！


        // HashMap key非基础类型，按照引用传递。
        Xu x1 = new Xu(1);
        Xu x2 = new Xu(1);
        HashMap<Xu,String> test2 = new HashMap<>();
        test2.put(x1,"我是x1");
        System.out.println(test.containsKey(x2));

    }
}
