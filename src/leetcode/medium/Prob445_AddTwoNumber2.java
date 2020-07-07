package leetcode.medium;

import java.util.Stack;

public class Prob445_AddTwoNumber2 {

	public static void main(String[] args) {
		ListNode l1 = createList(new int[] { 0, 0, 0 });
		ListNode l2 = createList(new int[] { 9, 9, 9 });
		print(l1);
		print(l2);

		ListNode l3 = addTwoNumbers(l1, l2);
		print(l3);
	}

	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> s1 = new Stack<>();
		Stack<ListNode> s2 = new Stack<>();

		ListNode temp1 = l1;
		while (temp1 != null) {
			s1.push(temp1);
			temp1 = temp1.next;
		}

		ListNode temp2 = l2;
		while (temp2 != null) {
			s2.push(temp2);
			temp2 = temp2.next;
		}

		ListNode s3 = null;

		int carry = 0;
		int sum = 0;
		while (!s1.isEmpty() && !s2.isEmpty()) {
			sum += carry;
			sum += (s1.pop().val + s2.pop().val);

			carry = sum / 10;
			sum = sum % 10;
			if (s3 == null) {
				s3 = new ListNode(sum, null);
			} else {
				ListNode temp = new ListNode(sum, s3);
				s3 = temp;
			}
			sum = 0;
		}

		Stack<ListNode> s0 = s1.isEmpty() && !s2.isEmpty() ? s2 : s1;

		sum = 0;
		while (!s0.isEmpty()) {
			sum += carry;
			sum += (0 + s0.pop().val);

			carry = sum / 10;
			sum = sum % 10;
			if (s3 == null) {
				s3 = new ListNode(sum, null);
			} else {
				ListNode temp = new ListNode(sum, s3);
				s3 = temp;
			}
			sum = 0;
		}

		if (carry > 0) {
			ListNode temp = new ListNode(carry, s3);
			s3 = temp;
		}
		return s3;
	}

	private static void print(ListNode l1) {
		System.out.println("Printing List::");
		ListNode temp = l1;
		while (temp != null) {
			System.out.print(temp.val + ", ");
			temp = temp.next;
		}
		System.out.println("\n");
	}

	private static ListNode createList(int[] is) {
		ListNode head = null;
		for (int i = is.length - 1; i >= 0; i--) {
			ListNode temp = new ListNode(is[i], head);
			head = temp;
		}
		return head;
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
