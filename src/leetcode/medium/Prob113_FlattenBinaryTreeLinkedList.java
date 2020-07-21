package leetcode.medium;

public class Prob113_FlattenBinaryTreeLinkedList {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 5, 3, 4, -999, 6 });
		inOrder(root);
		System.out.println();
		System.out.println("=== ");
		flatten(root);
		System.out.println("=== ");
		inOrder(root);
	}

	static public void flatten(TreeNode node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			flatten(node.left);
		}
		if (node.right != null) {
			flatten(node.right);
		}

		TreeNode flattenedRightTree = node.right;
		if (node.left == null) {
			node.right = flattenedRightTree;
		} else {
			node.right = node.left;
			node.left = null;
			TreeNode localDummt = node.right;
			if (localDummt != null) {
				while (localDummt.right != null) {
					localDummt = localDummt.right;
				}
				localDummt.right = flattenedRightTree;
			}
		}
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
