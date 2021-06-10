package Class03;

/**
 * @Auther: xucg
 * @Date: 2021/6/10 - 06 - 10 - 3:24 下午
 * @Description: 用数组实现队列
 * 两个指针begin, end
 * 增加一个size变量, 解耦 begin跟 end
 * 谁管着我能不能加, 跟能不能拿: Size 管着
 * 只要Size没有到5，我必能加把7放到 end所在的位置，
 * 然后让end++
 * 如果用户拿东西, 能不能size要不等于 0, 必能拿, 拿begin位置的数, 然后begin++, size--
 *
 * 思路：循环数组。
 * begin 和 end重合时，size满
 * 从begin出pop，size--
 * 从end处push，size++
 */
public class QueueWithArray {
    int[] arr = new int[10];
    int size = 0;
    int begin = 0;
    int end = 0;
    // 循环数组的关键之处，通过一个简单的三目解决
    public int nextIndex(int i){
        return i < arr.length -1? i+1: 0;
    }
    public int popFromHead(){
        // 判断是否为空
        if (size == 0){
            return -1;
        }
        // 不为空时，从开头弹出一个。
        else {
            size--;
            // ? 超过数组边界，怎么实现循环
            int ans = arr[begin];
            begin = nextIndex(begin);
            return ans;
        }
    }
    public void pushFromTail(int a){
        // 判断是否数组是否满
        if (size == arr.length){
            System.out.println("队列满了");
        }else{
            size++;
            arr[end] = a;
            end = nextIndex(end);
        }
    }
}
