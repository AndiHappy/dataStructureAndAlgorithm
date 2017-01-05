package com.data.util;

/**
 * @author AndiHappy ListNode.java
 *
 * @date 2017年1月5日 下午1:37:04
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return "ListNode[val = " + this.val + "]";
  }
}