package com.data.util;

/**
 * @author AndiHappy LinkNodeUtil.java
 * 
 *         链表的基础的操作
 *
 * @date 2017年1月5日 下午3:12:31
 */
public class LinkNodeUtil {

  /**
   * <p>
   * 合并链表，并且返回头结点
   * </p>
   */
  public static ListNode mergeLinkNodes(ListNode h1, ListNode h2) {
    if (h1 != null && h2 != null) {
      ListNode h = new ListNode(0);
      ListNode current = h;
      while (h1 != null && h2 != null) {
        if (h1.val < h2.val) {
          current.next = h1;
          h1 = h1.next;
        } else {
          current.next = h2;
          h2 = h2.next;
        }
        current = current.next;
      }

      if (h1 != null) {
        current.next = h1;
      }

      if (h2 != null) {
        current.next = h2;
      }

      return h.next;
    }
    return null;
  }

  /**
   * <p>
   * 打印输入的链表节点，及其以后的节点
   * </p>
   */
  public static void printLinkNode(ListNode node) {
    if (node != null) {
      System.out.print(node.val);
    }
    while (node.next != null) {
      System.out.print(" => " + node.next.val);
      node = node.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(8);
    l1.next = new ListNode(9);
    l1.next.next = new ListNode(10);
    printLinkNode(l1);

    ListNode l2 = new ListNode(7);
    l2.next = new ListNode(11);
    l2.next.next = new ListNode(13);
    printLinkNode(l2);

    printLinkNode(mergeLinkNodes(l1, l2));
  }
}
