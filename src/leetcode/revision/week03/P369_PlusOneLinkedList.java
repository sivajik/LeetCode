package leetcode.revision.week03;

import java.util.*;

public class P369_PlusOneLinkedList {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne1(new int[] { 0 }))); // 1
		System.out.println();
		System.out.println(Arrays.toString(plusOne1(new int[] { 4 }))); // 5
		System.out.println();
		System.out.println(Arrays.toString(plusOne1(new int[] { 9 }))); // 10
		System.out.println();
		System.out.println(Arrays.toString(plusOne1(new int[] { 1, 2, 3 }))); // 124
		System.out.println();
		System.out.println(Arrays.toString(plusOne1(new int[] { 1, 2, 9 }))); // 130
		System.out.println();
		System.out.println(Arrays.toString(plusOne1(new int[] { 4, 3, 2, 1 }))); // 4322
		System.out.println();
		System.out.println(Arrays.toString(plusOne1(new int[] { 9, 8, 9 }))); // 990
		System.out.println();
		System.out.println(Arrays.toString(plusOne1(new int[] { 9, 9, 9 }))); // 1000

	}

	static public ListNode plusOne(ListNode head) {
		if (head == null) {
			return head;
		}
		Stack<ListNode> stk = new Stack<>();
		ListNode t = head;
		while (t != null) {
			stk.push(t);
			t = t.next;
		}

		int carry = 0;
		boolean lastNode = true;
		while (!stk.isEmpty()) {
			ListNode currNode = stk.pop();
			int newVal = currNode.val + (lastNode ? 1 : 0) + carry;
			lastNode = false;

			currNode.val = newVal % 10;
			carry = newVal / 10;
		}

		if (carry == 1) {
			ListNode x = new ListNode(1);
			x.next = head;
			return x;
		} else {
			return head;
		}
	}

	// ====
	static public int[] plusOne1(int[] x) {
		ListNode head = null;
		ListNode runnngNode = null;
		for (int elem : x) {
			if (head == null) {
				ListNode t = new ListNode(elem);
				runnngNode = t;
				head = t;
			} else {
				runnngNode.next = new ListNode(elem);
				runnngNode = runnngNode.next;
			}
		}
		System.out.println(Arrays.toString(print(head)));
		head = plusOne(head);
		return print(head);
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
