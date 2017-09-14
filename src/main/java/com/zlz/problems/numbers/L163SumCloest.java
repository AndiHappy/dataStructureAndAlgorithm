package com.zlz.problems.numbers;

import java.util.Arrays;

/**
 * Created by zhailz on 16/10/25.
 *
 * version 1.0.0
 */
public class L163SumCloest {

  /**
   * Given an array S of n integers, find three integers in S such that the sum
   * is closest to a given number, target.
   * Return the sum of the three integers. You may assume that each input would
   * have exactly one solution.
   * For example, given array S = {-1 2 1 -4}, and target = 1.
   *
   * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
   *
   * 寻找最接近target值的三个值的相加，这个可以有很多的方法。首先根据我们L15的逻辑，我们可以寻找到
   * 一个最接近的，这个时候的算法的复杂度
   */
  public static int threeSumClosest(int[] nums, int target) {

      /* 首先进行数组的排序 */
      Arrays.sort(nums);

      int begine, end,res=Math.abs(nums[0] + nums[1] + nums[2] -target),result = nums[0] + nums[1] + nums[2];
      for (int i = 1; i < nums.length; i++) {
          begine = 0;
          end = nums.length - 1;
          while (begine < i && end > i) {
              if (nums[i] + nums[begine] + nums[end] == target) {
                  System.out.println(nums[i] +" "+ nums[begine] +" "+ nums[end] );
                  return target;
              } else if (nums[i] + nums[begine] + nums[end] < target) {
                 int tmp =  Math.abs(nums[i] + nums[begine] + nums[end] -target);
                  if(res > tmp){
                      res = tmp;
                      result = nums[i] + nums[begine] + nums[end];
                  }
                  begine++;
              } else {
                  int tmp =  Math.abs(nums[i] + nums[begine] + nums[end] -target);
                  if(res > tmp){
                      res = tmp;
                      result = nums[i] + nums[begine] + nums[end];
                  }
                  end--;
              }
          }
      }

      return result;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {

    int[] nums = new int[] { -1, 1, 2,  -4 };
    System.out.println(threeSumClosest(nums, 1));

  }

}
