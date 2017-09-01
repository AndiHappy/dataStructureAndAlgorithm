package com.zlz.sort;

import java.util.Arrays;

/**
 * @author zhailz
 * 冒泡排序，稳定的算法，最好的情况O(n),最坏的情况O(n2),平均的情况是O(n2)
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, 6, 7, 0, 4, 2, 3, 5, 7, 0, 1, 2, 3, 8 };
    arrays = bubbleSort(arrays);
    System.out.println(Arrays.toString(arrays));
  }

  public static int[] bubbleSort(int[] arrays) {
    for (int j = 0; j < arrays.length; j++) {
    	//临进的相比较
      for (int i = arrays.length - 1; i > j; i--) {
        if (arrays[i] < arrays[i - 1]) {
          int temp = arrays[i - 1];
          arrays[i - 1] = arrays[i];
          arrays[i] = temp;
        }
      }
    }
    return arrays;
  }

  public static int[] bubbleSortImpove(int[] arrays) {
    boolean flag = false;
    for (int j = 0; j < arrays.length; j++) {
    	//优化的地方
      if (flag)
        return arrays;
      flag = true;
      for (int i = arrays.length - 1; i > j; i--) {
        if (arrays[i] < arrays[i - 1]) {
          int temp = arrays[i - 1];
          arrays[i - 1] = arrays[i];
          arrays[i] = temp;
          flag = false;
        }
      }
    }

    return arrays;
  }
}
