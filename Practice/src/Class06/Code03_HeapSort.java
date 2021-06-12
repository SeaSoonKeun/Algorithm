package Class06;

import java.util.PriorityQueue;

/**
 * @Auther: xucg
 * @Date: 2021/6/15 - 06 - 15 - 10:08 下午
 * @Description: 堆排序 大到小
 */
public class Code03_HeapSort {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    // 大根堆
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
            }
    }
    // 下沉和孩子比较
    public static void heapify(int[] arr, int index, int heapSize){
        // 左孩子
        int left = index * 2 + 1;
        while (left < heapSize){
            // 左右孩子的最大值
            int largest = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1:left;
            // 最大的孩子和爹比较
            largest = arr[largest] > arr[index] ? largest : index;
            // 如果爹大，不用继续比较了
            if (largest == index){
                break;
            }
            // 孩子大，爹下去
            swap(arr,index,largest);
            // index 下沉
            index = largest;
            left = index * 2 + 1;
        }
    }
    public static void heapSort(int[] arr){
        // 先变成根堆结构 heapInsert
        // 弹出堆顶,恢复大小根堆结构 heapify
        // 依次弹出
        if (arr == null || arr.length<2){
            return;
        }
        // 从下往上使用heapify，大量叶子节点只用一层，时间复杂度用错位相减法得出是O(N).
        // 从上往下使用heapInsert，从第一层然后和叶子节点进行比较下沉，运算大量集中在叶子节点上，时间复杂度是O(N * logN)

        // 从最后一个开始，往上。
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr,i,arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            // 从上往下调整堆结构
            heapify(arr, 0, heapSize);
            // 最后一个和根交换
            swap(arr, 0, --heapSize);
        }
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,5,6,0,-2,-5};
        System.out.println("begin");
        printArray(test);
        heapSort(test);
        System.out.println("finish");
        printArray(test);
    }
}
