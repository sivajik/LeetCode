package leetcode.medium;

public class Prob1161_MaximumLevelSum {

	public static void main(String[] args) {
		System.out.println(maxLevelSum(prepareTree(new int[] { 1, 7, 9, 4, 4, 4, 4 })));
		System.out.println(maxLevelSum(prepareTree(new int[] { 1, 7, 0, 7, -8, -999, -999 })));
	}

	public static int maxLevelSum(TreeNode root) {
		int maxSum = root.val;
		int h = 1;
		int levelWithMaxSum = 1;
		int soFarSum = 0;

		java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if (tmp != null) {
				if (tmp.left != null) {
					q.add(tmp.left);
					soFarSum += tmp.left.val;
				}
				if (tmp.right != null) {
					q.add(tmp.right);
					soFarSum += tmp.right.val;
				}
			} else {
				if (!q.isEmpty()) {
					h++;
					if (soFarSum > maxSum) {
						maxSum = soFarSum;
						levelWithMaxSum = h;
					}
					soFarSum = 0;
					q.add(null);
				}
			}

		}
		return levelWithMaxSum;
	}

	// ======
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
