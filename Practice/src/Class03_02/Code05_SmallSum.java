package Class03_02;

/**
 * @Auther: xucg
 * @Date: 2021/6/11 - 06 - 11 - 6:46 下午
 * @Description: 最小和问题
 * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 * 思路：
 * 暴力解法：当前选定元素也可以向右移动，左边的元素同时通过指针进行向右移动，移动到选定元素结束
 * 归并解法：有方向性
 * 把问题换个角度，左边比他小的数，就是求某数右边有多少个数比他大。
 * 定义一个全局变量总和，先进行归类，左边的数（向右单方向移动），每次只用跟右边组（也是向右单方向移动）进行比较，有大的数量进行加一，最后和基准点数值相乘得到该数的和。
 * 参数定义
 */
public class Code05_SmallSum {
    public static int process(int[] arr,int L,int R){
        if (L == R){
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr, L, M)
                +
                process(arr,M + 1, R)
                +
                merge(arr, L, M, R);
    }
    public static int merge(int[] arr, int L, int M, int R){
        // 每次合并生成一个辅助数组，并赋值给初始数组。
        int[] help = new int[R - L + 1];
        int sum = 0;
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R){
            // 因为右边的数组有序，所以每次比较的时候只要找到第一个比左组大的数，然后乘以左数就可以。
            sum += arr[p1] < arr[p2] ? (R - p2 +1) * arr[p1] : 0;
            // 相等的时候拷贝右边的，继续往下走
            help[i++] = arr[p2] > arr[p1] ? arr[p1++] : arr[p2++];
            }
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5};
        System.out.println(process(arr,0,arr.length-1));
    }
}
