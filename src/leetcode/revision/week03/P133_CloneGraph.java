package leetcode.revision.week03;

import java.util.*;

public class P133_CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public Node cloneGraph(Node node) {
		return clone(node);
	}

	static Map<Integer, Node> m = new HashMap<>();

	private static Node clone(Node node) {
		if (node == null) {
			return null;
		}

		if (m.containsKey(node.val)) {
			return m.get(node.val);
		}

		Node newNode = new Node(node.val);
		m.put(node.val, newNode);

		for (Node eachNeighboutr : node.neighbors) {
			newNode.neighbors.add(clone(eachNeighboutr));
		}
		return newNode;
	}

	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}
