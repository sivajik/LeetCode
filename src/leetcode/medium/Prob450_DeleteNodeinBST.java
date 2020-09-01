package leetcode.medium;

public class Prob450_DeleteNodeinBST {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 5, 3, 6, 2, 4, -999, 7 });
		inOrder(root);
		System.out.println();
		inOrder(deleteNode(root, 3));
	}

	/*
	We will compare root value with the key to delete if root.val > key => look into left sub-tree.
	We will compare root value with the key to delete if root.val < key => look into right sub-tree.
	We will compare root value with the key to delete if root.val == key => we found the node to delete
		check if this node has no left node just update current node with its right node.
		check if this node has no right node just update current node with its left node.
		if node to delete has both left and right node find the successor or minValue in right sub-tree, and update current node val.
		Now delete the successor node which is in right sub-tree of the node and value is root.val.
	 */
	static public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				root.val = successor(root.right);
				root.right = deleteNode(root.right, root.val);
			}
		}
		return root;
	}
	
	static private int successor(TreeNode node) {
		return node.left == null ? node.val : successor(node.left);
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
