package leetcode.easy;

import java.util.List;

public class Prob559_MaxDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		int depth = 0;
		for (Node child : root.children) {
			depth = Math.max(depth, maxDepth(child));
		}
		return 1 + depth;
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
