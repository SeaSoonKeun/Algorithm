package Class08;

/**
 * @Auther: xucg
 * @Date: 2021/6/18 - 06 - 18 - 12:47 下午
 * @Description: 计数排序
 * 年龄排序--年龄数据状况是受限的。
 * O(N)
 */
public class Code02_CountSort {
    public static void countSort(int[] arr){
        int max = getMax(arr);
        // 创建计数辅助数组
        int[] help = new int[max];
        // 遍历数组，添加对应的记录进help；
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }
        // 遍历help数组实现排序
        int num = 0;
        for (int i = 0; i < help.length; i++) {
            while(help[i]-- > 0){
                arr[num++] = i;
            }
        }
    }
    // 取最大值
    public static int getMax(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
