package com.zlz.util;

/**
 * @author zhailz
 * @date 17/9/14 - 上午9:31.
 */
public class AlgUtil {


  /**
   * 数组中值的交换
   * */

  public static void swap(int[] list, int k, int i) {
    int m = list[k];
    list[k] = list[i];
    list[i] = m;
  }
}
