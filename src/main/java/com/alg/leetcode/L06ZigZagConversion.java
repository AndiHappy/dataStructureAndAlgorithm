package com.alg.leetcode;

/**
 * @author AndiHappy L06ZigZagConversion.java
 *
 * @date 2017年1月6日 下午4:35:30
 */
public class L06ZigZagConversion {

  /*
  The string "PAYPALISHIRING" is written in a zigzag pattern on a 
  given number of rows like this: (you may want to display this pattern in
   a fixed font for better legibility)
  
  P   A   H   N
  A P L S I I G
  Y   I   R
  
  And then read line by line: "PAHNAPLSIIGYIR"
  Write the code that will take a string and make 
  this conversion given a number of rows:
  
  
  string convert(string text, int nRows);
  convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
  */
  public static String convert(String s, int numRows) {
    StringBuilder sb = new StringBuilder();
    if (numRows == 1 || numRows == 0) {
      return s;
    } else if (numRows < 0) {
      throw new IllegalArgumentException("参数错误");
    }
    int zigLen = 2 * (numRows - 1);
    for (int r = 0; r < numRows; r++) {
      int idx = r;
      while (idx < s.length()) {
        sb.append(s.charAt(idx));
        // 中间内部的
        int dIdx = idx + zigLen - 2 * r;
        // 去除两端的数据
        if (r != 0 && r != numRows - 1 && dIdx < s.length()) {
          sb.append(s.charAt(dIdx));
        }
        idx += zigLen;
      }
    }
    return sb.toString();

  }

  public static void main(String[] args) {
    System.out.println(convert("123456789987654321", 4));
  }
}
