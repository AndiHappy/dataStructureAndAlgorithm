package com.zlz.problems.string;

import com.data.util.StringUtils;

/**
 * @author zhailzh
 * 
 * @Date 201511162:17:16
 * 
 * 最长的回文字符
 */
public class L05LongestPalindromicSubstring {

	public static void main(String[] args) {
		String value = "abacab";
		L05LongestPalindromicSubstring lo = new L05LongestPalindromicSubstring();
		System.out.println(lo.longestPalindrome1(value));
	}

	/**
	 * 第一种方法：采用最长的子串
	 * 把要求的字符串s,颠倒一下变为s`,然后求取两个字符串的最长公共子串，LCS
	 * 这个是把未知的问题转化为已知的问题
	 * */

	public String longestPalindrome1(String s) {
		//构建辅助的s`
		String ss = changeOver(s);
		String lcs = StringUtils.longestCommomSubstring(s, ss);
		return lcs;
	}

	/**
	 * 循环遍历的方法
	 * */
	public String longestPalindrome2(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			//bab的样式
			int len1 = expandAroundCenter(s, i, i);
			//adda的样式
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

	private String changeOver(String s) {
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

	public String longestPalindrome(String s) {
		int n = s.length();
		String res = null;
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
					res = s.substring(i, j + 1);
				}
			}
		}

		return res;
	}

	public boolean isPalind(String value, int start, int end) {

		if (!value.isEmpty()) {
			while (start <= end) {
				if (value.charAt(start) == value.charAt(end)) {
					start++;
					end--;
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
