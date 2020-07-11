package leetcode.medium;

public class Prob109_SortedListToBST {

	public static void main(String[] args) {
		ListNode n0 = new ListNode(-10);
		ListNode n1 = new ListNode(-3);
		ListNode n2 = new ListNode(0);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(9);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		inOrder(sortedListToBST(n0));

	}

	private static void inOrder(TreeNode r) {
		if (r != null) {
			inOrder(r.left);
			System.out.print(r.val + ", ");
			inOrder(r.right);
		}
	}


	static public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return new TreeNode(head.val);
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (slow != null && fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		TreeNode node = new TreeNode(slow.val);
		ListNode right = slow.next;
		slow.next = null;
		if (prev != null) {
			prev.next = null;
		}
		node.left = sortedListToBST(head);
		node.right = sortedListToBST(right);
		return node;
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

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
