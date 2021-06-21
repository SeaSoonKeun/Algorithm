package Class11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: xucg
 * @Date: 2021/6/21 - 06 - 21 - 8:20 下午
 * @Description: 二叉树按层遍历
 * 1）其实就是宽度优先遍历，用队列
 * 2）可以通过设置flag变量的方式，来发现某一层的结束（看题目）
 *
 * 类似于BFS，调用队列实现。
 * 1）队列从头进，从尾出，空节点不加
 * 2）弹出元素，有左进左，有右进右
 *
 */
public class Code01_LevelTraversalBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v){
            this.value = v;
        }
    }
    public static void levelTraversalBT(Node head){
        if (head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.value);
            if (poll.left != null){
                queue.add(poll.left);
            }
            if (poll.right != null){
                queue.add(poll.right);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        levelTraversalBT(head);
        System.out.println("========");
    }

}
