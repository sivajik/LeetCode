package leetcode.revision.week02;

public class P2_AddTwoNumbers {

	public static void main(String[] args) {
		/*ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		
		ListNode l3 = addTwoNumbers(l1, l2);
		print(l3);*/
		
		/*
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = addTwoNumbers(l1, l2);
		print(l3);*/
		

		ListNode l1 = new ListNode(2);
		
		
		ListNode l2 = null;
		
		ListNode l3 = addTwoNumbers(l1, l2);
		print(l3);
	}

	private static void print(ListNode l3) {
		while (l3 != null) {
			System.out.print(l3.val + " , ");
			l3 = l3.next;
		}
	}

	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(-999);
		ListNode ans = l3;

		int carry = 0;

		while (l1 != null && l2 != null) {
			int sum = (carry + l1.val + l2.val);
			int val = (sum) % 10;

			if (sum >= 10) {
				carry = sum / 10;
			} else {
				carry = 0;
			}

			ListNode temp = new ListNode(val);
			l3.next = temp;
			l3 = l3.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		ListNode dummy = (l1 == null && l2 != null) ? l2 : l1;

		while (dummy != null) {
			int sum = (carry + dummy.val);
			int val = (sum) % 10;

			if (sum >= 10) {
				carry = sum / 10;
			} else {
				carry = 0;
			}

			ListNode temp = new ListNode(val);
			l3.next = temp;
			l3 = l3.next;
			dummy = dummy.next;
		}

		if (carry > 0) {
			ListNode temp = new ListNode(carry);
			l3.next = temp;
		}
		return ans.next;
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
