package com.alg.util;

import java.util.Random;

/**
 * @author zhailz
 * @Date 2017年8月23日 - 上午8:30:54
 * @Doc: 
 */
/**
 * Returns a pseudo-random number between min and max, inclusive.
 * The difference between min and max can be at most
 * <code>Integer.MAX_VALUE - 1</code>.
 *
 * @param min
 *          Minimum value
 * @param max
 *          Maximum value. Must be greater than min.
 * @return Integer between min and max, inclusive.
 * @see java.util.Random#nextInt(int)
 */
public class MyRandom {
  
  private static Random rand = new Random();

  private MyRandom() {}

  private static class MyRandomHolder {
    private static final MyRandom instance = new MyRandom();
  }

  public static MyRandom getInstance() {
    return MyRandomHolder.instance;
  }

  public static int randInt(int min, int max) {
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }
  
  public static void main(String[] args) {
    System.out.println(MyRandom.randInt(1, 2));
  }

}
