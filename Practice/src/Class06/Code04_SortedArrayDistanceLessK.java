package Class06;

import java.util.PriorityQueue;


/**
 * @Auther: xucg
 * @Date: 2021/6/16 - 06 - 16 - 11:20 上午
 * @Description: 相对几乎有序数组排序
 * 已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离一定不超过k，并且k相对于数组长度来说是比较小的。
 * 请选择一个合适的排序策略，对这个数组进行排序。
 *
 * 思路：heapSize为K的堆，每次弹出k的堆顶元素，依次进行加入。保证时间复杂度为O(N*logK)
 * 1）首先建立一个k长度的堆
 * 2）K+1 --> length-1 heapInsert 弹出堆顶元素
 * 3）
 */
public class Code04_SortedArrayDistanceLessK {
    public static void sortedArrayDistanceLessK(int [] arr, int k){
        if (k == 0){
            return;
        }
        // 初始化K堆
//        int[] heap = new int[k];
//        for (int i = 0; i < k; i++) {
//            heap[i] = arr[i];
//            heapInsert(heap,i);
//        }

        // 使用优先级队列容器进行实现。
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (;index <= Math.min(arr.length -1, k-1);index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++) {
            heap.add(arr[index]);
            arr[i++] = heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }

//    public static void heapInsert(int[] arr, int index){
//        while(arr[index] > arr[(index - 1)/2] ) {
//            swap(arr, index, (index - 1) / 2);
//            index = (index - 1) / 2;
//        }
//    }
//    public static void swap(int[] arr, int i, int j){
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = new int[]{3,2,1,5,4};
        printArray(test);
        sortedArrayDistanceLessK(test,2);
        printArray(test);
    }
}
