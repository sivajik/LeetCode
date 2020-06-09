package leetcode.medium;

public class Prob1325_RemoveLeacesWithTarget {

	public static void main(String[] args) {
		TreeNode r = prepareTree(new int[] { 1, 2, 3, 2, -999, 2, 4 });
		inOrder(removeLeafNodes(r, 2));
	}

	static public TreeNode removeLeafNodes(TreeNode root, int target) {
		return removeHelper(root, target);
	}

	static private TreeNode removeHelper(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		root.left = removeHelper(root.left, target);
		root.right = removeHelper(root.right, target);
		if (isNodeToDel(root, target)) {
			return null;
		} else {
			return root;
		}
	}

	static private boolean isNodeToDel(TreeNode node, int target) {
		return node != null && node.val == target && node.left == null && node.right == null;
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
