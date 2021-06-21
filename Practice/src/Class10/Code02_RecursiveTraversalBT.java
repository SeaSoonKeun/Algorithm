package Class10;

/**
 * @Auther: xucg
 * @Date: 2021/6/21 - 06 - 21 - 4:45 下午
 * @Description: 二叉树遍历
 *
 * 递归序：每一个节点都会到达三次。
 * 先中后序是递归序加工后的结果。
 * 先序遍历：每个节点第一次到达打印
 * 中序遍历：每个节点第二次到达打印
 * 后续遍历：每个节点第三次到达打印
 *
 * 任何一个节点都有机会去左数收集信息回到它，去右树转一圈收集信息回到它，还能在第三次回到它的时候把左右两树的信息做整合。这是在树上做动态规划的基础。
 *
 * 子树：从某一节点出发，下面所有的东西都要包括。
 *
 * 证明题：
 *
 * 某个节点Ⅹ,有一个先序遍历的顺序,Ⅹ是二叉树中某一个节点,我得到了整棵树的先序遍历,我也知
 * 道这颗树的后序遍历,则有结论
 * Ⅹ先序遍历之前的节点定义为集合A,Ⅹ后序遍历之后的节点定义为集合B,则A∩B得到的解释是
 * 仅是X的祖先节点
 * 分为5类： X的所有孩子，X作为左树的右兄，X作为右树的左兄，X的祖先节点，X自己。
 *
 *
 * 递归方式实现三序遍历：
 */
public class Code02_RecursiveTraversalBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v){
            value = v;
        }
    }
    // 先序遍历
    public static void pre(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    // 中序遍历
   public static void in(Node head){
        if (head == null){
            return;
        }
        pre(head.left);
        System.out.println(head.value);
        pre(head.right);
   }

    // 后续遍历
   public static void pos(Node head){
        if (head == null){
            return;
        }
        pos(head.left);
        pos(head.right);
       System.out.println(head.value);
   }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos(head);
        System.out.println("========");

    }
}
