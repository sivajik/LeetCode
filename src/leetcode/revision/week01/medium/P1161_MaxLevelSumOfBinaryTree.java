package leetcode.revision.week01.medium;

import java.util.LinkedList;
import java.util.Queue;

public class P1161_MaxLevelSumOfBinaryTree {

	public static void main(String[] args) {
		System.out.println(maxLevelSum(prepareTree(new int[] { 1, 7, 0, 7, -8, -999, -999 })));

	}

	static public int maxLevelSum(TreeNode root) {
		int max = Integer.MIN_VALUE;
		int maxLevel = -1;

		int currLevel = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			int localSum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				localSum += temp.val;
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
			currLevel++;
			System.out.println("Level: " + currLevel + " & sum: " + localSum);
			if (localSum > max) {
				max = localSum;
				maxLevel = currLevel;
			}
		}

		return maxLevel;
	}

	// ====
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
