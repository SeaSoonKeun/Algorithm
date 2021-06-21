package Class09;

import java.util.HashMap;

/**
 * @Auther: xucg
 * @Date: 2021/6/18 - 06 - 18 - 6:16 下午
 * @Description: 一种特殊的单链表节点类描述如下
 * class Node {
 * int value;
 * Node next;
 * Node rand;
 * Node(int val) { value = val; }
 * }
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点 head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
 * 【要求】
 * 时间复杂度O(N)，额外空间复杂度O(1)
 * <p>
 * 思路：
 * 笔试方法1：利用HashMap的key 和 Value的对应关系进行新老节点的映射，最后通过遍历，完成链表的复制。
 */
public class Code04_CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int v) {
            this.value = v;
        }
    }

    // 笔试方法
    public static Node copyListWithRand1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashMap<Node, Node> oldToNew = new HashMap<Node, Node>();
        Node cur = head;
        // 复制生成所有节点
        while (cur != null) {
            oldToNew.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        // 遍历链表进行新链表的生成
        cur = head;
        while (cur != null) {
            oldToNew.get(cur).next = oldToNew.get(cur.next);
            oldToNew.get(cur).rand = oldToNew.get(cur.rand);
            cur = cur.next;
        }
        return oldToNew.get(head);
    }

    // 面试最省空间方法
    public static Node copyListWithRand2(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 老节点后加一个点
        Node cur1 = head;
        while (cur1 != null) {
            Node newNode = new Node(cur1.value);
            newNode.next = cur1.next;
            cur1.next = newNode;
            cur1 = newNode.next;
        }
        // 复制老节点的rand引用
        cur1 = head;
        while (cur1 != null) {
            if (cur1.rand != null){
                cur1.next.rand = cur1.rand.next;
                cur1 = cur1.next.next;
                }
            else {cur1 = cur1.next.next;}
        }

        // 提取新节点
        Node newNodeHead = head.next;
        cur1 = head;
        Node cur2 = cur1.next;
        // && cur2 != null && cur2.next != null
        while( cur2 != null ){
                cur1.next = cur2.next;
                if (cur2.next != null){
                cur2.next = cur2.next.next;
                cur1 = cur1.next;
                cur2 = cur2.next;
                }
                else {
                    break;
                }
        }
        return newNodeHead;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        System.out.println("原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");
        res1 = copyListWithRand1(head);
        System.out.println("方法一的拷贝链表：");
        printRandLinkedList(res1);
        System.out.println("=========================");
        res2 = copyListWithRand2(head);
        System.out.println("方法二的拷贝链表：");
        printRandLinkedList(res2);
        System.out.println("=========================");
        System.out.println("经历方法二拷贝之后的原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
