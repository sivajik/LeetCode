package leetcode.hard;

import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode();
		l1.add(1);
		l1.add(3);
		l1.add(5);
		l1.add(7);
		l1.add(9);
		l1 = l1.reverse();
		l1.print();

		ListNode l2 = new ListNode();
		l2.add(2);
		l2.add(4);
		l2.add(6);
		l2.add(8);
		l2.add(10);
		l2 = l2.reverse();
		l2.print();

		ListNode l3 = new ListNode();
		l3.add(1);
		l3.add(13);
		l3.add(15);
		l3.add(17);
		l3.add(19);
		l3 = l3.reverse();
		l3.print();

		ListNode l4 = new ListNode();
		l4.add(12);
		l4.add(14);
		l4.add(16);
		l4.add(18);
		l4.add(20);
		l4 = l4.reverse();
		l4.print();

		ListNode[] lists = new ListNode[4];
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l2;
		lists[3] = l3;

		ListNode result = mergeKLists(lists);
		result = result.reverse();
		result.print();
	}

	static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		for (ListNode listX : lists) {
			for (Node x = listX.first; x != null; x = x.next) {
				p.add(x.data);
			}
		}

		ListNode result = new ListNode();
		while (!p.isEmpty()) {
			result.add(p.remove());
		}
		return result;
	}
}

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

class ListNode {
	Node first;

	void add(int data) {
		if (first == null) {
			first = new Node(data, null);
		} else {
			first = new Node(data, first);
		}
	}

	ListNode reverse() {
		ListNode reverse = new ListNode();
		for (Node x = first; x != null; x = x.next) {
			reverse.add(x.data);
		}
		return reverse;
	}

	void print() {
		System.out.println("---- List ----");
		for (Node x = first; x != null; x = x.next) {
			System.out.print(x.data + " ");
		}
		System.out.println("\n");
	}
}