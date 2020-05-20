package leetcode.thirtydays.may;

public class Day19_KthSmallestinBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void inOrder(TreeNode root, java.util.List<Integer> list) {
		if (root != null) {
			inOrder(root.left, list);
			list.add(root.val);
			inOrder(root.right, list);
		}
	}

	public static int kthSmallest(TreeNode root, int k) {
		java.util.List<Integer> list = new java.util.ArrayList<>();
		inOrder(root, list);
		return list.get(k - 1);
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
