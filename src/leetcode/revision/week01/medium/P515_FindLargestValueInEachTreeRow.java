package leetcode.revision.week01.medium;

import java.util.*;

public class P515_FindLargestValueInEachTreeRow {

	public static void main(String[] args) {
		System.out.println(largestValuesDFS(prepareTree(new int[] { 1, 3, 2, 5, 3, 2, 9 })));
		System.out.println(largestValuesDFS(prepareTree(new int[] { 1, 2, 3 })));
		System.out.println(largestValuesDFS(prepareTree(new int[] { 1 })));
		System.out.println(largestValuesDFS(prepareTree(new int[] { 1, -999, 2 })));
		
		
		System.out.println();
		
		System.out.println(largestValuesBFS(prepareTree(new int[] { 1, 3, 2, 5, 3, 2, 9 })));
		System.out.println(largestValuesBFS(prepareTree(new int[] { 1, 2, 3 })));
		System.out.println(largestValuesBFS(prepareTree(new int[] { 1 })));
		System.out.println(largestValuesBFS(prepareTree(new int[] { 1, -999, 2 })));
	}

	// static int max = Integer.MIN_VALUE;
	static Map<Integer, Integer> map = new TreeMap<>();

	static public List<Integer> largestValuesDFS(TreeNode root) {
		List<Integer> op = new ArrayList<>();
		if (root == null) {
			return op;
		}

		preOrder(root, 0);
		op = new ArrayList<>(map.values());
		return op;
	}

	private static void preOrder(TreeNode root, int level) {
		if (root != null) {
			// if (level > max) {
			if (map.get(level) != null) {
				if (root.val > map.get(level)) {
					map.put(level, root.val);
				}
			} else {
				map.put(level, root.val);
			}
			// max = level;
			// }
			preOrder(root.left, 1 + level);
			preOrder(root.right, 1 + level);
		}
	}

	static public List<Integer> largestValuesBFS(TreeNode root) {
		List<Integer> op = new ArrayList<>();
		if (root == null) {
			return op;
		}

		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> l = new ArrayList<>();
			int localMax = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode tmp = q.poll();
				if (tmp.val > localMax) {
					localMax = tmp.val;
				}
				l.add(tmp.val);

				if (tmp.left != null) {
					q.add(tmp.left);
				}

				if (tmp.right != null) {
					q.add(tmp.right);
				}
			}
			op.add(localMax);
		}
		return op;
	}

	// ========
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
