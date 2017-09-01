package com.zlz.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhailz
 *
 *         时间：2016年10月27日 ### 上午11:11:05
 * 
 *         回溯算法
 */
public class L22GenerateParentheses {

  /*
   * Given n pairs of parentheses, write a function to generate all combinations
   * of well-formed parentheses.
   * 
   * For example, given n = 3, a solution set is:
   * 
   * [
   * "((()))",
   * "(()())",
   * "(())()",
   * "()(())",
   * "()()()"
   * ]
   */

  /////////////////////////// 比较慢的方法1///////////////////////////////////////////////////////////
  /**
   * 第一步分析问题，找到问题描述的确切的意义，3个和随机的排列的有一定的却别，要求保证括号的合法性
   * 第二步：寻找规律，这个是最难的。如果是1：(),2个就是：()(),(())
   */
  public List<String> generateParenthesis(int n) {
    Set<String> res = new HashSet<String>();
    res = valie(n, res);
    return new ArrayList<String>(res);
  }

  private Set<String> valie(int n, Set<String> res) {
    Set<String> resva = new HashSet<String>();
    if (n == 1) {
      resva.add("()");
      return resva;
    }
    res = valie(n - 1, resva);
    if (n >= 2) {
      for (String old : res) {
        for (int i = 0; i < old.length(); i++) {
          String value = insert(old, i, "()");
          if (!resva.contains(value)) {
            resva.add(value);
          }
        }
      }
    }
    return resva;
  }

  private String insert(String old, int i, String string) {
    String from = old.substring(0, i);
    String to = old.substring(i);
    old = from + string + to;
    return old;
  }
  /////////////////////////// 比较慢的方法1///////////////////////////////////////////////////////////

  public List<String> generateParenthesis1(int n) {
    List<String> res = new ArrayList<String>();
    getRes(n, 0, 0, res, "", 0);
    return res;
  }

  /**
   * 回溯的算法
   */
  public void getRes(int n, int cur, int len, List<String> res, String s, int balance) {
    if (cur > n || len > 2 * n) return;
    if (cur == n && s.length() == 2 * n && balance == 0) {
      res.add(s);
      return;
    }
    getRes(n, cur + 1, len + 1, res, s + "(", balance + 1);
    if (balance > 0) getRes(n, cur, len + 1, res, s + ")", balance - 1);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    L22GenerateParentheses pp = new L22GenerateParentheses();
    List<String> v = pp.generateParenthesis1(3);
    System.out.println(v);
  }

}
