package leetcode.easy;

public class Prob687_LongestUniValPath {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 5, 4, 5, 1, 1, -999, 5 });
		System.out.println(longestUnivaluePath(root));
	}

	static int len = 0;

	static public int longestUnivaluePath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root, root.val);
		return len;
	}

	private static int helper(TreeNode root, int val) {
		if (root == null) {
			return 0;
		}

		int left = helper(root.left, root.val);
		int right = helper(root.right, root.val);

		len = Math.max(left + right, len);
		if (root.val == val) {
			if (left > right) {
				return 1 + left;
			} else {
				return 1 + right;
			}
		} else {
			return 0;
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
