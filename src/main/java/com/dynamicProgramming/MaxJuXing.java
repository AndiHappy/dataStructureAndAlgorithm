package com.dynamicProgramming;

import java.util.Stack;

/**
 * 最大矩形的问题
 * */
public class MaxJuXing {
    public static int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<>();
        int max_area = 0; // 最大矩形面积
        int tp; // 栈顶
        int area_with_top;

        int i = 0;
        int n = height.length;
        while (i < n) {
            if (s.empty() || height[s.peek()] <= height[i]) {
                s.push(i++);
            } else {
                tp = s.pop();
                area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
                max_area = Math.max(max_area, area_with_top);
            }
        }

        while (!s.empty()) {
            tp = s.pop();
            area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
            max_area = Math.max(max_area, area_with_top);
        }
        return max_area;
    }
    
    public static void main(String[] args) {
      int[] height = new int[] {6,2,5,4,5,1,6};
      largestRectangleArea(height);
    }
}