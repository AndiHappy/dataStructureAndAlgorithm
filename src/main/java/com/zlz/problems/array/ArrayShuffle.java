package com.zlz.problems.array;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.RandomAccess;

/**
 * @author zhailz
 * @Date 2017年9月11日 - 上午10:14:48
 * @Doc: 将一个数组中的元素随机（打乱）
 */
public class ArrayShuffle {

  private static Random r;

  public static void shuffle(int[] list) {
    Random rnd = r;
    if (rnd == null) r = rnd = new Random(); // harmless race.
    shuffle(list, rnd);
  }

  /**
   * Random 的 nextInt(i) 和 i-1 之间的调换来进行打乱顺序
   * */
  private static void shuffle(int[] list, Random rnd) {
    for (int i = list.length; i > 1; i--)
      // int nextInt(int n) // 返回一个“[0, n) 之间的int类型”的随机数。
      swap(list, i - 1, rnd.nextInt(i));
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void shuffle(List<?> list) {
    Random rnd = r;
    if (rnd == null) r = rnd = new Random(); // harmless race.
    shuffle(list, rnd);
  }

  private static final int SHUFFLE_THRESHOLD = 5;

  public static void shuffle(List<?> list, Random rnd) {
    int size = list.size();
    if (size < SHUFFLE_THRESHOLD || list instanceof RandomAccess) {
      for (int i = size; i > 1; i--)
        swap(list, i - 1, rnd.nextInt(i));
    } else {
      Object arr[] = list.toArray();
      // Shuffle array
      for (int i = size; i > 1; i--)
        swap(arr, i - 1, rnd.nextInt(i));

      // 迭代器的初始化
      @SuppressWarnings("unchecked")
      ListIterator<Object> it = (ListIterator<Object>) list.listIterator();
      for (int i = 0; i < arr.length; i++) {
        it.next();
        it.set(arr[i]);
      }
    }
  }

  public static void swap(List<?> list, int i, int j) {
    @SuppressWarnings("unchecked")
    final List<Object> l = (List<Object>) list;
    l.set(i, l.set(j, l.get(i)));
  }

  private static void swap(Object[] arr, int i, int j) {
    Object tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] value = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
    for (int i = 0; i < 100000; i++) {
      shuffle(value);
    }
   
    System.out.println(Arrays.toString(value));

  }

}
