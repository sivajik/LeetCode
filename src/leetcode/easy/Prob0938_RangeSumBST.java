package leetcode.easy;

public class Prob0938_RangeSumBST {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 10, 5, 15, 3, 7, -999, 18 });
		inOrder(root);
		System.out.println();
		rangeSumBST(root, 7, 15);
		System.out.println(ans);
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

		TreeNode(int x) {
			val = x;
		}
	}

	static int ans = 0;

	public static void rangeSumBST(TreeNode root, int L, int R) {
		if (root != null) {
			if (root.val >= L && root.val <= R) {
				ans += root.val;
			}
			if (root.val < R) {
				rangeSumBST(root.right, L, R);
			}
			if (root.val > L) {
				rangeSumBST(root.left, L, R);
			}
		}

	}
}
