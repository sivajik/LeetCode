package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Prob83_DeleteDuplicateInSortedList {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(3);
		l.add(3);
		l.add(3);
		l.add(3);
		l.add(3);
		
		l.print();

		l.setHead(l.deleteDuplicates(l.head));
		l.print();
	}

	static class LinkedList {
		ListNode head;

		public ListNode deleteDuplicates(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			} else {
				ListNode prev = head;
				ListNode curr = prev.next;
				while (curr != null) {
					if (prev.val == curr.val) {
						prev.next = curr.next;
						curr = curr.next;
					} else {
						prev = curr;
						curr = curr.next;
					}
				}
			}
			return head;
		}
//  1 -> 2
		public void add(int data) {
			ListNode temp = new ListNode(data);
			temp.next = head;
			this.head = temp;
		}

		public void setHead(ListNode head) {
			this.head = head;
		}

		public void print() {
			ListNode temp = head;
			Set<ListNode> set = new HashSet<ListNode>();

			while (temp != null && !set.contains(temp)) {
				System.out.print(temp.val + "  ");
				set.add(temp);
				temp = temp.next;
			}
			System.out.println();
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
