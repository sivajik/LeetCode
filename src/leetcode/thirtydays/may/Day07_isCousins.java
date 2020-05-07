package leetcode.thirtydays.may;

import java.util.LinkedList;
import java.util.Queue;

public class Day07_isCousins {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, -999, -999, -999 });
		System.out.println(isCousins(root, 4, 3));
	}

	public static boolean isCousins(TreeNode root, int x, int y) {
		java.util.Map<Integer, Integer> parentsMap = new java.util.HashMap<>();
		java.util.Map<Integer, Integer> heightsMap = new java.util.HashMap<>();

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		parentsMap.put(root.val, -1);
		heightsMap.put(root.val, 0);
		int h = 1;
		while (!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if (tmp != null) {
				if (tmp.left != null) {
					q.add(tmp.left);
					parentsMap.put(tmp.left.val, tmp.val);
					heightsMap.put(tmp.left.val, h);
				}
				if (tmp.right != null) {
					q.add(tmp.right);
					parentsMap.put(tmp.right.val, tmp.val);
					heightsMap.put(tmp.right.val, h);
				}
			} else {
				if (!q.isEmpty()) {
					q.add(null);
					h++;
				}
			}

		}
		return heightsMap.get(x) == heightsMap.get(y) && parentsMap.get(x) != parentsMap.get(y);
	}

	// =======
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
