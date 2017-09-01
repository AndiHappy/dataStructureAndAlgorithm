package com.zlz.leetcode.numbers;

/**
 * @author zhailz
 *
 *         时间：2016年10月21日 ### 下午2:13:14
 */
public class L13RomanToInteger {

  // Given a roman numeral, convert it to an integer.
  //
  // Input is guaranteed to be within the range from 1 to 3999.

  /**
   * 有罗马的数字转换为 int value
   * 1，第一个念头是分开来进行匹配，首先匹配千位，如果匹配成功，找到匹配的项目
   * 2,再次的分析，只要字母比自己右侧的小就是减，如果比自己的右侧的数字大或者相等就是加
   */
  public static int romanToInt(String s) {
    int value = 0;
    int i = 0;
    int current = 0;
    int after = 0;
    current = romanToAuth(s.charAt(i));
    while (i < s.length()) {
      if (i + 1 > s.length() - 1) {
        after = 0;
      } else {
        after = romanToAuth(s.charAt(i + 1));
      }
      if (after <= current) {
        value = value + current;
      } else {
        value = value + (-current);
      }
      current = after;
      i = i + 1;
    }

    return value;
  }

  private static int romanToAuth(char temp) {
    switch (temp) {
    // "M", "D", "C", "L", "X", "V", "I"
    case 'M':
      return 1000;
    case 'D':
      return 500;
    case 'C':
      return 100;
    case 'L':
      return 50;
    case 'X':
      return 10;
    case 'V':
      return 5;
    case 'I':
      return 1;
    default:
      return 0;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(romanToInt("MMCMLXXVI"));
  }

}
