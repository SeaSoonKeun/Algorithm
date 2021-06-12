package Class08;

/**
 * @Auther: xucg
 * @Date: 2021/6/18 - 06 - 18 - 12:47 下午
 * @Description: 经典基数排序
 * 非负、10进制的数，改写可以拓宽到负数。
 * 所有数字从左往右按 个位数 分别进桶 ，然后倒出来，是按个位数排序的
 * 所有数字从左往右按 十位数 分别进桶 ，然后倒出来，是按十位数排序的（个位已经有序）
 * 所有数字从左往右按 百位数 分别进桶 ，然后倒出来，是按百位数排序的（十位和个位已经有序）
 * ……
 * 代码十个队列可以实现，有更优雅地实现（没有桶优雅地实现入桶出桶）
 * count记录个位数字出现几次，生成count' 计算累加和
 * 从右往左遍历，知道最后出现的问题，插入对应的位置。
 */
public class Code03_RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length, maxbits(arr));
    }
    // 最大位数
    public static int maxbits(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max / 10 == 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] arr, int L, int R, int digit) {
        // 所有数字从左往右按个位数记录到count数组中。
        // 基数
        final int radix = 10;
        int i =0, j=0;
        int[] help = new int[R - L + 1];
        // 有多少位数就 比较几次，排几次序。
        for (int d = 1; d <= digit; d++) {
            // 10个空间
            // count[]{0,1,2,3,4,……,9}
            int[] count = new int[radix];
            // d位数结尾进行统计，加到count数组
            for ( i = L; i <= R; i++) {
                j = getDigit(arr[i],d);
                count[j]++;
            }
            // why：方便辅助数组定位元素位置。how：遍历数组进行累加，第i位记录 <= i 的d位数，
            for (i = 1; i < radix; i++){
                count[i] = count[i] + count[i-1];
            }
            // 从右往左遍历数组，加入到help数组指定的count位置。
            for (i = R; i >= L ; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            // 辅助数组的值更新到原数组中
            for (i = L,j = 0; i <= R;i++,j++){
                arr[i] = help[j];
            }
        }
    }
    // 取第几位的数
    public static int getDigit(int x, int d){
        // Math.pow(x,y) 返回值 x的 y 次幂
        return (x / (int)(Math.pow(10, d - 1))) % 10;
    }
 }
