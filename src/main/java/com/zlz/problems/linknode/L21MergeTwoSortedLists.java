package com.zlz.problems.linknode;

/**
 * @author zhailz
 *
 * 时间：2016年7月20日 ### 上午11:39:10
 */
public class L21MergeTwoSortedLists {

//	Merge two sorted linked lists and return it as a new list. 
//			The new list should be made by splicing together the nodes of the first two lists.
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode l3 = new ListNode(0);
		 ListNode first = l3;
		 while(l1 != null || l2 != null){
			 if(l1 != null && l2 != null){
				 if(l1.val < l2.val){
					l3.next = l1;
					l1 = l1.next;
				 }else{
					 l3.next = l2;
					 l2 = l2.next; 
				 }
			 }else if(l1 == null && l2 != null){
				 l3.next = l2;
				 l2 = l2.next; 
			 }else if(l2 == null && l1 != null){
				 l3.next = l1;
				 l1 = l1.next; 
			 }
			 l3 = l3.next;
		 }
		 return first.next;
	    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;

		ListNode node11 = new ListNode(11);
		ListNode node21 = new ListNode(21);
		node11.next = node21;
		ListNode node31 = new ListNode(31);
		node21.next = node31;
		ListNode node41 = new ListNode(41);
		node31.next = node41;
		
		L21MergeTwoSortedLists sort = new L21MergeTwoSortedLists();
		ListNode pp = sort.mergeTwoLists(node11, node1);
		System.out.println(pp);

	}
	
	// 简练的答案,简练优雅
	public ListNode mergeTwoLists_normal(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists_normal(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists_normal(l1, l2.next);
			return l2;
		}
}

}
