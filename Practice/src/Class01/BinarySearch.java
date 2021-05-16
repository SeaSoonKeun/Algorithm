package Class01;

import javax.crypto.spec.PSource;

/**
 * @Auther: xucg
 * @Date: 2021/5/16 - 05 - 16 - 下午1:34
 * @Description: Class02
 */
/*
* 二分查找：
* 前提是有序数组
* 二分循环条件确认：L <= R
* 通过中点位置元素值和所查找的值进行比较，进行下一次二分
* */
public class BinarySearch {
    public static void main(String[] args) {
//        输入有序数组
        int [] arr = new int[]{1,3,5,7,9,11};
//        传参数，调用二分法 方法
        System.out.println(binarySearch(arr,8)?"success":"failed");
    }
    public static boolean binarySearch(int[] sortedArr, int num){
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
// 注意此处的边界问题：
/*
* while(L<R) {
}

return sortedArr[L] == num;

// OR

while(L<=R) {
}
return false;
* - 这两种写法，有的同学就问了，啥时候写 ≤ 时候写 < . 我只能说都对你如果把你的大逻辑定成至少两个数的时候，你就有这种逻辑下的边界条件。如果你把你的逻辑定成至少一个数字我就能二分，那就有这种逻辑下的边界条件，这个东西其实相当的仁者见仁智者见智，写Code扣边界条件这个过程是必不可少的。
- 不要说老师，你的写法什么时候这么写，什么时候那么写，没有固定的写法. 算法是一个大的思想，怎么实现这个大的思想，八仙过海各显神通
- 有很多同学确实问了这个问题，他可能脑筋还是比较死，认为算法是一个我教就直接会的东西，真不是，^^你自己的练习非常重要，你不管算法能力有没有提高，只要你写Code，只要你写算法题，你的Coding能力必提高^^
*
* */

//        推荐这种写法，比较容易理解
        while (L <= R){
            mid = L + ((R-L) >> 1);
            if (sortedArr[mid] > num){
                R = mid - 1;
            }
            if (sortedArr[mid] < num){
                L = mid + 1;
            }
            else if (sortedArr[mid] == num){
                return true;
            }
        }
        return false;
    }
}
