package leetcode.easy;

import java.util.List;

public class Prob872_LeafSimilarTree {

	public static void main(String[] args) {
		/*
		TreeNode r1 = prepareTree(new int[] { 3, 5, 1, 6, 2, 9, 8, -999, -999, 7, 4, -999, -999, -999, -999 });
		TreeNode r2 = prepareTree(new int[] { 3, 5, 1, 6, 2, 9, 8, -999, -999, 7, 4, -999, -999, -999, -999 });
		*/
		TreeNode r1 = prepareTree(new int[] { 1 });
		TreeNode r2 = prepareTree(new int[] { 2 });
		
		System.out.println(leafSimilar(r1, r2));
	}

	static public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		java.util.List<Integer> l1 = new java.util.ArrayList<>();
		java.util.List<Integer> l2 = new java.util.ArrayList<>();

		inOrder(root1, l1);
		inOrder(root2, l2);

		if (l1.size() == l2.size()) {
			for (int i = 0; i < l1.size(); i++) {
				if (l1.get(i) != l2.get(i)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static void inOrder(TreeNode tree, List<Integer> l) {
		if (tree != null) {
			inOrder(tree.left, l);
			if (tree.left == null && tree.right == null) {
				l.add(tree.val);
				System.out.print(tree.val + " ");
			}
			inOrder(tree.right, l);
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
