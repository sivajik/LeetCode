package leetcode.revision.week01;

import java.util.ArrayList;
import java.util.List;

public class P113_PathSum2 {

	public static void main(String[] args) {
		TreeNode t = prepareTree(new int[] { 5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1 });
		for (List<Integer> l : pathSum(t, 22)) {
			System.out.println(l);
		}
	}

	static List<List<Integer>> result = new ArrayList<>();

	static public List<List<Integer>> pathSum(TreeNode root, int sum) {
		helper(root, sum, new ArrayList<Integer>());
		return result;
	}

	static private void helper(TreeNode root, int sum, ArrayList<Integer> runningList) {
		if (root == null) {
			return;
		}
		if (root != null && root.val == sum && root.left == null && root.right == null) {
			runningList.add(root.val);
			result.add(new ArrayList<>(runningList));
			return;
		}

		runningList.add(root.val);
		helper(root.left, sum - root.val, new ArrayList(runningList));
		helper(root.right, sum - root.val, new ArrayList(runningList));
		runningList.remove(runningList.size() - 1);
	}

	// ========
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
