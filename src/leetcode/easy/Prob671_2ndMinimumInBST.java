package leetcode.easy;

public class Prob671_2ndMinimumInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static int findSecondMinimumValue(TreeNode root) {
		return kthSmallest(root, 2);
	}

	public static void inOrder(TreeNode root, java.util.List<Integer> l) {
		if (root != null) {
			inOrder(root.left, l);
			l.add(root.val);
			inOrder(root.right, l);
		}
	}

	public static int kthSmallest(TreeNode root, int k) {
		java.util.List<Integer> list = new java.util.ArrayList<>();
		inOrder(root, list);
		java.util.Collections.sort(list);
		int end = 0;
		while (end < list.size() && list.get(0).intValue() == list.get(end).intValue()) {
			end++;
		}
		if (end >= list.size())
			return -1;
		return list.get(end).intValue();
	}
}
