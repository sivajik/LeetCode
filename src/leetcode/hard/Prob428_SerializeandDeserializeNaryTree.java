package leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob428_SerializeandDeserializeNaryTree {

	public static void main(String[] args) {
		String s = "1 [ 3 [ 5 6 ] 2 4 ] ]";
		Codec c = new Codec();
		c.deserialize(s);

	}

	static class Codec {
		public String serialize(Node root) {
			if (root == null) {
				return "";
			}
			StringBuilder sbr = new StringBuilder();
			serailHelper(root, sbr);
			return sbr.toString();
		}

		// 1 [ 3 [ 5 6 ] 2 4 ] ]
		private void serailHelper(Node root, StringBuilder sbr) {
			if (root == null) {
				return;
			}
			sbr.append(root.val);
			if (root.children.size() > 0) {
				sbr.append(" [");
				for (Node eachChild : root.children) {
					serailHelper(eachChild, sbr.append(" "));
				}
				sbr.append(" ]");
			}
		}

		// 1 [ 3 [ 5 6 ] 2 4 ] ]
		public Node deserialize(String data) {
			if (data == null || data.length() == 0) {
				return null;
			}
			String[] nodes = data.split(" ");
			Node curr = new Node(Integer.valueOf(nodes[0]), new ArrayList<>());
			Node parent = curr;

			Stack<Node> stk = new Stack<>();

			for (int i = 1; i < nodes.length; i++) {
				if (nodes[i].equals("[")) {
					stk.push(curr);
				} else if (nodes[i].equals("]")) {
					parent = stk.pop();
				} else {
					curr = new Node(Integer.valueOf(nodes[i]), new ArrayList<>());
					stk.peek().children.add(curr);
				}
			}

			return parent;
		}
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
