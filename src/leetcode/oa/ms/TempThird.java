package leetcode.oa.ms;

import java.util.HashMap;
import java.util.HashSet;

public class TempThird {

	public static void main(String[] args) {
		System.out.println(solution(3, "1B 1C 1H 2F 3A 3K"));
		System.out.println(solution(2, "1A 2F 1C"));
		System.out.println(solution(1, ""));
	}
	// well commented code, user created test input,no overreliance on libraries

	static public int solution(int N, String S) {
		if (N == 1 && S.equalsIgnoreCase("")) {
			return 2;
		}
		/*
		 * convert seat numbers to a 2d array. Note: they did not give column I so
		 * handle it carefully.
		 */
		String[] tokens = S.split(" ");
		int seatCount = tokens.length;
		int[][] reserved = new int[seatCount][2];
		int counter = 0;
		for (String eachSeat : S.split(" ")) {
			// System.out.println(eachSeat);
			int[] tempSeat = new int[2];
			tempSeat[0] = eachSeat.charAt(0) - '0'; // since rows starts from 1.
			if (eachSeat.charAt(1) == 'K' || eachSeat.charAt(1) == 'J') {
				tempSeat[1] = eachSeat.charAt(1) - 'A';
			} else {
				tempSeat[1] = eachSeat.charAt(1) - 'A' + 1; // in flights we dont have col I
			}
			reserved[counter++] = tempSeat;
		}

		HashMap<Integer, HashSet<Integer>> seaatMap = new HashMap<>();
		for (int[] seat : reserved) {
			// no need of processing first and last columns,
			if (seat[1] == 1 || seat[1] == 10)
				continue;
			seaatMap.computeIfAbsent(seat[0], x -> new HashSet<>()).add(seat[1]);
		}

		int count = 0;
		count += (N - seaatMap.size()) * 2;
		// O(keys) is enough to do this.
		// since map.contains is O(1) operation.
		for (int row : seaatMap.keySet()) {
			int groups = 0;
			HashSet<Integer> set = seaatMap.get(row);
			// seat 2,3,4,5 (aisles) with one break. left side
			if (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5))
				groups++;
			// seats 6,7,8,9 (aisles) with one break. right side
			if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9))
				groups++;
			// seats 4,5,6,7 - all in one row with no break.
			if (groups == 0) {
				if (!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7))
					groups++;
			}
			count += groups;
		}
		return count;
	}
}
