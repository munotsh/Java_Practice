package com.example.companies.loblaw;

public class AddTwoNumbersLinkedList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

	}

	public static void main(String[] args) {
		
//		ListNode head = new ListNode(2);
//		head.next = new ListNode(4);
//		head.next.next = new ListNode(3);
//		
//		ListNode head1 = new ListNode(5);
//		head1.next = new ListNode(6);
//		head1.next.next = new ListNode(4);
		
		ListNode head = new ListNode(9);
		head.next = new ListNode(9);
		head.next.next = new ListNode(9);
		head.next.next.next = new ListNode(9);
		head.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next = new ListNode(9);
		
		ListNode head1 = new ListNode(9);
		head1.next = new ListNode(9);
		head1.next.next = new ListNode(9);
		head1.next.next.next = new ListNode(9);

		ListNode result = addTwoNumbers(head,head1);
		print(result);
	}

//	public static ListNode revers(ListNode rev) {
//		ListNode prev = null;
//		ListNode curr = rev;
//		
//		while(curr.next!=null) {
//			ListNode temp = curr.next;
//			curr.next = prev;
//			prev = curr;
//			curr = temp;
//		}
//		return prev;
//		
//	}
	
	public static void print(ListNode node) {
		while(node.next!=null) {
			System.out.print(node.val);
			node = node.next;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = new ListNode();
		ListNode temp = new ListNode();
		result = temp;
		int carry =0;
		while(l1 != null || l2 != null || carry > 0) {
			int val1 =0;
			int val2 =0;
			if(l1 != null) {
				val1 = l1.val;
				l1 = l1.next;
			}
			
			if(l2 != null) {
				val2 = l2.val;
				l2 = l2.next;
			}
			int sum = val1+val2+carry;
			temp.val = sum%10;
			carry = sum/10;
			temp.next = new ListNode();
			temp = temp.next;
			
		}
		
		
		return result;

	}
}
