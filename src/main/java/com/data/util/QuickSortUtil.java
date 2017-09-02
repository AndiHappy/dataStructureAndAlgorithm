package com.data.util;

import java.util.Arrays;

/**
 * @author zhailz
 * @Date 2017年8月23日 - 上午8:22:49
 * @Doc: 快速排序的应用
 */
public class QuickSortUtil {

  public static <T extends Comparable<T>>  T[] quicksort(T[] a, int from, int end) {
    if (from < end) {
      int mid = quickSortContent(a, from, end);
      quicksort(a, mid + 1, end);
      quicksort(a, from, mid - 1);
    }
    return a;
  }
  
  private static <T extends Comparable<T>> int quickSortContent(T[] arrays, int i, int end) {
    //随机生成i 到 j 的数据
    int key = RandEnum.INSTANCE.randInt(i, end);
    System.out.println(arrays[key]);
    swap(arrays, key, end);//换到最后一位
    int small = i;
    for (int k = i; k < end; k++) {
      if (arrays[k].compareTo(arrays[end]) > 0 ) {
        swap(arrays, small, k);
        small++;
      }
    }
    swap(arrays, small, end);
    System.out.println(small);
    return small;
  }
  
  private static <T> void swap(T[] arrays, int i, int j) {
    T temp = arrays[i];
    arrays[i] = arrays[j];
    arrays[j] = temp;
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    Integer[] va = new Integer[]{3,4,7,8,1,2,6,5};
    System.out.println(Arrays.toString(quicksort(va, 0, va.length-1)));

  }

}
