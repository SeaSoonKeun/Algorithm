package Class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: xucg
 * @Date: 2021/6/10 - 06 - 10 - 2:11 下午
 * @Description: Class03
 */
public class DoubleEndsQueueToStaskAndQueue {
    // 双端队列的数据结构
    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            value = data;
        }
    }

    public static class DoubleEndQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromTail(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
        }

        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }

        public T popFromTail() {
            if (head == null) {
                return null;
            }
            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                cur.last = null;
                tail.last = null;
            }
            return cur.value;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }


    // 双端队列实现栈
    public static class  MyStack<T> {
        private DoubleEndQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    // 双端队列实现队列
    public static class MyQueue<T> {
        private DoubleEndQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++){
            // 构造两个自定义栈和队列
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            // 构建两个系统自带栈和队列
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            // 循环比较
            for (int j = 0; j < oneTestDataNum; j++) {
                // 生成随机数
                int nums = (int)(Math.random() * value);
                // 如果栈是空的，自定义栈和系统栈同时压入随机数
                if (stack.isEmpty()){
                    myStack.push(nums);
                    stack.push(nums);
                }else {
                    // 非空的话 生成数 进行随机压入
                    if (Math.random() < 0.5){
                        myStack.push(nums);
                        stack.push(nums);
                    }else {
                        // 比较系统栈和自定义栈弹出的数值是否一致
                        if (!isEqual(myStack.pop(),stack.pop())){
                            System.out.println("ooops");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }

}
