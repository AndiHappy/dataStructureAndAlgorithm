package com.alg.leetcode;

import com.alg.util.ArraysUtil;
import com.data.util.StringUtils;

/**
 * @author AndiHappy L05LongestPalindromicSubstring.java
 *
 * @date 2017年1月6日 上午9:42:43
 */
public class L05LongestPalindromicSubstring {

  /**
   * 找到给出字符串的最长的回文字符子序列
   */

  /**
   * 第一种方法：采用最长的子串
   * 把要求的字符串s,颠倒一下变为s`,然后求取两个字符串的最长公共子串，LCS
   * 这个是把未知的问题转化为已知的问题
   */

  public String longestPalindrome1(String s) {
    // 构建辅助的s`
    String ss = StringUtils.changeOver(s);
    String lcs = StringUtils.longestCommomSubstring(s, ss);
    return lcs;
  }

  /**
   * 循环遍历的方法
   */
  public String longestPalindrome2(String s) {
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      // bab的样式
      int len1 = expandAroundCenter(s, i, i);
      // adda的样式
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }

  /**
   * 动态规划，选取最长的回文字符串
   */
  public String longestPalindrome(String s) {
    int n = s.length();
    String res = null;
    // 中间数据，相当于状态方程的转移的过程
    boolean[][] dp = new boolean[n][n];
    // dp 的意义应该是dp[i][j] 是否是回文字符串里面
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        // j - i < 3 || dp[i + 1][j - 1] 这个判断
        dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
        if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
          res = s.substring(i, j + 1);
        }
      }
    }
    return res;
  }

  /**
   * 动态规划，选取最长的回文字符串
   */
  public String longestPalindromevalue(String s) {
    int n = s.length();
    String res = null;
    // 中间数据，相当于状态方程的转移的过程
    boolean[][] dp = new boolean[n][n];
    // dp 的意义应该是dp[i][j]
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
      }
    }
    System.out.println(ArraysUtil.arraystoString(dp));
    return res;
  }

  public static void main(String[] args) {
    String value = "abacab";
    L05LongestPalindromicSubstring lo = new L05LongestPalindromicSubstring();
    System.out.println(lo.longestPalindromevalue(value));
  }

}

/**
 * 1. 转化问题的能力
 * 2. 动态规划
 * 
 */
