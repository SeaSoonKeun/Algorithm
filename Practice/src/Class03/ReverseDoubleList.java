package Class03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xucg
 * @Date: 2021/5/19 - 05 - 19 - 下午10:49
 * @Description: 逆转双链表
 * 思路：抓住双链表中的引用节点，对当前节点进行操作就可以了，不需要考虑后面的节点，但要保证链表的指针不能断掉。
 * 双链表的定义也是从单个应用节点出发，所以可以参考。举一反三。
 */
public class ReverseDoubleList {
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode Prev = null;
        DoubleNode Next = null;
        while(head!=null) {
            Next = head.next;
            head.pre = Next;
            head.next = Prev;
            Prev = head;
            head = Next;
        }
        return Prev;
    }
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        // 使用ArrayList做对数器
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    // for test
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.pre;
        }
        return true;
    }
    // 生成随机双链表，使用一个cur引用变量，保留头指针的同时，替头指针完成循环追加元素的功能
    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    public static void main(String args[]){
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            DoubleNode node3 = generateRandomDoubleList(len, value);
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            node3 = reverseDoubleList(node3);
            if (!checkDoubleListReverse(list3, node3)) {
                System.out.println("Oops3!");
            }

            DoubleNode node4 = generateRandomDoubleList(len, value);
            List<Integer> list4 = getDoubleListOriginOrder(node4);
            node4 = reverseDoubleList(node4);
            if (!checkDoubleListReverse(list4, node4)) {
                System.out.println("Oops4!");
            }

        }
        System.out.println("test finish!");

    }
}
