package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob1490_CloneNaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public Node cloneTree(Node root) {
		if (root == null) {
			return null;
		}

		Node newNode = new Node(root.val);

		for (Node eachChild : root.children) {
			newNode.children.add(cloneTree(eachChild));
		}
		return newNode;
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}
