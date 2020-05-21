package leetcode.medium;

public class Prob987_VerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 6, 5, 7 });
		for (java.util.List<Integer> l : verticalTraversal(root)) {
			System.out.println(l);
		}
	}

	static class Pair {
		int val;
		int level;

		Pair(int val, int level) {
			this.val = val;
			this.level = level;
		}
	}

	static java.util.Map<Integer, java.util.List<Pair>> m = new java.util.TreeMap<>();

	public static java.util.List<java.util.List<Integer>> verticalTraversal(TreeNode root) {
		if (root == null) {
			return new java.util.ArrayList<>();
		}

		traverse(root, 0);

		java.util.List<java.util.List<Integer>> list = new java.util.ArrayList<>();
		for (java.util.Map.Entry<Integer, java.util.List<Pair>> entry : m.entrySet()) {
			java.util.List<Pair> t = entry.getValue();
			java.util.Collections.sort(t, new java.util.Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					if (o1.level == o2.level) {
						return o1.val - o2.val;
					} else {
						return o1.level - o2.level;
					}
				}
			});

			java.util.List<Integer> tempList = new java.util.ArrayList<>();
			for (Pair p : t) {
				tempList.add(p.val);
			}
			list.add(tempList);
		}
		return list;
	}

	private static void traverse(TreeNode root, int i) {
		if (root == null) {
			return;
		}

		if (m.containsKey(i)) {
			java.util.List<Pair> l = m.get(i);
			l.add(new Pair(root.val, i));
			m.put(i, l);
		} else {
			java.util.List<Pair> l = new java.util.ArrayList<>();
			l.add(new Pair(root.val, i));
			m.put(i, l);
		}

		traverse(root.left, i - 1);
		traverse(root.right, i + 1);
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
