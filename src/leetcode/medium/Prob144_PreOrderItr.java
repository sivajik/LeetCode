package leetcode.medium;

import java.util.List;

public class Prob144_PreOrderItr {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 8, 2, 4, 5, 3, -999 });
		inOrder(root);
		List<Integer> l = preorderTraversal(root);
		System.out.println(l);
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return new java.util.ArrayList<Integer>();
		}
		java.util.Stack<TreeNode> s = new java.util.Stack<>();
		s.push(root);

		java.util.List<Integer> list = new java.util.ArrayList<Integer>();

		while (!s.isEmpty()) {
			TreeNode t = s.pop();
			list.add(t.val);

			if (t.right != null) {
				s.push(t.right);
			}
			if (t.left != null) {
				s.push(t.left);
			}
		}
		return list;
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
