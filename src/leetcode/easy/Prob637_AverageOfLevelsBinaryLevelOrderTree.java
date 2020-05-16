package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob637_AverageOfLevelsBinaryLevelOrderTree {

	public static void main(String[] args) {
		TreeNode n1 = prepareTree(new int[] { 3, 9, 20, -999, -999, 15, 7 });
		List<Double> l = averageOfLevels(n1);
		System.out.println(l);
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		List<Integer> tempList = new ArrayList<>();
		List<Double> list = new ArrayList<>();

		double sum = 0d;
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (t != null) {
				tempList.add(t.val);
				sum += t.val;
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			} else {
				list.add(sum / tempList.size());
				sum = 0d;
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
