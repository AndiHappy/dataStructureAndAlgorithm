package com.alg.leetcode;

/**
 * @author AndiHappy L07ReverseInteger.java
 *
 * @date 2017年1月6日 下午4:44:15
 */
public class L07ReverseInteger {

  // Reverse digits of an integer.
  //
  // Example1: x = 123, return 321
  // Example2: x = -123, return -321

  /**
   * 反转int数值的时候，使用了long类型的变量
   * */
  public static int reverse(int x) {
    int value = x > 0 ? x : -x;
    long change = 0;
    while (value > 0) {
      int tmp = value % 10;
      change = change * 10 + tmp;
      if (change > Integer.MAX_VALUE) {
        return 0;
      }
      value = value / 10;
    }
    return (int) (x > 0 ? change : -change);
  }

  public static void main(String[] args) {
    System.out.println(reverse(1534236469));
    System.out.println(reverse(-1463847412));
  }

}
