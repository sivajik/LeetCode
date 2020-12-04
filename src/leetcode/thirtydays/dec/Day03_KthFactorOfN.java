package leetcode.thirtydays.dec;

import java.util.*;

public class Day03_KthFactorOfN {

	public static void main(String[] args) {
		System.out.println(kthFactor(12, 3));

	}

	static public int kthFactor(int n, int k) {
		List<Integer> l = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				l.add(i);
			}
		}
		return l.size() < k ? -1 : l.get(k - 1);
	}
}
