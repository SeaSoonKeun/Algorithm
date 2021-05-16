package Class02;

/**
 * @Auther: xucg
 * @Date: 2021/5/16 - 05 - 16 - 下午3:24
 * @Description: Class02
 */
/*
题目：
数组中有一个数出现了奇数次，其他的都是偶数次，找出这个数
* 解题思路：
* 因为 N ^ N = 0
* 所以偶数个数的数异或完都是0
* 而且0 ^ N = N
* 所以只要把所有数进行异或操作就可以得到奇个数的值
*/
public class OneOddOtherEven {
    public static void main(String[] args) {
        int[] arr1 = new int[]{6,2,2,3,3};
        System.out.println(oneOddOtherEven(arr1));
    }
    public static int oneOddOtherEven(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }
}
