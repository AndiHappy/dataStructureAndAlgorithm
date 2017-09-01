package com.zlz.sort;

import java.util.Arrays;

/**
 * @author zhailz
 * 计数排序（Counting sort）是一种稳定的线性时间排序算法。
 * 计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。然后根据数组C来将A中的元素排到正确的位置
 */
public class CountSort {

	public static void main(String[] args) {
		//排序的数组
		int a[] = { 100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95 };
		int b[] = countSort(a);
		for (int i : b) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}

	/*
	 * 	找出待排序的数组中最大和最小的元素
	 * 	统计数组中每个值为i的元素出现的次数，存入数组 C 的第 i 项
	 * 	对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
	 * 	反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
	 * */
	public static int[] countSort(int[] a) {

		int b[] = new int[a.length];

		//获得数组的最大值和最小值
		int max = a[0], min = a[0];
		for (int i : a) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}

		//这使得计数排序对于数据范围很大的数组，需要大量时间和内存
		//这里k的大小是要排序的数组中，元素大小的极值差+1
		int k = max - min + 1;
		int c[] = new int[k];
		for (int i = 0; i < a.length; ++i) {
			c[a[i] - min] += 1;//优化过的地方，减小了数组c的大小
		}

		//前面有几个比我小的值
		for (int i = 1; i < c.length; ++i) {
			c[i] = c[i] + c[i - 1];
		}
		PrintUtil.printArray(a);
		PrintUtil.printArray(c);
		for (int i = a.length - 1; i >= 0; --i) {
			//主要是考虑到了数组的中数字的重复性
			c[a[i] - min] = c[a[i] - min] - 1;
			int index = c[a[i] - min];
			b[index] = a[i];//按存取的方式取出c的元素
			PrintUtil.printArray(b);
		}
		return b;
	}

	public static int[] countingSort(int[] A) {
		int[] B = new int[A.length];
		// 假设A中的数据a'有，0<=a' && a' < k并且k=100
		int k = 100 + 1;
		countingSort(A, B, k);
		return B;
	}

	private static void countingSort(int[] A, int[] B, int k) {
		int[] C = new int[k];
		// 计数
		for (int j = 0; j < A.length; j++) {
			int a = A[j];
			C[a] += 1;
		}
		// 求计数和
		for (int i = 1; i < k; i++) {
			C[i] = C[i] + C[i - 1];
		}
		PrintUtil.printArray(A);
		PrintUtil.printArray(C);

		// 整理
		for (int j = A.length - 1; j >= 0; j--) {
			int a = A[j];
			B[C[a] - 1] = a;
			C[a] -= 1;
			PrintUtil.printArray(B);
			PrintUtil.printArray(C);
		}
	}
	
	static class PrintUtil{

    public static void printArray(int[] b) {
      System.out.println(Arrays.toString(b));
    }
	  
	}
}