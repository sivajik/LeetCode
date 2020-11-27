package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Prob919_CompleteBinaryTreeInserter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class CBTInserter {
	TreeNode root;
	Deque<TreeNode> doubleEndedQ = new ArrayDeque<>();

	public CBTInserter(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();

		this.root = root;
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode tmp = q.poll();
			// dont use &&, use ||
			if (tmp.left == null || tmp.right == null) {
				doubleEndedQ.add(tmp);
			}

			if (tmp.left != null) {
				q.add(tmp.left);
			}
			if (tmp.right != null) {
				q.add(tmp.right);
			}
		}

	}

	public int insert(int v) {
		TreeNode nodeToInsert = doubleEndedQ.peekFirst();

		doubleEndedQ.add(new TreeNode(v));

		if (nodeToInsert.left == null) {
			nodeToInsert.left = doubleEndedQ.peekLast();
		} else if (nodeToInsert.right == null) {
			nodeToInsert.right = doubleEndedQ.peekLast();
			// remove from first position as its both childs are filled
			doubleEndedQ.pollFirst();
		}
		return nodeToInsert.val;
	}

	public TreeNode get_root() {
		return this.root;
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
