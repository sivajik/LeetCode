package leetcode.easy;

public class Prob1290_ConvertBintoInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getDecimalValue(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val);
			head = head.next;
		}
		
		return Integer.parseInt(sb.toString(), 2);
	}
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}

