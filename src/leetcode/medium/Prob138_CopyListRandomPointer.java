package leetcode.medium;

public class Prob138_CopyListRandomPointer {

	public static void main(String[] args) {
		Node n0 = new Node(7);
		Node n1 = new Node(13);
		Node n2 = new Node(11);
		Node n3 = new Node(10);
		Node n4 = new Node(1);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		n0.random = null;
		n1.random = n0;
		n2.random = n4;
		n3.random = n2;
		n4.random = n0;

		print(n0);
		print(copyRandomList(n0));
	}

	static public Node copyRandomList(Node head) {
		java.util.Map<Node, Node> oldListToNewList = new java.util.HashMap<>();

		Node oldNode = head;
		Node doops = new Node(-999);
		Node newList = doops;
		while (oldNode != null) {
			Node newNode = new Node(oldNode.val);
			newList.next = newNode;
			newList = newList.next;
			oldListToNewList.put(oldNode, newNode);
			oldNode = oldNode.next;
		}

		oldNode = head;
		newList = doops.next;
		while (oldNode != null) {
			Node randomPointer = oldNode.random;
			if (randomPointer != null) {
				Node oldNodeMappedTo = oldListToNewList.get(randomPointer);
				newList.random = oldNodeMappedTo;
			} else {
				newList.random = null;
			}
			oldNode = oldNode.next;
			newList = newList.next;
		}

		return doops.next;
	}

	static void print(Node a1) {
		Node a = a1;
		while (a != null) {
			System.out.print(a.val + "[" + (a.random != null ? a.random.val : -1) + "]" + "  ");
			a = a.next;
		}
		System.out.println();
	}

	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
