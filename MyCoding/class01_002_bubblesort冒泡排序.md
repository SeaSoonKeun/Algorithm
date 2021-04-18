[TOC]
## code
```
package com.xucg;
/* 冒泡排序
 * 思路：因为从小到大，从最后一个数字开始，开始第一层遍历，第二层从0到倒数第一个数进行逐次比较，逐个将最大的数顶上倒数第一个位置。
 * 时间复杂度：遍历N个数，第一次N个数比较，第二次N-1个数比较，相加为等差数列，复杂度为O(n^2)
 * 空间复杂度：不需要额外的空间,左右进行交换
*/
// 从小到大冒泡排序
public class BubbleSort {

    public static void arrayReader(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] generateRadomArray(int maxLength, int range){
        int length = (int)(Math.random() * (maxLength + 1));
        int[] arr = new int[length];
        for (int i = 0; i < length; i++){
            int value = (int)(Math.random() * (range + 1)) - (int)(Math.random() * (range + 1));
            arr[i] = value;
        }
        return arr;
    }
//异或位运算进行交换
    public static void swap(int[] arr, int i, int k){
        arr[i] = arr[i] ^ arr[k];
        arr[k] = arr[i] ^ arr[k];
        arr[i] = arr[i] ^ arr[k];
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
    }

    public static int[] bubbleSort(int[] arr){
        for (int i = arr.length -1; i > 0; i--){
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = generateRadomArray(10, 20);
        arrayReader(arr);
        System.out.println();
        arrayReader(bubbleSort(arr));
    }
}


```
## result

## summary

