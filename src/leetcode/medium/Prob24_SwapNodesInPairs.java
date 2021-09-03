package leetcode.medium;

public class Prob24_SwapNodesInPairs {

	public static void main(String[] args) throws Exception {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		/*
		 * ListNode l5 = new ListNode(5); ListNode l6 = new ListNode(6); ListNode l7 =
		 * new ListNode(7); ListNode l8 = new ListNode(8);
		 */
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		/*
		 * l4.next = l5; l5.next = l6; l6.next = l7; l7.next = l8;
		 */
		print(l1);
		print(swapInPairs(l1));

	}

	public static ListNode swapInPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode curr = dummy;

		while (curr.next != null && curr.next.next != null) {
			ListNode first = curr.next;
			ListNode second = curr.next.next;
			ListNode secondNext = second.next;

			curr.next = second;
			second.next = first;
			first.next = secondNext;

			curr = curr.next.next;

		}
		return dummy.next;
	}

	private static void print(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
