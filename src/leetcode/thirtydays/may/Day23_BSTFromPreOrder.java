package leetcode.thirtydays.may;

import java.util.Stack;

public class Day23_BSTFromPreOrder {

	public static void main(String[] args) {
		TreeNode myRoot = bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });
		preOrder(myRoot);
		System.out.println();
		TreeNode myRoot1 = bstFromPreorderv2(new int[] { 8, 5, 1, 7, 10, 12 });
		preOrder(myRoot1);

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	// { 8, 5, 1, 7, 10, 12 }
	public static TreeNode bstFromPreorderv2(int[] preorder) {
		if (preorder == null) {
			return null;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();

		TreeNode root = new TreeNode(preorder[0]);
		s.push(root);

		for (int i = 1; i < preorder.length; i++) {
			TreeNode t = null;

			while (!s.isEmpty() && s.peek().val > preorder[i]) {
				t = s.pop();
			}

			if (t != null) {
				TreeNode x = new TreeNode(preorder[i]);
				t.left = x;
				s.push(x);
			} else {
				t = s.peek();
				TreeNode x = new TreeNode(preorder[i]);
				t.right = x;
				s.push(x);
			}
		}
		return root;
	}

	public static TreeNode bstFromPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		for (int i = 1; i < preorder.length; i++) {
			insertToTree(root, preorder[i]);
		}
		return root;
	}

	public static void insertToTree(TreeNode myRoot, int i) {
		TreeNode root = myRoot;
		TreeNode newNode = new TreeNode(i);

		while (root != null) {
			if (i < root.val) {
				if (root.left == null) {
					root.left = newNode;
					break;
				} else {
					root = root.left;
				}
			} else if (i > root.val) {
				if (root.right == null) {
					root.right = newNode;
					break;
				} else {
					root = root.right;
				}
			}
		}
	}
}
