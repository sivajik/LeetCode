package leetcode.easy;

public class Prob111_MinDepthOfTee {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 3, 9, 20, 15, 7, -999, -999 });
		// TreeNode root = prepareTree(new int[] { 0, 2, 4, 1, -999, 3, -1, 5, 1, -999,
		// 6, -999, 8 });
		System.out.println(minDepth(root));
	}

	static public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int ans = 1;
		java.util.Queue<TreeNode> q = new java.util.LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode t = q.poll();

				if (isLeafNode(t)) {
					return ans;
				}
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			}
			ans++;
		}
		return ans;
	}

	static public boolean isLeafNode(TreeNode t) {
		return t != null && t.left == null && t.right == null;
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
