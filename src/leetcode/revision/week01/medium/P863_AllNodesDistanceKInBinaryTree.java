package leetcode.revision.week01.medium;

import java.util.*;

public class P863_AllNodesDistanceKInBinaryTree {

	public static void main(String[] args) {
		TreeNode n3 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1);
		TreeNode n6 = new TreeNode(6);
		TreeNode n2 = new TreeNode(2);
		TreeNode n0 = new TreeNode(0);
		TreeNode n8 = new TreeNode(8);
		TreeNode n7 = new TreeNode(7);
		TreeNode n4 = new TreeNode(4);

		n3.left = n5;
		n3.right = n1;

		n5.left = n6;
		n5.right = n2;

		n1.left = n0;
		n1.right = n8;

		n2.left = n7;
		n2.right = n4;

		System.out.println(distanceK(n3, n5, 2));
		System.out.println(distanceK(n3, n6, 4));
		System.out.println(distanceK(n3, n6, 43));

	}

	static public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new ArrayList<>();

		if (root == null || target == null) {
			return res;
		}
		if (K == 0) {
			res.add(target.val);
			return res;
		}

		Map<TreeNode, TreeNode> parentsMap = new HashMap<>();
		populateParents(root, null, parentsMap);

		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(target);
		int distance = 0;

		Queue<TreeNode> visited = new ArrayDeque<>();
		visited.add(target);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode tmp = q.poll();
				if (tmp.left != null && !visited.contains(tmp.left)) { // if we keep adding parents, keep coming.
					q.add(tmp.left);
					visited.add(tmp.left);
				}
				if (tmp.right != null && !visited.contains(tmp.right)) {
					q.add(tmp.right);
					visited.add(tmp.right);
				}
				if (parentsMap.get(tmp) != null && !visited.contains(parentsMap.get(tmp))) {
					q.add(parentsMap.get(tmp));
					visited.add(parentsMap.get(tmp));
				}
			}
			distance++;
			if (distance == K) {
				while (!q.isEmpty()) {
					res.add(q.poll().val);
				}
				return res;
			}
		}

		return res;
	}

	private static void populateParents(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentsMap) {
		// TODO Auto-generated method stub
		if (root != null) {
			parentsMap.put(root, parent);
			populateParents(root.left, root, parentsMap);
			populateParents(root.right, root, parentsMap);
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