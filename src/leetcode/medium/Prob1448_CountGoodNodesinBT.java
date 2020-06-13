package leetcode.medium;

public class Prob1448_CountGoodNodesinBT {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 3, 1, 4, 3, 0, 1, 5 });
		System.out.println(goodNodes(root));
		System.out.println(" --- ");
		root = prepareTree(new int[] { 3, 3, -999, 4, 2 });
		System.out.println(goodNodes(root));
		System.out.println(" --- ");
		root = prepareTree(new int[] { 1 });
		System.out.println(goodNodes(root));
		System.out.println(" --- ");
		root = prepareTree(new int[] { 9, 0, 3, 0, 0, 6 });
		System.out.println(goodNodes(root));

	}

	public static int goodNodeCount = 0;

	static public int goodNodes(TreeNode root) {
		goodNodeCount = 0;
		helper(root, Integer.MIN_VALUE);
		return goodNodeCount;
	}

	private static int helper(TreeNode root, int max) {
		if (root == null) {
			return 0;
		}
		if (root.val >= max) {
			System.out.println("Good node: " + root.val);
			goodNodeCount++;
		}
		int leftC = helper(root.left, Math.max(max, root.val));
		int rightC = helper(root.right, Math.max(max, root.val));
		return leftC + rightC;
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
