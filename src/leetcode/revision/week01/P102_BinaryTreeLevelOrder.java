package leetcode.revision.week01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102_BinaryTreeLevelOrder {

	public static void main(String[] args) {
		TreeNode t = prepareTree(new int[] { 3, 9, 20, 8, 4, 15, 7, 1, 2, 3, 4 });
		for (List<Integer> l : levelOrder(t)) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			List<Integer> tempList = new ArrayList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode t = q.poll();
				tempList.add(t.val);
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			}
			res.add(tempList);
		}
		return res;
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
