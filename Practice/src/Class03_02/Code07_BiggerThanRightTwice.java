package Class03_02;

/**
 * @Auther: xucg
 * @Date: 2021/6/15 - 06 - 15 - 3:40 下午
 * @Description: 在一个数组中，
 * 对于每个数num，求有多少个后面的数 * 2 依然<num，求总个数
 *
 * ```text
 * 比如：[3,1,7,0,2]
 * 3的后面有：1，0
 * 1的后面有：0
 * 7的后面有：0，2
 * 0的后面没有
 * 2的后面没有
 * 所以总共有5个
 * ```
 * 利用mergeSort变成有序，然后进行左右指针的单向遍历，比较出想要的结果
 */
public class Code07_BiggerThanRightTwice {
    public static int biggerThanRightTwice(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R){
        if (L == R){
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr,L,M)
                +
                process(arr, M +1, R)
                +
                merge(arr, L, M, R);
    }

    public static int merge(int[] arr, int L, int M, int R){
        // 利用窗口进行比较，直到右边不满足条件，把右组左边窗口个数进行返回。
        int ans = 0;
        int windowsR = M + 1;
        // for 循环左组的元素，与右边的窗口进行比较
        for (int i = L; i <= M ; i++) {
            while (windowsR <= R && arr[i] > (arr[windowsR] * 2)){
                windowsR++;
            }
            ans += windowsR-(M+1);
        }

        int i = 0;
        int[] help = new int[R-L+1];
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,3,2,1};
        System.out.println(biggerThanRightTwice(test));
    }
}
