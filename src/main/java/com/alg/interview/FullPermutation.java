package com.alg.interview;

public class FullPermutation {
  static int count = 0;

  // 递归实现全排列
  // 程序思路是：依次确定第一位到最后一位，与人的一般思维方式一致
  public static void main(String[] args) {
    String str = "12";
    str = check(str);// 去除重复元素
    fullPermutate(0, "", str);
    System.out.print(count);
  }

  // @param index 本次调用确定第index位
  // @param path 已经确定顺序的串
  // @param string 待全排列的串
  static void fullPermutate(int index, String path, String string) {
    //这一步很重要，这一步就是下一步产生的基础
    String restStr = strSub(string, path);
    if (index == string.length()) {
      System.out.println(path + restStr);
      count++;
      return;
    } else {
      for (int i = 0; i < string.length() - index; i++)
        fullPermutate(index + 1, path + restStr.charAt(i), string);
    }
  }

  // @param full 完整的串
  // @param part 部分子串
  // @return rest 返回full与part的差集
  static String strSub(String full, String part) {
    String rest = "";
    for (int i = 0; i < full.length(); i++) {
      String c = full.charAt(i) + "";
      if (!part.contains(c)) rest += c;
    }
    return rest;
  }

  // @param str 待检查的串
  // @return 返回不含重复元素的串
  static String check(String str) {
    for (int i = 0; i < str.length() - 1; i++) {
      String firstPart = str.substring(0, i + 1);
      String restPart = str.substring(i + 1);
      str = firstPart + restPart.replace(str.charAt(i) + "", "");
    }
    return str;
  }
}