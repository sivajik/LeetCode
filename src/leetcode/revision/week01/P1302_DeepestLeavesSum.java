package leetcode.revision.week01;

import java.util.LinkedList;
import java.util.Queue;

public class P1302_DeepestLeavesSum {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);

		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);

		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		System.out.println(deepestLeavesSum(n1));

	}

	public static int deepestLeavesSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int localSum = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			localSum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				localSum += temp.val;

				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}

			}
		}
		return localSum;
	}

	static class TreeNode

	{
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
