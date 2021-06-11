package Class03;

/**
 * @Auther: xucg
 * @Date: 2021/6/10 - 06 - 10 - 3:24 下午
 * @Description: 用数组实现栈
 * 思路：数组实现先抓住整体大小，避免因为位置引入多余的操作。
 */
public class StackWithArray {
    int[] arr = new int[5];
    int size = arr.length;
    int index = 0;
    public class MyStack{
        public void push(int a){
            if (size == arr.length){
                System.out.println("栈满了");
            }else {
                arr[index]=a;
                index++;
                size++;
            }
        }
        public int pop(){
            if (size > 0){
                size--;
                return arr[index];
            }
            else {
                System.out.println("栈是空的");
                return -1;
            }
        }
    }
}

