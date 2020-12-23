package leetcode.revision.week03;

public class P148_SortList {

	public static void main(String[] args) {
		ListNode n0 = new ListNode(4);
		ListNode n1 = new ListNode(19);
		ListNode n2 = new ListNode(14);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(-3);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(8);
		ListNode n7 = new ListNode(5);
		ListNode n8 = new ListNode(11);
		ListNode n9 = new ListNode(15);

		link(n0, n1);
		link(n1, n2);
		link(n2, n3);
		link(n3, n4);
		link(n4, n5);
		link(n5, n6);
		link(n6, n7);
		link(n7, n8);
		link(n8, n9);

		print(sortList(n0));

	}

	static public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		ListNode left = sortList(head);
		ListNode rite = sortList(slow);
		return merge(left, rite);
	}

	static private ListNode merge(ListNode left, ListNode right) {

		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		ListNode head = new ListNode();
		ListNode curr = head;

		while (left != null && right != null) {
			if (left.val <= right.val) {
				curr.next = new ListNode(left.val);
				left = left.next;
			} else {
				curr.next = new ListNode(right.val);
				right = right.next;
			}
			curr = curr.next;
		}

		if (left == null && right != null) {
			curr.next = right;
		}

		if (left != null && right == null) {
			curr.next = left;
		}
		return head.next;

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
