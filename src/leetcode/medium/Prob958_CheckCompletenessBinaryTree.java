package leetcode.medium;

import java.util.*;

public class Prob958_CheckCompletenessBinaryTree {

	public static void main(String[] args) {
		System.out.println(isCompleteTree(prepareTree(new int[] { 1, 2, 3, 4, 5, 6, -999 })));
		System.out.println(isCompleteTree(prepareTree(new int[] { 1, 2, 3, 4, 5, -999, 6 })));
	}

	static public boolean isCompleteTree(TreeNode root) {
		List<ANode> nodes = new ArrayList<>();
		nodes.add(new ANode(root, 1));
		int i = 0;
		while (i < nodes.size()) {
			ANode anode = nodes.get(i++);
			if (anode.node != null) {
				nodes.add(new ANode(anode.node.left, 2 * anode.value));
				nodes.add(new ANode(anode.node.right, (2 * anode.value) + 1));
			}
		}

		System.out.println(nodes);
		return nodes.get(i - 1).value == nodes.size();
	}

	static class ANode {
		TreeNode node;
		Integer value;

		ANode(TreeNode a, Integer b) {
			this.node = a;
			this.value = b;
		}

		public String toString() {
			return (node == null ? "-999" : node.val) + "[" + value + "]";
		}
	}

	//
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
