package com.zlz.problems.array;

import java.util.Arrays;

import static com.zlz.util.AlgUtil.swap;

/**
 * @author zhailz
 * @date 17/9/14 - 上午9:05.
 *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *  使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 *  并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ArrayChangeByRule {

  public static int[] changeByRule(int[] a){
    int [] tmp = new int[a.length];
    System.arraycopy (a,0,tmp,0,a.length);
    int from = 0,end = tmp.length-1;

    if(a == null || a.length == 1){
      return a;
    }

    int i = 0,j = a.length-1;
    while(i < a.length  && j > -1){
      if(i % 2 == 1){
        tmp[from] = a[i];
        from++;
      }

      i++;

      if(j % 2 == 0){
        tmp[end] = a[j];
        end--;
      }
      j--;
    }

    return tmp;

  }

  public  static void main(String[] args){
    int[] a = new int[]{1,2,3,4,5,6,7,8,9,0};
    System.out.println (Arrays.toString (a));
    a = changeByRule (a);
    System.out.println (Arrays.toString (a));
  }
}
