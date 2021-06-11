package Class03_02;

import java.util.TreeMap;

/**
 * @Auther: xucg
 * @Date: 2021/6/11 - 06 - 11 - 11:30 上午
 * @Description: 有序表 接口名
 * 功能比 哈希表 强大
 * 红黑树 TreeMap
 * avl,sb树，跳表
 * O(logN)
 * 值传递，按有序组值
 * 注意：有序表传非基础类型时，需要自己实现比较器
 */
public class Code02_TreeMap {
    public static void main(String[] args) {
        TreeMap<Integer,String> test = new TreeMap<>();
        int a = 1;
        int b = 2;
        int c = 3;
        test.put(a,"我是a");
        test.put(b,"我是b");
        test.put(c,"我是c");
        System.out.println(test.containsKey(1));
        System.out.println(test.containsKey(4));
        System.out.println(test.get(4));
        System.out.println(test.get(3));
        // 第一个key
        System.out.println(test.firstKey());
        // 最后一个key
        System.out.println(test.lastKey());
        // 返回小于或等于返回到给定键的最大键
        System.out.println(test.floorKey(3));
        // 返回大于或等于返回到给定键的最小键
        System.out.println(test.ceilingKey(5));
    }
}
