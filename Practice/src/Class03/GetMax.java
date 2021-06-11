package Class03;

/**
 * @Auther: xucg
 * @Date: 2021/6/10 - 06 - 10 - 10:00 下午
 * @Description: Class03
 */
public class GetMax {
    public static int getMax(int[] arr, int L, int R){
        // 注意basecase条件不能漏掉，不然会引起栈溢出
        if (L == R) {
            return arr[L];
        }
        // 位运算需要用括号括起来，运算优先级很低
        int mid = L + ((R - L) >> 1);
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);
        int ans =  Math.max(leftMax, rightMax);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,8};
        int max = getMax(arr,0,arr.length -1);
        System.out.println(max);
    }
}
