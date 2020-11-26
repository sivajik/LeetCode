package leetcode.medium;

public class Prob623_AddOneRowToTree {

	public static void main(String[] args) {
		inOrder(addOneRow(prepareTree(new int[] { 4, 2, 6, 3, 1, 5, -999 }), 1, 2));
		System.out.println();
		inOrder(addOneRow(prepareTree(new int[] { 4, 2, 9, 3, 1, -999, -999 }), 1, 3));
	}

	static public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode newRoot = new TreeNode(v);
			newRoot.left = root;
			return newRoot;
		}

		helper(root, 1, v, d);

		return root;
	}

	private static void helper(TreeNode root, int currLevel, int v, int d) {
		if (root == null) {
			return;
		}

		if (currLevel == d - 1) {
			TreeNode newLeft = new TreeNode(v);
			TreeNode newRight = new TreeNode(v);
			if (root.left != null) {
				newLeft.left = root.left;
			}
			if (root.right != null) {
				newRight.right = root.right;
			}
			root.left = newLeft;
			root.right = newRight;
			return;
		}

		helper(root.left, currLevel + 1, v, d);
		helper(root.right, currLevel + 1, v, d);
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
