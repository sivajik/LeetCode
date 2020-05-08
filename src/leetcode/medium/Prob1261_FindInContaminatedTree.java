package leetcode.medium;

public class Prob1261_FindInContaminatedTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { -1, -999, -1 });
		FindElements f = new FindElements(root);
		System.out.println(f.find(1));
		System.out.println(f.find(2));
	}

	// ======
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

	// ======

	static class FindElements {
		private TreeNode root;
		java.util.Set<Integer> allElem = new java.util.HashSet<>();

		public FindElements(TreeNode root) {
			this.root = root;
			correctTheTree();
			//print(this.root);
			//System.out.println();
		}

		public boolean find(int target) {
			return allElem.contains(target);
		}

		private void correctTheTree() {
			java.util.Queue<TreeNode> q = new java.util.LinkedList<>();

			root.val = 0;

			q.add(root);
			q.add(null);

			while (!q.isEmpty()) {
				TreeNode tmp = q.poll();
				if (tmp != null) {

					allElem.add(tmp.val);

					if (tmp.left != null) {
						q.add(tmp.left);
						tmp.left.val = (2 * tmp.val) + 1;
					}
					if (tmp.right != null) {
						q.add(tmp.right);
						tmp.right.val = (2 * tmp.val) + 2;

					}
				} else {
					if (!q.isEmpty()) {
						q.add(null);
					}
				}
			}
		}

		public void print(TreeNode x) {
			if (x != null) {
				print(x.left);
				System.out.print(x.val + " ");
				print(x.right);
			}
		}
	}
}
