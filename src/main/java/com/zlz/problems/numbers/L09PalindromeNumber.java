package com.zlz.problems.numbers;

/**
 * @author zhailz
 *
 * 时间：2016年9月28日 ### 上午11:24:38
 */
public class L09PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindromeNumber(121));

	}

	//	Determine whether an integer is a palindrome. Do this without extra space.
	public static boolean isPalindromeNumber(int num) {
		int temp = 0;
		while (num != 0) {
			temp = temp * 10 + num % 10;
			num = num / 10;
		}
		return temp == num;
	}

}
