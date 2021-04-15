package leetcode.medium;

public class Prob328_EvenOddPositionList {

	public static void main(String[] args) throws Exception {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		print(l1);

		print(OddEventList(l1));
	}

	public static ListNode OddEventList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public static ListNode OddEventList1(ListNode head) {
		ListNode origOdd = head;
		ListNode odd = head;
		ListNode origEven = origOdd.next;
		ListNode even = odd.next;

		if (origEven == null || origOdd == null) {
			return origOdd;
		}

		while (odd != null && odd.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd != null && odd.next != null ? odd.next : null;
			even = even.next != null ? even.next : null;
		}
		origOdd.next = origEven;
		return origOdd;
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
