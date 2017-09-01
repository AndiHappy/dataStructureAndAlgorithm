package com.zlz.leetcode.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhailz
 *
 *         时间：2016年7月20日 ### 下午1:44:50
 */
public class L184Sum {

  /*
   * Given an array S of n integers, are there elements a, b, c, and d in S
   * such that a + b + c + d = target? Find all unique quadruplets in the
   * array which gives the sum of target.
   * 
   * Note:
   * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a
   * ≤ b ≤ c ≤ d)
   * The solution set must not contain duplicate quadruplets.
   * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
   * 
   * A solution set is:
   * (-1, 0, 0, 1)
   * (-2, -1, 1, 2)
   * (-2, 0, 0, 2)
   * 
   */

  /**
   * 按照L15 和 L16 的逻辑，首先排序，然后在开始试探性的排列
   */
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> l;
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i < len - 3; i++) {
      // 相同直接返回
      if (i != 0 && nums[i] == nums[i - 1]) continue;
      // 最小值如果大于target，直接的返回
      if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
      // 此值和最大的三个值相加，小于target 直接的返回
      if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 2] < target) continue;

      for (int j = i + 1; j < len - 2; j++) {
        // 相同直接返回
        if (j != i + 1 && nums[j] == nums[j - 1]) continue;
        // 最小值如果大于target，直接的返回
        if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
        // 此值和最大的三个值相加，小于target 直接的返回
        if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;

        int head = j + 1, end = len - 1;
        while (head < end) {
          int tempt = nums[i] + nums[j] + nums[head] + nums[end];
          if (tempt == target) {
            l = new ArrayList<Integer>();
            l.add(nums[i]);
            l.add(nums[j]);
            l.add(nums[head]);
            l.add(nums[end]);
            list.add(l);
            head++;
            while (head < end && nums[head] == nums[head - 1]) {
              head++;
            }
          } else if (tempt > target)
            end--;
          else
            head++;
        }
      }
    }
    return list;
  }

  public static void main(String[] args) {

    // S = {1 0 -1 0 -2 2}, and target = 0.
    int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
    int target = 0;
    System.out.println(fourSum(nums, target));

  }
}
