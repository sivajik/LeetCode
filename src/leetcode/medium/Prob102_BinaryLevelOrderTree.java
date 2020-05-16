package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob102_BinaryLevelOrderTree {

	public static void main(String[] args) {
		TreeNode n1 = prepareTree(new int[] { 3, 9, 20, -999, -999, 15, 7 });
		List<List<Integer>> l = levelOrder(n1);
		for (List<Integer> list : l) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		List<Integer> tempList = new ArrayList<>();

		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (t != null) {
				tempList.add(t.val);

				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			} else {
				list.add(tempList);
				if (!q.isEmpty()) {
					q.add(null);
					tempList = new ArrayList<>();
				}
			}

		}
		return list;
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
