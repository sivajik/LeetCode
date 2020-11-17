package leetcode.revision.week01.medium;

import java.util.*;

public class P116_PopulatingNextRightPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			root.left.next = root.right;
		}
		if (root.right != null) {
			root.right.next = root.next == null ? root.next : root.next.left;
		}

		connect(root.left);
		connect(root.right);
		return root;
	}

	static public Node connectUsualBFS(Node root) {
		if (root == null) {
			return null;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			List<Node> tempList = new ArrayList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				tempList.add(node);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}

			for (int i = 0; i < tempList.size() - 1; i++) {
				tempList.get(i).next = tempList.get(i + 1);
			}
			tempList = null;
		}
		return root;
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};
}
