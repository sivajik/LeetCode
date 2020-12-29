package leetcode.revision.week03;

public class P129_SumRootToLeafNumbers {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1,2,3 });
		System.out.println(sumNumbers(root));

	}

	static public int sumNumbers(TreeNode root) {
		sum(root, 0);
		return gt;
	}

	static int gt = 0;

	private static int sum(TreeNode root, int multipler) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			gt += root.val + (10 * multipler);
		}
		return sum(root.left, root.val + (10 * multipler)) + sum(root.right, root.val + (10 * multipler));
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
