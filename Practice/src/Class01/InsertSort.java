package Class01;

import java.util.Arrays;

/**
 * @Auther: xucg
 * @Date: 2021/5/15 - 05 - 15 - 下午9:37
 * @Description: Class01
 */
/*
解题思路：
一个一个取，然后插入到前面的数组中；移动过程有点类似与冒泡算法
 */
public class InsertSort {
    public static void insertSort(int[] arr){
        if(arr.length == 0 || arr.length == 1)
            return;
        // 从第二个数开始
        for (int i = 1; i < arr.length; i++) {
            // 注意此处判断条件的顺序，不可以反，否则会引起数组越界
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--){
                //类似冒泡排序算法交换元素
                swap(arr, j, j+1);
            }
        }
    }
    public static int[] generatArray(int maxSize, int maxValue){
        int length = (int)((maxSize + 1) * Math.random());
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int value = (int)((maxValue + 1) * Math.random()) - (int)((maxValue + 1) * Math.random());
            arr[i] = value;
        }
        return arr;
    }
    public static void swap(int[] arr, int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
    // Arrays工具对数器
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    // 复制数组
    public static int[] copyArray(int[] arr){
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }
    // 打印数组
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // 判断两个数组是否相等
    public static boolean isEqual (int[] arr1, int[] arr2){
        if (arr1.length != arr2.length){
            return false;
        }
        if (((arr1 == null)&& (arr2 != null))||((arr1 != null)&&(arr2 == null))){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int testTime = 100;
        int maxSize = 10;
        int maxValue = 20;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generatArray(maxSize, maxValue);
//            printArray(arr1);
            int[] arr2 = copyArray(arr1);
            insertSort(arr1);
//            printArray(arr1);
            comparator(arr2);
//            printArray(arr2);
            System.out.println(isEqual(arr1, arr2) ? "success" : "failed");
        }
    }
}
