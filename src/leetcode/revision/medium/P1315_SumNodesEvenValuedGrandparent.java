package leetcode.revision.medium;

import java.util.LinkedList;
import java.util.Queue;

public class P1315_SumNodesEvenValuedGrandparent {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 6, 7, 8, 2, 7, 1, 3, 9, -999, 1, 4, -999, -999, -999, 5 });
		System.out.println(sumEvenGrandparent(root));
	}

	public static int sumEvenGrandparent(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int total = 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				if (temp.val % 2 == 0) {
					if (temp.left != null && temp.left.left != null) {
						total += temp.left.left.val;
					}
					if (temp.left != null && temp.left.right != null) {
						total += temp.left.right.val;
					}
					if (temp.right != null && temp.right.left != null) {
						total += temp.right.left.val;
					}
					if (temp.right != null && temp.right.right != null) {
						total += temp.right.right.val;
					}
				}

				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}

		return total;

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
