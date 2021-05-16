package Class02;

/**
 * @Auther: xucg
 * @Date: 2021/5/16 - 05 - 16 - 下午3:15
 * @Description: Class03
 */
/*异或运算的性质

0^N == N
N^N == 0
异或运算满足交换律和结合率

上面的两个性质用无进位相加来理解就非常的容易

同样一批数，不管选择什么样的顺序做异或操作，最后结果一定是一个

不用额外变量交换两个数，前提是两个交换的数不能是同一内存区域，像个相同地址空间异或会变成0


* 异或*/
public class Xor {
    public static void swap(int[] arr, int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
