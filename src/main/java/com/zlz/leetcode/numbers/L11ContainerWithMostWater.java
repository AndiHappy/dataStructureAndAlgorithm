package com.zlz.leetcode.numbers;

/**
 * @author zhailz
 *
 * 时间：2016年9月29日 ### 下午4:23:42
 */
public class L11ContainerWithMostWater {

	//	Given n non-negative integers a1, a2, ..., an, where each represents
	//	a point at coordinate (i, ai). n vertical lines are drawn such 
	//	that the two endpoints of line i is at (i, ai) and (i, 0). 
	//	Find two lines, which together with x-axis forms a container, 
	//	such that the container contains the most water.

	//	Note: You may not slant the container.

	/**
	 * 思维的力量：认清楚题目two lines ，是两个支柱之间包含最多的水量
	 * 
	 * In this case, we will simply consider the area for 
	 * every possible pair of the lines and find out the maximum area out of those.
	 * */
	public int maxArea(int[] height) {
		int maxarea = 0;
		for (int i = 0; i < height.length; i++)
			for (int j = i + 1; j < height.length; j++)
				maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
		return maxarea;
	}

	public int maxAreaImporve(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return maxarea;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
