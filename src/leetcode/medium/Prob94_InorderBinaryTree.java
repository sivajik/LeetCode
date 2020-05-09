package leetcode.medium;

import java.util.List;

public class Prob94_InorderBinaryTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 4, 2, 7, 1, 3, 6, 9 });
		inOrder(root);
		System.out.println();
//		for (Integer i : inorderTraversal(root)) {
//			System.out.print(i + " ");
//		}

		java.util.ArrayList<Integer> l = inorderProb94Itr(root);
		for (Integer i : l) {
			System.out.print(i + " ");
		}
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		java.util.List<Integer> l = new java.util.ArrayList<>();
		inorderProb94Rec(root, l);
		return l;
	}

	private static void inorderProb94Rec(TreeNode root, java.util.List<Integer> l) {
		if (root != null) {
			inorderProb94Rec(root.left, l);
			l.add(root.val);
			inorderProb94Rec(root.right, l);
		}
	}

	private static java.util.ArrayList<Integer> inorderProb94Itr(TreeNode root) {
		boolean done = false;
		java.util.Stack<TreeNode> stack = new java.util.Stack<>();
		java.util.ArrayList<Integer> l = new java.util.ArrayList<>();
		while (!done) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					root = stack.pop();
					l.add(root.val);
					root = root.right;
				}
			}
		}
		return l;
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