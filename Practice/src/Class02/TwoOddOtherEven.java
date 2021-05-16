package Class02;

/**
 * @Auther: xucg
 * @Date: 2021/5/16 - 05 - 16 - 下午3:25
 * @Description: Class02
 */
public class TwoOddOtherEven {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,3,3,2,2,4,4,8,8};
        twoOddOtherEven(arr);
    }
    public static void twoOddOtherEven(int[] arr){
        int theOne = 0;
        int theOtherOne = 0;
        int xor = 0;
        // xor = a ^ b
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        // 提取最右侧的一
        int rightOne = xor & (-xor);
        for (int i = 0; i < arr.length; i++) {
            if ((rightOne & arr[i]) != 0 ){
                //此处的异或过滤掉偶数个数的值
                theOne ^= arr[i];
            }
        }
            theOtherOne = xor ^ theOne;
        System.out.println(theOne + " " + theOtherOne);

    }
}
