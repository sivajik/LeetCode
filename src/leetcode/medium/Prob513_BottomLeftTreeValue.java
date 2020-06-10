package leetcode.medium;

public class Prob513_BottomLeftTreeValue {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 2, 1, 3 });
		System.out.println(findBottomLeftValue(root));

		 root = prepareTree(new int[] { 1, 2, 3, 4, -999, 5, 6, 7, 9 });
		System.out.println(findBottomLeftValue(root));

		root = prepareTree(new int[] { 0 });
		System.out.println(findBottomLeftValue(root));

		root = prepareTree(new int[] { 0, -999, -1 });
		System.out.println(findBottomLeftValue(root));
	}

	static public int findBottomLeftValue(TreeNode root) {
		java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
		q.add(root);
		q.add(null);

		TreeNode leftMost = root;

		java.util.List<TreeNode> tempList = new java.util.ArrayList<>();

		while (!q.isEmpty()) {
			TreeNode ll = q.poll();
			if (ll != null) {
				if (ll.left != null) {
					q.add(ll.left);
					tempList.add(ll.left);
				}
				if (ll.right != null) {
					q.add(ll.right);
					tempList.add(ll.right);
				}
			} else {
				if (!q.isEmpty()) {
					leftMost = tempList.get(0);
					q.add(null);
					tempList.clear();
				}
			}
		}
		return leftMost.val;
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
