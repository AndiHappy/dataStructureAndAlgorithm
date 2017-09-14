package com.zlz.problems.linknode;

/**
 * @author zhailz
 * @date 17/9/14 - 下午2:42.
 * DOC:输入一个链表，输出该链表中倒数第k个结点。
 */
public class LastKNode {


  public static ListNode lastKNode(ListNode head,int k){
    if(head != null && k > 0){

      int step = k- 1;
      ListNode first = head;
      ListNode second = head;
      while(step > 0 && first != null){
        first = first.next;
        step--;
      }

      while(first.next != null){
        first = first.next;
        second = second.next;
      }

      return second;

    }else {
      throw new IllegalArgumentException ("Illeagal argument !");
    }
  }

  public static void main(String[] args){
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    node1.next = node2;
    ListNode node3 = new ListNode(3);
    node2.next = node3;
    ListNode node4 = new ListNode(4);
    node3.next = node4;
    ListNode node5 = new ListNode(5);
    node4.next = node5;

    System.out.println (lastKNode (node1,1));
  }
}
