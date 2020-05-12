package leetcode.medium;

public class Prob98_ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isValidBST(TreeNode root) {
		return isValidBSTPrivate(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private static boolean isValidBSTPrivate(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		return isValidBSTPrivate(root.left, min, root.val) && 
					isValidBSTPrivate(root.right, root.val, max);
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
