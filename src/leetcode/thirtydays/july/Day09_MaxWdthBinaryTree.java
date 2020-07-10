package leetcode.thirtydays.july;

import java.util.LinkedList;
import java.util.Queue;

public class Day09_MaxWdthBinaryTree {

	public static void main(String[] args) {
		System.out.println(widthOfBinaryTree(prepareTree(new int[] { 1, 3, 2, 5, 3, -999, 9 })) == 4);
		System.out.println(widthOfBinaryTree(prepareTree(new int[] { 1, 3, -999, 5, 3 })) == 2);
		System.out.println(widthOfBinaryTree(prepareTree(new int[] { 1, 3, 2, 5, -999, -999, -999 })) == 2);

		/*
		 * System.out.println(getHeight(prepareTree(new int[] { 1, 3, 2, 5, 3, -999, 9
		 * })) ); System.out.println(getHeight(prepareTree(new int[] { 1, 3, -999, 5, 3
		 * })) ); System.out.println(getHeight(prepareTree(new int[] { 1, 3, 2, 5, -999,
		 * -999, -999 })) );
		 */
	}

	static public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int rowMax = Integer.MIN_VALUE;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		int left = 1, right = 1;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();

				if (i == 0) {
					left = temp.val;
				}

				if (i == size - 1) {
					right = temp.val;
				}

				if (temp.left != null) {
					q.add(temp.left);
					temp.left.val = temp.val * 2;
				}
				if (temp.right != null) {
					q.add(temp.right);
					temp.right.val = (temp.val * 2) + 1;
				}
			}
			rowMax = Math.max(rowMax, right - left + 1);
		}

		return rowMax;
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

		public String toString() {
			return String.valueOf(val);
		}
	}

}
