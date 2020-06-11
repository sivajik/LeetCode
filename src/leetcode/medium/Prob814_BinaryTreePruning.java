package leetcode.medium;

import leetcode.medium.Prob701_InsertBinarySearchTree.TreeNode;

public class Prob814_BinaryTreePruning {

	public static void main(String[] args) {
		inOrder(pruneTree(prepareTree(new int[] { 1, 0, 1, 0, 0, 0, 1 })));
		System.out.println();
		inOrder(pruneTree(prepareTree(new int[] { 1, 1, 0, 1, 1, 0, 1, 0 })));
	}

	static public TreeNode pruneTree(TreeNode root) {
		return helper(root);
	}

	static private TreeNode helper(TreeNode root) {
		if (root == null) {
			return null;
		}

		root.left = helper(root.left);
		root.right = helper(root.right);

		if (root.left == null && root.right == null && root.val == 0) {
			return null;
		}
		return root;
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
