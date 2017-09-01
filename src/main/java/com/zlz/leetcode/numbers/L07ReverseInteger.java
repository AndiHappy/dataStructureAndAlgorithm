package com.zlz.leetcode.numbers;

/**
 * @author zhailz
 *
 * 时间：2016年9月27日 ### 下午4:16:26
 * ps:范围如果可能的话，使用大范围的进行限定
 */
public class L07ReverseInteger {

	//	Reverse digits of an integer.
	//
	//	Example1: x = 123, return 321
	//	Example2: x = -123, return -321

	public static int reverse(int x) {
		int value = x > 0 ? x : -x;
		long change = 0;
		while (value > 0) {
			int tmp = value % 10;
			change = change * 10 + tmp;
			if (change > Integer.MAX_VALUE) {
				return 0;
			}
			value = value / 10;
		}
		return (int) (x > 0 ? change : -change);
	}

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
		System.out.println(reverse(-1463847412));
	}

}
