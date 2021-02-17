package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob1602_FindNearestRightNodeinBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
		if (root == null || u == null) {
			return null;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<TreeNode> levelList = new ArrayList<>();
			boolean nodeAtLevelFound = false;
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				levelList.add(temp);
				if (temp.val == u.val) {
					// actual node is found;
					nodeAtLevelFound = true;

				}
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
			// level ends...

			if (nodeAtLevelFound) {
				for (int i = 0; i < levelList.size(); i++) {
					if (levelList.get(i).val == u.val) {
						if (i == levelList.size() - 1) {
							return null;
						} else {
							return levelList.get(i + 1);
						}
					}
				}
			}
		}
		return null;
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
