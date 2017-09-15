package com.zlz.problems.linknode;

import com.data.util.ListNode;

/**
 * @author zhailz
 *
 * 时间：2016年11月21日 ### 下午4:45:51
 */
public class L24SwapNodesinPairs {

  /***
   * Given a linked list, swap every two adjacent nodes and return its head.
   * For example,
   * Given 1->2->3->4, you should return the list as 2->1->4->3.
   * Your algorithm should use only constant space. You may not modify the values in the list, 
   * only nodes itself can be changed.
   * 
   * */
  
  public ListNode swapPairs(ListNode head) {
    if(head == null) return head;
    ListNode pre = new ListNode(0);
    pre.next = head;
    int value = 0;
    while(head != null && head.next != null){
      if(head.next != null){
       value =  head.val;
       head.val = head.next.val;
       head.next.val = value;
      }
      head = head.next.next;
    }
    return pre.next;
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    ListNode h3 = new ListNode(1);
    h3.next = new ListNode(2);
    h3.next.next = new ListNode(3);
   

  }

}
