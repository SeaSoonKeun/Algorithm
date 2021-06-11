package Class03;

import java.util.Dictionary;

/**
 * @Auther: xucg
 * @Date: 2021/5/19 - 05 - 19 - 下午10:45
 * @Description: 双链表由最基本的双链表doublenode链接而成，牢记。一个值（赋值语句），两个引用。
 */
public class DoubleNode {
    public int value;
    public DoubleNode pre;
    public DoubleNode next;
    public DoubleNode(int data){
        value = data;
    }
}
