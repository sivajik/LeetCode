package leetcode.medium;

public class Prob117_PopulateNextPointer {

	public static void main(String[] args) {
		Node n1 = prepareTree(new int[] { 1, 2, 3, 4, 5, -999, 7 });
		n1 = connect(n1);
		inOrder(n1);
	}

	public static Node connect(Node root) {
		if (root == null) {
			return root;
		}

		java.util.Queue<Node> q = new java.util.LinkedList<>();
		q.add(root);
		q.add(null);

		java.util.List<Node> tempList = new java.util.ArrayList<>();

		while (!q.isEmpty()) {
			Node t = q.poll();
			if (t != null) {
				tempList.add(t);

				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			} else {
				/*
				 * process the tempList
				 */
				for (int i = 0; i < tempList.size() - 1; i++) {
					Node x = tempList.get(i);
					x.next = tempList.get(i + 1);
				}

				if (!q.isEmpty()) {
					q.add(null);
					tempList = new java.util.ArrayList<>();
				}
			}

		}
		return root;
	}

	public static Node prepareTree(int[] values) {
		Node[] treeArray = new Node[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] == -999) {
				treeArray[i] = null;
			} else {
				treeArray[i] = new Node(values[i]);
			}
		}

		for (int i = 0; i < values.length; i++) {
			Node node = treeArray[i];
			if (((2 * i) + 1 < values.length) && ((2 * i) + 2 < values.length)) {
				node.left = treeArray[(2 * i) + 1];
				node.right = treeArray[(2 * i) + 2];
			}
		}
		return treeArray[0];
	}

	public static void inOrder(Node tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.val + "(" + (tree.next != null ? tree.next.val : "*") + ") ");
			inOrder(tree.right);
		}
	}

	static class Node {
		int val;
		Node left;
		Node right;
		Node next;

		Node() {
		}

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node left, Node right, Node next) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.next = next;
		}
	}
}
