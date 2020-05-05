package leetcode.medium;

public class Prob1038_GreaterSumTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 4, 1, 6, 0, 2, 5, 7, -999, -999, -999, 3, -999, -999, -999, 8 });
		inOrder(root);
		System.out.println();
		bstToGst(root);
		inOrder(root);
	}

	static int sum = 0;

	public static TreeNode bstToGst(TreeNode root) {
		reverseInOrder(root);
		return root;
	}

	private static void reverseInOrder(TreeNode root) {
		if (root != null) {
			bstToGst(root.right);
			sum += root.val;
			root.val = sum;
			bstToGst(root.left);
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
