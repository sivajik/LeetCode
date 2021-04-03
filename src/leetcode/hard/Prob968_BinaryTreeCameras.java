package leetcode.hard;

public class Prob968_BinaryTreeCameras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static enum Camera {
		HAS_CAMERA_HERE, NODE_IS_COVERED, NODE_NOT_COVERED;
	}

	static int total = 0;

	static public int minCameraCover(TreeNode root) {
		Camera c = cover(root);
		if (c == Camera.NODE_NOT_COVERED) {
			total++;
		}
		return total;
	}

	private static Camera cover(TreeNode root) {
		if (root == null) {
			return Camera.NODE_IS_COVERED;
		}
		Camera l = cover(root.left);
		Camera r = cover(root.right);

		if (l == Camera.NODE_NOT_COVERED || r == Camera.NODE_NOT_COVERED) {
			total++;
			return Camera.HAS_CAMERA_HERE;
		}

		if (l == Camera.HAS_CAMERA_HERE || r == Camera.HAS_CAMERA_HERE) {
			return Camera.NODE_IS_COVERED;
		}
		return Camera.NODE_NOT_COVERED;
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
