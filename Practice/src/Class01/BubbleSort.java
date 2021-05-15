package Class01;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.Arrays;

/**
 * @Auther: xucg
 * @Date: 2021/5/15 - 05 - 15 - 下午8:23
 * @Description: Class01
 */

/*
解题思路：
从左到右，增序排列
第一层：
第一个和第二个比，大的冒泡
第二个和第三个比，大的冒泡，
……
直到最大的冒泡到最后面，利用swap交换
第二层：
依次第二大的冒泡到倒数第二个位置
……
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0 ; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
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
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    public static int[] copyArray(int[] arr){
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
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
            //printArray(arr1);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            //printArray(arr1);
            comparator(arr2);
            //printArray(arr2);
            System.out.println(isEqual(arr1, arr2) ? "success" : "failed");
        }
    }
}
