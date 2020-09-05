package leetcode.thirtydays.sep;

import java.util.List;

public class Day05_MergeBinaryTrees {

	public static void main(String[] args) {
		TreeNode root1 = prepareTree(new int[] { 0, -10, 10 });
		inOrder(root1);
		System.out.println();

		TreeNode root2 = prepareTree(new int[] { 5, 1, 7, 0, 2 });
		inOrder(root2);
		System.out.println();

		java.util.List<Integer> list = getAllElements(root1, root2);
		for (Integer num : list) {
			System.out.print(num + " ");
		}
	}

	public static java.util.List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		java.util.List<Integer> l1 = new java.util.ArrayList<>();
		inOrder(root1, l1);

		java.util.List<Integer> l2 = new java.util.ArrayList<>();
		inOrder(root2, l2);

		return merge(l1, l2);
	}

	private static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
		java.util.List<Integer> l3 = new java.util.ArrayList<>();

		int i = 0, j = 0;

		while (i < l1.size() && j < l2.size()) {
			if (l1.get(i) < l2.get(j)) {
				l3.add(l1.get(i++));
			} else {
				l3.add(l2.get(j++));
			}
		}

		if (i == l1.size() && j != l2.size()) {
			while (j < l2.size()) {
				l3.add(l2.get(j++));
			}
		}

		if (i != l1.size() && j == l2.size()) {
			while (i < l1.size()) {
				l3.add(l1.get(i++));
			}
		}
		return l3;
	}

	private static void inOrder(TreeNode root1, List<Integer> l2) {
		if (root1 != null) {
			inOrder(root1.left, l2);
			l2.add(root1.val);
			inOrder(root1.right, l2);
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