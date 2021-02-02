package leetcode.thirtydays.feb;

public class P02_TrimABinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 0, 2 });
		inOrder(trimBST(root, 1, 2));
	}

	static public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null) {
			return null;
		}

		if (root.val >= low && root.val <= high) {
			root.left = trimBST(root.left, low, high);
			root.right = trimBST(root.right, low, high);
			return root;
		} else if (root.val < low) {
			return trimBST(root.right, low, high);
		} else if (root.val > high) {
			return trimBST(root.left, low, high);
		}
		return root;
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
