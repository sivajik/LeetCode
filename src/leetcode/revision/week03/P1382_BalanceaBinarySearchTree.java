package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.List;

public class P1382_BalanceaBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public TreeNode balanceBST(TreeNode root) {
		if (root == null) {
			return root;
		}
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);

		return balance(list, 0, list.size() - 1);
	}

	private static TreeNode balance(List<Integer> list, int l, int h) {
		if (l <= h) {
			int mid = l + (h - l) / 2;
			TreeNode node = new TreeNode(list.get(mid));
			node.left = balance(list, l, mid - 1);
			node.right = balance(list, mid + 1, h);
			return node;
		} else {
			return null;
		}
	}

	// ==''';
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

	public static void inOrder(TreeNode tree, List<Integer> list) {
		if (tree != null) {
			inOrder(tree.left, list);
			list.add(tree.val);
			inOrder(tree.right, list);
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
