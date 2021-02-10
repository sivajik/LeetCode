package leetcode.thirtydays.feb;

import java.util.HashMap;
import java.util.Map;

public class P10_CopyListWithRandomPointer {

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
		Node newList = new Node(-999);
		Node originalNew = newList;

		Map<Node, Node> map = new HashMap<>();
		Node oldList = head;
		// populate normal 'val' values.
		while (oldList != null) {
			Node temp = new Node(oldList.val);
			newList.next = temp;
			newList = newList.next;

			map.put(oldList, temp);

			oldList = oldList.next;
		}

		// print(originalNew.next);

		// populate 'random' pointer
		Node t = originalNew.next;
		oldList = head;
		while (oldList != null) {
			Node oldRandomPointer = oldList.random;
			if (oldRandomPointer != null) {
				Node newRandomPointer = map.get(oldRandomPointer);
				t.random = newRandomPointer;
				t = t.next;
			} else {
				t.random = null;
				t = t.next;
			}
			oldList = oldList.next;
		}
		return originalNew.next;
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
