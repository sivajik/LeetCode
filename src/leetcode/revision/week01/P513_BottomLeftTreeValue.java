package leetcode.revision.week01;

public class P513_BottomLeftTreeValue {

	public static void main(String[] args) {
		System.out.println(findBottomLeftValue(prepareTree(new int[] { 2, 1, 3 })));
		System.out.println(findBottomLeftValue(prepareTree(new int[] { 1, 2, 3, 4, 0, 5, 6, 0, 0, 0,0,7, 0, 0, 0 })));

	}

	static int max = Integer.MIN_VALUE;
	static int answer;

	static public int findBottomLeftValue(TreeNode root) {
		max = Integer.MIN_VALUE;
		preOrder(root, 0);
		return answer;
	}

	static private void preOrder(TreeNode root, int level) {
		if (root != null) {
			if (level > max) {
				max = level;
				answer = root.val;
			}
			preOrder(root.left, level + 1);
			preOrder(root.right, level + 1);
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
