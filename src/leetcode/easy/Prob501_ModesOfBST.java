package leetcode.easy;

public class Prob501_ModesOfBST {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 9, 9, 2, 9, 4, 2, -999 });
		System.out.println(java.util.Arrays.toString(findMode(root)));
	}

	static public int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[] {};
		}

		java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
		inOrder(root, map);

		int prevFreq = Integer.MIN_VALUE;
		java.util.List<Integer> l = new java.util.ArrayList<>();

		for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > prevFreq) {
				l.clear();
				l.add(entry.getKey());
				prevFreq = entry.getValue();
			} else if (entry.getValue() == prevFreq) {
				l.add(entry.getKey());
			}
		}
		int[] r = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			r[i] = l.get(i);
		}
		return r;
	}

	public static void inOrder(TreeNode tree, java.util.Map<Integer, Integer> map) {
		if (tree != null) {
			inOrder(tree.left, map);
			if (map.containsKey(tree.val)) {
				map.put(tree.val, 1 + map.get(tree.val));
			} else {
				map.put(tree.val, 1);
			}
			inOrder(tree.right, map);
		}
	}

	// ====
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
