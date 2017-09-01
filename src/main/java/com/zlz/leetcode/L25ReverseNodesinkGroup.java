package com.zlz.leetcode;

import com.data.util.ListNode;

/**
 * @author zhailz
 *
 * 时间：2016年11月23日 ### 下午8:40:52
 */
public class L25ReverseNodesinkGroup {

//      Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//      If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//      You may not alter the values in the nodes, only nodes itself may be changed.
//
//      Only constant memory is allowed.
//
//      For example,
//      Given this linked list: 1->2->3->4->5
//
//      For k = 2, you should return: 2->1->4->3->5
//
//      For k = 3, you should return: 3->2->1->4->5


  public ListNode reverseKGroup(ListNode head, int k) {
    if(k <= 1) return head;
    ListNode tmp = new ListNode(0);
    tmp.next = head; 
    ListNode tmp1 = head.next;
    while(head != null && k>1){
      
    }
    
        
    tmp = head;
    
    return null;
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
