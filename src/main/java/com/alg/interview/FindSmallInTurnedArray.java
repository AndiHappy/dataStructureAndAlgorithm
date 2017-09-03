package com.alg.interview;

/**
 * @author zhailz
 * @Date 2017年9月2日 - 下午3:12:26
 * @Doc: 递增的旋转数组，发现最小值
 */
public class FindSmallInTurnedArray {

  public static int findSmallInTurnedArray(int[] numbers, int length) {
    if (numbers == null || length <= 0) throw new IllegalArgumentException("Inval id parameters");
    int index1 = 0;
    int index2 = length - 1;
    // mid的初始化的值
    int indexMid = index1;
    while (numbers[index1] >= numbers[index2]) {
      // 相邻
      if (index2 - index1 == 1) {
        indexMid = index2;
        break;
      }
      // 初始化
      indexMid = (index1 + index2) / 2;

      if(numbers[index1] == numbers[index2] && numbers[index1] == numbers[indexMid]) {
        //特殊的情况下，只能依赖便利查找
        return findSmallInTurnedArrayInOrder(numbers,index1, index2);
      }
      
      if (numbers[indexMid] >= numbers[index1]) {
        // 中间值大于前面的值，前面值前移
        index1 = indexMid;

      } else if (numbers[indexMid] <= numbers[index2]) {
        // 中间值小于后面的值，后面值前移
        index2 = indexMid;
      }
    }
    return numbers[indexMid];
  }

  /**
   * @param numbers
   * @param index1
   * @param index2
   * @return
   */
  private static int findSmallInTurnedArrayInOrder(int[] numbers, int index1, int index2) {
    int tmp = numbers[index1];
    for (int i = index1+1; i < index2+1; i++) {
      if(tmp > numbers[i]) {
        tmp = numbers[i];
      }
    }
    return tmp;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] a = new int[] {5, 1,2,3,4};
    System.out.println(findSmallInTurnedArray(a, a.length));
    a = new int[] {1,0,1,1,1};
    System.out.println(findSmallInTurnedArray(a, a.length));
  }

}
