package com.zlz.leetcode.numbers;

/**
 * @author zhailz
 *
 *         时间：2016年10月21日 ### 下午1:59:37
 */
public class L12IntegerToRoman {

  // Given an integer, convert it to a roman numeral.
  // Input is guaranteed to be within the range from 1 to 3999.
  //
  /**
   * 解析题目：roman numeral 意思是罗马数字
   * 输入的字符数是有限制的1到3999
   * 
   * 关键在于对罗马数字的认识
   */
  public static String intToRoman(int num) {
    String M[] = { "", "M", "MM", "MMM" };
    String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(intToRoman(2976));

  }

}
