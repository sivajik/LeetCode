package leetcode.medium;

public class Prob1379_NodeInClonedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if (original == null) {
			return null;
		}

		if (original == target) {
			return cloned;
		}

		TreeNode x = getTargetCopy(original.left, cloned.left, target);
		if (x != null) {
			return x;
		}
		return getTargetCopy(original.right, cloned.right, target);
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
