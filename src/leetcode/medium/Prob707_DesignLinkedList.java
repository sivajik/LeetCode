package leetcode.medium;

public class Prob707_DesignLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode prev;

		ListNode(int x) {
			val = x;
		}
	}

	static class MyLinkedList {
		int size;
		// sentinel nodes as pseudo-head and pseudo-tail
		ListNode head, tail;

		public MyLinkedList() {
			size = 0;
			head = new ListNode(-999);
			tail = new ListNode(-999);
			head.next = tail;
			tail.prev = head;
		}

		public int get(int index) {
			if (index < 0 || index >= size)
				return -1;

			ListNode curr = head;
			for (int i = 0; i < index + 1; ++i)
				curr = curr.next;

			return curr.val;
		}

		public void addAtHead(int val) {
			ListNode pred = head, succ = head.next;

			++size;
			ListNode toAdd = new ListNode(val);
			toAdd.prev = pred;
			toAdd.next = succ;
			pred.next = toAdd;
			succ.prev = toAdd;
		}

		public void addAtTail(int val) {
			ListNode succ = tail, pred = tail.prev;

			++size;
			ListNode toAdd = new ListNode(val);
			toAdd.prev = pred;
			toAdd.next = succ;
			pred.next = toAdd;
			succ.prev = toAdd;
		}

		public void addAtIndex(int index, int val) {
			if (index > size)
				return;

			if (index < 0)
				index = 0;

			// find predecessor and successor of the node to be added
			ListNode pred, succ;
			pred = head;
			for (int i = 0; i < index; ++i)
				pred = pred.next;
			succ = pred.next;

			// insertion itself
			++size;
			ListNode toAdd = new ListNode(val);
			toAdd.prev = pred;
			toAdd.next = succ;
			pred.next = toAdd;
			succ.prev = toAdd;
		}

		/** Delete the index-th node in the linked list, if the index is valid. */
		public void deleteAtIndex(int index) {
			if (index < 0 || index >= size)
				return;

			// find predecessor and successor of the node to be deleted
			ListNode pred, succ;
			pred = head;
			for (int i = 0; i < index; ++i)
				pred = pred.next;
			succ = pred.next.next;

			// delete pred.next
			--size;
			pred.next = succ;
			succ.prev = pred;
		}
	}
}