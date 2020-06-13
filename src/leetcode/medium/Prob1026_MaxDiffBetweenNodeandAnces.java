package leetcode.medium;

public class Prob1026_MaxDiffBetweenNodeandAnces {

	public static void main(String[] args) {
		System.out.println(maxAncestorDiff(prepareTree(new int[] { 0, -999, 1 /* 8, 3, 10, 1, 6 */ })));
	}

	static public int maxAncestorDiff(TreeNode root) {
		maxDiff = 0;
		helper(root, root.val, root.val);
		return maxDiff;
	}

	static int maxDiff;

	static private void helper(TreeNode root, int max, int min) {
		if (root == null) {
			return;
		}
		maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - min), Math.abs(max - root.val)));
		max = root.val > max ? root.val : max;
		min = root.val < min ? root.val : min;
		helper(root.left, max, min);
		helper(root.right, max, min);
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
