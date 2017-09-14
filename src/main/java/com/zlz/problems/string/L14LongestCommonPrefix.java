package com.zlz.problems.string;

/**
 * @author zhailz
 *
 *         时间：2016年10月24日 ### 上午11:50:20
 */
public class L14LongestCommonPrefix {

  // Write a function to find the longest common prefix string amongst an array
  // of strings.

  /**
   * 一个数组的全部的公共子串：subString
   * 1. 第一个念头：需要一个数组的全部的lcp，我们两个两个的比较，然后找到最后的值
   * 看了答案感觉自己的理解有问题：longest common prefix
   * prefix 这个词的准确的意思是from beginning one by one
   */
  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String prefix = strs[0];
    // 横向进行比较
    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) {
          return "";
        }
      }
    }
    return prefix;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////
  public String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    // 纵向进行比较
    for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * 归并的思想，非常的有意思的设计
   */
  public String longestCommonPrefix3(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    return longestCommonPrefix(strs, 0, strs.length - 1);
  }

  private String longestCommonPrefix(String[] strs, int l, int r) {
    if (l == r) {
      return strs[l];
    } else {
      int mid = (l + r) / 2;
      String lcpLeft = longestCommonPrefix(strs, l, mid);
      String lcpRight = longestCommonPrefix(strs, mid + 1, r);
      return commonPrefix(lcpLeft, lcpRight);
    }
  }

  String commonPrefix(String left, String right) {
    int min = Math.min(left.length(), right.length());
    for (int i = 0; i < min; i++) {
      if (left.charAt(i) != right.charAt(i)) {
        return left.substring(0, i);
      }
    }
    return left.substring(0, min);
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////
  // 二分思想
  public String longestCommonPrefix4(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs) {
      minLen = Math.min(minLen, str.length());
    }
    int low = 1;
    int high = minLen;

    // 这个二分思想的利用！！
    while (low <= high) {
      int middle = (low + high) / 2;
      if (isCommonPrefix(strs, middle))
        low = middle + 1;
      else
        high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
  }

  private boolean isCommonPrefix(String[] strs, int len) {
    String str1 = strs[0].substring(0, len);
    for (int i = 1; i < strs.length; i++)
      if (!strs[i].startsWith(str1)) return false;
    return true;
  }
  /////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * @param args
   */
  public static void main(String[] args) {
    String[] strs = new String[] { "abcdefgtyui", "ertabcdefgtyui", "erabcdefgtyui" };
    System.out.println(longestCommonPrefix(strs));
  }

}
