package leetcode.revision.week01.medium;

public class P236_LCA_BinaryTree {

	public static void main(String[] args) {
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode one = new TreeNode(1);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode zero = new TreeNode(0);
		TreeNode eight = new TreeNode(8);

		three.left = five;
		three.right = one;

		five.left = six;
		five.right = two;
		one.left = zero;
		one.right = eight;

		System.out.println(lowestCommonAncestor(three, six, eight).val);
	}

	static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return helper(root, p, q);
	}

	private static TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (root.val == p.val || root.val == q.val) {
			return root;
		}

		TreeNode l = helper(root.left, p, q);
		TreeNode r = helper(root.right, p, q);

		if (l != null && r != null) {
			return root;
		}
		
		if (l != null) {
			return l;
		} else {
			return r;	
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
