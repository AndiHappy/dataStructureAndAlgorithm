package com.zlz.sort;

import java.util.Arrays;

import com.data.util.ListNode;


/**
 * @author zhailz
 *
 * 时间：2016年9月22日 ### 上午11:08:16
 * 最差时间复杂度	O(n^{2})
 * 平均时间复杂度	 O(n+k)
 * 最差空间复杂度	 O(n*k)
 */
public class BucketSort {

	public static void main(String[] args) {
		int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, 6, 7, 0, 4, 2, 3, 5, 7, 0, 1, 2, 3, 8 };
		arrays = bucketSort(arrays);
		System.out.println(Arrays.toString(arrays));
	}

	/**
	 * n 为分配的范围，例如我们使用取余的方式，确定数组中的值回落到哪一个位置
	 * */
	public static int[] bucketSort(int arr[]) {
		int max = 0;
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}

		int arrl = arr.length - 1;
		ListNode[] nodes = new ListNode[arrl + 1];
		for (int i = 0; i < arr.length; i++) {
			//保证数组中的元素，按照大在前，小在后的不严格顺序的全部的落入到nodes数组中
			int index = arr[i] * arrl / max;
			if (nodes[index] == null) {
				nodes[index] = new ListNode(arr[i]);
			} else {
				//这里使用遍历链表的算法
				for (ListNode temp = nodes[index]; temp != null; temp = temp.next) {
					if (temp.val >= arr[i]) {
						//换值变为后插入
						ListNode insert = new ListNode(temp.val);
						temp.val = arr[i];
						insert.next = temp.next;
						temp.next = insert;
						break;
					}
					temp = temp.next;
				}
			}
		}

		int j = 0;
		int[] tmp = new int[arr.length];
		for (ListNode listNode : nodes) {
			if (listNode != null) {
				while (listNode != null) {
					tmp[j] = listNode.val;
					listNode = listNode.next;
					j++;
				}
			}
		}

		return tmp;
	}

	public void print(ListNode[] nodes) {

	}
}
