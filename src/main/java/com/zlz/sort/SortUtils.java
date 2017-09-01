package com.zlz.sort;

import com.alg.util.Chect;

/**
 * @author zhailz
 *
 * 时间：2016年7月15日 ### 上午10:03:06
 * 
 * 各类排序算法的静态的调用
 */
final class SortUtils {

	/**
	 * 冒泡算法情况下排序，默认情况是升序的排列<br/>
	 * 
	 * */
	public static void bubbleSort(int[] a) {
		if (Chect.isNotNullOrEmptyArray(a) && a.length > 1) {
			for (int i = 1; i < a.length; i++) {
				for (int j = i; j > 0; j--) {
					if (a[j] < a[j - 1]) {
						int temp = a[j - 1];
						a[j - 1] = a[j];
						a[j] = temp;
					}
				}
			}
		}
	}

	/**
	 * 插入排序算法进行排序，默认的情况下是升序的排序
	 * */
	public static void insertSort(int[] a) {
		if (Chect.isNotNullOrEmptyArray(a) && a.length > 1) {
			for (int i = 1; i < a.length; i++) {
				int key = a[i];
				int j = i - 1;
				for (; j >= 0; j--) {
					if (key < a[j]) {
						a[j + 1] = a[j];
					} else {
						break;
					}
				}
				if (j != (i - 1)) {
					a[j + 1] = key;
				}
			}
		}
	}

	/**
	 * 选择排序，按照升序的规则排列
	 * */
	public static void selectorSort(int[] a) {
		if (Chect.isNotNullOrEmptyArray(a) && a.length > 1) {
			for (int i = 0; i < a.length - 1; i++) {
				int min = i;
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] < a[min]) {
						min = j;
					}
				}
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}

	/**
	 * 快速排序算法，按照默认的升序规则排列
	 * */
	public static void quickSort(int[] a) {
		if (Chect.isNotNullOrEmptyArray(a) && a.length > 1) {
			quicksort(a, 0, a.length - 1);
		}
	}

	/**
	 * 一定范围内的快排
	 * */
	private static void quicksort(int[] a, int from, int end) {
		if (from < end) {
			int mid = quicksortkey(a, from, end);
			quicksort(a, mid + 1, end);
			quicksort(a, from, mid - 1);
		}
	}

	private static int quicksortkey(int[] a, int from, int end) {
		int key = a[from];
		int j = from + 1;//开始的位置作为key值，比较从from+1开始
		for (int i = from + 1; i <= end; i++) {
			if (a[i] < key) {//不变的原理是小于key值的位于前段否则，直接的交换，j指向是临界点
				swap(a, i, j);
				j++;
			}
		}
		swap(a, j - 1, from);
		return j - 1;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * 堆快排，按照升序的规则
	 * */
	public static void hearpSort(int[] a) {
		creatheap(a);
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, 0, i);
			mainHeap(a, 0, i);
		}
	}

	private static int[] creatheap(int[] arrays) {
		for (int i = arrays.length / 2; i >= 0; i--) {
			mainHeap(arrays, i, arrays.length);
		}
		return arrays;
	}

	private static void mainHeap(int[] arrays, int i, int length) {
		// 
		int largest = i;
		if (left(i) < length && arrays[left(i)] > arrays[largest]) {
			largest = left(i);
		}

		if (right(i) < length && arrays[right(i)] > arrays[largest]) {
			largest = right(i);
		}

		if (largest != i) {
			swap(arrays, i, largest);
			mainHeap(arrays, largest, length);
		}
	}

	private static int left(int i) {
		return 2 * i + 1;
	}

	private static int right(int i) {
		return 2 * i + 2;
	}

	private static String toString(int[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "";

		StringBuilder b = new StringBuilder();
		for (int i = 0;; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.toString();
			b.append(", ");
		}
	}

	public static int[] mergeSort(int[] arrays) {
		return arrayMergeSort(arrays, 0, arrays.length - 1);
	}

	private static int[] arrayMergeSort(int[] arrays, int i, int j) {
		if (i < 0 || j > arrays.length - 1) {
			throw new IllegalArgumentException("");
		}
		if (i < j) {
			int m = (i + j) / 2;
			arrayMergeSort(arrays, i, m);
			arrayMergeSort(arrays, m + 1, j);
			arrayMergeSortContentNoFlag(arrays, i, m, j);
		}
		return arrays;
	}

	private static void arrayMergeSortContentNoFlag(int[] arrays, int i, int m, int j) {
		int first = m - i + 1;
		int second = j - m;

		int[] firsta = new int[first];
		int[] seconda = new int[second];

		// ʼ
		for (int k = i; k <= m; k++) {
			firsta[k - i] = arrays[k];
		}
		for (int k = m + 1; k <= j; k++) {
			seconda[k - m - 1] = arrays[k];
		}

		int ff = 0;
		int ss = 0;
		int k = i;
		for (; k <= j && ff < firsta.length && ss < seconda.length; k++) {
			if (firsta[ff] < seconda[ss]) {
				arrays[k] = firsta[ff];
				ff++;
			} else {
				arrays[k] = seconda[ss];
				ss++;
			}
		}

		if (ff <= firsta.length - 1) {
			for (; ff < firsta.length; k++, ff++) {
				arrays[k] = firsta[ff];
			}
		}

		if (ss <= seconda.length - 1) {
			for (; ff < seconda.length; k++, ss++) {
				arrays[k] = seconda[ss];
			}
		}
	}

	/**
	 * 希尔排序
	 * */
	public static void shellsort(int[] arr) {
		int gap = 1, i, j, len = arr.length;
		int temp;
		//确定gap的位置
		while (gap < len / 3) {
			gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
		}

		for (; gap > 0; gap /= 3)
			//变化的插入排序
			for (i = gap; i < len; i++) {
				temp = arr[i];
				for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
					arr[j + gap] = arr[j];
				}
				arr[j + gap] = temp;
			}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[] { 7, 3, 5, 4, 6, 9, 8, 8, 0, 1, 2 };
		System.out.println(toString(a));
		//		SortUtils.hearpSort(a);
		SortUtils.mergeSort(a);
		System.out.println(toString(a));

	}

}
