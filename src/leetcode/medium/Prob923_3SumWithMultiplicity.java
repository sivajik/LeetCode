package leetcode.medium;

import java.util.Arrays;

public class Prob923_3SumWithMultiplicity {

	public static void main(String[] args) {
		System.out.println(threeSumMulti(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, 8));

	}

	static public int threeSumMulti(int[] arr, int target) {
		Arrays.sort(arr);
		int ans = 0;
		int MOD = 1_000_000_007;

		for (int i = 0; i < arr.length; i++) {
			int t = target - arr[i];
			int j = i + 1;
			int k = arr.length - 1;

			while (j < k) {
				if (arr[j] + arr[k] < t) {
					j++;
				} else if (arr[j] + arr[k] > t) {
					k--;
				} else if (arr[j] != arr[k]) {
					// We have A[j] + A[k] == T.
					// Let's count "left": the number of A[j] == A[j+1] == A[j+2] == ...
					// And similarly for "right".

					int left = 1, right = 1;
					while (j + 1 < k && arr[j] == arr[j + 1]) {
						left++;
						j++;
					}

					while (k - 1 > j && arr[k] == arr[k - 1]) {
						right++;
						k--;
					}

					ans += (left * right);
					ans %= MOD;
					j++;
					k--;
				} else {
					// M = k - j + 1
					// We contributed M * (M-1) / 2 pairs.
					ans += (k - j + 1) * (k - j) / 2;
					ans %= MOD;
					break;
				}
			}
		}
		return (int) ans;
	}
}
