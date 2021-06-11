package Class03_02;

/**
 * @Auther: xucg
 * @Date: 2021/6/10 - 06 - 10 - 2:09 下午
 * @Description: 归并排序
 * 1）整体是递归，左边排好序+右边排好序+merge让整体有序
 * 2）让其整体有序的过程里用了外排序方法
 * 3）利用master公式来求解时间复杂度
 * 4）当然可以用非递归实现
 * 思路：
 * 1、先归类，归类到最后有一个base case的终止条件 L==R,最后只剩一个数字
 * 2、后合并，归类完成后，会触发合并操作。合并有边界条件，双指针移动。
 * 辅助数组
 * 全局变量作为辅助数组的index
 * 三层while确保指针运行中边界，和参数移动
 * p1 <= mid && p2 <= R
 * p1 <= mid
 * p2 <= R
 * 将辅助数组赋值回原数组，使得结果生效，注意此处是相对位置，不可直接从0开始赋值。
 */
public class Code03_MergeSort {
    // 归类
    public static void process(int[] arr, int L, int R) {
        // base case
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public  static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        // 赋值回去,从help角度出发
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }

    }

}
