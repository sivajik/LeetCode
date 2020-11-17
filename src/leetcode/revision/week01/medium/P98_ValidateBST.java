package leetcode.revision.week01.medium;

public class P98_ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean helper(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (root.val < minValue || root.val > maxValue) {
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
