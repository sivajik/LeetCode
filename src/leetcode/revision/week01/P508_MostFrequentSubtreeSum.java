package leetcode.revision.week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P508_MostFrequentSubtreeSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findFrequentTreeSum(prepareTree(new int[] { 5, 2, -3 }))));

	}

	static public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null) {
			return new int[] {};
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		helper(root, map);

		TreeMap<Integer, List<Integer>> freqMap = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int nodeVal = entry.getKey();
			int freq = entry.getValue();

			if (freqMap.containsKey(freq)) {
				List<Integer> listOfValues = freqMap.get(freq);
				listOfValues.add(nodeVal);
				freqMap.put(freq, listOfValues);
			} else {
				List<Integer> listOfValues = new ArrayList<>();
				listOfValues.add(nodeVal);
				freqMap.put(freq, listOfValues);
			}
		}

		List<Integer> result = freqMap.firstEntry().getValue();

		int[] op = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			op[i] = result.get(i);
		}
		return op;

	}

	static private int helper(TreeNode root, Map<Integer, Integer> map) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			addToMap(root, map);
			return root.val;
		} else {
			int temp = root.val + helper(root.left, map) + helper(root.right, map);
			root.val = temp;
			addToMap(root, map);
			return root.val;
		}
	}

	static private void addToMap(TreeNode root, Map<Integer, Integer> map) {
		if (map.containsKey(root.val)) {
			map.put(root.val, 1 + map.get(root.val));
		} else {
			map.put(root.val, 1);
		}
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
