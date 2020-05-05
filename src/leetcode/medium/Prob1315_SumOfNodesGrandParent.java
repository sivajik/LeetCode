package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Prob1315_SumOfNodesGrandParent {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 6, 7, 8, 2, 7, 1, 3, 9, -999, 1, 4, -999, -999, -999, 5 });
		System.out.println(sumEvenGrandparent(root));
	}

	public static int sumEvenGrandparent(TreeNode root) {
		int sum = 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if (tmp.val % 2 == 0) {
				if (tmp.left != null) {
					if (tmp.left.left != null) {
						sum += tmp.left.left.val;
					}
					if (tmp.left.right != null) {
						sum += tmp.left.right.val;
					}
				}

				if (tmp.right != null) {
					if (tmp.right.left != null) {
						sum += tmp.right.left.val;
					}
					if (tmp.right.right != null) {
						sum += tmp.right.right.val;
					}
				}
			}

			if (tmp.left != null) {
				q.add(tmp.left);
			}
			if (tmp.right != null) {
				q.add(tmp.right);
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
