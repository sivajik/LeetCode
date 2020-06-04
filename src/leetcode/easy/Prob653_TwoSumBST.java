package leetcode.easy;

public class Prob653_TwoSumBST {

	public static void main(String[] args) {
		TreeNode r = prepareTree(new int[] { 1 });
		// System.out.println(findTarget(r, 6));
		System.out.println(findTargetBetterWay(r, 2));
	}

	static public boolean findTargetBetterWay(TreeNode root, int k) {
		java.util.List<Integer> l = new java.util.ArrayList<>();
		inOrderBetterWay(root, l);

		int low = 0, high = l.size() - 1;
		while (low < high) {
			int sum = l.get(low);
			sum += l.get(high);
			if (sum == k) {
				return true;
			} else if (sum < k) {
				low++;
			} else {
				high--;
			}
		}
		return false;
	}

	public static void inOrderBetterWay(TreeNode tree, java.util.List<Integer> l) {
		if (tree != null) {
			inOrderBetterWay(tree.left, l);
			l.add(tree.val);
			inOrderBetterWay(tree.right, l);
		}
	}

	public static boolean foundEle = false;

	static public boolean findTarget(TreeNode root, int k) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return false;
		}
		inOrder(root, root, k);
		return foundEle;
	}

	public static void inOrder(TreeNode origTree, TreeNode tree, int k) {
		if (tree != null) {
			inOrder(origTree, tree.left, k);

			if (!foundEle) {
				System.out.print("For " + tree.val + " -> " + " searching for " + (k - tree.val));
				boolean found = find(origTree, tree, k - tree.val);
				if (found) {
					System.out.println("  Found... ");
					foundEle = true;
					return;
				} else {
					System.out.println();
				}
			}

			inOrder(origTree, tree.right, k);
		}
	}

	static public boolean find(TreeNode root, TreeNode temp, int k) {
		if (root != null) {
			if (root.val == k && root != temp) {
				return true;
			} else if (k < root.val) {
				return find(root.left, temp, k);
			} else {
				return find(root.right, temp, k);
			}
		}
		return false;
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
