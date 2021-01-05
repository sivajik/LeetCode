package leetcode.revision.week04;

public class P61_RotateList {

	public static void main(String[] args) {

		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		/*
		 * ListNode n2 = new ListNode(2); ListNode n3 = new ListNode(4); ListNode n4 =
		 * new ListNode(5);
		 */
		link(n0, n1);
//		link(n1, n2);
//		link(n2, n3);
//		link(n3, n4);

		print(n0);
		print(rotateRight(n0, 2));

	}

	static public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		ListNode temp = head;

		int len = 0;
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		int moves = len - (k % len);

		if (moves == len) {
			return head;
		}

		ListNode prev = null;
		temp = head;
		for (int i = 0; i < moves; i++) {
			prev = temp;
			temp = temp.next;
		}
		ListNode newHead = prev.next;
		prev.next = null;

		ListNode temp1 = newHead;
		while (temp1.next != null) {
			temp1 = temp1.next;
		}
		temp1.next = head;
		return newHead;
	}

	private static void link(ListNode n2, ListNode n4) {
		n2.next = n4;
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

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
