package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P143_ReorderList {

	public static void main(String[] args) {
		ListNode l1 = createList(new int[] { 1});
		reorderList(l1);
		System.out.println(Arrays.toString(print(l1)));
	}

	static public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		
		ListNode[] arr = split(head);
		ListNode l1 = arr[0];

		ListNode l2 = arr[1];
		l2 = reverse(l2);

//		System.out.println(Arrays.toString(print(l1)));
//		System.out.println(Arrays.toString(print(l2)));

		ListNode l3 = merge(l1, l2);
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(-999);
		ListNode iii = l3;

		while (l1 != null && l2 != null) {
			ListNode l1Next = l1.next;
			ListNode l2Next = l2.next;

			l3.next = l1;
			l3 = l3.next;

			l1.next = l2;
			l2.next = l1Next;
			l3 = l3.next;

			l1 = l1Next;
			l2 = l2Next;
		}

		if (l1 == null && l2 != null) {
			l3.next = l2;
		} else if (l1 != null && l2 == null) {
			l3.next = l1;
		}
		return iii.next;
	}

	private static ListNode[] split(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (slow != null && fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// 1 2 3 4 5
		return new ListNode[] { head, slow };
	}

	static public ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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
