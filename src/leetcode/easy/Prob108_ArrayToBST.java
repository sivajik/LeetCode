package leetcode.easy;

public class Prob108_ArrayToBST {

	public static void main(String[] args) {
		TreeNode tree = sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
		inOrder(tree);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST1(nums, 0, nums.length - 1);
	}

	public static TreeNode sortedArrayToBST1(int[] nums, int l, int h) {
		TreeNode t = null;
		if (l <= h) {
			int m = l + (h - l) / 2;
			t = new TreeNode(nums[m]);
			t.left = sortedArrayToBST1(nums, l, m - 1);
			t.right = sortedArrayToBST1(nums, m + 1, h);
		} else {
			return null;
		}
		return t;
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
