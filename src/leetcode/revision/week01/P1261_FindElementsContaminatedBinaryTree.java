package leetcode.revision.week01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P1261_FindElementsContaminatedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class FindElements {
		Map<Integer, Boolean> map = new HashMap<>();

		public FindElements(TreeNode root) {
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			root.val = 0;

			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					TreeNode temp = q.poll();
					map.put(temp.val, true);
					
					if (temp.left != null) {
						temp.left.val = (2 * temp.val) + 1;
						q.add(temp.left);
					}

					if (temp.right != null) {
						temp.right.val = (2 * temp.val) + 2;
						q.add(temp.right);
					}
				}
			}
		}

		public boolean find(int target) {
			return map.containsKey(target);
		}
	}

	// ====
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
