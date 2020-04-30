package leetcode.thirtydays.april;

import java.util.HashMap;
import java.util.Map;

public class Day02_HappyNumber {

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			System.out.println(i + " => " + isHappy(i));
		}
	}

	public static boolean isHappy(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		while (n != 1) {
			int sum = 0;
			while (n > 0) {
				sum = sum + ((n % 10) * (n % 10));
				n = n / 10;
			}
			n = sum;
			// System.out.println(sum);
			if (map.containsKey(sum)) {
				return false;
			} else {
				map.put(sum, sum);
			}
		}
		return true;
	}
}
