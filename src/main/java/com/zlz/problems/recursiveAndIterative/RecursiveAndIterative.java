package com.zlz.problems.recursiveAndIterative;

/**
 * @author zhailz
 * @Date 2017年9月2日 - 下午5:55:31
 * @Doc: 递归和循环
 */
public class RecursiveAndIterative {
  public static int AddFrom1ToN_Recursive(int n) {
    return n <= 0 ? 0 : n + AddFrom1ToN_Recursive(n - 1);
  }

  public static int AddFrom1ToN_Iterative(int n) {
    int result = 0;
    for (int i = 1; i <= n; ++i)
      result += i;
    return result;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(AddFrom1ToN_Iterative(10));
    System.out.println(AddFrom1ToN_Recursive(10));
    System.out.println(AddFrom1ToN_Iterative(500000));
    //直接的爆了
    System.out.println(AddFrom1ToN_Recursive(500000));

  }

}
