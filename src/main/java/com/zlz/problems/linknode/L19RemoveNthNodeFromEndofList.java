package com.zlz.problems.linknode;

/**
 * @author zhailz
 *
 * 时间：2016年7月15日 ### 下午4:24:49
 */
public class L19RemoveNthNodeFromEndofList {

	/*Given a linked list, remove the nth node from the end of list and return its head.
	
			For example,
	
			   Given linked list: 1->2->3->4->5, and n = 2.
	
			   After removing the second node from the end, the linked list 
			   becomes 1->2->3->5.
			Note:
			Given n will always be valid.
			Try to do this in one pass.*/

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int length = getLinkedLength(head);
		head = removeNode(head, n, length);
		return head;
	}

	private ListNode removeNode(ListNode head, int n, int length) {
		//循环了一次，从头到尾巴
		ListNode q = head;
		ListNode p = head;
		if (length == n && n == 1)
			return null;
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
		return q;
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		//		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;

		L19RemoveNthNodeFromEndofList list = new L19RemoveNthNodeFromEndofList();
		list.removeNthFromEnd(node1, 1);
	}

	//看看规范的答案

	public ListNode removeNthFromEnd_normal(ListNode head, int n) {
		//为返回数据做准备
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		//求取链表的长度
		int length = 0;
		ListNode first = head;
		while (first != null) {
			length++;
			first = first.next;
		}

		//找到初始的位置
		length -= n;
		first = dummy;
		while (length > 0) {
			length--;
			first = first.next;
		}

		//直接跳过元素
		first.next = first.next.next;
		return dummy.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	ListNode(int x,ListNode next){
		val = x;
		this.next = next;
	}

	@Override public String toString () {
		return "ListNode{" +
				"val=" + val +
				'}';
	}
}