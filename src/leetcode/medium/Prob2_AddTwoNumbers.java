package leetcode.medium;

public class Prob2_AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1_0 = new ListNode(2);
		ListNode l1_1 = new ListNode(4);
		ListNode l1_2 = new ListNode(3);

		l1_0.next = l1_1;
		l1_1.next = l1_2;

		ListNode l2_0 = new ListNode(5);
		ListNode l2_1 = new ListNode(6);
		ListNode l2_2 = new ListNode(9);
		ListNode l2_3 = new ListNode(9);
		ListNode l2_4 = new ListNode(1);

		l2_0.next = l2_1;
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		l2_3.next = l2_4;

		print(l1_0);
		print(l2_0);

		ListNode l3 = addTwoNumbers(l1_0, l2_0);
		print(l3);
	}

	/*
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
	 * 465 = 807.
	 */
	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode head = result;
		int carry = 0;
		while (l1 != null && l2 != null) {
			ListNode temp = new ListNode((l1.val + l2.val + carry) % 10);
			carry = (l1.val + l2.val + carry) / 10;
			result.next = temp;
			result = result.next;

			l1 = l1.next;
			l2 = l2.next;
		}

		ListNode l3 = (l1 == null & l2 != null) ? l2 : l1;

		while (l3 != null) {
			ListNode temp = new ListNode((l3.val + 0 + carry) % 10);
			carry = (l3.val + 0 + carry) / 10;
			result.next = temp;
			result = result.next;
			l3 = l3.next;
		}

		if (carry > 0) {
			result.next = new ListNode(carry);
		}
		return head.next;
	}

	public static void print(ListNode l) {
		ListNode temp = l;
		while (temp != null) {
			System.out.print(temp.val);
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
