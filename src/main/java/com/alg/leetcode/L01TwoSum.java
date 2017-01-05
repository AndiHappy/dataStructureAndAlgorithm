package com.alg.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author AndiHappy  L01TwoSum.java 
 *
 * @date 2017年1月5日 下午1:37:04
 */
public class L01TwoSum {

  /*
  Given an array of integers, return indices of the two numbers such 
  that they add up to a specific target.

  You may assume that each input would have exactly one solution.

  Example:
  Given nums = [2, 7, 11, 15], target = 9,

  Because nums[0] + nums[1] = 2 + 7 = 9,
  return [0, 1].*/

  /**
   * put all numbers in hashMap,and then circulate find the other value
   * */
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> keys = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      keys.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      Integer value = keys.get(target - nums[i]);
      // 缺乏边界条件的考虑：value != i
      if (value != null && value != i) {
        return i > value?  new int[] { value, i }:  new int[] { i, value };
      }
    }
    return null;
  }

  /**
   * first judge is right value，and the put the not correct value  into hashmap 
   * */
  public int[] twoSum_improve(int[] nums, int target) {
    HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int value = target - nums[i];
      if (temp.containsKey(value)) {
        int index = temp.get(value);
        int[] res = new int[2];
        res[0] = i > index ? index : i;
        res[1] = i > index ? i : index;
        return res;
      }
      temp.put(nums[i], i);
    }
    temp.clear();
    temp = null;
    return null;
  }

  /**
   * first sort then find,but we must save index
   * user x*n+i algorithm
   * */
  public static int[] twoSum_sort(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n; i++)
      nums[i] = nums[i] * n + (nums[i] < 0 ? -i : i);
    Arrays.sort(nums);

    int lo = 0, hi = n - 1;
    while (lo < hi) {
      // 判断的时候，没有挂着下标
      int sum = nums[lo] / n + nums[hi] / n;
      if (sum == target) return new int[] { nums[lo] < 0 ? -nums[lo] % n : nums[lo] % n,
          nums[hi] < 0 ? -nums[hi] % n : nums[hi] % n };
      if (sum < target)
        lo++;
      else
        hi--;
    }
    throw new IllegalArgumentException();
  }

  public static void main(String[] args) {
    int[] value = new int[] { 3, 2, 4 };
    System.out.println(Arrays.toString(twoSum_sort(value, 6)));

  }
  
  /**
   * 算法的变通：如果我们改变了数字的顺序，又想记着原来的下标的做法：
   * x = x>0?x*n+i: x*n+(-i);
   * 使用原来值的方法：x = x/n
   * 使用原来下标的方法: index = x%n
   * */

}
