package leetcode.easy;

public class Prob563_BinaryTreeTilt {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] {1, 2, 3});
		System.out.println(findTilt(root));

	}
	static int sum = 0;
	
	 static public int findTilt(TreeNode root) {
		 findTilt1(root);
		 return sum;
	 }
	 
	 
    static public int findTilt1(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        int l = findTilt1(root.left);
        int r = findTilt1(root.right);
        sum += Math.abs(l - r);
        return l + r + root.val;
    }
    
	// ===

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
