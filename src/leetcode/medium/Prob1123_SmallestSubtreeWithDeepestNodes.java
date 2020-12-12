package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob1123_SmallestSubtreeWithDeepestNodes {

	public static void main(String[] args) {
		TreeNode root = subtreeWithAllDeepest(prepareTree(new int[] { 3, 5, 1, 6, 2, 0, 8, -999, -999, 2, 4 }));
		System.out.println(root.val);
	}

	static public TreeNode subtreeWithAllDeepest(TreeNode root) {
		// get depths
		Map<TreeNode, Integer> map = new HashMap<>();
		map.put(null, -1);

		dfs(root, null, map);

		// get max depth
		int maxDepth = Integer.MIN_VALUE;
		for (Map.Entry<TreeNode, Integer> eset : map.entrySet()) {
			maxDepth = Math.max(maxDepth, eset.getValue());
		}

		// return lca
		return lca(root, map, maxDepth);
	}

	static private TreeNode lca(TreeNode root, Map<TreeNode, Integer> map, int maxDepth) {
		if (root == null || map.get(root) == maxDepth) {
			return root;
		}

		TreeNode left = lca(root.left, map, maxDepth);
		TreeNode rite = lca(root.right, map, maxDepth);

		if (left != null && rite != null) {
			return root;
		}

		if (left != null) {
			return left;
		}
		if (rite != null) {
			return rite;
		}
		return null;
	}

	static private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, Integer> map) {
		if (root != null) {
			map.put(root, map.get(parent) + 1);

			dfs(root.left, root, map);
			dfs(root.right, root, map);
		}
	}

	// ------
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

		public String toString() {
			return String.valueOf(val);
		}
	}
}
