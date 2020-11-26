package leetcode.revision.week02;

import java.util.ArrayList;
import java.util.List;

public class P1305_AllElementsTwoBST {

	public static void main(String[] args) {
		TreeNode n1 = prepareTree(new int[] {2,1,4});
		TreeNode n2 = prepareTree(new int[] {1,0,3});
		System.out.println(getAllElements(n1, n2));
	}

	static public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> l1 = new ArrayList<>();
		inorder(root1, l1);

		List<Integer> l2 = new ArrayList<>();
		inorder(root2, l2);
		return merge(l1, l2);
	}

	static private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
		int i = 0, j = 0;

		List<Integer> l3 = new ArrayList<>();

		while (i < l1.size() && j < l2.size()) {
			if (l1.get(i) < l2.get(j)) {
				l3.add(l1.get(i++));
			} else {
				l3.add(l2.get(j++));
			}
		}
		if (i == l1.size() && j < l2.size()) {
			while (j < l2.size()) {
				l3.add(l2.get(j++));
			}
		}
		
		if (j == l2.size() && i < l1.size()) {
			while (i < l1.size()) {
				l3.add(l1.get(i++));
			}
		}
		
		return l3;
	}

	static public void inorder(TreeNode tree, List<Integer> l1) {
		if (tree != null) {
			inorder(tree.left, l1);
			l1.add(tree.val);
			inorder(tree.right, l1);
		}
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
