package leetcode.easy;

public class Prob1022_SumOfRoot2Leaves {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 0, 1});
		int total = sumRootToLeaf(root);
		System.out.println(total);
	}

	public static int sumRootToLeaf(TreeNode root) {
		travelEachPath(root, 0, new int[1000]);
		return grantTotal;
	}

	static int grantTotal = 0;
	
	public static void travelEachPath(TreeNode root, int count, int[] arr) {
		if (root != null) {
			arr[count++] = root.val;
			if (root.left == null && root.right == null) {
				convertToDecimalAndSumup(arr, count);
			}
			travelEachPath(root.left, count, arr);
			travelEachPath(root.right, count, arr);
		}
	}

	private static void convertToDecimalAndSumup(int[] arr, int count) {
		StringBuilder sbr = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sbr.append(arr[i]);
		}
		int decimalNum = Integer.parseInt(sbr.toString(), 2);
		grantTotal = grantTotal + decimalNum;
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
