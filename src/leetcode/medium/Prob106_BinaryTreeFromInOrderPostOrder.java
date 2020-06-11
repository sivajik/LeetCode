package leetcode.medium;

public class Prob106_BinaryTreeFromInOrderPostOrder {

	public static void main(String[] args) {
		TreeNode root = buildTree(new int[] { 4, 9, 5, 3, 15, 20, 7 }, new int[] { 4, 5, 9, 15, 7, 20, 3 });
		inOrder(root);
	}

	static public TreeNode buildTree(int[] inorder, int[] postorder) {
		java.util.Map<Integer, Integer> map = new java.util.HashMap();

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	static private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd,
			java.util.Map<Integer, Integer> map) {

		if (pStart > pEnd || iStart > iEnd) {
			return null;
		}

		int rootNodeVal = postorder[pEnd];
		TreeNode root = new TreeNode(rootNodeVal);

		int rootPos = map.get(rootNodeVal);

		root.left = helper(inorder, iStart, rootPos - 1, postorder, pStart, pEnd + rootPos - iEnd - 1, map);
		root.right = helper(inorder, rootPos + 1, iEnd, postorder, pEnd + rootPos - iEnd - 1, pEnd - 1, map);

		return root;
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

	public static void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.val + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
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
