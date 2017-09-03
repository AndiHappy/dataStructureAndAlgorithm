package com.alg.interview;

/**
 * @author zhailz
 * @Date 2017年9月3日 - 下午3:36:54
 * @Doc: 数字中1的个数
 */
public class NumbersOf1 {

  public static int NumberOf1(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >> 1;
    }
    return count;
  }
  
  public static int NumberOf1_change(int n) {
    int count = 0;
    int flag = 1;
    while (flag != 0) {
      if ((n & flag) > 0) {
        count++;
      }
      flag = flag << 1;
    }
    return count;
  }
  
  public static int NumberOf1_improve(int n) {
    int count = 0;
    while (n > 0) {
      count++;
      //n和n-1做与运算的结果是：n的最右边的数字1变为0
      n = n & (n-1);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(NumberOf1(9));
    System.out.println(NumberOf1_change(9));
    System.out.println(NumberOf1_improve(9));
    
    System.out.println(NumberOf1(900000000));
    System.out.println(NumberOf1_change(900000000));
    System.out.println(NumberOf1_improve(900000000));

  }
}
