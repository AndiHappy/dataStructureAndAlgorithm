package com.data.util;

import java.util.Random;

/**
 * @author zhailz
 * @Date 2017年8月23日 - 上午8:35:18
 * @Doc: 
 */
public enum  RandEnum {
  INSTANCE;
  
  private static Random rand = new Random();
  
  public  int randInt(int min, int max) {
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }
  
  public static void main(String[] args) {
    System.out.println(INSTANCE.randInt(1, 2));
  }
}
