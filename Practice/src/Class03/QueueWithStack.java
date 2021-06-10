package Class03;

import java.util.Stack;

/**
 * @Auther: xucg
 * @Date: 2021/6/10 - 06 - 10 - 5:09 下午
 * @Description: 栈实现队列
 * 思路：一个push栈。一个pop栈,
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
// 这是重点
    public void pushtopop(){
        if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
        pushtopop();
    }

    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("栈空的，取个屁");
        }
        pushtopop();
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("栈空的，取个屁");
        }
        pushtopop();
        return stackPop.peek();
    }

}

