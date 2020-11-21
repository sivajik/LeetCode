package leetcode.revision.week01.medium;

import java.util.*;

public class P114_FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 5, 3, 4, -999, 6 });
		inOrder(root);
		System.out.println();
		flatten(root);
		inOrder(root);
	}

	static public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<>();

		s.push(root);

		while (!s.isEmpty()) {
			TreeNode t = s.pop();
			// always update t not root.
			if (t.right != null) {
				s.push(t.right);
			}

			if (t.left != null) {
				s.push(t.left);
			}

			if (!s.isEmpty()) {
				t.right = s.peek();
			}
			t.left = null;
		}
	}
	// ===

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
