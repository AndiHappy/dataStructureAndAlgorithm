package com.zlz.problems.map;

import java.util.Arrays;
import java.util.HashMap;


/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

public class L01TwoSum {

	
	public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> keys = new HashMap<Integer, Integer>();
        if(n > 1){
        	for (int i = 0; i < nums.length; i++) {
        		keys.put(nums[i], i);
			}
        	
        	for (int i = 0; i < nums.length; i++) {
        		Integer value = keys.get(target - nums[i]);
        		// 缺乏边界条件的考虑：value != i
				if( value != null && value != i){
					if(i>value){
						return new int[]{value,i};
					}else{
						return new int[]{i,value};
					}
				}
			}
        }
        return null;
    }
	
	public int[] twoSum_improve(int[] nums, int target) {
		HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int value = target - nums[i];
			if(temp.containsKey(value)){
				int index = temp.get(value);
				int[] res = new int[2];
				res[0] = i > index? index:i;
				res[1] = i > index? i:index;
				return res;
			}
			temp.put(nums[i], i);
		}
		temp.clear();
		temp = null;
		return null;
	}
	
	
	public int[] twoSum_sort(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++) 
             nums[i] = nums[i] * n + (nums[i] < 0 ? -i : i);
        
        Arrays.sort(nums);
        
        int lo = 0, hi = n - 1;
        
        while (lo < hi) {
            int sum = nums[lo]/n + nums[hi]/n;
            if (sum == target) return new int[]{nums[lo] < 0 ? -nums[lo] % n : nums[lo] % n, nums[hi] < 0 ? -nums[hi] % n : nums[hi] % n};
            if (sum < target)   lo++;
            else                hi--;
        }
        throw new IllegalArgumentException();
    }
	
	public static void main(String[] args) {
		int[] value = new int[]{3,2,4};
		System.out.println(Arrays.toString(twoSum(value, 6)));

	}
}
