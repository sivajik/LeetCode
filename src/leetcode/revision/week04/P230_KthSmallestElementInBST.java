package leetcode.revision.week04;

import java.util.ArrayList;
import java.util.List;

public class P230_KthSmallestElementInBST {

	public static void main(String[] args) {
		TreeNode r = prepareTree(new int[] { 3, 1, 4, -999, 2 });
		System.out.println(kthSmallest(r, 1));
	}

	static int min;

	static public int kthSmallest(TreeNode root, int k) {
		inOrder(root, k, new ArrayList<>());
		return min;
	}

	public static void inOrder(TreeNode tree, int k, List<Integer> l) {
		if (tree != null && l.size() < k) {
			inOrder(tree.left, k, l);
			l.add(tree.val);
			if (l.size() == k) {
				min = tree.val;
			}
			inOrder(tree.right, k, l);
		}
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
