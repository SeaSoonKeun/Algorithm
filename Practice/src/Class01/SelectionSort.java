package Class01;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: xucg
 * @Date: 2021/5/15 - 05 - 15 - 下午4:02
 * @Description: Class01
 */
/* 选择排序思路
从小到大排序情况：
每次选择数组中最小的数 与数组第一个数进行交换位置，
然后选择前n-1个数值进行再次排序，然后再选择其中最小的数与第二个数进行交换
 */
public class SelectionSort {
    public static void selectionSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minindex = arr[j] < arr[minindex] ? j : minindex;
            }
            // 因为采用异或的方式进行置换元素，所以需要保证两个数不一样
            if( i != minindex){
                swap(arr, i, minindex);
            }
        }
    }
// 交换两个数组元素的位置
    public static void swap(int arr[], int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
    }
// 随机生成数组
    public static int[] generateRadomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)((maxValue + 1) * Math.random());
        }
        return arr;
    }
// 对数器
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
// 比较两个数数组是否一致
    public static boolean isEqual(int[] arr1, int[] arr2 ){
        if (arr1.length != arr2.length){
            return false;
        }
        if (arr1 == null && arr2 == null){
            return true;
        }
        if ((arr1 == null && arr2 != null) || (arr2 == null && arr1 != null)){
            return false;
        }
        for (int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
// 拷贝数组至一个新的数组
    public static int[] copyArray(int[] arr1 ){
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }
// 输出数组
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int testTime = 100;
        int maxSize = 10;
        int maxValue = 20;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRadomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            //printArray(arr1);
            comparator(arr2);
            //printArray(arr2);
            System.out.println(isEqual(arr1,arr2) ? "success":"failed");
        }
    }
}
