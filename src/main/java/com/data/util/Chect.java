package com.data.util;

/**
 * @author AndiHappy Chect.java
 *
 * @date 2017年1月6日 上午9:30:13
 */
public class Chect {
  /**
   * <p>
   * 判断数组是否为空数组
   * </p>
   * 
   * <pre>
   * isNullOrEmptyArray(null) = true;
   * isNullOrEmptyArray([]) = true;
   * </pre>
   */
  public static boolean isNullOrEmptyArray(int[] a) {
    if (a == null || a.length <= 0) {
      return true;
    } else {
      return false;
    }
  }

  // 判断数组不为空数组
  public static boolean isNotNullOrEmptyArray(int[] a) {
    return !isNullOrEmptyArray(a);
  }
}
