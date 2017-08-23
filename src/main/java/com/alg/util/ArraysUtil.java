package com.alg.util;

/**
 * @author AndiHappy SortUtil.java
 *
 * @date 2017年1月6日 上午9:18:40
 * 
 *       排序的各种的算法
 */
public class ArraysUtil {

  /**
   * <p>
   * 快速排序算法，按照默认的升序规则排列
   * </p>
   */
  public static void quickSort(int[] a) {
    if (Chect.isNotNullOrEmptyArray(a) && a.length > 1) {
      quicksort(a, 0, a.length - 1);
    }
  }

  /**
   * 一定范围内的快排
   */
  private static void quicksort(int[] a, int from, int end) {
    if (from < end) {
      int mid = quicksortkeyindex(a, from, end);
      quicksort(a, mid + 1, end);
      quicksort(a, from, mid - 1);
    }
  }

  public static int quicksortkeyindex(int[] a, int from, int end) {
    int key = a[from];
    int j = from + 1;// 开始的位置作为key值，比较从from+1开始
    for (int i = from + 1; i <= end; i++) {
      if (a[i] < key) {// 不变的原理是小于key值的位于前段否则，直接的交换，j指向是临界点
        swap(a, i, j);
        j++;
      }
    }
    swap(a, j - 1, from);
    return j - 1;
  }

  /**
   * <p>
   * 希尔排序
   * </p>
   */
  public static void shellsort(int[] arr) {
    int gap = 1, i, j, len = arr.length;
    int temp;
    // 确定gap的位置
    while (gap < len / 3) {
      gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
    }

    for (; gap > 0; gap /= 3)
      // 变化的插入排序
      for (i = gap; i < len; i++) {
        temp = arr[i];
        for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
          arr[j + gap] = arr[j];
        }
        arr[j + gap] = temp;
      }
  }

  /**
   * <p>
   * 归并排序
   * </p>
   */
  public static int[] mergeSort(int[] arrays) {
    return arrayMergeSort(arrays, 0, arrays.length - 1);
  }

  /**
   * <p>
   * 堆快排，按照升序的规则
   * </p>
   */
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

  /**
   * <p>
   * 数组转化为字符串
   * </p>
   */
  public static String arraystoString(int[] a) {
    if (a == null) return "null";
    int iMax = a.length - 1;
    if (iMax == -1) return "";
    StringBuilder b = new StringBuilder();
    for (int i = 0;; i++) {
      b.append(a[i]);
      if (i == iMax) return b.toString();
      b.append(", ");
    }
  }

  /**
   * <p>
   * 数组转化为字符串
   * </p>
   */
  public static String arraystoString(int[][] a) {
    return arraystoString(a, false);
  }

  /**
   * @param dp
   */
  public static String arraystoString(boolean[][] a) {
    if (a == null) return "null";
    int iMax = a.length - 1;
    if (iMax == -1) return "";
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length - 1; j++) {
        b.append(a[i][j] + "  ");
      }
      b.append(a[i][a[0].length - 1] + " \n");
    }

    return b.toString();
  }

  /**
   * <p>
   * 数组转化为字符串
   * </p>
   */
  public static String arraystoString(int[][] a, boolean isprintLine) {
    if (a == null) return "null";
    int iMax = a.length - 1;
    if (iMax == -1) return "";
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length - 1; j++) {
        b.append(a[i][j] + "  ");
      }
      b.append(a[i][a[0].length - 1] + " \n");
    }

    return b.toString();
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

  private static void swap(int[] arrays, int ii, int k) {
    int temp = arrays[ii];
    arrays[ii] = arrays[k];
    arrays[k] = temp;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[][] va = new int[][] { { 1, 2, 3 }, { 5, 6, 7, 8 }, { 10, 11, 12, 13 }
        // , { 14, 56, 78,90 }, { 1, 2, 3, 4 }
    };
    System.out.println(arraystoString(va));

  }

}
