package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob199_BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, -999, 5, -999, 4 });

		for (int i : rightSideView(root)) {
			System.out.print(i + " ");
		}

	}

	static public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		List<Integer> result = new ArrayList<>();

		List<TreeNode> l = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp != null) {
				l.add(temp);
				if (temp.left != null) {
					q.add(temp.left);
				}

				if (temp.right != null) {
					q.add(temp.right);
				}
			} else {
				result.add(l.get(l.size() - 1).val);
				l.clear();
				if (!q.isEmpty()) {
					q.add(null);
				}
			}
		}
		return result;
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
