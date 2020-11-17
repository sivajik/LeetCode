package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob1609_EvenOddTree {

	public static void main(String[] args) {
		System.out.println(isEvenOddTree(prepareTree(new int[] { 5, 4, 2, 3, 3, 7, 9 })));

	}

	static public boolean isEvenOddTree(TreeNode root) {
		if (root == null) {
			return false;
		}

		if (root.val % 2 == 0) {
			return false;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int currLevel = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = q.poll();
				list.add(tmp.val);
				
				if (tmp.left != null) {
					q.add(tmp.left);
				}
				if (tmp.right != null) {
					q.add(tmp.right);
				}
			}

			if (currLevel % 2 == 0) {
				// even level.
				// except all entries to be ODD.
				// must increase
				if (list.size() == 1) {
					if (list.get(0) % 2 != 1) {
						return false;
					}
				} else {
					for (int i = 1; i < list.size(); i++) {
						if (list.get(i) % 2 == 1 && list.get(i - 1) % 2 == 1 && list.get(i) > list.get(i - 1)) {
							continue;
						} else {
							return false;
						}
					}
				}

			} else {
				// odd level
				// expect all entries to be even;
				// must decrease
				if (list.size() == 1) {
					if (list.get(0) % 2 != 0) {
						return false;
					}
				} else {
					for (int i = 1; i < list.size(); i++) {
						if (list.get(i) % 2 == 0 && list.get(i - 1) % 2 == 0 && list.get(i) < list.get(i - 1)) {
							continue;
						} else {
							return false;
						}
					}
				}

			}
			currLevel++;
		}

		return true;
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
