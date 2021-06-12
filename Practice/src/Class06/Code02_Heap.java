package Class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: xucg
 * @Date: 2021/6/15 - 06 - 15 - 9:09 下午
 * @Description: 堆结构
 * 通过比较器实现大根堆和小根堆
 * 完全二叉树：
 * 左孩子 2*i + 1
 * 右孩子 2*i + 2
 * 父节点 （i - 1）/ 2 默认向下取整
 * 堆满足：
1）堆结构就是用数组实现的完全二叉树结构
2）完全二叉树中如果每棵子树的最大值都在顶部就是大根堆
3）完全二叉树中如果每棵子树的最小值都在顶部就是小根堆
4）堆结构的heapInsert与heapify操作
5）堆结构的增大和减少
6）优先级队列结构，就是堆结构，默认是小根堆

只有两个操作：
 heapInsert 新节点干老爹的过程。 从下（最底层）往上
 heapify 老爹被干掉了，选举最强的儿子。从上往下
最大值，从堆上删掉。头结点和最后一个节点交换实现逻辑删除。找较大的孩子比较和自己比较，下沉的过程。

未知位置的值发生变化 使用heapInsert和heapify可以使其归位。因为只会执行一个。

 复杂度：高度是logN
 O(logN)
 */
public class Code02_Heap {
    public static class MyComp implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static void swap(int [] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index -1) / 2]){
            swap(arr,index,(index-1)/2);
            index = (index - 1)/2;
        }
    }
    // 从index位置，往下看，不断的下沉
    // 停：较大的孩子都不再比index位置的数大；已经没孩子了
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            // 左右孩子的最大值
            int largest = left + 1 < heapSize && arr[left+1] > arr[left] ? arr[left+1]:arr[left];
            // 孩子和爹比较
            largest = arr[largest] > arr[index] ? largest : index;
            // 如果爹大，不用继续比较了
            if (largest == index){
                break;
            }
            swap(arr,index,largest);
            // index 下沉
            index = largest;
            left = index * 2 + 1;
        }
    }



    public static void main(String[] args) {
        System.out.println("begin =========");
        // 默认是小根堆，可以加重复值。
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComp());
        heap.add(10);
        heap.add(11);
        heap.add(9);
        heap.add(12);
        heap.add(3);
        heap.add(4);
        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
