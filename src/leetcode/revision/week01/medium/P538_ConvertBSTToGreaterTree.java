package leetcode.revision.medium;

public class P538_ConvertBSTToGreaterTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 4, 1, 6, 0, 2, 5, 7, 0, 0, 0, 3, 0, 0, 0, 8 });
		inOrder1(root);
		System.out.println();
		convertBST(root);
		System.out.println();
		inOrder1(root);
	}

	static int sum = 0;
	private static TreeNode convertBST(TreeNode root) {
		processInOrder(root);
		return root;
	}

	private static void processInOrder(TreeNode root) {
		if (root != null) {
			processInOrder(root.right);
			
			int val = root.val;
			sum += val;
			root.val = sum;
			
			processInOrder(root.left);
		}
	}

	public static void inOrder1(TreeNode tree) {
		if (tree != null) {
			inOrder1(tree.left);
			System.out.print(tree.val + " ");
			inOrder1(tree.right);
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
