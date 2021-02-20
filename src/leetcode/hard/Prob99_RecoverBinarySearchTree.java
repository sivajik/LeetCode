package leetcode.hard;

public class Prob99_RecoverBinarySearchTree {

	public static void main(String[] args) {
		TreeNode t = prepareTree(new int[] { 3, 1, 4, -999, -999, 2, -999 });
		inorder(t);
		System.out.println();
		recoverTree(t);
		inorder(t);
	}

	static TreeNode[] swap = new TreeNode[2];
	static TreeNode curr = null;

	static public void recoverTree(TreeNode root) {
		helper(root);
		if (swap[0] != null && swap[1] != null) {
			int temp = swap[0].val;
			swap[0].val = swap[1].val;
			swap[1].val = temp;
		}
	}

	private static void helper(TreeNode node) {
		if (node == null) {
			return;
		}

		helper(node.left);

		if (curr != null && curr.val > node.val) {
			// curr.val > node.val => previous node has more than curr node ; violation in
			// 'inorder' flow as expected to see low to high sort order.
			if (swap[0] == null) {
				swap[0] = curr;
			}
			swap[1] = node;
		}
		curr = node;

		helper(node.right);

	}

	// ======
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

	public static void inorder(TreeNode tree) {
		if (tree != null) {
			inorder(tree.left);
			System.out.print(tree.val + " ");
			inorder(tree.right);
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
