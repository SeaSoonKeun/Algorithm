package Class03_02;

/**
 * @Auther: xucg
 * @Date: 2021/6/15 - 06 - 15 - 12:05 下午
 * @Description: 求数组中逆序对数量
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。可以利用归并排序, 在merge的时候,统计逆序对个数。
 * 在一个数组中，任何一个前面的数a，和任何一个后面的数b，如果(a,b)是降序的，就称为逆序对, 返回数组中所有的逆序对
 */
public class Code06_ReversePair {
    public static int reversePair(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }
    public static int process(int[] arr, int L, int R){
        if (L == R){
            return 0;
        }
        int M = L + (R - L >> 1);
        return process(arr,L,M)
                +
                process(arr,M+1,R)
                +
                merge(arr,L,M,R);
    }
    public static int merge(int[] arr, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = help.length - 1;
        int res = 0;
        int p1 = M;
        int p2 = R;
        while(p1 >= L && p2 >= M+1){
            res += arr[p2] < arr[p1] ? p2 - M :0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while(p1 >= L){
            help[i--] = arr[p1--];
        }
        while(p2 >= M + 1){
            help[i--] = arr[p2--];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] test = new int[]{2,1,3,1};
        System.out.println(reversePair(test));
    }
}
