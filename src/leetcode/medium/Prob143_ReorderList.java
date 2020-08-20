package leetcode.medium;

public class Prob143_ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode[] twoLists = splitList(head);
		ListNode first = twoLists[0];
		ListNode seco = twoLists[1];

		seco = reverse(seco);

		head = merge(first, seco);
	}

	static private ListNode merge(ListNode first, ListNode seco) {
		ListNode head = new ListNode(-999);
		ListNode ooo = head;

		while (first != null && seco != null) {
			ListNode temp1 = first.next;
			ListNode temp2 = seco.next;

			head.next = first;
			head = head.next;
			head.next = seco;
			head = head.next;

			first = temp1;
			seco = temp2;
		}

		if (first != null) {
			ListNode a = first;
			ListNode b = first.next;
			head.next = a;
			head = head.next;

			head.next = b;
			head = head.next;
		}

		return ooo.next;
	}

	static private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextElem = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextElem;
		}
		return prev;
	}

	static private ListNode[] splitList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			fast = fast.next;
		}
		ListNode second = slow.next;
		slow.next = null;
		ListNode first = head;

		return new ListNode[] { first, second };
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
