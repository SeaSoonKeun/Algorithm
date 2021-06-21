package Class11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: xucg
 * @Date: 2021/6/21 - 06 - 21 - 8:48 下午
 * @Description: 序列化
 * 什么是序列化、反序列化
 * 有一棵树，如果机器停机，想把它转换成文件或者字符串的形式，代表唯一结构（树和字符串一一对应）----序列化
 * 从一个字符串形式还原成为内存结构---反序列化
 * <p>
 * 1）先序方式序列化和反序列化
 * <p>
 * 2）按层方式序列化和反序列化
 */
public class Code02_SerializeAndReconstructTree {

    // 先序遍历：序列化和反序列化
    // 用null值或者#等特殊字符串代表空，不可忽略
    public static class Node {
        public String value;
        public Node left;
        public Node right;

        public Node(String v) {
            this.value = v;
        }
    }

    public static Queue<String> preSerialize(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Queue<String> ans = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(cur);
        int num = 0;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            ans.add(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            } else {
                ans.add("X");
            }
            if (cur.left != null) {
                stack.push(cur.left);
            } else {
                ans.add("X");
            }
        }
        return ans;
    }

    public static Node buildByPreSerialze(Queue<String> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        return preb(queue);
    }

    public static Node preb(Queue<String> queue) {
        String value = queue.poll();
        if (value == "X") {
            return null;
        }
        Node head = new Node(value);
        head.left = preb(queue);
        head.right = preb(queue);
        return head;
    }


    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node("1");
        head.left = new Node("2");
        head.right = new Node("3");
        head.left.left = new Node("4");
        head.left.right = new Node("5");
        head.right.left = new Node("6");
        head.right.right = new Node("7");

        Queue<String> ans = preSerialize(head);
//        while (!ans.isEmpty()){
//            System.out.printf(ans.poll());
//        }
        System.out.println();
        System.out.println("========");

        Node node_ans = buildByPreSerialze(ans);
        printTree(node_ans);
    }
}
