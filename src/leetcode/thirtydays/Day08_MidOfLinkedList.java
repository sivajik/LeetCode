package leetcode.thirtydays;

public class Day08_MidOfLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode mid = middleNode(head);
		System.out.println(mid.val);
	}

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}

	// 2 pointers one sprints at normal and other sprints at double speed.
	public static ListNode middleNode(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}

	// two way walking, waste of time. worst approach.
	public ListNode middleNode1(ListNode head) {
		ListNode temp = head;
		int sizeOfList = 0;
		while (temp != null) {
			temp = temp.next;
			sizeOfList++;
		}

		int index = 0;
		temp = head;
		while (index != sizeOfList / 2) {
			temp = temp.next;
			index++;
		}
		return temp;
	}
}
