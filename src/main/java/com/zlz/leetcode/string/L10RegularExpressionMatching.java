package com.zlz.leetcode.string;

/**
 * @author zhailz
 *
 * 时间：2016年9月28日 ### 上午11:39:20
 */
public class L10RegularExpressionMatching {

	//	'.' Matches any single character.
	//	'*' Matches zero or more of the preceding element.
	//
	//	The matching should cover the entire input string (not partial).
	//
	//	The function prototype should be:
	//	bool isMatch(const char *s, const char *p)
	//
	//	Some examples:
	//	isMatch("aa","a") → false
	//	isMatch("aa","aa") → true
	//	isMatch("aaa","aa") → false
	//	isMatch("aa", "a*") → true
	//	isMatch("aa", ".*") → true
	//	isMatch("ab", ".*") → true
	//	isMatch("aab", "c*a*b") → true

	/**
	 * 规则解释：
	 * 1，‘.’ 可以匹配任意一个元素
	 * 2，‘*’ 它前面的元素出现0次或者n次
	 * */

	//特殊的规则匹配字符串
	public static boolean isMatch(String s, String p) {
		if (s == null && p == null)
			return true;
		if (s == null || p == null)
			return false;
		return isMatch(s, 0, p, 0);
	}

	/**
	 * 递归的调用的方式,缺乏思考的过程，最终就不能按照一点点的弄出来
	 * 1.既然使用递归的方式解决，就必然有递归的出口和递归的方程式
	 * 2.递归的方程式：
	 * 2.1 如果s(i-1) = p(j-1)(包括pj-1 为.的情况)，我们就可以直接的比较 s(i)和p(j)
	 * 2.2 如果ss(i-1) != p(j-1) 但是pj = * 我们就可以直接的比较s(i-1) 和 p(j+1)
	 * 2.3 如果ss(i-1) != p(j-1) 但是pj != * 我们就可以直接的比较s(i-1) 和 p(j)
	 * 3.递归的出口
	 * 3.1 如果现在s和p都比较最后一个元素相等以后，比较si+1 pj+1 直接的返回true
	 * 3.2 如果现在s匹配完了，但是p后面还有数据，并且最后一个不是*，直接返回false
	 * 3.3 如果现在s匹配没有完，但是p后面的数据没有了，直接的返回false
	 * 
	 * */

	private static boolean isMatch(String s, int sstart, String p, int pstart) {

		if (s.length() == sstart && p.length() == pstart)
			return true;
		if (p.length() == pstart)
			return false;
		if (s.length() == sstart) {
			if (pstart + 1 >= p.length() || p.charAt(pstart + 1) != '*') {
				return false;
			}
			return isMatch(s, sstart, p, pstart + 2);
		}

		//		"aaa", "ab*a*c*a"
		// 这一个的理解致关的重要，可以看做是第二个字符串上面匹配字符的移动，因为可以匹配多个，所以
		// 当前一个相等的时候，我们的第一个匹配的字符会发生移动，但是第二个匹配的位置不能发生移动
		if (pstart + 1 <= p.length() - 1 && p.charAt(pstart + 1) == '*') {
			if (s.charAt(sstart) == p.charAt(pstart) || p.charAt(pstart) == '.') {
				return isMatch(s, sstart + 1, p, pstart) || isMatch(s, sstart, p, pstart + 2);
			}
			return isMatch(s, sstart, p, pstart + 2);
		} else if (p.charAt(pstart) == '.') {
			return isMatch(s, sstart + 1, p, pstart + 1);
		} else {
			return p.charAt(pstart) == s.charAt(sstart) && isMatch(s, sstart + 1, p, pstart + 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//		System.out.println("1:" + isMatch("aa", "a"));
		//		System.out.println("2:" + isMatch("aaa", "aaaa"));
		System.out.println("3:" + isMatch("aa", "a*"));
		//		System.out.println("4:" + isMatch("ab", ".*c"));
		//		System.out.println("5:" + isMatch("aa", "a"));
		//		System.out.println("6:" + isMatch("aa", "aa"));
		//		System.out.println("7:" + isMatch("aaa", "aa"));
		//		System.out.println("8:" + isMatch("aa", "a*"));
		//		System.out.println("9:" + isMatch("aa", ".*"));
		//		System.out.println("10:" + isMatch("ab", ".*"));
		//		System.out.println("11:" + isMatch("aab", "c*a*b"));
		//		System.out.println("12:" + isMatch("aaa", "ab*a*c*a"));
	}

}
