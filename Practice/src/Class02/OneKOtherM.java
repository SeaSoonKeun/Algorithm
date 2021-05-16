package Class02;

/**
 * @Auther: xucg
 * @Date: 2021/5/16 - 05 - 16 - 下午3:25
 * @Description: Class02
 */
/*
题目：一个数组中有一种数出现K次，其他数都出现了M次，
M > 1,  K < M
找到，出现了K次的数，
要求，额外空间复杂度O(1)，时间复杂度O(N)、
*/
public class OneKOtherM {
    public static void main(String[] args) {
//        int[] arr = new int[]{20,2,2,2,5,5,5};
        int[] arr = generateArray(10,3,5);
        printArray(arr);
        System.out.println(oneKOhterM(arr, 3, 5));
    }
//  随机产生符合题意数组对数器
    public static int[] generateArray(int maxValue, int k, int m){
        if (k > m){
            System.out.println("输入有误，请确保k<m");
        }
        int typeOfM = (int)(9 * Math.random()) + 1;
        int[] typeOfMArray = new int[typeOfM];
        int[] arr = new int[k + m * typeOfM];
        int inter = 0;
        for (int i = 0; i < typeOfMArray.length; i++) {
            boolean flag = true;
            b1:while(flag){
                int r1 = (int)((maxValue + 1) * Math.random());if (r1 == 0){
                    break b1;
                }else{
                    for (int j = 0; j <= i; j++) {
                        if (r1 == typeOfMArray[j]){
                            flag = true;
                            break b1;
                        }
                    }
                    typeOfMArray[i] = r1;
                    flag = false;
                }
                for (int count = 0; count < m; count++) {
                    arr[i * m + count] = typeOfMArray[i];
                    inter = i * m + count;
                }
            }
        }
        printArray(typeOfMArray);
//        r2 = (int)((maxValue + 1) * Math.random());
//        for (int i = 0; i < typeOfMArray.length; i++) {
//            if (r2 == typeOfMArray[i]||r2 == 0){
//                r2 = (int)((maxValue + 1) * Math.random());
//            }
//        }
        boolean flag2 = true;
        b2:while (flag2){
            int r2 = (int)((maxValue + 1) * Math.random());
            if (r2 == 0){
                break b2;
            }
            for (int i = 0; i < typeOfMArray.length; i++) {
                if(r2 == typeOfMArray[i]){
                    flag2 = true;
                    break b2;
                }
            }
            flag2 = false;
            for (int i = 0; i < k; i++){
                arr[inter + i + 1] = r2;
            }
        }
        return arr;
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int oneKOhterM(int[] arr, int k, int m) {
//        定义一个32位的数组
        int[] t = new int[32];
//        数组元素迭代器，时间复杂度还是O(n),因为迭代是一个固定时间。
        for (int num : arr) {
//            数组元素迭代通过位运算的方法转换成二进制形式，如果位元素为1，则参照数组该位也加一
            for (int i = 0; i < t.length; i++) {
                t[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < t.length; i++) {
//            如果等于0，这说明这个数在该位置上为没有1。如果不等于0，则说明在该位上有1。
            if (t[i] % m == 0){
                continue;
            }
//            如果在该位上有一，且等于k，则可以得到出现k次的数，在该位上有1，返回参数值 植入 一个1进去 1 << i
            if (t[i] % m == k){
                ans |= 1 << i;
            }
            else{
                return -1;
            }
        }
        if (ans == 0){
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    count++;
                }
            }
            if (count != k){
                return -1;
            }
        }
        return ans;
    }

}