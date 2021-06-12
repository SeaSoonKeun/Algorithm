package Class07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: xucg
 * @Date: 2021/6/16 - 06 - 16 - 10:40 下午
 * @Description: 最大线段重合问题-堆实现
 * 给定很多线段，每个线段都有两个数组[start, end]，
 * 表示线段开始位置和结束位置，左右都是闭区间
 * 规定：
 * 1）线段的开始和结束位置一定都是整数值
 * 2）线段重合区域的长度必须>=1
 * 返回线段最多重合区域中，包含了几条线段
 *
 * 流程:
 * 当把下端开始位置 由小到大拍完序之后, 依次考察每一个线段
 * 遍历到任何一个线段时, 在小根堆里把所有<=开始位置的值都弹出,
 * 然后把此时结束位置加入小根堆, 此时小跟堆里有几个数, 就是这线段的答案
 * 所有线段的答案都求出来, 最大的那个就是最大线段重合数
 * 为什么用小根堆?
 *   小根堆调整快, 从小到大依次弹出, 以及把一个数加入后自动重新排序很快
 */
public class Code02_CoverMax {
    // 定义线段类
    public static class Line{
        public int start;
        public int end;
        public Line(int s, int e){
            start = s;
            end = e;
        }
    }
    // 定义线段头部的比较器,只比较头部
    public static class StartComparator implements Comparator<Line> {

        @Override
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }
    // 传入双元素数组
    public static int CoverMax(int[][] m){
        // 把数组的值传入线段
        Line[] lines = new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        // 按照线段的头部比较器进行排序，从小到大
        Arrays.sort(lines, new StartComparator());
        // 定义小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        // lines线段，从头开始，加入的时候，弹出比线段首部小的元素，加入线段尾
        for (int i = 0; i < lines.length; i++) {
            // 判断堆不为空且小根堆堆顶元素比线段头部要小，把堆顶元素弹出。直到堆顶元素>当前元素大。
            while (!heap.isEmpty() && heap.peek() <= lines[i].start){
                heap.poll();
            }
            // 把线段尾部的元素加入小根堆
            heap.add(lines[i].end);
            // 最大值是堆元素大小，循环与最大值进行比较。
            max = Math.max(max, heap.size());
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2}};
        System.out.println(test[0][0] + "," + test[0][1]);
    }
}
