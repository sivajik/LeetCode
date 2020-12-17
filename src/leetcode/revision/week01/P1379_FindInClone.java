package leetcode.revision.week01;

public class P1379_FindInClone {

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
		TreeNode left = getTargetCopy(original.left, cloned.left, target);
		if (left != null) {
			return left;
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
