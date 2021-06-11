package Class03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xucg
 * @Date: 2021/5/19 - 05 - 19 - 下午10:48
 * @Description: 逆转单链表，参照双链表的思路，一样的。多了一步操作。
 */
/*
* 反转单链表*/
public class ReverseLinkedList {
    public static Node reverseLinkedList(Node head){
        Node Pre = null;
        Node Next = null;
        //头指针不为空，进行循环，因为循环体内头指针最后指向了Next节点。如果Next节点都为空，没有继续反转的必要
        while (head != null){
            // 先根据head指针确定 Next指针的位置，
            Next = head.next;
            // 把head.next位置确认，保证head和head指向前一个节点的指针正确性
            head.next = Pre;
            // 新的头节点位置
            Pre = head;
            // 头节点去完原始下一节点位置，保证单向链表不出现断链的情况
            head = Next;
        }
        return Pre;
    }

    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }
    public static void main(String[] args) {
        Node node1 = generateRandomLinkedList(10, 10);
        List<Integer> list1 = getLinkedListOriginOrder(node1);
        node1 = reverseLinkedList(node1);
        if (!checkLinkedListReverse(list1, node1)) {
            System.out.println("Oops1!");
        }
    }
}
