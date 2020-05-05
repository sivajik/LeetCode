package leetcode.easy;

public class Prob617_MergeTwoBinaryTree {

	public static void main(String[] args) {
		TreeNode t1 = prepareTree(new int[] { 1, 3, 2, 5, -999, -999, -999 });
		TreeNode t2 = prepareTree(new int[] { 2, 1, 3, -999, 4, -999, 7 });
		inOrder(t1);
		System.out.println();

		inOrder(t2);
		System.out.println();

		TreeNode t3 = mergeTrees(t1, t2);
		inOrder(t3);
	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		if (t1 == null && t2 != null) {
			return t2;
		}
		if (t1 != null && t2 == null) {
			return t1;
		}

		TreeNode t3 = new TreeNode(t1.val + t2.val);
		t3.left = mergeTrees(t1.left, t2.left);
		t3.right = mergeTrees(t1.right, t2.right);
		return t3;
	}

	// =======
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
