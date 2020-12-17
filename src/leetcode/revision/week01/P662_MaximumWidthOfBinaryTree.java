package leetcode.revision.week01;

import java.util.ArrayDeque;
import java.util.Queue;

public class P662_MaximumWidthOfBinaryTree {

	public static void main(String[] args) {
		System.out.println(widthOfBinaryTree(prepareTree(new int[] { 1, 3, 2, 5, 3, -999, 9 })));
	}

	static public int widthOfBinaryTree(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int max = Integer.MIN_VALUE;

		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		root.val = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int a = 0, b = 0;
			for (int i = 0; i < size; i++) {
				TreeNode t = q.poll();

				if (i == 0) {
					a = t.val;
				}
				if (i == size - 1) {
					b = t.val;
				}
				if (t.left != null) {
					t.left.val = (2 * t.val) + 1;
					q.add(t.left);
				}
				if (t.right != null) {
					t.right.val = (2 * t.val) + 2;
					q.add(t.right);
				}
			}
			max = Math.max(max, (b - a + 1));
		}

		return max;

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
