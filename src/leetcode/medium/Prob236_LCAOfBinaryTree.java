package leetcode.medium;

public class Prob236_LCAOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 3, 5, 1, 6, 2, 0, 8 });
		System.out.println(lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
		System.out.println(lowestCommonAncestor(root, new TreeNode(6), new TreeNode(2)).val);
		System.out.println(lowestCommonAncestor(root, new TreeNode(0), new TreeNode(8)).val);
		System.out.println(lowestCommonAncestor(root, new TreeNode(6), new TreeNode(8)).val);

	}

	static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return helper(root, p, q);
	}

	private static TreeNode helper(TreeNode currNode, TreeNode p, TreeNode q) {
		if (currNode == null) {
			return null;
		}

		if (currNode.val == p.val || currNode.val == q.val) {
			return currNode;
		}
		TreeNode le = helper(currNode.left, p, q);
		TreeNode ri = helper(currNode.right, p, q);

		if (le != null && ri != null) {
			return currNode;
		}

		if (le != null) {
			return le;
		} else {
			return ri;
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
