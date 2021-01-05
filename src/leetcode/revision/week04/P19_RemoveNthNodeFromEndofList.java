package leetcode.revision.week04;

public class P19_RemoveNthNodeFromEndofList {

	public static void main(String[] args) {

		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);

		link(n0, n1);
		link(n1, n2);
		link(n2, n3);
		link(n3, n4);

		print(n0);
		print(removeNthFromEnd(n0, 2));

	}

	static public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head;
		ListNode fast = head;

		for (int i = 1; i <= n; i++) {
			fast = fast.next;
		}
		if (fast == null) {
			return head.next;
		}

		ListNode prev = null;

		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		prev.next = slow.next;

		return head;
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
