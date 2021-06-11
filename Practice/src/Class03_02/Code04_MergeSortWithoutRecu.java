package Class03_02;

/**
 * @Auther: xucg
 * @Date: 2021/6/11 - 06 - 11 - 2:34 下午
 * @Description: 非递归实现归并排序
 *
 * 重点：真正调用递归的是归并中"归"，并的merge是可以公用的
 * 所以用非递归方法实现时，把"归"换一种方法进行实现就可以。
 *
 * 思路：使用步长增加的方法（设计变量步长，步长为1，相邻两个一组进行merge，直到步长超过数组长度）
 *  步长为1--2--4--8--16直到超过数组长度
 *  左右进行比较，
 *
 */
public class Code04_MergeSortWithoutRecu {
    public static void mergeSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        int mergeSize = 1;
        // 一个步长，一次扫描
        while (mergeSize < N){
            int L = 0;
            // 一个步长下，每两个一组，向右边进行扩张
            while(L < N){
                // 最右边的不满足一个步长时，不用进行比较
                if (mergeSize >= N - L){
                    break;
                }
                int M = L + mergeSize -1;
                int R = M + mergeSize;
                Code03_MergeSort.merge(arr,L,M,R);
                //
                L = R + 1;
            }
            if (mergeSize > N/2){
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,5,3,7,1,10,123,32};
        mergeSort2(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
    }
}
