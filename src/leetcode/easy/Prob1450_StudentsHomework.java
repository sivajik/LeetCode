package leetcode.easy;

public class Prob1450_StudentsHomework {

	public static void main(String[] args) {
		System.out.println(busyStudent(new int[] { 1, 2, 3 }, new int[] { 3, 2, 7 }, 4));
		System.out.println(busyStudent(new int[] { 4 }, new int[] { 4 }, 4));
		System.out.println(busyStudent(new int[] { 4 }, new int[] { 4 }, 5));
		System.out.println(busyStudent(new int[] { 1, 1, 1, 1 }, new int[] { 1, 3, 2, 4 }, 7));
		System.out.println(busyStudent(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 },
				new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 5));
	}

	public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int c = 0;
		for (int i = 0; i < startTime.length; i++) {
			if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
				c++;
			}
		}
		return c;
	}
}
