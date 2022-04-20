package leetcode.g5.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Prob1302_DeepestLeavesSum {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, 9, 6, 7, -999, -999, -999, -999, -999, -999, 8 });
		inOrder(root);
		deepestLeavesSum(root);
	}

	static public int deepestLeavesSum(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		int sum = 0;

		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				sum += node.val;
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}

		return sum;
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
