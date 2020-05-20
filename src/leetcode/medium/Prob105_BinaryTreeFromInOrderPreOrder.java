package leetcode.medium;

public class Prob105_BinaryTreeFromInOrderPreOrder {

	public static void main(String[] args) {
		TreeNode root = buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
		preOrder(root);
		System.out.println();
		inOrder(root);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		java.util.Map<Integer, Integer> m = new java.util.HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			m.put(inorder[i], i);
		}
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, m);
	}

	private static TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd,
			java.util.Map<Integer, Integer> m) {
		if (pStart > pEnd || iStart > iEnd) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[pStart]);
		int rootLoca = m.get(preorder[pStart]);

		int x = pStart + rootLoca - iStart;

		root.left = build(preorder, pStart + 1, x, inorder, iStart, rootLoca - 1, m);
		root.right = build(preorder, x + 1, pEnd, inorder, rootLoca + 1, iEnd, m);

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
