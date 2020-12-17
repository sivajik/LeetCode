package leetcode.revision.week01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P894_AllPossibleFullBinaryTrees {

	public static void main(String[] args) {
		for (TreeNode t : allPossibleFBT(7)) {
			inOrder(t);
			System.out.println();
		}
	}

	static Map<Integer, List<TreeNode>> map = new HashMap<>();

	static public List<TreeNode> allPossibleFBT(int N) {

		if (!map.containsKey(N)) {
			List<TreeNode> list = new ArrayList<>();
			if (N == 1) {
				list.add(new TreeNode(0));
				return list;
			} else {
				if (N % 2 == 1) {
					for (int x = 0; x < N; x++) {
						int y = N - x - 1;
						for (TreeNode left : allPossibleFBT(x)) {
							for (TreeNode rite : allPossibleFBT(y)) {
								TreeNode tmp = new TreeNode(0);
								tmp.left = left;
								tmp.right = rite;
								list.add(tmp);
							}
						}

					}
				}
				map.put(N, list);
			}
		}
		return map.get(N);

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
