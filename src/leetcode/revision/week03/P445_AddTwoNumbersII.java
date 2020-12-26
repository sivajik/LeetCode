package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P445_AddTwoNumbersII {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				print(addTwoNumbers(createList(new int[] { 7, 2, 4, 3 }), createList(new int[] { 5, 6, 4 })))));

		System.out.println(Arrays
				.toString(print(addTwoNumbers(createList(new int[] { 7, 2 }), createList(new int[] { 9, 9, 9, 9 })))));

		System.out.println(
				Arrays.toString(print(addTwoNumbers(createList(new int[] { 0 }), createList(new int[] { 1, 1, 1 })))));

		System.out.println(
				Arrays.toString(print(addTwoNumbers(createList(new int[] { 9, 9, 9 }), createList(new int[] { 1 })))));

	}

	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> s1 = pushToStack(l1);
		Stack<ListNode> s2 = pushToStack(l2);

		int carry = 0;

		ListNode l3 = null;

		while (!s1.isEmpty() && !s2.isEmpty()) {
			ListNode n1 = s1.pop();
			ListNode n2 = s2.pop();

			int newVal = n1.val + n2.val + carry;

			if (l3 == null) {
				l3 = new ListNode(newVal % 10);
				carry = newVal / 10;
			} else {
				ListNode temp = new ListNode(newVal % 10);
				carry = newVal / 10;
				temp.next = l3;
				l3 = temp;
			}
		}

		Stack<ListNode> s3 = null;
		if (s1.isEmpty() && !s2.isEmpty()) {
			s3 = s2;
		} else {
			s3 = s1;
		}

		while (!s3.isEmpty()) {
			int newVal = s3.pop().val + carry;
			ListNode temp = new ListNode(newVal % 10);
			carry = newVal / 10;
			temp.next = l3;
			l3 = temp;
		}

		if (carry > 0) {
			ListNode temp = new ListNode(1);
			temp.next = l3;
			l3 = temp;
		}
		return l3;
	}

	static private Stack<ListNode> pushToStack(ListNode l1) {
		Stack<ListNode> s = new Stack<>();
		ListNode t = l1;
		while (t != null) {
			s.push(t);
			t = t.next;
		}
		return s;
	}

// ===

	private static ListNode createList(int[] is) {
		ListNode head = null;
		for (int i = is.length - 1; i >= 0; i--) {
			ListNode temp = new ListNode(is[i], head);
			head = temp;
		}
		return head;
	}

	static public int[] print(ListNode h) {
		List<Integer> list = new ArrayList<>();

		ListNode t = h;
		while (t != null) {
			list.add(t.val);
			t = t.next;
		}

		int[] re = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			re[i] = list.get(i);
		}
		return re;
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
