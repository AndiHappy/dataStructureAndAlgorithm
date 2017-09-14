package com.zlz.problems.backtracking;

import java.util.Arrays;

import static com.zlz.util.AlgUtil.swap;

/**
 * @author zhailz
 * @Date 2017年9月4日 - 下午9:28:10
 * @Doc: 全排列算法
 */
public class QuanPaiLie {
  
  private static int count = 0;

  public static void quanpailie(int[] a) {
    int[] tmp = new int[a.length];
    quanpailie(0, a, tmp);
  }

  /**
   * @param i
   * @param a
   */
  private static void quanpailie(int i, int[] a, int[] tmp) {
    int[] tmpp = restValue(a, tmp, i);
    if (i >= a.length) {
      System.out.println(Arrays.toString(tmp));
    } else {
      // i 位置上面的可能性的值是 a.length-i
      // tmp[i] 每次迭代的时候，向里面赛数据的内容
      for (int j = 0; j < a.length - i; j++) {
        tmp[i] = tmpp[j];
        quanpailie(i + 1, a, tmp);
      }
    }

  }

  /**
   * @param a
   * @param tmp
   * @param i
   * @return
   */
  private static int[] restValue(int[] a, int[] tmp, int end) {
    int[] tmpp = new int[a.length];
    int index = 0;
    for (int i = 0; i < a.length; i++) {
      if (notin(a[i], tmp, end)) {
        tmpp[index] = a[i];
        index++;
      }
    }
    return Arrays.copyOf(tmpp, index++);
  }

  /**
   * @param i
   * @param tmp
   * @param end
   * @return
   */
  private static boolean notin(int i, int[] tmp, int end) {
    for (int j = 0; j < end; j++) {
      if (tmp[j] == i) {
        return false;
      }
    }
    return true;
  }

  // 核心思想是交换，具体来说，对于一个长度为n的串，要得到其所有排列，我们可以这样做：
  // 把当前位上的元素依次与其后的所有元素进行交换
  // 对下一位做相同处理，直到当前位是最后一位为止，输出序列
  // （需要注意的一点：我们的思想是“交换”，也就是直接对原数据进行修改，那么在交换之后一定还要再换回来，
  // 否则我们的原数据就发生变化了，肯定会出错）
  public static void perm(int list[], int k, int m) {
    int i;
    if (k > m) {
      System.out.print(Arrays.toString(list));
      System.out.println();
      setCount(getCount() + 1);
    } else {
      for (i = k; i <= m; i++) {
        //交换数据
        swap(list, k, i);
        perm(list, k + 1, m);
        //交换回来
        swap(list, k, i);
      }
    }
  }


  public static void main(String[] args) {
    int[] a = new int[] { 1, 2, 3, 4 };
    // quanpailie(a);
    perm(a, 0, 3);
  }

  public static int getCount() {
    return count;
  }

  public static void setCount(int count) {
    QuanPaiLie.count = count;
  }

}
