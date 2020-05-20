package leetcode.easy;

public class Prob101_SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 2, 3, 4, 4, 3 });
		System.out.println(isSymmetric(root));

	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric1(root.left, root.right);
	}

	public static boolean isSymmetric1(TreeNode leftRoot, TreeNode rightRoot) {
		if (leftRoot == null && rightRoot == null) {
			return true;
		}

		if (leftRoot == null && rightRoot != null) {
			return false;
		}
		if (leftRoot != null && rightRoot == null) {
			return false;
		}

		return leftRoot.val == rightRoot.val && isSymmetric1(leftRoot.left, rightRoot.right)
				&& isSymmetric1(leftRoot.right, rightRoot.left);
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
