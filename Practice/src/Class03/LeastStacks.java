package Class03;

import java.sql.Statement;
import java.util.Stack;

/**
 * @Auther: xucg
 * @Date: 2021/6/10 - 06 - 10 - 4:06 下午
 * @Description: 最小栈
 * 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
 * 1）pop、push、getMin操作的时间复杂度都是 O(1)。
 * 2）设计的栈类型可以使用现成的栈结构。
 *
 * 思路：设计两个相同高度的栈，最小栈随着新元素的压栈，会将当前压入栈的元素进行比较，取最小值放在栈顶。
 * 注意点：两边栈要保证同步，每部操作都需要关心两边元素的变化。
 */
public class LeastStacks {
    // 定义内部类 封装两个栈
    public static class MyStack1{
        private Stack<Integer> StackData;
        private Stack<Integer> StackMin;
        public MyStack1(){
            this.StackData = new Stack<Integer>();
            this.StackMin = new Stack<Integer>();
        }
        public void push(int num){
            if (this.StackMin.isEmpty()){
            this.StackMin.push(num);
            }else if (num <= this.getmin()){
                this.StackMin.add(num);
            }
            this.StackData.push(num);
        }

        public int pop(){
            if (this.StackData.isEmpty()){
                throw new RuntimeException("your stack is empty");
            }
            int value = this.StackData.pop();
            if (value == this.getmin()){
                this.StackMin.pop();
            }
            return value;
        }

        public int getmin(){
            if (this.StackMin.isEmpty()){
                throw new RuntimeException("Your Stack is empty");
            }
            // peek 不删除栈顶的值
            return this.StackMin.peek();
        }
    }

}
