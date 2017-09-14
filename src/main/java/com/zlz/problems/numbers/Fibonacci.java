package com.zlz.problems.numbers;

import java.math.BigDecimal;

/**
 * @author zhailz
 * @Date 2017年9月2日 - 下午6:22:37
 * @Doc: 斐波那契数列
 */
public class Fibonacci {
  /**
   * 迭代的调用
   * */
  public static long fibonacci(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
  
  /**
   * 优化迭代的数据
   * */
  public static BigDecimal fibonacci_change(int n) {
    BigDecimal result[] = new BigDecimal[] {BigDecimal.ZERO,BigDecimal.ONE};
    if(n <= 1) return result[n];
    BigDecimal tmp0 = new BigDecimal(0);
    BigDecimal tmp1 = new BigDecimal(1);
    BigDecimal resultv = null;
    for (int i = 2; i <= n; i++) {
      resultv = tmp0.add(tmp1);
      tmp0 = tmp1;
      tmp1 = resultv;
    }
    return resultv;
  }
  
  public static void main(String[] args) {
    System.out.println(fibonacci(10));
  
    System.out.println(fibonacci_change(10));
    //直接的爆了
//    System.out.println(fibonacci(50000));
    System.out.println(fibonacci_change(50000));
  }
}
