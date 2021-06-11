package Class03;

import java.util.Stack;

/**
 * @Auther: xucg
 * @Date: 2021/6/10 - 06 - 10 - 5:09 下午
 * @Description: 栈实现队列
 * 思路：一个push栈。一个pop栈,队列中元素分散在两个栈中需要注意两边的同步和协调。
 * 来回倒，有两个原则：
 * 1、pop栈非空不能倒
 * 2、push栈到pop栈一次性倒完
 */
public class QueueWithStack {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;
    public QueueWithStack(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }
// 这是重点,pop栈为空时，push栈不为空时，把push栈所有元素都压入到pop栈。
    public void pushtopop(){
        if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
// 压入第一个元素的时候，会检测pop栈是否为空，为空时压入所有
    public void add(int pushInt){
        stackPush.push(pushInt);
        pushtopop();
    }
// 取出元素时，会判断两边是否为空，如果两个边有一个不为空，有元素。
// pop栈不为空，直接弹出栈顶元素，pop栈为空，把push栈所有元素都压入进去。会引起两边栈的一次更新。
    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("栈空的，取个屁");
        }
        pushtopop();
        return stackPop.pop();
    }
// 查看元素
    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("栈空的，取个屁");
        }
        pushtopop();
        return stackPop.peek();
    }

}

