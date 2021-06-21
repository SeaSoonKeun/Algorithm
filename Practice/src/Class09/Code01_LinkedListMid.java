package Class09;

/**
 * @Auther: xucg
 * @Date: 2021/6/18 - 06 - 18 - 12:49 下午
 * @Description: 链表中点-快慢指针
 *
 * 1）输入链表头节点，奇数长度返回中点，偶数长度返回上中点
 *
 * 2）输入链表头节点，奇数长度返回中点，偶数长度返回下中点
 *
 * 3）输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
 *
 * 4）输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
 */
public class Code01_LinkedListMid {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }
    // 1）输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static Node midOrUpMidNode(Node head){
        if (head.next == null || head.next.next == null){
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 2）输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public static Node midOrDownMidNode(Node head){
        if (head.next == null || head == null){
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //3）输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
    public static Node midPreOrUpMidPreNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // 4）输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
    public static Node midPreOrDownMidPre(Node head){
        if (head == null || head.next == null){
            return null;
        }
        if (head.next.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
