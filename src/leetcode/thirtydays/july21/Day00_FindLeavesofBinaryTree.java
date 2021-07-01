package leetcode.thirtydays.july21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day00_FindLeavesofBinaryTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, -999, -999 });
		for (List<Integer> l : findLeaves(root)) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> l = new ArrayList<>();

		while (root != null) {
			if (root.left == null && root.right == null) {
				l.add(Arrays.asList(new Integer[] { root.val }));
				root = null;
			} else {
				List<Integer> leftLeafs = new ArrayList<>();
				List<Integer> riteLeafs = new ArrayList<>();

				root.left = collectChilds(root.left, leftLeafs);
				root.right = collectChilds(root.right, riteLeafs);

				leftLeafs.addAll(riteLeafs);
				l.add(leftLeafs);
			}
		}
		return l;
	}

	private static TreeNode collectChilds(TreeNode node, List<Integer> list) {
		if (node == null) {
			return null;
		} else if (node.left == null && node.right == null) {
			list.add(node.val);
			return null;
		} else {
			node.left = collectChilds(node.left, list);
			node.right = collectChilds(node.right, list);
			return node;
		}
	}

	// ===
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
