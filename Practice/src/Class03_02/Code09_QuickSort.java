package Class03_02;

import jdk.jshell.spi.SPIResolutionException;

/**
 * @Auther: xucg
 * @Date: 2021/6/15 - 06 - 15 - 5:47 下午
 * @Description: 快速排序
 * 快排1.0
 * 最右边的数字，<= 区域 >区域
 * 快排2.0
 * 最右边的数字，<区域 = 区域 >区域
 * 快排3.0
 * 随机进行数值的交换，< = > 三个区域
 *
 */
public class Code09_QuickSort {
    // 返回等值数组长度 [开始位置，结束位置]
    // 荷兰国旗问题
    public static int[] netherland(int[] arr,int L,int R){
        if (L > R){
            return new int[]{-1, -1};
        }
        if (L == R ){
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while(index < more){
                // 相等时，直接下一个
            if (arr[index] == arr[R]){
                index ++;
                // 小于时，交换less+1的位置，index和less都加一，左边界向右扩
            }else if (arr[index] < arr[R]){
                swap(arr,index++,++less);
            }else{
                // 因为换过来的数还没有参与比较，所以index不用加，右边界向左扩
                swap(arr,index,--more);
            }
        }
        // 最后一个数和右边界的第一个数进行交换，把所有等于放中间。本来more是比当前数大的值，最后相等返回
        swap(arr,more,R);
        // less + 1,小于区的后一个数是等于
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length-1);
    }

    public static void process(int[] arr, int L, int R){
        if (L >= R){
            return;
        }
        // 比2.0多一步随机交换值，把随机数与最后一个数进行交换
        swap(arr, L+(int)(Math.random() * (R - L + 1)), R);
        // 选出等于区，递归对非等于区进行"内部等于区"的选举，保证整体是有序的。
        int[] equalArea = netherland(arr, L ,R);
        process(arr,L,equalArea[0]);
        process(arr,equalArea[1]+1,R);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3,5, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
