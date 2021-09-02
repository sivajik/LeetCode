package leetcode.thirtydays.sep21;

import java.util.ArrayList;
import java.util.List;

public class Day02_PossibleBSTs {

	public static void main(String[] args) {
		for (TreeNode t : generateTrees(3)) {
			inOrder(t);
			System.out.println();
		}
	}

	static public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}
		return generate(1, n);
	}

	static private List<TreeNode> generate(int start, int end) {
		List<TreeNode> all = new ArrayList<>();

		if (start > end) {
			all.add(null);
			return all;
		}

		for (int i = start; i <= end; i++) {
			// first get lefts and rites of 'i'
			List<TreeNode> lefts = generate(start, i - 1);
			List<TreeNode> rites = generate(i + 1, end);

			// now connect 'i' with lefts and rites
			for (TreeNode left : lefts) {
				for (TreeNode rite : rites) {
					TreeNode curr = new TreeNode(i);
					curr.left = left;
					curr.right = rite;
					all.add(curr);
				}
			}

		}

		// TODO Auto-generated method stub
		return all;
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

	public static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		} else {
			System.out.print(" null ");
		}
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			super();
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
}
