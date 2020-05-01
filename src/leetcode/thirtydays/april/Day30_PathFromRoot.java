package leetcode.thirtydays.april;

public class Day30_PathFromRoot {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(0);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(1);
		TreeNode f = new TreeNode(0);
		TreeNode g = new TreeNode(4);
		TreeNode h = new TreeNode(0);
		TreeNode i = new TreeNode(0);

		a.left = b;
		a.right = c;

		b.left = d;
		b.right = e;

		c.left = f;

		d.right = g;

		e.left = h;
		e.right = i;

		System.out.println(isValidSequence(a, new int[] { 1, 2, 3, 4 }));
	}

	public static boolean isValidSequence(TreeNode root, int[] arr) {
		return checkPath(root, arr, 0);
	}

	private static boolean checkPath(TreeNode root, int[] arr, int index) {
		if (root == null || arr.length == index) {
			return false;
		}
		
		if (root.left == null && root.right == null && root.val == arr[index] && index == arr.length - 1) {
			return true;
		}
		return root.val == arr[index] && (
						checkPath(root.left, arr, index+1) || checkPath(root.right, arr, index+1)
				);
	}

	public static boolean isLeafNode(TreeNode node) {
		return node.left == null && node.right == null;
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
