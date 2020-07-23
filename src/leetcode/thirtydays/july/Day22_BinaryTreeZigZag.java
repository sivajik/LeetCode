package leetcode.thirtydays.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day22_BinaryTreeZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		boolean l2r = true;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		List<Integer> tempList = new ArrayList<>();

		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (t != null) {
				tempList.add(t.val);

				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			} else {
				if (!l2r) {
					Collections.reverse(tempList);
				}
				list.add(tempList);
				l2r = !l2r;

				if (!q.isEmpty()) {
					q.add(null);
					tempList = new ArrayList<>();
				}
			}

		}
		return list;

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
