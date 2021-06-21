package Class10;

import java.util.Stack;

/**
 * @Auther: xucg
 * @Date: 2021/6/21 - 06 - 21 - 6:11 下午
 * @Description: 非递归实现二叉树的先中后遍历
 *
 * 先序：右左压栈，头左右
 * 中序：用左树分解掉
 * 后序：另一个栈，头右左，然后倒出来。
 */
public class Code03_UnRecursiveTraversalBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v){
            this.value = v;
        }
    }

    // 头左右
    public static void pre(Node head){
        if (head == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.add(head);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop.value);
            if (pop.right != null){
                stack.push(pop.right);
            }
            if (pop.left != null){
                stack.push(pop.left);
            }
        }
    }
    // 左边界遍历
    public static void in(Node head){
        if (head == null){
            return;
        }
        Stack<Node> stack= new Stack<Node>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop.value);
            Node popRight = pop.right;
            // 这边只需要比较一层就可以了
            if (popRight != null){
                stack.push(popRight);
                // 也只需要比较一层
                if (popRight.left != null){
                    stack.push(popRight.left);
                }
            }
        }
    }

    // 左神中序解法。像是引入了一个flag，循环结束会变成null，进入另一段代码。
    public static void in2(Node cur) {
        System.out.print("in-order: ");
        if (cur != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    // 双栈实现方式
    public static void pos1(Node head){
        if (head == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> help = new Stack<Node>();
        stack.push(head);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            help.push(pop);
            if (pop.left != null){
                stack.push(pop.left);
            }
            if (pop.right != null){
                stack.push(pop.right);
            }
        }
        while (!help.isEmpty()){
            System.out.println(help.pop().value);
        }

    }

    // 后序单栈实现
    // 通过h、c两个标记进行卡逻辑
    public static void pos2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                // 新节点。左树右树都没处理，压入左树
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                    // 左树处理完了，右树没处理，压入右树
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                    // 左右树都处理完了，压入头自己
                } else {
                    System.out.print(stack.pop().value + " ");
                    // h追踪上一个处理的节点
                    h = c;
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");

        pos1(head);
        System.out.println("========");

        in(head);
        System.out.println("========");

    }
}
