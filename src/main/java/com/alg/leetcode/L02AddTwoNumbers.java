package com.alg.leetcode;

import com.data.util.ListNode;

/**
 * @author AndiHappy L02AddTwoNumbers.java
 *
 * @date 2017年1月5日 下午2:16:18
 */
public class L02AddTwoNumbers {

  /*
   * You are given two linked lists representing two non-negative numbers.
   * The digits are stored in reverse order and each of their nodes contain a
   * single digit. Add the two numbers and return it as a linked list.
   * 
   * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   * Output: 7 -> 0 -> 8
   */
  /**
   * 1.情况分的太细了，没有抽出来普世的逻辑出来.
   * 2.考虑到了进位的情况下，就不能再按照普通的合并链表的基础的算法进行了
   */
  public ListNode addTwoNumbers_manyCode(ListNode l1, ListNode l2) {
    if (l1 != null && l2 != null) {
      int flag = 0;
      int value = l1.val + l2.val;
      int numc = value % 10;
      ListNode sum = new ListNode(numc);
      // 进位
      flag = value / 10;
      ListNode temp = sum;

      while (l1.next != null && l2.next != null) {
        int tv = l1.next.val + l2.next.val + flag;
        flag = tv / 10;
        numc = tv % 10;
        ListNode node = new ListNode(numc);
        temp.next = node;
        temp = node;
        l1 = l1.next;
        l2 = l2.next;
      }

      if (l1.next != null) {
        while (l1.next != null) {
          int tv = l1.next.val + flag;
          int num = tv % 10;
          flag = tv / 10;
          ListNode node = new ListNode(num);
          temp.next = node;
          temp = node;
          l1 = l1.next;
          if (flag == 0) {
            temp = l1.next;
            break;
          }
        }
      }

      if (l2.next != null) {
        while (l2.next != null) {
          int tv = l2.next.val + flag;
          int num = tv % 10;
          flag = tv / 10;
          ListNode node = new ListNode(num);
          temp.next = node;
          temp = node;
          l2 = l2.next;
          if (flag == 0) {
            temp = l2.next;
            break;
          }
        }
      }

      if (l2.next == null && l1.next == null && flag != 0) {
        ListNode node = new ListNode(flag);
        temp.next = node;
        temp = node;
      }

      return sum;
    }
    return null;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 指向头指针的处理
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carry + x + y;
      // 进位处理
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return dummyHead.next;
  }

  public static void main(String[] args) {
    L02AddTwoNumbers num = new L02AddTwoNumbers();
    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(8);
    l1.next.next = new ListNode(9);
    System.out.println(l1.toString());

    ListNode l2 = new ListNode(1);
    // l2.next = new ListNode(6);
    // l2.next.next = new ListNode(4);
    System.out.println(l2.toString());
    ListNode l3 = num.addTwoNumbers(l1, l2);
    System.out.println(l3);

  }

  /**
   * 1. 链表的操作的过程中：
   * ListNode dummyHead = new ListNode(0);
   * ListNode curr = dummyHead;
   * return dummyHead.next;
   * 头指针的处理，这样可以保证在操作的时候，最后的返回的指针是从头指针开始的
   * 
   * 2. 抽象的能力，合理的抽象可以大大的提高代码的规整的程度
   */
}
