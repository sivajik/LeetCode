package leetcode.easy;

public class Prob897_IncreasingOrderSearchTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 5, 3, 7, 2, 4, 6, 8 });
		inOrder(root);
		System.out.println();

		TreeNode newRoot = increasingBST(root);
		inOrder(newRoot);

	}

	public static TreeNode increasingBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		java.util.List<Integer> list = new java.util.ArrayList<>();

		inOrder(root, list);
		
		TreeNode newRoot = new TreeNode(list.get(0));
		TreeNode tempRoot = newRoot;
		for (int i = 1; i < list.size(); i++) {
			TreeNode temp = new TreeNode(list.get(i));
			tempRoot.right = temp;
			tempRoot = tempRoot.right;
		}
		return newRoot;
	}

	public static void inOrder(TreeNode tree, java.util.List<Integer> list) {
		if (tree != null) {
			inOrder(tree.left, list);
			list.add(tree.val);
			inOrder(tree.right, list);
		}
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
