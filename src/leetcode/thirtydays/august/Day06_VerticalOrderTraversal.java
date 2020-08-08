package leetcode.thirtydays.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day06_VerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 3, 9, 20, -999, -999, 15, 7 });
		for (java.util.List<Integer> l : verticalTraversal(root)) {
			System.out.println(l);
		}
	}

	static class Pair {
		int x;
		int y;

		int val;

		TreeNode node;

		Pair(int x, int y, int val, TreeNode node) {
			this.x = x;
			this.y = y;
			this.val = val;
			this.node = node;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", " + ", val=" + val + "]";
		}
	}

	static java.util.Map<Integer, java.util.List<Pair>> m = null;

	public static java.util.List<java.util.List<Integer>> verticalTraversal(TreeNode root) {
		if (root == null) {
			return new java.util.ArrayList<>();
		}
		m = new java.util.TreeMap<>();

		// traverse(root, 0, 0, 0);
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0, root.val, root));
		while (!q.isEmpty()) {
			Pair t = q.poll();

			if (m.containsKey(t.x)) {
				List<Pair> l = m.get(t.x);
				l.add(t);
				m.put(t.x, l);
			} else {
				List<Pair> l = new ArrayList<>();
				l.add(t);
				m.put(t.x, l);
			}

			if (t.node.left != null) {
				q.add(new Pair(t.x - 1, t.y + 1, t.node.left.val, t.node.left));
			}
			if (t.node.right != null) {
				q.add(new Pair(t.x + 1, t.y + 1, t.node.right.val, t.node.right));
			}
		}
		List<List<Integer>> ans = new ArrayList<>();

		for (int i : m.keySet()) {
			List<Pair> l = m.get(i);// -----4-----
			Collections.sort(l, new Comparator<Pair>() {

				@Override
				public int compare(Pair a, Pair b) {
					if (a.y == b.y) {
						return a.val - b.val;
					} else {
						return a.y - b.y;
					}
				}

			}); // -----5----
			List<Integer> aa = new ArrayList<>();
			for (Pair m : l) {
				aa.add(m.val);
			}
			ans.add(aa);
		}
		return ans;
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
