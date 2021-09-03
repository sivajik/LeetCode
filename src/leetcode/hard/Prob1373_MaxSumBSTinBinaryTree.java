package leetcode.hard;

public class Prob1373_MaxSumBSTinBinaryTree {

	public static void main(String[] args) {
		// TreeNode root = prepareTree(new int[] { 4, 8, -999, 6, 1, 9, -999, -5, 4,
		// -999, -999, -999, -3, -999, 10 });
		TreeNode root = prepareTree(new int[] { 2, 1, 3 });
		System.out.println(maxSumBST(root));
	}

	public static int maxSumBST(TreeNode root) {
		java.util.List<Integer> l = new java.util.ArrayList<>();
		maxSumBSTUtil(root, l);
		java.util.Collections.sort(l);
		if (l.size() > 0) {
			return l.get(l.size() - 1);
		} else {
			return 0;
		}
	}

	public static void maxSumBSTUtil(TreeNode root, java.util.List<Integer> list) {
		if (root != null) {
			if (isBST(root)) {
				int[] result = new int[1];
				sumOfNodes(root, result);
				list.add(Math.max(0, result[0]));
			}

			maxSumBSTUtil(root.left, list);
			maxSumBSTUtil(root.right, list);
		}

	}

	private static void sumOfNodes(TreeNode root, int[] res) {
		if (root != null) {
			sumOfNodes(root.left, res);
			res[0] += root.val;
			sumOfNodes(root.right, res);
		}
	}

	private static boolean isBST(TreeNode root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTUtil(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		return root.val > minValue && root.val < maxValue && isBSTUtil(root.left, minValue, root.val)
				&& isBSTUtil(root.right, root.val, maxValue);
	}

	// ==

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
