package leetcode.medium;

public class Prob437_PathSum3 {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 10, 5, -3, 3, -7, 1, 11 });
		System.out.println(pathSum(root, 8));
	}

	static int res = 0;

	static public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return res;
		}
		helper(root, sum);

		if (root.left != null) {
			pathSum(root.left, sum);
		}
		if (root.right != null) {
			pathSum(root.right, sum);
		}
		return res;
	}

	static private void helper(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		if (root.val == sum) {
			res++;
		}
		if (root.left != null) {
			helper(root.left, sum - root.val);
		}
		if (root.right != null) {
			helper(root.right, sum - root.val);
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
