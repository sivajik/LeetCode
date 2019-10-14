package leetcode.easy;

import java.util.Arrays;
import java.util.Stack;

public class Prob234_IsPlaindromeList {

	public static void main(String[] args) throws Exception {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(1);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		print(l1);
		System.out.println(isPalindrome(l1));

	}

	public static boolean isPalindrome(ListNode head) {
		Stack<Integer> stack = new Stack<Integer>();

		ListNode curr = head;
		while (curr != null) {
			stack.push(curr.val);
			curr = curr.next;
		}
		boolean isPalindrome = true;
		curr = head;
		while (curr != null) {
			if (curr.val != stack.pop()) {
				isPalindrome = false;
				break;
			} else {
				curr = curr.next;
			}
		}
		System.out.println(Arrays.toString(stack.toArray()));
		return isPalindrome;
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
