package leetcode.easy;

public class Prob606_StringFrmBinaryTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, -999, 4, -999, -999 });
		String s = tree2str(root);
		System.out.println(s);

		TreeNode root1 = prepareTree(new int[] { 1, 2, 3, 4, -999, -999, -999 });
		String s1 = tree2str(root1);
		System.out.println(s1);
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

	public static String tree2str(TreeNode t) {
		StringBuilder sbldr = new StringBuilder();
		preOrder(t, sbldr);
		return sbldr.toString();
	}

	public static void preOrder(TreeNode tree, StringBuilder l) {
		if (tree != null) {
			l.append("" + tree.val);
			if (tree.left != null) {
				l.append("(");
				preOrder(tree.left, l);
				l.append(")");
			}
			if (tree.right != null) {
				if (tree.left == null) {
					l.append("()");
				}
				l.append("(");
				preOrder(tree.right, l);
				l.append(")");
			}
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
