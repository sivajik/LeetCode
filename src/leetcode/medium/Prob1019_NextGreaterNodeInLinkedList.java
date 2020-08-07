package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * could have improved using stacks, montonic approach.
 */
public class Prob1019_NextGreaterNodeInLinkedList {

	public static void main(String[] args) {
		m0();
		// m1();
		// m2();
		// m3();
	}

	public static void m0() {
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(1);
		ListNode l6 = new ListNode(8);
		ListNode l7 = new ListNode(10);

		// 1,7,5,1,9,2,5,1
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;

		System.out.println(Arrays.toString(nextLargerNodes(l1)));
	}

	private static void m1() {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;

		System.out.println(Arrays.toString(nextLargerNodes(l1)));
	}

	private static void m2() {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(7);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		System.out.println(Arrays.toString(nextLargerNodes(l1)));
	}

	private static void m3() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(7);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(9);
		ListNode l6 = new ListNode(2);
		ListNode l7 = new ListNode(5);
		ListNode l8 = new ListNode(1);

		// 1,7,5,1,9,2,5,1
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;

		System.out.println(Arrays.toString(nextLargerNodes(l1)));
	}

	static public int[] nextLargerNodes(ListNode head) {
		ListNode temp = head;

		List<Integer> resultList = new ArrayList<>();

		while (temp != null) {
			ListNode nextNode = temp.next;

			while (nextNode != null && temp.val >= nextNode.val) {
				nextNode = nextNode.next;
			}

			if (nextNode == null) { // reached end with no bigger elem
				resultList.add(0);
			} else {
				resultList.add(nextNode.val);
			}
			temp = temp.next;
		}

		int[] r = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			r[i] = resultList.get(i);
		}
		return r;
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
