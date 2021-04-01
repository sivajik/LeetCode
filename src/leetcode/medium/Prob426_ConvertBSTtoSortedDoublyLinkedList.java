package leetcode.medium;

public class Prob426_ConvertBSTtoSortedDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static Node first = null;
	static Node last = null;

	static public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}

		helper(root);

		first.left = last;
		last.right = first;
		return first;
	}

	private static void helper(Node node) {
		if (node != null) {
			helper(node.left);

			// process root;
			if (last != null) {
				last.right = node;
				node.left = last;
			} else {
				first = node;
			}
			last = node;

			helper(node.right);
		}

	}

	static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};
}
