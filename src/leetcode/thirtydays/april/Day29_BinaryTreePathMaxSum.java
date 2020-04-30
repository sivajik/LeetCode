package leetcode.thirtydays.april;

public class Day29_BinaryTreePathMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		calcSum(root);
		return maxSum;
	}


	private int calcSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = calcSum(root.left);
		int r = calcSum(root.right);
		maxSum = Math.max(maxSum, root.val + Math.max(l, 0) + Math.max(r, 0));
		return root.val + Math.max(0, Math.max(l, r));
	}

	class TreeNode {
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
