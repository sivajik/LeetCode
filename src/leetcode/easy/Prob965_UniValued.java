package leetcode.easy;

public class Prob965_UniValued {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 1, 1, 1, 1, -999, 1 });
		System.out.println(isUnivalTree(root));
	}

	public static boolean isUnivalTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isUniValUitl(root, root.val);
	}

	private static boolean isUniValUitl(TreeNode root, int val) {
		if (root == null) {
			return true;
		}
		return root.val == val && isUniValUitl(root.left, val) && isUniValUitl(root.right, val);
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
