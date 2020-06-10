package leetcode.medium;

public class Prob515_LargestInEachTreeRow {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 3, 2, 5, 3, -999, 9 });
		System.out.println(largestValues(root));

		root = prepareTree(new int[] { 1 });
		System.out.println(largestValues(root));

		root = prepareTree(new int[] { 1, -999, 8 });
		System.out.println(largestValues(root));

		root = prepareTree(new int[] { 0, -2147483648, 2147483647 });
		System.out.println(largestValues(root));

	}

	static public java.util.List<Integer> largestValues(TreeNode root) {
		if (root == null) {
			return new java.util.ArrayList<>();
		}

		java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
		q.add(root);

		java.util.List<Integer> result = new java.util.ArrayList<>();

		while (!q.isEmpty()) {
			int size = q.size();

			int rowMax = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode t = q.poll();

				if (t.val > rowMax) {
					rowMax = t.val;
				}
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			}
			result.add(rowMax);
		}
		return result;
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
