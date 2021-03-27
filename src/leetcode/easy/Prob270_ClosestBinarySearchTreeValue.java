package leetcode.easy;

public class Prob270_ClosestBinarySearchTreeValue {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, -999, 2 });
		System.out.println(closestValue(root, 4.428));

	}

	static public int closestValue(TreeNode root, double target) {
		int val, closest = root.val;
		while (root != null) {
			val = root.val;
			closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
			root = target < root.val ? root.left : root.right;
		}
		return closest;
	}

	static double diff = Double.MAX_VALUE;
	static int nodeVal = -1;

	// not using BST Option at all...
	static public int closestValue1(TreeNode root, double target) {
		helper(root, target);
		return nodeVal;
	}

	public static void helper(TreeNode tree, double target) {
		if (tree != null) {
			helper(tree.left, target);
			if (Math.abs(tree.val - target) < diff) {
				diff = Math.abs(tree.val - target);
				nodeVal = tree.val;
			}
			helper(tree.right, target);
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
