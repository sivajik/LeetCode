package leetcode.medium;

public class Prob98_ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidBST(TreeNode root) {
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean helper(TreeNode root, long minValue, long maxValue) {
		if (root == null) {
			return true;
		}
		if (root.val <= minValue || root.val >= maxValue) {
			return false;
		}
		return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
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
