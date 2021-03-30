package leetcode.medium;

public class Prob708_InsertintoaSortedCircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public Node insert(Node head, int insertVal) {
		if (head == null) {
			head = new Node(insertVal, null);
			head.next = head;
			return head;
		}

		if (insertVal < head.val) {
			Node tmp = new Node(insertVal, head);
			Node x = head;
			while (x.next != head) {
				x = x.next;
			}
			x.next = tmp;
			return tmp;
		}

		Node prev = head;
		Node curr = head.next;

		while (curr != head) {
			if (insertVal >= prev.val && insertVal <= curr.val) {
				break;// we found the spot
			}
			if (prev.val > curr.val) {
				if (insertVal >= prev.val || insertVal <= curr.val) {
					break;
				}
			}
			prev = prev.next;
			curr = curr.next;
		}

		Node temp = new Node(insertVal, prev.next);
		prev.next = temp;
		return head;

	}

	static class Node {
		public int val;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _next) {
			val = _val;
			next = _next;
		}
	}
}
