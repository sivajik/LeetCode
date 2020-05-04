package leetcode.medium;

import java.util.Arrays;

public class Prob654_MaximumBinaryTree {

	public static void main(String[] args) {
		TreeNode root = constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
		inOrder(root);
	}

	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums.length > 0) {
			int maxElemLocation = getMaxElemLocation(nums);
			TreeNode root = new TreeNode(nums[maxElemLocation]);
			root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxElemLocation));
			root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxElemLocation + 1, nums.length));
			return root;			
		}
		return null;
	}

	private static int getMaxElemLocation(int[] nums) {
		int maxElem = Integer.MIN_VALUE;
		int maxElemLocation = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maxElem) {
				maxElemLocation = i;
				maxElem = nums[i];
			}
		}
		return maxElemLocation;
	}

	public static TreeNode prepareTree(int[] values) {
		TreeNode[] treeArray = new TreeNode[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] == -999) {
				treeArray[i] = null;
			} else {
				treeArray[i] = new TreeNode(values[i]);
			}
		}

		for (int i = 0; i < values.length; i++) {
			TreeNode node = treeArray[i];
			if (((2 * i) + 1 < values.length) && ((2 * i) + 2 < values.length)) {
				node.left = treeArray[(2 * i) + 1];
				node.right = treeArray[(2 * i) + 2];
			}
		}
		return treeArray[0];
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