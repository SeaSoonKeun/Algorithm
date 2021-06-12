package Class03_02;

/**
 * @Auther: xucg
 * @Date: 2021/6/15 - 06 - 15 - 4:14 下午
 * @Description: 区间和个数
 * 给定一个数组arr，和两个整数a和b（a<=b）求arr中有多少个子数组，累加和在[a,b]这个范围上，返回达标的子数组数量
 * 给定一个数组arr，两个整数lower和upper，
 * 返回arr中有多少个子数组的累加和在[lower,upper]范围上
 *
 * 思路：前缀和数组
 */

public class Code08_CountOfRangeSum {
    public static int countOfRangeSum(int[] nums, int lower, int upper){
        if (nums == null || nums.length == 0){
            return 0;
        }
        // 前缀和数组
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return process(sum,0, sum.length-1, lower, upper);
    }
    public static int process(long[] sum, int L, int R, int lower, int upper){
        if (L == R){
            return sum[L] >= lower && sum[R] <= upper ? 1:0;
        }
        int M = L + ((R - L)>>1);
        return process(sum,L,M,lower,upper) +
                process(sum,M+1,R,lower,upper) +
                merge(sum,L,M,R,lower,upper);
    }
    public static int merge(long[] sum, int L, int M, int R, int lower, int upper){
        int ans = 0;
        // 求结果的时候窗口不回退，O(N)
        int windowL = L;
        int windowR = L;
        // [windowL,windowR) 窗口的表达，左闭右开 [14,14)代表一个数都没有
        for ( int i = M + 1; i <= R; i++){
            // [X-upper,X-lower]
            long t_lower = sum[i] - upper;
            long t_upper = sum[i] - lower;
            while (windowR <= M && sum[windowR] <= t_upper){
                windowR++;
            }
            while (windowL <= M && sum[windowL] < t_lower){
                windowL++;
            }
            // 窗口有可能会错位，max进行筛选。
            ans += Math.max(0,windowR - windowL);
        }

        // 利用归并排序不回退的技巧
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while(p1 <= M && p2 <= R){
            help[i++] = sum[p1] <= sum[p2] ? sum[p1++]:sum[p2++];
        }
        while(p1 <= M){
            help[i++] = sum[p1++];
        }
        while(p2 <= R){
            help[i++] = sum[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            sum[L + j] = help[j];
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
