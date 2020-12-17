package leetcode.revision.week01;

public class P109_ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}

		ListNode prev = null;

		ListNode slow = head;
		ListNode fast = head;
		while (slow != null && fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		TreeNode root = new TreeNode(slow.val);

		prev.next = null;
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
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
