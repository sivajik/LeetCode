package leetcode.thirtydays.dec;

import java.util.ArrayList;
import java.util.Iterator;

public class Day09_BinarySearchTreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class BSTIterator {
		Iterator<Integer> itr;

		public BSTIterator(TreeNode root) {
			ArrayList<Integer> l = new ArrayList<>();
			feed(root, l);
			this.itr = l.iterator();
		}

		private void feed(TreeNode root, ArrayList<Integer> l) {
			if (root != null) {
				feed(root.left, l);
				l.add(root.val);
				feed(root.right, l);
			}
		}

		/** @return the next smallest number */
		public int next() {
			return itr.next();
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return itr.hasNext();
		}
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
