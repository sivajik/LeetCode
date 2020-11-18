package leetcode.revision.week01.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94_BinaryTreeInOrder {

	public static void main(String[] args) {
		System.out.println(inorderTraversal(prepareTree(new int[] { 1, 2, 3, 4, 5, 6, 7 })));

	}

	static public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> op = new ArrayList<>();

		if (root == null) {
			return op;
		}

		Stack<TreeNode> stack = new Stack<>();

		while (true) {
			if (root != null) { // ensure root is not null, keep moving to left.
				stack.push(root);
				root = root.left;
			} else { // once exhausted, then popping off from stack.
				if (stack.isEmpty()) {
					break;
				} else {
					root = stack.pop();
					op.add(root.val);
					root = root.right;
				}
			}
		}

		return op;
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
