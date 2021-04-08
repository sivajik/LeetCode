package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob652_FindDuplicateSubtrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		Map<String, Integer> map = new HashMap<>();
		List<TreeNode> ans = new ArrayList<>();
		process(root, ans, map);
		return ans;
	}

	private static String process(TreeNode root, List<TreeNode> ans, Map<String, Integer> map) {
		if (root == null) {
			return "@";
		}
		// its key to keep commas as well.
		String key = root.val + "," + process(root.left, ans, map) + "," + process(root.right, ans, map);
		if (map.containsKey(key)) {
			map.put(key, 1 + map.get(key));
		} else {
			map.put(key, 1);
		}

		if (map.get(key) == 2) {
			ans.add(root);
		}
		return key;
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
