package leetcode.easy;

public class Prob404_SumOfLeftLeaves {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 3, 9, 20, -999, -999, 15, 7 });
		int sum = sumOfLeftLeaves(root);
		System.out.println(sum);
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
		q.add(root);
		int sum = 0;
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (t.left != null) {
				q.add(t.left);
				if (isLeaf(t.left)) {
					sum += t.left.val;
				}
			}
			if (t.right != null) {
				q.add(t.right);
			}
		}
		return sum;
	}

	private static boolean isLeaf(TreeNode n) {
		return n.left == null && n.right == null;
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
