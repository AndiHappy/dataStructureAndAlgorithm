package com.zlz.util;

/**
 * @author zhailz
 * @date 17/9/14 - 上午9:31.
 */
public class AlgUtil {


  /**
   * 数组中值的交换
   * */

  public static void swap(int[] list, int k, int i) {
    int m = list[k];
    list[k] = list[i];
    list[i] = m;
  }
  
  /**
   * @param va
   */
  public static void print(int[][] va) {
    System.out.println();
    System.out.println();
    for (int i = 0; i < va.length; i++) {
      for (int j = 0; j < va[i].length; j++) {
        if(va[i][j] > 10) {
          System.out.print(va[i][j] + " ");
        }else {
          System.out.print(va[i][j] + " "+" ");
        }
       
      }
      System.out.println();
    }
    
  }
}
