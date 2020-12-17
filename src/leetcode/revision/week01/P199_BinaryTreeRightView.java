package leetcode.revision.week01;

import java.util.ArrayList;
import java.util.List;

public class P199_BinaryTreeRightView {

	public static void main(String[] args) {
		System.out.println(rightSideView(prepareTree(new int[] { 1, 2, 3, 0, 5, 0, 4 })));
	}

	static int max = Integer.MIN_VALUE;

	static public List<Integer> rightSideView(TreeNode root) {
		List<Integer> op = new ArrayList<>();
		if (root == null) {
			return op;
		}
		max = Integer.MIN_VALUE;
		preOrder(root, op, 0);
		return op;
	}

	static private void preOrder(TreeNode root, List<Integer> op, int level) {
		if (root != null) {
			if (level > max) {
				max = level;
				op.add(root.val);
			}
			preOrder(root.right, op, level + 1);
			preOrder(root.left, op, level + 1);
		}
	}

	// ========
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
