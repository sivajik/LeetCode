package leetcode.revision.medium;

public class P1008_BSTFromPreOrder {

	public static void main(String[] args) {
		TreeNode t = bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });
		preOrder(t);
	}

	static public TreeNode bstFromPreorder(int[] preorder) {
		TreeNode t = null;

		for (int elem : preorder) {
			t = insert(t, elem);
		}
		return t;
	}

	private static TreeNode insert(TreeNode t, int elem) {
		if (t == null) {
			return new TreeNode(elem);
		}

		if (elem < t.val) {
			t.left = insert(t.left, elem);

		} else {
			t.right = insert(t.right, elem);
		}
		return t;
	}

	//
	public static void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.val + " ");
			preOrder(tree.left);
			preOrder(tree.right);
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
