package Class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: xucg
 * @Date: 2021/6/16 - 06 - 16 - 5:05 下午
 * @Description: 加强堆
 * 加入反向索引表，加快遍历速度O(logN)
 * 添加HashMap
 *
 */
public class Code01_HeapGreater<T> {
    // 动态数组实现堆
    private ArrayList<T> heap;
    // 反向索引表，indexMap是按值传递，基础类型会进行覆盖，可以使用加一层包装内部类的方式进行封装。
    private HashMap<T, Integer> indexMap;
    // 堆大小
    private int heapSize;
    // 比较器
    private Comparator<? super T> comp;
    // 构造器
    public Code01_HeapGreater(Comparator<T> c){
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        comp = c;
    }

    // 判断是否为空
    public boolean isEmpty(){return heapSize == 0;}
    // 判断大小
    public int size(){return heapSize;}
    // 判断是否包含元素
    public boolean contains(T obj){return indexMap.containsKey(obj);}
    // 返回堆顶元素，不删除
    public T peek(){return heap.get(0);}
    // 压入新元素进堆
    public void push(T obj){
        // heap数组添加obj元素
        heap.add(obj);
        // 反向索引添加obj元素
        indexMap.put(obj, heapSize);
        // 跟爹干，比大小，调整堆
        heapInsert(heapSize++);
    }
    // 弹出其中某个元素
    public T pop(){
        T ans = heap.get(0);
        // swap调整最后位置和0位置
        swap(0,heapSize-1);
        // 反向索引表更新
        indexMap.remove(ans);
        // 堆数组移除元素
        heap.remove(--heapSize);
        // 跟孩子比，下沉，调整堆
        heapify(0);
        return ans;
    }
    // 加强堆的特殊方法实现，通过indexMap快速定位
    public void remove(T obj){
        // 堆最后一个元素
        T replace = heap.get(heapSize - 1);
        // 删除值的索引位置
        int index = indexMap.get(obj);
        // 索引中删掉该值
        indexMap.remove(obj);
        // 删除最后一个元素
        heap.remove(--heapSize);
        // 删除的就是最后一个元素什么都不用做
        if (obj != replace){
            // 用replace值更新index处元素
            heap.set(index, replace);
            // 加入新索引映射
            indexMap.put(replace, index);
            // 重新调整堆，会并行调整索引
            resign(replace);
        }
    }

    public void resign(T obj){
        // 只会发生一个
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }

    public List<T> getAllElements(){
        List<T> ans = new ArrayList<>();
        for (T c : heap) {
            ans.add(c);
        }
        return ans;
    }


    public void swap(int i, int j){
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        // ArrayList元素调整
        heap.set(i, o2);
        heap.set(j, o1);
        // 索引调整
        indexMap.put(o2, i);
        indexMap.put(o1, j);
    }


    public void heapInsert(int index){
        // 小根堆
        while (comp.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    public void heapify(int index){
        int left = index * 2 + 1;
        while(left < heap.size()){
            int largest = left + 1 < heapSize && comp.compare(heap.get(left+1), heap.get(left))<0 ? left+1:left;
            largest = comp.compare(heap.get(left+1), heap.get(index)) < 0 ? largest : index;
            if (largest == index){
                break;
            }
            swap(largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

}
