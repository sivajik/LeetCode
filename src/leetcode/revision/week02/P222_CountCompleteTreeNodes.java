package leetcode.revision.week02;

public class P222_CountCompleteTreeNodes {

	public static void main(String[] args) {
		TreeNode t = prepareTree(new int[] { 1, 2, 3, 4, 5, 6, -999 });
		System.out.println(countNodes(t));
	}

	static public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

		java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
		q.add(root);

		int count = 0;
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (t != null) {
				count++;
				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}

			} 
		}
		return count;
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
