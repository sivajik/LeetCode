package leetcode.medium;

public class Prob147_InsertionSortList {

	public static void main(String[] args) {
		ListNode a = new ListNode(4);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(3);

		link(a, b);
		link(b, c);
		link(c, d);
		print(a);
		print(insertionSortList(a));
	}

	static public ListNode insertionSortList(ListNode head) {
		ListNode sorted = null;

		ListNode temp = head;
		while (temp != null) {
			ListNode nextNode = temp.next;

			temp.next = null;
			sorted = insertToList(sorted, temp);

			temp = nextNode;
		}

		return sorted;
	}

	static ListNode insertToList(ListNode head, ListNode nodeToPut) {
		if (head == null) {
			head = nodeToPut;
			return head;
		} else {
			ListNode temp = head;
			ListNode prev = null;
			while (temp != null && temp.val < nodeToPut.val) {
				prev = temp;
				temp = temp.next;
			}
			if (prev == null) {
				nodeToPut.next = temp;
				head = nodeToPut;
			} else {
				prev.next = nodeToPut;
				nodeToPut.next = temp;
			}
			return head;
		}
	}

	private static void link(ListNode a, ListNode b) {
		a.next = b;
	}

	static public void print(ListNode head) {
		ListNode t = head;
		while (t != null) {
			System.out.print(t.val + " ");
			t = t.next;
		}
		System.out.println();
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
