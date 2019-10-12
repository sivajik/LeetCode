package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob61_RotateList {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(2);
		l.add(1);
		// l.add(1);
		// l.add(0);
		// l.add(2);
		// l.add(1);

		l.print();

		l.setHead(l.rotateRight(l.head, 2));
		l.print();
	}

	static class LinkedList {
		ListNode head;

		public ListNode rotateRight(ListNode head1, int k) {
			if (head1 == null || head1.next == null) {
				return head1;
			}

			ListNode cur = head1;
			int totalNode = 1;
			while (cur.next != null) {
				totalNode++;
				cur = cur.next;
			}
			cur.next = head1; // making it circular
			cur = head1; // reset, reuse
			int rotation = k % totalNode;
			int positionToMove = totalNode - rotation;
			ListNode prev = cur;
			for (int i = 1; i <= positionToMove; i++) {
				prev = cur;
				cur = cur.next;
			}
			prev.next = null;
			return cur;
		}

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
