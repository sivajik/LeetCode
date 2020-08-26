package leetcode.thirtydays.august;

import java.util.ArrayList;
import java.util.List;

public class Day25_FizzBuzz {

	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));

	}

	/*
	 * can't believe this is a leetcode question :(
	 */
	public static List<String> fizzBuzz(int n) {
		List<String> l = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				l.add("FizzBuzz");
				continue;
			}

			if (i % 3 == 0) {
				l.add("Fizz");
				continue;
			}

			if (i % 5 == 0) {
				l.add("Buzz");
				continue;
			}

			l.add(Integer.toString(i));
		}

		return l;
	}
}
