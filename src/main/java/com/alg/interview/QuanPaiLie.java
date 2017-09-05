package com.alg.interview;

import java.util.Arrays;

/**
 * @author zhailz
 * @Date 2017年9月4日 - 下午9:28:10
 * @Doc: 全排列算法
 */
public class QuanPaiLie {

  public static void quanpailie(int[] a) {
    int[] tmp = new int[a.length];
    quanpailie(0, a, tmp);
  }

  /**
   * @param i
   * @param a
   */
  private static void quanpailie(int i,int[] a, int[] tmp) {
    int[] tmpp = restValue(a,tmp,i);
    if (i >= a.length) {
      System.out.println(Arrays.toString(tmp));
    } else {
      // i 位置上面的可能性的值是 a.length-i
      // tmp[i] 每次迭代的时候，向里面赛数据的内容
      for (int j = 0; j < a.length-i; j++) {
        tmp[i] = tmpp[j];
        quanpailie(i + 1, a, tmp);
      }
    }

  }

  /**
   * @param a
   * @param tmp
   * @param i
   * @return
   */
  private static int[] restValue(int[] a, int[] tmp, int end) {
    int[] tmpp = new int[a.length];
    int index = 0;
    for (int i = 0; i < a.length; i++) {
      if(notin(a[i],tmp,end)) {
        tmpp[index] = a[i];
        index++;
      }
    }
    return Arrays.copyOf(tmpp, index++);
  }

  /**
   * @param i
   * @param tmp
   * @param end 
   * @return
   */
  private static boolean notin(int i, int[] tmp, int end) {
    for (int j = 0; j < end; j++) {
      if(tmp[j] == i) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] a = new int[] { 1,2,3,4};
    quanpailie(a);
  }

}
