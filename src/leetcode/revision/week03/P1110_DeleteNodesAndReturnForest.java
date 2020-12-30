package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1110_DeleteNodesAndReturnForest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> l = new ArrayList<>();
		if (root == null) {
			return l;
		}
		Set<Integer> set = new HashSet<>();
		for (int a : to_delete) {
			set.add(a);
		}

		helper(root, l, set, null);

		return l;
	}

	private static TreeNode helper(TreeNode node, List<TreeNode> l, Set<Integer> set, TreeNode parent) {
		if (node == null) {
			return null;
		}

		if (set.contains(node.val)) {
			helper(node.left, l, set, node);
			helper(node.right, l, set, node);
			return null;
		} else {
			if (parent == null || set.contains(parent.val)) {
				l.add(node);
			}
			node.left = helper(node.left, l, set, node);
			node.right = helper(node.right, l, set, node);
			return node;
		}
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

		@Override
		public String toString() {
			return "" + val;
		}
	}
}
