package leetcode.thirtydays.june;

public class Day05_RandomPickWeight {

	public static void main(String[] args) {
		Solution obj = new Solution(new int[] { 1, 3 });
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());

	}

}

class Solution {

	private int[] cumSum;
	private java.util.Random rand;

	public Solution(int[] w) {
		rand = new java.util.Random();
		cumSum = new int[w.length + 1];
		cumSum[0] = 0;
		for (int i = 0; i < w.length; i++) {
			cumSum[i + 1] = cumSum[i] + w[i];
		}
	}

	public int pickIndex() {
		int pos = rand.nextInt(cumSum[cumSum.length - 1]) + 1;
		return binarySearch(pos) - 1;
	}

	private int binarySearch(int pos) {
		int left = 0, right = cumSum.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (cumSum[mid] < pos)
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
}