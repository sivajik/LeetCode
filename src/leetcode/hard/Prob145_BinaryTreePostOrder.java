package leetcode.hard;

import java.util.List;

public class Prob145_BinaryTreePostOrder {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		postOrder(root);
		System.out.println();
		for (Integer i : postorderTraversal(root)) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) {
			return new java.util.ArrayList<>();
		}
		
		java.util.Stack<TreeNode> s1 = new java.util.Stack<>();
		java.util.Stack<TreeNode> s2 = new java.util.Stack<>();

		s1.push(root);

		while (!s1.isEmpty()) {
			TreeNode t = s1.pop();
			s2.push(t);

			if (t.left != null) {
				s1.push(t.left);
			}
			if (t.right != null) {
				s1.push(t.right);
			}
		}

		java.util.List<Integer> l = new java.util.ArrayList<>();
		while (!s2.isEmpty()) {
			l.add(s2.pop().val);
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

	public static void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.val + " ");
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
