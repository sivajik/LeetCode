package leetcode.medium;

public class Prob230_KthSmallestInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
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
}
