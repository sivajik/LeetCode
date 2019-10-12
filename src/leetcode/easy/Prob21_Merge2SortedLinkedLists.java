package leetcode.easy;

public class Prob21_Merge2SortedLinkedLists {
	public static void main(String[] args) throws Exception {
		ListNode l1 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l5 = new ListNode(1);
		ListNode l7 = new ListNode(1);

		l1.next = l3;
		l3.next = l5;
		l5.next = l7;

		ListNode l2 = new ListNode(1);
		ListNode l4 = new ListNode(1);
		ListNode l6 = new ListNode(1);
		ListNode l8 = new ListNode(1);

		l2.next = l4;
		l4.next = l6;
		l6.next = l8;

		print(l1);
		print(l2);
		ListNode merged = mergeTwoLists(l1, l2);
		print(merged);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode merged = null;

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		if (l1.val <= l2.val) {
			merged = l1;
			merged.next = mergeTwoLists(l1.next, l2);
		} else if (l1.val > l2.val) {
			merged = l2;
			merged.next = mergeTwoLists(l1, l2.next);
		}
		return merged;
	}

	private static void print(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
