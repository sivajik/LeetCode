package leetcode.revision.week01;

import java.util.Arrays;

public class P654_MaximumBinaryTree {

	public static void main(String[] args) {
		TreeNode root = constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
		inOrder(root);
	}

	static public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode root = prepTree(nums);
		return root;
	}

	private static TreeNode prepTree(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		// 3, 2, 1, 6, 0, 5
		int[] topElems = getMax(nums);
		TreeNode root = new TreeNode(topElems[0]);
		root.left = prepTree(Arrays.copyOfRange(nums, 0, topElems[1]));
		root.right = prepTree(Arrays.copyOfRange(nums, 1 + topElems[1], nums.length));
		return root;
	}

	private static int[] getMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				index = i;
			}
		}
		return new int[] { max, index };
	}

	public static void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.val + " ");
			inOrder(tree.right);
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
