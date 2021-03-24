package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob545_BoundaryofBinaryTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);

		n1.right = n2;
		n2.left = n3;
		n2.right = n4;

		System.out.println(boundaryOfBinaryTree(n1));

	}

	static boolean isLeaf(TreeNode t) {
		return t.left == null && t.right == null;
	}

	static void addLeaves(TreeNode t, ArrayList<Integer> res) {
		if (isLeaf(t)) {
			res.add(t.val);
		} else {
			if (t.left != null) {
				addLeaves(t.left, res);
			}
			if (t.right != null) {
				addLeaves(t.right, res);
			}
		}
	}

	static public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		// add root
		if (isLeaf(root)) {
			res.add(root.val);
			return res;
		} else {
			res.add(root.val);
		}

		// add left
		TreeNode t = root.left;
		while (t != null) {
			if (!isLeaf(t)) {
				res.add(t.val);
			}

			if (t.left != null) {
				t = t.left;
			} else {
				t = t.right;
			}
		}

		// add leaves
		addLeaves(root, res);

		// add right (in reverse)
		Stack<TreeNode> stk = new Stack<>();
		t = root.right;
		while (t != null) {
			if (!isLeaf(t)) {
				stk.push(t);
			}
			if (t.right != null) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		while (!stk.isEmpty()) {
			res.add(stk.pop().val);
		}

		return res;
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
