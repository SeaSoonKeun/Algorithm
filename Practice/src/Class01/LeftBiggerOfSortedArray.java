package Class01;

import java.util.Arrays;

/**
 * @Auther: xucg
 * @Date: 2021/5/17 - 05 - 17 - 上午8:44
 * @Description: Class01
 */
public class LeftBiggerOfSortedArray {
    public static void main(String[] args) {
        int testTime = 30;
        int maxSize = 10;
        int maxValue = 20;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            Arrays.sort(arr1);
            printArray(arr1);
            int[] arr2 = copyArray(arr1);
//            System.out.println(leftBiggerOfSortedArray(arr1, 3) == comparator(arr2, 3) ?
//                    "大于等于3最左侧的位置索引是：" + leftBiggerOfSortedArray(arr1, 3) : "出错了");
            System.out.println(leftBiggerOfSortedArray(arr1, 3) == comparator(arr2, 3) ?
                    "success" : "fail");
        }
    }
    public static int leftBiggerOfSortedArray(int[] arr, int num){
        if (arr.length == 0){
            return -1;
        }else{
            int L = 0;
            int R = arr.length - 1;
            int Mid = 0;
            // 引入index
            int index = -1;
            if(arr[R] < num){
                return -1;
            }
            while (L <= R){
                Mid = L + ((R - L) >> 1);
                if (arr[Mid] >= num){
                    index = Mid;
                    R = Mid - 1;
                }else {
                    L = Mid + 1;
                }
            }
            return index;
        }
    }
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int length = (int)((maxSize + 1) * Math.random());
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            int value = (int)((maxValue + 1) * Math.random()) - (int)((maxValue + 1) * Math.random());
            arr[i] = value;
        }
        return arr;
    }
    public static int[] copyArray(int[] arr){
        if (arr.length == 0){
            System.out.println("数组为空");
            return null;
        }
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }
    public static void printArray(int[] arr ){
        if (arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int comparator(int[] arr, int num){
        if(arr == null || arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= num){
                return i;
            }
        }
        return -1;
    }
}
