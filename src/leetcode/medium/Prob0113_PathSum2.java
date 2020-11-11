package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob0113_PathSum2 {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0,
		0, 5, 1 });
		//TreeNode root = prepareTree(new int[] { 1, 2, -999 });
		inOrder(root);
		System.out.println();
		pathSum(root, 22);
		for (List<Integer> eachList : finalList) {
			System.out.println(eachList);
		}
	}

	static List<List<Integer>> finalList = new ArrayList<>();

	static public List<List<Integer>> pathSum(TreeNode root, int sum) {
		pathSumHelper(root, sum, new ArrayList<>());
		return finalList;
	}

	static public void pathSumHelper(TreeNode root, int sum, List<Integer> runningList) {
		if (root == null) {
			return;
		}
		if (root != null && root.val == sum && root.left == null && root.right == null) {
			runningList.add(root.val);
			finalList.add(new ArrayList<>(runningList));
			return;
		}
		runningList.add(root.val);
		pathSumHelper(root.left, sum - root.val, new ArrayList<>(runningList));
		pathSumHelper(root.right, sum - root.val, new ArrayList<>(runningList));
		runningList.remove(runningList.size() - 1);
	}

	//

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
