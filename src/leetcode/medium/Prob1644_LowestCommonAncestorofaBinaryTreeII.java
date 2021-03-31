package leetcode.medium;

public class Prob1644_LowestCommonAncestorofaBinaryTreeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}

		TreeNode res = lca(root, p, q);

		if (res == p) {
			return lca(p, q, q) != null ? res : null;
		} else if (res == q) {
			return lca(q, p, p) != null ? res : null;
		}
		return res;
	}

	private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lca(root.left, p, q);
		TreeNode rite = lca(root.right, p, q);

		if (left != null && rite != null) {
			return root;
		}
		if (left != null && rite == null) {
			return left;
		}
		if (left == null && rite != null) {
			return rite;
		}
		return null;
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
