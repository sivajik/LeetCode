package leetcode.easy;

public class Prob876_MiddleOfLinkedList {
	public static void main(String[] args) throws Exception {
		Solution1 s = new Solution1();
		s.add(1);
		// s.add(2);
		// s.add(3);
		// s.add(4);
		// s.add(5);
		// s.add(6);

		System.out.println(s.middleNode(s.getHead()));
	}
}

class Solution1 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + "]";
		}
	}

	ListNode head = null;
	int size = 0;

	public ListNode getHead() {
		return head;
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

	public ListNode middleNodeOld(ListNode head) {
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

	public void add(int value) {
		ListNode temp = new ListNode(value);
		if (head == null) {
			head = temp;
		} else {
			ListNode x = head;
			while (x.next != null) {
				x = x.next;
			}
			x.next = temp;
		}
		size++;
	}

	public void print() {
		ListNode temp = head;
		for (int i = 0; i < size; i++) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}