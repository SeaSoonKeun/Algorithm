package Class02;

/**
 * @Auther: xucg
 * @Date: 2021/5/16 - 05 - 16 - 下午3:26
 * @Description: Class02
 */
/*
题目：
提取出int类型数最右侧的1
* 解题思路：
* 1，取反加一 刚好是 最后一位为0，前面的数前面位数相反，从右往左最后一个为1的数，就是该值最右侧的一
* 2，取与，只有最后一位的地方是1
a & (~a + 1) 反码加一
a & (-a) 负数等去取反加一
*/
public class Right1OfInt {
    public static void main(String[] args) {

    }
    public static int
}
