package com.data.util;

/**
 * @author zhailz
 *
 *         时间：2016年9月18日 ### 下午6:37:16
 * 
 *         字符串的操作的
 */
public class StringUtils {

  /**
   * 将字符串反转
   * 
   * @param s
   * @param sencond
   * @return
   */
  public static String changeOver(String s) {
    if (s != null && s.length() > 0) {
      StringBuilder builder = new StringBuilder();
      for (int i = s.length() - 1; i >= 0; i--) {
        builder.append(s.charAt(i));
      }
      return builder.toString();
    } else {
      return s;
    }
  }

  /**
   * 求取两个字符串的最长的公共子序列<br>
   * 采用的是动态规划的算法，两个字符串s1，s2 怎么算出最长的公共子序列的？状态的转移的方程是什么样子的？<br>
   * 假设 km 是字符转ai 和 bj 的最长的公共的子序列。k[0,1,2,......m] =
   * lcs(a[0,1,2,3,......i],b[0,1,2,3,......j];<br>
   * 那么如果字符a[i] == b[j] 那么km = a[i] ，k[0,1,2,......m-1] =
   * lcs(a[0,1,2,3,......i-1],b[0,1,2,3,......j-1];<br>
   * 那么如果字符a[i] != b[j] 并且km = a[i] ，k[0,1,2,......m-1] =
   * lcs(a[0,1,2,3,......i-1],b[0,1,2,3,......j];<br>
   * 那么如果字符a[i] != b[j] 并且km = b[j] ，k[0,1,2,......m-1] =
   * lcs(a[0,1,2,3,......i],b[0,1,2,3,......j-1];<br>
   * 最后的总结是：k[0,1,2,......m-1] =
   * max{lcs(a[0,1,2,3,......i],b[0,1,2,3,......j-1],lcs(a[0,1,2,3,......i-1],b[
   * 0,1,2,3,......j]};<br>
   * 
   * 然后我们就可以得到：需要一个中间变量来表示a[i]是否等于b[j],这个时候就能自然而然的想起二维数组来进行表示k[i][j],如果是使用k[i][j
   * ]等于1来表示<br>
   * a[i] == b[j],那么我们根据k[i][j] 就能够找到最长的公共子序列，这个时候的状态转移方程，也会有相应的变化<br>
   * 
   * 如果k[i][j] = 1 ，那么：k[0,1,2,......m] =
   * 1+lcs(a[0,1,2,3,......i],b[0,1,2,3,......j];<br>
   * 如果k[i][j] = 0 ，那么：k[0,1,2,......m] =
   * max{lcs(a[0,1,2,3,......i],b[0,1,2,3,......j-1],lcs(a[0,1,2,3,......i-1],b[
   * 0,1,2,3,......j]};<br>
   * 
   * @param first
   * @param second
   * @return
   */

  // 最长公共子串（Longest Common Substring）指的是两个字符串中的最长公共子串，要求子串一定连续。
  // 最长公共子序列（Longest Common Subsequence）指的是两个字符串中的最长公共子序列，不要求子序列连续。
  public static String longestCommomSubsequence(String first, String second) {
    if (first == null || first.length() <= 0 || second == null || second.length() <= 0) {
      return null;
    }
    char[] fir = first.toCharArray();
    char[] sec = second.toCharArray();
    int f = fir.length;
    int s = sec.length;
    // 首先是初始化
    int[][] k = new int[f][s];
    for (int i = 0; i < f; i++) {
      for (int j = 0; j < s; j++) {
        if (fir[i] == sec[j]) {
          if (i == 0 || j == 0) {
            k[i][j] = 1;
          } else {
            k[i][j] = k[i - 1][j - 1] + 1;
          }

        } else {
          if (i == 0 || j == 0) {
            k[i][j] = 0;
          } else {
            k[i][j] = Math.max(k[i - 1][j], k[i][j - 1]);
          }
        }
      }
    }
    StringBuffer sb = getLongestCommonSubsequence(fir, sec, k);
    return sb.reverse().toString();
  }

  /**
   * 得到的是最长的公共子序列
   * 
   * @param fir
   * @param sec
   * @param k
   * @return
   */

  private static StringBuffer getLongestCommonSubsequence(char[] fir, char[] sec, int[][] k) {
    int ff = fir.length - 1;
    int ss = sec.length - 1;
    int maxlength = k[ff][ss];
    StringBuffer sb = new StringBuffer();
    while (maxlength > 0 && ss >= 0 && ff >= 0) {
      // System.out.println(fir[ff] + "，" + sec[ss]);
      if (fir[ff] == sec[ss]) {
        // System.out.println(k[ff][ss]);
        sb.append(fir[ff]);
        ff = ff - 1;
        ss = ss - 1;
        maxlength--;
      } else {
        if (k[ff][ss - 1] > k[ff - 1][ss]) {
          ss = ss - 1;
        } else {
          ff = ff - 1;
        }
      }
    }
    return sb;
  }

  public static void main(String[] args) {
    String a = "csdn.ertieiteitoebteoteteutt";
    String b = "csdn.bt";
    System.out.println(longestCommomSubstring(a, b));
    System.out.println(longestCommomSubsequence(a, b));
  }

  /**
   * 得到最长的公共子串
   */
  // 最长公共子串（Longest Common Substring）指的是两个字符串中的最长公共子串，要求子串一定连续。
  public static String longestCommomSubstring(String first, String second) {
    if (first == null || first.length() <= 0 || second == null || second.length() <= 0) {
      return null;
    }
    char[] fir = first.toCharArray();
    char[] sec = second.toCharArray();
    int ff = fir.length;
    int ss = sec.length;
    int[][] k = new int[ff][ss];
    int max = 0;
    int imax = 0, jmax = 0;
    for (int i = 0; i < ff; i++) {
      for (int j = 0; j < ss; j++) {
        if (fir[i] == sec[j]) {
          if (i == 0 || j == 0) {
            k[i][j] = 1;
          } else {
            if (k[i - 1][j - 1] > 0) {
              k[i][j] = k[i - 1][j - 1] + 1;
            } else {
              k[i][j] = 1;
            }
          }
        } else {
          k[i][j] = 0;
        }

        if (k[i][j] > max) {
          imax = i;
          jmax = j;
          max = k[i][j];
        }
      }
    }

    StringBuilder res = new StringBuilder();
    for (int i = imax, j = jmax; i >= 0 && j >= 0 && max > 0; i--, j--) {
      res.append(fir[i]);
      max--;
    }
    return res.reverse().toString();
  }

  /**
   * 判断字符串不为NULL
   * 
   * @param word
   * @return
   */
  public static boolean isNotEmpty(String word) {
    return !isEmpty(word);
  }

  /**
   * 判断字符串为NULL
   * 
   * @param word
   * @return
   */
  public static boolean isEmpty(String word) {
    // TODO Auto-generated method stub
    return null == word || word.length() == 0;
  }
}