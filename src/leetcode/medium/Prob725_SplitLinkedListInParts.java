package leetcode.medium;

import java.util.Arrays;

public class Prob725_SplitLinkedListInParts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode[] splitListToParts(ListNode root, int k) {

		if (root == null) {
			return new ListNode[k];
		}
		ListNode[] op = new ListNode[k];
		int[] size = new int[k];

		ListNode temp = root;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.next;
		}

		int eachListSize;
		if (len < k) {
			eachListSize = 1;
			Arrays.fill(size, 1);
		} else {
			eachListSize = len / k;
			int remaining = len % k;
			for (int i = 0; i < k; i++) {
				if (remaining > 0) {
					size[i] = eachListSize;
					size[i]++;
					remaining--;
				} else {
					size[i] = eachListSize;
				}

			}
		}

		System.out.println(Arrays.toString(size));

		ListNode startCurrNode = root;
		ListNode prev = null;
		for (int i = 0; i < size.length; i++) {
			int lenOfList = size[i];
			ListNode localStart = startCurrNode;
			if (startCurrNode == null) {
				op[i] = null;
			} else {
				while (lenOfList > 0) {
					prev = startCurrNode;
					startCurrNode = startCurrNode.next;
					lenOfList--;
				}
				prev.next = null;
				op[i] = localStart;
			}
		}
		return op;
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
