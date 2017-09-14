package com.zlz.problems.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhailz
 *
 *         时间：2016年10月24日 ### 下午8:04:00
 */
public class L153Sum {
  //
  // Given an array S of n integers, are there elements a, b, c in S such that a
  // + b + c = 0? Find all unique triplets in the array which gives the sum of
  // zero.
  //
  // Note: The solution set must not contain duplicate triplets.
  //
  // For example, given array S = [-1, 0, 1, 2, -1, -4],
  //
  // A solution set is:
  // [
  // [-1, 0, 1],
  // [-1, -1, 2]
  // ]
  // Subscribe to see which companies asked this question

  /**
   * 第一个念头肯定是遍历，然后感觉比较的low
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (nums == null || nums.length < 3) {
      return res;
    }
    // 首先给数组进行排序
    Arrays.sort(nums);
    int begine, end;
    for (int i = 1; i < nums.length; i++) {
      begine = 0;
      end = nums.length - 1;
      while (begine < i && end > i) {
        if (nums[i] + nums[begine] + nums[end] == 0) {
          res.add(Arrays.asList(nums[begine], nums[i], nums[end]));
          begine++;
          end--;
        } else if (nums[i] + nums[begine] + nums[end] < 0) {
          begine++;
        } else {
          end--;
        }
      }
    }

    return res;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {

    int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
    System.out.println(threeSum(nums));

  }

}
