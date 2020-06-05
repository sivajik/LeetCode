package leetcode.medium;

public class Prob129_SumRootToLeaf {

	public static void main(String[] args) {
		// System.out.println(sumNumbers(prepareTree(new int[] { 1, 2, 3 })));
		System.out.println(sumNumbers(prepareTree(new int[] { 4, 9, 0, 5, 1 })));
	}

	static public int sumNumbers(TreeNode root) {
		return sum1(root, 0);
	}

	static public int sum1(TreeNode root, int multiplier) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return root.val + (10 * multiplier);
		}
		int left = sum1(root.left, root.val + (10 * multiplier));
		int right = sum1(root.right, root.val + (10 * multiplier));

		return left + right;
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
