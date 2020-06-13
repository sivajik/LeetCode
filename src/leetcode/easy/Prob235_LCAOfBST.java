package leetcode.easy;

public class Prob235_LCAOfBST {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 6, 2, 8, 0, 4, 7, 9 });
		// System.out.println(lowestCommonAncestor(root, new TreeNode(0), new TreeNode(8)).val);
		// System.out.println(lowestCommonAncestor(root, new TreeNode(0), new TreeNode(4)).val);
		// System.out.println(lowestCommonAncestor(root, new TreeNode(7), new TreeNode(9)).val);
		System.out.println(lowestCommonAncestor(root, new TreeNode(0), new TreeNode(6)).val);
	}

	static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else {
				break;
			}
		}
		return root;
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
