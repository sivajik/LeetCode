package leetcode.thirtydays;

public class Day11_BinaryTreeDiameter {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);

		root.left = two;
		root.right = three;

		two.left = four;
		two.right = five;

		System.out.println(diameterOfBinaryTree(root));
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

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lH = height(root.left);
		int rH = height(root.right);

		return -1+Math.max(height(root.left) + height(root.right) + 1,
				Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right))+1);
	}

	public static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
