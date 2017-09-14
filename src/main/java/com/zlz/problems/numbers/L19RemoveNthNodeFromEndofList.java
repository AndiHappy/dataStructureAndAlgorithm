package com.zlz.problems.numbers;

import com.data.util.ListNode;

/**
 * @author zhailz
 *
 *         时间：2016年10月26日 ### 下午2:09:28
 */
public class L19RemoveNthNodeFromEndofList {

  /*
   * Given a linked list, remove the nth node from the end of list and return
   * its head.
   * 
   * For example,
   * 
   * Given linked list: 1->2->3->4->5, and n = 2.
   * 
   * After removing the second node from the end, the linked list becomes
   * 1->2->3->5.
   * Note:
   * Given n will always be valid.
   * Try to do this in one pass.
   */

  public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      int length = getLinkedLength(head);
      head = removeNode(head, n, length);
      return head;
    }

    private ListNode removeNode(ListNode head, int n, int length) {
      // 循环了一次，从头到尾巴
      ListNode p = head;
      if (length == n && n == 1) return null;
      for (int i = 0; i < length; i++) {
        if (i == length - 1) {
          p.next = null;
          break;
        }
        if (i >= length - n && head.next != null) {
          head.val = head.next.val;
        }
        p = head;
        head = head.next;
      }
      return head;
    }

    private ListNode removeNode1(ListNode head, int n, int length) {
      // 循环了一次，从头到尾巴
      ListNode p = head;
      if (length == n && n == 1) return null;

      for (int i = 0; i < length; i++) {
        // 如果删除的是头元素
        if (n == length) {
          head = head.next;
          break;
        }

        // 如果删除的是最后一个元素
        if (n == 1 && i == length - 2) {
          p.next = null;
          break;
        }

        // 如果删除的是中间的元素
        if (i == length - n - 1 && p.next != null) {
          p.next = p.next.next;
          break;
        }

        p = p.next;
      }
      return head;
    }

    /**
     * @param head
     * @return
     */
    private int getLinkedLength(ListNode head) {
      int value = 0;
      while (head != null) {
        value++;
        head = head.next;
      }
      return value;
    }
  }
}
