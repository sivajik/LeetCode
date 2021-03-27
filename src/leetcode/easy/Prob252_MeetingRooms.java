package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class Prob252_MeetingRooms {

	public static void main(String[] args) {
		System.out.println(canAttendMeetings(new int[][] { { 7, 10 }, { 2, 4 } }));
		System.out.println(canAttendMeetings(new int[][] { {0,30},{5,10},{15,20} }));
	}

	static public boolean canAttendMeetings(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return true;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		int prevMeetEndTime = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int nextMeetStartTime = intervals[i][0];
			if (prevMeetEndTime <= nextMeetStartTime) {
				prevMeetEndTime = intervals[i][1];
			} else {
				return false;
			}
		}
		return true;
	}
}
