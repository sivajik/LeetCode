package leetcode.thirtydays.mar21;

public class P04_ListIntersection {

	public static void main(String[] args) throws Exception {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		print(l1);

		ListNode lb1 = new ListNode(-3);
		ListNode lb2 = new ListNode(-2);
		ListNode lb3 = new ListNode(-1);
		ListNode lb4 = new ListNode(0);
		ListNode lb5 = new ListNode(8);

		lb1.next = lb2;
		lb2.next = lb3;
		lb3.next = lb4;
		lb4.next = lb5;
		lb5.next = l3;

		print(lb1);

		ListNode result = getIntersectionNode(l1, lb1);
		System.out.println(result != null ? result.val : null);
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1 = 0, len2 = 0;
		ListNode a = headA, b = headB;

		while (a != null) {
			len1++;
			a = a.next;
		}

		while (b != null) {
			len2++;
			b = b.next;
		}

		int diff = Math.abs(len1 - len2);
		ListNode biggerList = len1 > len2 ? headA : headB;
		ListNode smallerList = len1 <= len2 ? headA : headB;

		for (int i = 0; i < diff; i++) {
			biggerList = biggerList.next;
		}

		while (biggerList != null && smallerList != null) {
			if (biggerList == smallerList) {
				return biggerList;
			} else {
				biggerList = biggerList.next;
				smallerList = smallerList.next;
			}
		}
		return null;
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
