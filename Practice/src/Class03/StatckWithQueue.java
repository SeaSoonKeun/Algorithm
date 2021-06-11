package Class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * @Auther: xucg
 * @Date: 2021/6/10 - 06 - 10 - 5:38 下午
 * @Description: 队列实现栈
 * 思路：
 * 1、取栈数据时，先把队列中的数放到另外一个队列中。原队列中只剩一个数待取，
 * 2、队列
 * 注意点：
 * 1、可以循环使用两个队列，分工明确、
 * 2、每次从queue取数，就会更新一次help，并把help转为queue，每次还是从queue取数，和压入数。
 * 3、取数的时候记得把最后一个数留下，进行返回，这个数在栈和队列中就已经不存在了。
 */
public class StatckWithQueue {
    // 先定义两个队列,一个负责压取数据，另个一个辅助存储。数据来回倒，
        public static class TwoQueueStack<T>{
            public Queue<T> queue;
            public Queue<T> help;

            public TwoQueueStack() {
                queue = new LinkedList<>();
                help = new LinkedList<>();
            }

            // 出栈
            public T poll(){
                if (queue.size() > 1){
                    help.offer(queue.poll());
                }
                T ans = queue.poll();
                Queue<T> tmp = queue;
                queue = help;
                help = tmp;
                return ans;
            }

            // 只读栈顶不删除
            public T peek(){
                if (queue.size() > 1){
                    help.offer(queue.poll());
                }
                T ans = queue.poll();
                help.offer(ans);
                Queue<T> tmp = queue;
                queue = help;
                help = tmp;
                return ans;
            }

            // 压栈
            public void push(T v){
               queue.offer(v);
            }

            public boolean isEmpty(){
                return queue.isEmpty();
            }
        }
        public static void main(String[] args){
            System.out.println("test begin");
            TwoQueueStack<Integer> mystack= new TwoQueueStack<>();
            Stack<Integer> test = new Stack<>();
            int testTime = 1000000;
            int max = 100000;
            for (int i = 0; i < testTime; i++){
                // 自定义队列为空
                if (mystack.isEmpty()){
                    // 对数器test栈非空
                    if(!test.isEmpty()){
                        System.out.println("ops");
                    }
                    // 两个栈中都同时插入随机数
                    int num = (int)(Math.random() * max);
                    mystack.push(num);
                    test.push(num);
                    // 两队列都为空的情况下
                }else {
                    // 1/4 概率插入一个随机数
                    if (Math.random() < 0.25){
                        int num = (int)(Math.random() * max);
                        mystack.push(num);
                        test.push(num);
                        // 1/2 概率下 ，如果mystack和test栈顶元素相同(不删除)
                    }else if (Math.random() < 0.5){
                        //
                        if (!mystack.peek().equals(test.peek())){
                            System.out.println("oops");
                        }
                        // 3/4 概率下，如果mystack和test栈顶元素相同(删除)
                    }else if (Math.random() < 0.75){
                        if (!mystack.poll().equals(test.pop())){
                            System.out.println("ooops");
                        }
                    }else {
                        if (mystack.isEmpty() != test.isEmpty()){
                            System.out.println("oooops");
                        }
                    }
                }
            }
            System.out.println("test finish");
        }
}
