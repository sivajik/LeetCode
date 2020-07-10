package leetcode.medium;

public class Prob430_FlattenDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node flatten(Node head) {

		Node currNode = head;

		while (currNode != null) {
			if (currNode.child != null) {
				Node currNodeNext = currNode.next;

				Node temp = flatten(currNode.child);
				currNode.next = temp;
				temp.prev = currNode;

				Node childNodeEndNode = null;
				if (temp.next == null) {
					childNodeEndNode = temp;
				} else {
					while (temp.next != null) {
						temp = temp.next;
					}
					childNodeEndNode = temp;
				}
				childNodeEndNode.next = currNodeNext;
				if (currNodeNext != null)
					currNodeNext.prev = childNodeEndNode;
			}
			currNode.child = null;
			currNode = currNode.next;
		}
		return head;

	}

	static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	}
}
