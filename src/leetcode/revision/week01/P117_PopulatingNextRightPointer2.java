package leetcode.revision.week01;

import java.util.*;

public class P117_PopulatingNextRightPointer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Node> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node t = q.poll();
				list.add(t);
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			}
			if (list.size() > 1) {
				for (int i = 0; i < list.size() - 1; i++) {
					list.get(i).next = list.get(i + 1);
				}
			}
		}
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
