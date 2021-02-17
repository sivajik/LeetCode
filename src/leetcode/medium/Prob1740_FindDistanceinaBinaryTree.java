package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Prob1740_FindDistanceinaBinaryTree {

	public static void main(String[] args) {
		TreeNode r = prepareTree(new int[] { 3, 5, 1, 6, 2, 0, 8, -999, -999, 7, 4, -999, -999, -999, -999 });
		System.out.println(findDistance(r, 7, 0));
	}

	public static int findDistance(TreeNode root, int p, int q) {
		if (root == null) {
			return 0;
		}
		Map<TreeNode, TreeNode> parents = new HashMap<>();
		populatePaernts(root, null, parents);

		TreeNode pNode = find(root, p);
		return bfs(pNode, q, parents);
	}

	private static int bfs(TreeNode r, int val, Map<TreeNode, TreeNode> parents) {
		if (r == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<>();
		Map<TreeNode, TreeNode> seen = new HashMap<>();

		q.add(r);
		seen.put(r, r);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();

				if (temp.val == val) {
					return level;
				}

				if (temp.left != null && !seen.containsKey(temp.left)) {
					q.add(temp.left);
					seen.put(temp.left, temp.left);
				}
				if (temp.right != null && !seen.containsKey(temp.right)) {
					q.add(temp.right);
					seen.put(temp.right, temp.right);
				}
				if (parents.get(temp) != null && !seen.containsKey(parents.get(temp))) {
					q.add(parents.get(temp));
					seen.put(parents.get(temp), parents.get(temp));
				}
			}
			level++;
		}
		return -1;
	}

	private static TreeNode find(TreeNode root, int p) {
		if (root == null) {
			return null;
		}
		if (root.val == p) {
			return root;
		}
		TreeNode ll = find(root.left, p);
		if (ll != null) {
			return ll;
		}

		return find(root.right, p);
	}

	private static void populatePaernts(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parents) {
		if (root != null) {
			parents.put(root, parent);
			populatePaernts(root.left, root, parents);
			populatePaernts(root.right, root, parents);
		}
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
}
