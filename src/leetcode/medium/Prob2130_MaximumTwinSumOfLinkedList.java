package leetcode.medium;

import java.util.Stack;

public class Prob2130_MaximumTwinSumOfLinkedList {

	public static void main(String[] args) {
		ListNode l = createList(new int[] { 5,4,2,1 });
		System.out.println(pairSum(l));
	}

	static public int pairSum(ListNode head) {
		Stack<ListNode> s = new Stack<>();
		ListNode temp = head;
		while (temp != null) {
			s.push(temp);
			temp = temp.next;
		}

		temp = head;
		int sum = Integer.MIN_VALUE;
		int loops = s.size();
		while (loops > 0) {
			int newSum = temp.val + s.pop().val;
			if (newSum > sum) {
				sum = newSum;
			}
			temp = temp.next;
			loops -= 2;
		}
		return sum;
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
