package com.zlz.problems.linknode;

import com.data.util.LinkNodeUtil;
import com.data.util.ListNode;

/**
 * @author zhailz
 * @date 17/9/14 - 下午3:00.
 * DOC:ReverseNodes,输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseLinkedNode {

  public static ListNode reverseLinkedNode (ListNode head) {

    ListNode current = head;
    ListNode next = current.next;
    ListNode nextn = null;
    current.next = null;
    while (next != null) {
      nextn = next.next;
      next.next = current;
      current = next;
      next = nextn;
    }

    return current;
  }

  public static void main (String[] args) {

    ListNode node1 = new ListNode (1);
    ListNode node2 = new ListNode (2);
    node1.next = node2;
    ListNode node3 = new ListNode (3);
    node2.next = node3;
    ListNode node4 = new ListNode (4);
    node3.next = node4;
    ListNode node5 = new ListNode (5);
    node4.next = node5;
    LinkNodeUtil.printLinkNode (node1);
    System.out.println ();
    LinkNodeUtil.printLinkNode (node1);

    ListNode newhead = reverseLinkedNode (node1);
    LinkNodeUtil.printLinkNode (newhead);

  }
}
