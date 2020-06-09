package leetcode.easy;

public class Prob783_MinAbsoluteDiff2 {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 4, 2, 6, 1, 3, -999, -999 });
		System.out.println();
		System.out.println(minDiffInBST(root));
	}

	static public int minDiffInBST(TreeNode root) {
		java.util.List<Integer> l = new java.util.ArrayList<>();
		inOrder(root, l);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < l.size() - 1; i++) {
			int diff = Math.abs(l.get(i) - l.get(i + 1));
			if (diff < minDiff) {
				minDiff = diff;
			}
		}
		return minDiff;
	}

	public static void inOrder(TreeNode tree, java.util.List<Integer> l) {
		if (tree != null) {
			inOrder(tree.left, l);
			l.add(tree.val);
			inOrder(tree.right, l);
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
