package leetcode.medium;

public class Prob19_RemoveLastnthNode {

	public static void main(String[] args) throws Exception {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		print(l1);
		//print(removeNthFromEnd(l1, 5));
		//print(removeNthFromEnd(l1, 4));
		//print(removeNthFromEnd(l1, 3));
		//print(removeNthFromEnd(l1, 2));
		print(removeNthFromEnd(l1, 1));

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		for (int i = 1; i <= n; i++) {
			fastPtr = fastPtr.next;
		}

		if (fastPtr == null) {
			return head.next;
		}

		ListNode prev = slowPtr;
		while (fastPtr != null) {
			prev = slowPtr;
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}

		{
			prev.next = slowPtr.next;
			return head;
		}
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
