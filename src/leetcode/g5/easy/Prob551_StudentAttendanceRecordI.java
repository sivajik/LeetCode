package leetcode.g5.easy;

public class Prob551_StudentAttendanceRecordI {

	public static void main(String[] args) {
		System.out.println(checkRecord("PPALLP"));
		System.out.println(checkRecord("PPALLL"));
	}

	/*
	 * The student was absent ('A') for strictly fewer than 2 days total. The
	 * student was never late ('L') for 3 or more consecutive days.
	 */
	static public boolean checkRecord(String s) {
		int absentCnt = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'A') {
				absentCnt++;
			}
		}
		return absentCnt < 2 && s.indexOf("LLL") == -1;
	}
}
