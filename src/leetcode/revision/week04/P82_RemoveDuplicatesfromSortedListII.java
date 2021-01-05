package leetcode.revision.week04;

public class P82_RemoveDuplicatesfromSortedListII {

	public static void main(String[] args) {

		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);

		link(n0, n1);
		link(n1, n2);
		link(n2, n3);
		link(n3, n4);
		link(n4, n5);
		link(n5, n6);

		print(n0);
		print(deleteDuplicates(n0));

	}

	static public ListNode deleteDuplicates(ListNode head) {
		ListNode sentinal = new ListNode(-999);
		sentinal.next = head;

		// 1 2 3 3 4 4 5
		ListNode curr = head;
		ListNode prev = sentinal;
		while (curr != null) {
			if (curr.next != null && curr.val == curr.next.val) {
				while (curr.next != null && curr.val == curr.next.val) {
					curr = curr.next;
				}
				prev.next = curr.next;
			} else {
				prev = curr;
			}
			curr = curr.next;
		}

		return sentinal.next;
	}

	private static void link(ListNode n2, ListNode n4) {
		n2.next = n4;
	}

	private static void print(ListNode n1) {
		ListNode temp = n1;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
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
