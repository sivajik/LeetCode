package leetcode.thirtydays.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day20_CloneGraph {
	public static void main(String[] args) throws Exception {

	}

    private HashMap<Integer, Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {
		return clone(node);
	}

	private Node clone(Node node) {
		if (node == null) {
			return null;
		}
		
		if (map.containsKey(node.val)) {
			return map.get(node.val);
		}
		
		Node clonedNode = new Node(node.val);
		map.put(node.val, clonedNode);
		
		for (Node neighbour : node.neighbors) {
			clonedNode.neighbors.add(clone(neighbour));
		}
		return clonedNode;
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
