package leetcode.medium;

public class Prob701_InsertBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 4, 2, 7, 1, 3 });
		root = insertIntoBST(root, 5);
		inOrder(root);
	}

	public static TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		} else {
			if (val < root.val) {
				root.left = insertIntoBST(root.left, val);
			} else if (val > root.val) {
				root.right = insertIntoBST(root.right, val);
			}
		}
		return root;
	}

	public static TreeNode insertIntoBSTItr(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		TreeNode tmp = root;
		while (true) {
			if (val > root.val) {
				if (root.right != null) {
					root = root.right;
				} else {
					root.right = new TreeNode(val);
					break;
				}
			} else if (val < root.val) {
				if (root.left != null) {
					root = root.left;
				} else {
					root.left = new TreeNode(val);
					break;
				}
			}
		}
		if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		} else if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
		}

		return tmp;
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