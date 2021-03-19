package leetcode.medium;

public class Prob769_MaxChunksToMakeSorted {

	public static void main(String[] args) {
		System.out.println(maxChunksToSorted(new int[] { 4, 3, 2, 1, 0 }));
	}

	static public int maxChunksToSorted(int[] arr) {
		int ans = 0, max = 0;
		for (int i = 0; i < arr.length; ++i) {
			max = Math.max(max, arr[i]);
			if (max == i)
				ans++;
		}
		return ans;
	}
}
