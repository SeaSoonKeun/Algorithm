package Class10;

import java.util.HashSet;

/**
 * @Auther: xucg
 * @Date: 2021/6/21 - 06 - 21 - 1:20 下午
 * @Description: 单链表爹题
 * <p>
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
 * 【要求】
 * 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度 请达到O(1)
 *
 * 笔记：
 * 能不能不给单链表的头节点，只给想要删除的节点，就能做到在链表上把这个点删掉？
 * 答案：不能，正常单链表是给头链表进行删除指定的元素。返回Node类型，因为头部元素也可能是要删除元素。
 * 有问题：
 * 1）最后一个节点删不掉，null是一块独立的内存区域。null在系统中也是一个有地址的区域，也需要前一个节点的指针指向这块区域，但是现在拿不到前一个节点，因此没有办法删除
 * 2）工程中，后面元素内容可能很复杂，没有很好地办法进行复制。
 */
public class Code01_FindFirstIntersecNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            this.value = v;
        }
    }
        public static Node getIntersectNode(Node head1, Node head2) {
            if (head1 == null || head2 == null) {
                return null;
            }
            Node loop1 = isCircleList2(head1);
            Node loop2 = isCircleList2(head2);
            if (loop1 == null && loop2 == null) {
                return noLoop(head1, head2);
            }
            if (loop1 != null && loop2 != null) {
                return bothLoop(head1, loop1, head2, loop2);
            }
            return null;
        }

        // 容器方法实现 判断单链表是否有环，有环的话返回入环节点，没有的话返回空
        public static Node isCircleList1(Node head) {
            HashSet<Node> hashSet = new HashSet<>();
            Node cur = head;
            while (cur != null) {
                if (hashSet.contains(cur)) {
                    return cur;
                } else {
                    hashSet.add(cur);
                    cur = cur.next;
                }
            }
            return null;
        }

        // 快慢指针实现判断是否有环
        public static Node isCircleList2(Node head) {
            if (head == null || head.next == null || head.next.next == null) {
                return null;
            }
            Node slow = head;
            Node fast = head;
            // 注意此处快慢指针为&&都不能为空
            while ( fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                // 会相等就一定有环，找到入环节点。
                if (slow == fast) {
                    fast = head;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return slow;
                }
            }
            return null;
        }

        // 因为无环和有环单链表不可能相交，所以只用分析两种情况。

        // 两个无环单链表判断是否相交，相交返回相交节点，不相交返回null
        public static Node noLoop(Node head1, Node head2) {
            Node cur1 = head1;
            int len1 = 0;
            while (cur1 != null) {
                len1++;
                cur1 = cur1.next;
            }
//            System.out.println("len1:" + len1);
            Node cur2 = head2;
            int len2 = 0;
            while (cur2 != null){
                len2++;
                cur2 = cur2.next;
            }
//            System.out.println("len2:" + len2);
            // 如果最后一个节点相等说明相交,找第一个相交节点
            if (cur1 == cur2){
                int n = Math.abs(len1 - len2);
//                System.out.println("n:" + n);
                if (len1 >= len2){
                    cur1 = head1;
                    while(n != 0){
                        cur1 = cur1.next;
                        n--;
                    }
                    cur2 = head2;
                    // 注意：相等的时候跳出循环
                    while(cur1 != cur2){
                        cur1 = cur1.next;
                        cur2 = cur2.next;
                    }
                    return cur1;
                }
                else{
                    cur2 = head2;
                    while(n != 0){
                        cur2 = cur2.next;
                        n--;
                    }
//                    System.out.println(cur2.value);
                    cur1 = head1;
                    // 注意：相等的时候跳出循环
                    while(cur1 != cur2){
                        cur1 = cur1.next;
                        cur2 = cur2.next;
                    }
//                    System.out.println(cur1.value);
                    return cur1;
                }
            }
            return null;
        }

        // 两个有环单链表判断是否相交，相交返回相交节点，不相交返回null
        // 有环情况可以根据入环节点是否为同一个分为两种情况，
        //        如果是同一个入环节点，则只有一个相交节点。
        //        如果不是同一个入环节点，则两个入环节点都是相交节点，随机返回一个。
        public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
            if (loop1 == loop2){
                Node l1_next = loop1.next;
                Node l2_next = loop2.next;
                loop1.next = null;
                loop2.next = null;
                Node res =  noLoop(head1, head2);
                loop1.next = l1_next;
                loop2.next = l2_next;
                return res;
            }
            else {
                // 从loop1下一个节点开始找，直到绕完一个圈
                Node cur = loop1.next;
                while (cur != loop1){
                    if (cur == loop2){
                        return loop1;
                    }
                    cur = cur.next;
                }
                return null;
            }
        }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }

}
