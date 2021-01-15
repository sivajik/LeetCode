package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob92_ReverseLinkedList2 {
	public static void main(String[] args) throws Exception {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;

		print(n1);
		// print(reverseBetween(n1, 2, 6));
		// print(reverseBetween(n1, 2, 9));
		// print(reverseBetween(n1, 1, 9));
		print(reverseBetween(n1, 8, 9));
	}

	static public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}

		int count = 1;
		ListNode dummy = new ListNode(-999);
		dummy.next = head;
		ListNode curr = head;
		ListNode prev = dummy;
		while (count < m) {
			prev = curr;
			curr = curr.next;
			count++;
		}
		ListNode movedCurr = curr;
		List<ListNode> l = reverseList(curr, n - m);
		prev.next = l.get(0);
		movedCurr.next = l.get(1) == null ? null : l.get(1);
		return dummy.next;
	}

	public static List<ListNode> reverseList(ListNode head, int upto) {
		ListNode prev = null;
		ListNode curr = head;
		int count = 0;
		while (count < upto) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		ListNode next = curr.next;

		curr.next = prev;
		List<ListNode> l = new ArrayList<>();
		l.add(curr);
		l.add(next);
		return l;
	}

	private static void print(ListNode n1) {
		ListNode temp = n1;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
