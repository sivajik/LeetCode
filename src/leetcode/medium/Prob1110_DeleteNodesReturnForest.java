package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob1110_DeleteNodesReturnForest {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		for (TreeNode eachForest : delNodes(root, new int[] { 3, 5 })) {
			inOrder(eachForest);
			System.out.println();
		}
	}

	static public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> result = new ArrayList<>();

		Set<Integer> set = new HashSet<>();
		for (int elem : to_delete) {
			set.add(elem);
		}

		if (root == null) {
			return result;
		}

		delNodesHelper(root, set, result, null);
		return result;
	}

	private static TreeNode delNodesHelper(TreeNode node, Set<Integer> set, List<TreeNode> result, TreeNode parent) {
		if (node == null) {
			return null;
		}

		if (set.contains(node.val)) {
			delNodesHelper(node.left, set, result, node);
			delNodesHelper(node.right, set, result, node);
			return null;
		} else {
			if (parent == null || set.contains(parent.val)) {
				result.add(node);
			}

			node.left = delNodesHelper(node.left, set, result, node);
			node.right = delNodesHelper(node.right, set, result, node);
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
