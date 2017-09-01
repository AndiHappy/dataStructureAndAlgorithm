package com.zlz.leetcode.stack;

import java.util.Stack;

/**
 * @author zhailz
 *
 * 时间：2016年7月20日 ### 上午11:11:40
 */
public class L20ValidParentheses {

	/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
	determine if the input string is valid.

	The brackets must close in the correct order, "()" and "()[]{}" are all valid 
	but "(]" and "([)]" are not.*/

    public boolean isValid(String s) {
    	
    	//ini valid
    	if(s == null || s.length() <= 0){
    		return true;
    	}
    	Stack<Character> stack = new Stack<Character>();
    	for (int i = 0; i < s.length(); i++) {
    		char cha = s.charAt(i);
			switch (cha) {
			case '(':
			case '{':
			case '[':
				stack.push(cha);
				break;
			case ')':
				if(stack.isEmpty() || stack.pop() != '(' ){
					return false;
				}
				break;
			case '}':
				if(stack.isEmpty() || stack.pop() != '{' ){
					return false;
				}
				break;
			case ']':
				if(stack.isEmpty() || stack.pop() != '[' ){
					return false;
				}
				break;
			default:
				break;
			}
		}
    	return stack.isEmpty();
    }

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
