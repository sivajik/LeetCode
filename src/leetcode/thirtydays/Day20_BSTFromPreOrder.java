package leetcode.thirtydays;

public class Day20_BSTFromPreOrder {

	public static void main(String[] args) {
		TreeNode myRoot = bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });
		preOrder(myRoot);
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

	public static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static TreeNode bstFromPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		for (int i = 1; i < preorder.length; i++) {
			insertToTree(root, preorder[i]);
		}
		return root;
	}

	public static void insertToTree(TreeNode myRoot, int i) {
		TreeNode root = myRoot;
		TreeNode newNode = new TreeNode(i);

		while (root != null) {
			if (i < root.val) {
				if (root.left == null) {
					root.left = newNode;
					break;
				} else {
					root = root.left;
				}
			} else if (i > root.val) {
				if (root.right == null) {
					root.right = newNode;
					break;
				} else {
					root = root.right;
				}
			}
		}
	}

}
