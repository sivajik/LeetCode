package leetcode.revision.week03;

public class P450_DeleteNodeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.right != null) {
				root.val = successor(root.right);
				root.right = deleteNode(root.right, root.val);
			} else {
				root.val = predesessort(root.left);
				root.left = deleteNode(root.left, root.val);
			}
		}
		return root;
	}

	private int predesessort(TreeNode r) {
		r = r.left;
		while (r.right != null) {
			r = r.right;
		}
		return r.val;
	}

	private int successor(TreeNode r) {
		r = r.right;
		while (r.left != null) {
			r = r.left;
		}
		return r.val;
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
