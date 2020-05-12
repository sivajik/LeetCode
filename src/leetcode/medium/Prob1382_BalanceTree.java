package leetcode.medium;

public class Prob1382_BalanceTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);

		n1.right = n2;
		n2.right = n3;
		n3.right = n4;

		TreeNode t = balanceBST(n1);
		inOrder(t);
	}

	public static TreeNode balanceBST(TreeNode root) {
		java.util.List<Integer> ll = new java.util.ArrayList<>();
		inOrder(root, ll);

		Integer[] array = ll.toArray(new Integer[0]);
		return makeTree(array, 0, array.length - 1);
	}

	public static TreeNode makeTree(Integer[] a, int l, int h) {
		if (l <= h) {
			int mid = l + (h - l) / 2;
			TreeNode t = new TreeNode(a[mid]);
			t.left = makeTree(a, l, mid - 1);
			t.right = makeTree(a, mid + 1, h);
			return t;
		} else {
			return null;
		}
	}

	public static void inOrder(TreeNode tree, java.util.List<Integer> l) {
		if (tree != null) {
			inOrder(tree.left, l);
			l.add(tree.val);
			inOrder(tree.right, l);
		}
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
