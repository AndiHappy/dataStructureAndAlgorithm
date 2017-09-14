package com.zlz.problems;

import com.data.util.ListNode;

/**
 * @author zhailz
 *
 *         时间：2016年10月27日 ### 下午3:33:30
 */
public class L23MergeKSortedLists {

  /*
   * Merge k sorted linked lists and return it as one sorted list. Analyze and
   * describe its complexity.
   */

  /**
   * Time Limit Exceeded
   * 暴力的破解，循环的比较，导致complexity 为n个节点每一个循环n次，这个就直接爆炸了
   */
  public ListNode mergeKLists1(ListNode[] lists) {
    ListNode head = new ListNode(0);
    ListNode p = head;
    // 确定当前的节点
    while (p != null) {
      // 确定p的下一个节点
      p.next = getNext(lists);
      p = p.next;
    }
    return head.next;
  }

  private ListNode getNext(ListNode[] lists) {
    ListNode tmp = null;
    int flag = 0;
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null && tmp == null) {
        tmp = lists[i];
        flag = i;
        continue;
      }
      if (lists[i] != null && tmp.val > lists[i].val) {
        tmp = lists[i];
        flag = i;
      }
    }
    if (tmp != null) {
      lists[flag] = lists[flag].next;
    }
    return tmp;
  }

  /**
   * 本来我们知道，两两合并的算法，所以我们自然的想到
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null) return null;
    
    if(lists.length <= 1){
      return lists[0];
    }
    return mergeKLists1fromAndTo(lists, 0, lists.length - 1);
  }

  private ListNode mergeKLists1fromAndTo(ListNode[] lists, int i, int j) {
    if (i + 1 == j) {
      return mergeKLists1fromAndTo(lists[i], lists[j]);
    } else if (i == j) {
      return lists[i];
    } else {
      int midle = (i + j) / 2;
      ListNode h1 = mergeKLists1fromAndTo(lists, i, midle);
      ListNode h2 = mergeKLists1fromAndTo(lists, midle+1, j);
      return mergeKLists1fromAndTo(h1, h2);
    }
  }

  // 操作的动作的，操作的是新建的节点
  public ListNode mergeKLists1fromAndTo(ListNode l1, ListNode l2) {
    ListNode l3 = new ListNode(0);
    ListNode first = l3;
    while (l1 != null || l2 != null) {
      if (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          l3.next = l1;
          l1 = l1.next;
        } else {
          l3.next = l2;
          l2 = l2.next;
        }
      } else if (l1 == null && l2 != null) {
        l3.next = l2;
        l2 = l2.next;
      } else if (l2 == null && l1 != null) {
        l3.next = l1;
        l1 = l1.next;
      }
      l3 = l3.next;
    }
    return first.next;
  }

  /**
   * 另外的一种比较
   */

  /**
   * @param args
   */
  public static void main(String[] args) {

    ListNode[] lists = new ListNode[3];

    ListNode h1 = new ListNode(2);
    h1.next = new ListNode(7);
    ListNode h3 = new ListNode(3);
    h3.next = new ListNode(8);
    h3.next.next = new ListNode(9);
    ListNode h4 = new ListNode(4);

    lists[0] = h1;
    lists[1] = h3;
    lists[2] = h4;

    L23MergeKSortedLists value = new L23MergeKSortedLists();
    ListNode h5 = value.mergeKLists1(lists);
    System.out.println(h5);

  }

}
