[TOC]
## Code

```
import java.util.Arrays;

/* 选择排序
 * 思路：因为从小到大，所以依次遍历，每次选择均把最小的数提取到最前面的位置。
 * 时间复杂度：遍历N个数，每次所有数都比较一边，与第一个进行交换。
 * 空间复杂度：不需要额外的空间
*/

public class SelectionSort {
//	 对数器，生成一个不同长度，不同值的整型随机数据
	public static int[] randomArray(int maxLength, int range) {
		int length = (int) (Math.random() * (maxLength + 1));
		int[] arr1 = new int[length];
		for (int i = 0; i < length; i++) {
			arr1[i] = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
		}
		return arr1;
	}

//对数器ArrayList sort方法
//	public static ArrayList arrayListSort(int[] arr) {
//		ArrayList arr1 = new ArrayList();
//		for(int i = 0; i < arr.length; i++) {
//			arr1.add(arr[i]);
//		}
//		arr1.sort(null);
//		return arr1;
//	}
	public static void arraySort(int[] arr) {
		Arrays.sort(arr);
	}

//遍历数组方法
	public static void arrayRead(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

//比较对数器结果-
	public static boolean compareArray(int[] arr) {
		int[] arr1 = arr;
		int[] arr2 = arr;
		selectionSort(arr1);
		arrayRead(arr1);
		System.out.println();
		arraySort(arr2);
		arrayRead(arr2);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

// 参数：最大长度，值范围
	public static void selectionSort(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				int least = arr[i];
				if (arr[j] < least) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
// 对数器参数设置
		int Times = 1000;
		int maxLength = 10;
		int range = 20;
//		生成随机数组

//		int[] arr = new int[]{3, 5, 1, 0, 7, 2, 9};

		for (int i = 0; i < Times; i++) {
			int[] arr = randomArray(maxLength, range);
//			arrayRead(arr);
//			System.out.println();
			boolean result = compareArray(arr);
			System.out.println(result ? "成功啦!" : "失败啦");
		}

	}
}


```
## 运行结果
![image](8D63D3080AAE4AC2A1DDAF8E415180A6)

## 总结

- 随机`Math.random()` [0,1) 生成数组范围，长度方法   
    - 长度：(int)(Math.random() * (maxlength + 1)
        - 如length为5，int( 6 * [0,1) ) = [0,5]
    - 范围：(int)(Math.random() * (range + 1) - (int)(Math.random() * (range)
        - 如range为5，[0,5] - [0,5] = [-5,5]  
- Array.sort(int[] arr)方法，import java.util.Arrays  
- 三目运算符
    - System.out.println(result ? "成功啦!" : "失败啦");
- 交换方法，传入对象进行修改引用对象内容
    - 	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}