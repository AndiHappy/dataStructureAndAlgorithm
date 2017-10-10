package com.zlz.problems.array;

import com.zlz.util.AlgUtil;;
/**
 * @author zhailz
 * @Date 2017年9月27日 - 下午1:57:15
 * @Doc: 顺时针设置数组的值
 */
public class ClockWise {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int y = 5;
    int x = 7;
    int[][] va = new int[y][x];
    AlgUtil.print(va);
    
    //记录开始的节点
    int xx = 0; int yy = 0; 
    int tmp = 1;
    while(yy*2 < va.length && xx*2 < va[0].length) {
      tmp = intCircle(va,xx,yy,tmp);
      xx++;
      yy++;
    }
  }

  /**
   * 设置这圈的值
   * @param va
   * @param i
   * @param j
   * @param tmp
   * @return
   */
  private static int intCircle(int[][] numbers, int xx, int yy, int tmp) {
    // 数组的行数
    int yylength = numbers.length;
    // 数组的列数
    int xxlength = numbers[0].length;
    
    //设置第一段，环的最上端
    for (int i = yy; i <= xxlength - yy - 1; i++) {
      numbers[yy][i] = tmp;
      tmp++;
    }
    
    AlgUtil.print(numbers);
    
    //设置第二段，环的最右边
    if (xxlength - xx - 1 > xx && yylength - 1 - yy > yy) {
      for (int i = yy+1; i <= yylength - yy - 1; i++) {
        numbers[i][xxlength - 1 - xx] = tmp;
        tmp++;
      }
    }
    
    AlgUtil.print(numbers);
    
    // 设置第三段，底下的一段
    if (xxlength - xx - 1 > xx) {
      for (int i = xxlength - xx-2; i >= xx; i--) {
        numbers[yylength - yy - 1][i]=tmp;
        tmp++;
      }
    }
    AlgUtil.print(numbers);
    
    // 设置第四段
    if (xxlength - xx - 1 > xx && yylength - 1 - yy > yy) {
      for (int i = yylength - yy - 2; i > yy; i--) {
        numbers[i][xx] = tmp;
        tmp++;
      }
    }
    AlgUtil.print(numbers);
    return tmp;
  }
  
  public static void printMatrixInCircle(int[][] numbers, int x, int y) {
    // 数组的行数
    int rows = numbers.length;
    // 数组的列数
    int cols = numbers[0].length;
    // 输出环的上面一行，包括最中的那个数字
    for (int i = y; i <= cols - y - 1; i++) {
      System.out.print(numbers[x][i] + " ");
    }
    // 环的高度至少为2才会输出右边的一列
    // rows-x-1：表示的是环最下的那一行的行号
    if (rows - x - 1 > x) {
      // 因为右边那一列的最上面那一个已经被输出了，所以行呈从x+1开始，
      // 输出包括右边那列的最下面那个
      for (int i = x + 1; i <= rows - x - 1; i++) {
        System.out.print(numbers[i][cols - y - 1] + " ");
      }
    }
    // 环的高度至少是2并且环的宽度至少是2才会输出下面那一行
    // cols-1-y：表示的是环最右那一列的列号
    if (rows - x - 1 > x && cols - 1 - y > y) {
      // 因为环的左下角的位置已经输出了，所以列号从cols-y-2开始
      for (int i = cols - y - 2; i >= y; i--) {
        System.out.print(numbers[rows - 1 - x][i] + " ");
      }
    }
    // 环的宽度至少是2并且环的高度至少是3才会输出最左边那一列
    // rows-x-1：表示的是环最下的那一行的行号
    if (cols - 1 - y > y && rows - 1 - x > x + 1) {
      // 因为最左边那一列的第一个和最后一个已经被输出了
      for (int i = rows - 1 - x - 1; i >= x + 1; i--) {
        System.out.print(numbers[i][y] + " ");
      }
    }
  }
}
