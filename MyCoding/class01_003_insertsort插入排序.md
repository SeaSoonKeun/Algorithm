[TOC]
## code
```
import java.util.Arrays;

public class InsertSort {
    public static void arrayReader(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static int[] generateRandomAraay(int maxLength, int valueRange){
        int length = (int)((maxLength + 1) * Math.random());
        int[] arr = new int[length];
        for (int i = 0; i < length; i++){
            int value = (int)((valueRange + 1) * Math.random()) - (int)((valueRange + 1) * Math.random());
            arr[i] = value;
        }
        return arr;
    }
    public static int[] arraySort(int[] arr1){
       Arrays.sort(arr1);
       int[] arr2 = new int[arr1.length];
       for (int i = 0; i < arr1.length; i++){
           arr2[i] = arr1[i];
       }
       return arr2;
    }

    public static void insertSort(int[] arr){
        if(arr.length == 0 || arr.length == 1)
            return;
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--){
                swap(arr, j, j + 1);
            }
        }
    }

    public static boolean compareTwoArray(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length || arr1.length == 0 )
            return true;
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int Times = 1000;
        int maxLength = 20;
        int maxRange = 20;
        for (int i = 0; i < Times; i++) {
            int[] arr = generateRandomAraay(maxLength, maxRange);
            System.out.println("输入数组为：" );
            arrayReader(arr);
            System.out.println();
            int[] arr1 = arraySort(arr);
            System.out.println("对数器输出数组为：" );
            arrayReader(arr1);
            insertSort(arr);
            System.out.println();
            System.out.println("程序输出数组为：" );
            arrayReader(arr);
            System.out.println();
            boolean result = compareTwoArray(arr1, arr);
            if (result == true) {
                System.out.println("succeed");
            } else {
                System.out.println("Failed");
            }
        }
    }
}

```

## result
```
输入数组为：
-16 -1 -13 -12 -9 0 -4 10 2 -2 -2 -12 2 -5 -4 5 13 -8 5 2 
对数器输出数组为：
-16 -13 -12 -12 -9 -8 -5 -4 -4 -2 -2 -1 0 2 2 2 5 5 10 13 
程序输出数组为：
-16 -13 -12 -12 -9 -8 -5 -4 -4 -2 -2 -1 0 2 2 2 5 5 10 13 
succeed
输入数组为：
-13 6 9 -4 -5 
对数器输出数组为：
-13 -5 -4 6 9 
程序输出数组为：
-13 -5 -4 6 9 
succeed
输入数组为：
-1 -1 
对数器输出数组为：
-1 -1 
程序输出数组为：
-1 -1 
succeed
输入数组为：
7 -10 3 
对数器输出数组为：
-10 3 7 
程序输出数组为：
-10 3 7 
succeed
```
## summary
```
    public static void insertSort(int[] arr){
        if(arr.length == 0 || arr.length == 1)
            return;
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--){
                swap(arr, j, j + 1);
            }
        }
    }
```
注意边界位置，第二层插入数据时，j从[0,i-1] j+1从[1,i], 就相当于[0,i]个数进行排序