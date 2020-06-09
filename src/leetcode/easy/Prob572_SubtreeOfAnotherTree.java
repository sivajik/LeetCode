package leetcode.easy;

public class Prob572_SubtreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode s = prepareTree(new int[] { 3, 4, 5, 1, 2, -999, -999 });
		TreeNode t = prepareTree(new int[] { 4, 1, 2 });
		System.out.println(isSubtree(s, t));

	}

	/*
	 * [1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2]
	 * [1,null,1,null,1,null,1,null,1,null,1,2]
	 */
	static public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			return false;
		} else if (areSame(s, t)) {
			return true;
		} else {
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
	}

	static public boolean areSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null) {
			return false;
		}

		if (s.val != t.val) {
			return false;
		}

		if (s.val == t.val) {
			return areSame(s.left, t.left) && areSame(s.right, t.right);
		}
		return false;
	}

	// ===

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
