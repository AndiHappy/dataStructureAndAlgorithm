package com.zlz.problems.string;

/**
 * @author zhailz
 *
 * 时间：2016年9月27日 ### 下午5:01:43
 */
public class L08StringToInteger {

	//
	//	Implement atoi to convert a string to an integer.
	//
	//	Hint: Carefully consider all possible input cases. If you want a challenge, 
	//	please do not see below and ask yourself what are the possible input cases.
	//
	//	Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
	//	You are responsible to gather all the input requirements up front.
	//
	//	Update (2015-02-10):
	//	The signature of the C++ function had been updated. If you still see your function signature 
	//	accepts a const char * argument, please click the reload button  to reset your code definition.

	/**
	 * 1.超过最大值或者小于最小值的就返回最大值或者最小值
	 * 2.字符串前的" "直接的忽略
	 * 3.如果有不能够解析的字符，截止到此
	 * */
	public static int myAtoi(String str) {
		//正负值的问题
		Boolean value = null;
		int ii = 0;
		for (; ii < str.length(); ii++) {
			char tmp = str.charAt(ii);
			if (tmp == ' ') {
				continue;
			}
			if (tmp == '+' || tmp == '-') {
				value = tmp == '-';
				break;
			}

			if (Character.isDigit(tmp)) {
				ii--;
				value = false;
				break;
			} else {
				return 0;
			}

		}

		long res = 0;
		for (int i = ii + 1; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (Character.isDigit(tmp)) {
				res = res * 10 + (tmp - '0');
				if ((!value && res > Integer.MAX_VALUE) || (value && -res < Integer.MIN_VALUE)) {
					return value ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
			} else {
				return (int) ((value != null && value) ? -res : res);
			}

		}

		return (int) ((value != null && value) ? -res : res);
	}

	public static void main(String[] args) {
		String value = "  -0012a42";
		System.out.println(myAtoi(value));
		System.out.println(myAtoi("   +0 123"));//0
		System.out.println(myAtoi("-2147483648"));//"-2147483648"
		System.out.println(myAtoi("1"));//1
		System.out.println(myAtoi("-2147483649"));//"-2147483648"
		System.out.println(myAtoi(" b11228552307"));//0
	}
}
