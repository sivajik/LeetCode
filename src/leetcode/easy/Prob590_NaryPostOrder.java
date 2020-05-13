package leetcode.easy;

import java.util.List;

public class Prob590_NaryPostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorder(Node root) {
		java.util.List<Integer> l = new java.util.ArrayList<Integer>();
		process(root, l);
		return l;
	}

	public void process(Node root, List<Integer> l) {
		if (root == null) {
			return;
		}
		for (Node child : root.children) {
			process(child, l);
		}
		l.add(root.val);
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
