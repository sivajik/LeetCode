package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob253_MeetingRooms2 {

	public static void main(String[] args) {
		System.out.println(minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
		System.out.println(minMeetingRooms(new int[][] { { 7, 10 }, { 2, 4 } }));

	}

	static public int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}

		});

		PriorityQueue<Integer> p = new PriorityQueue<>();
		p.add(intervals[0][1]);// add first meeting end time.

		for (int i = 1; i < intervals.length; i++) {
			int nextMeetingStartTime = intervals[i][0];
			int nextMeetingEndTime = intervals[i][1];

			if (nextMeetingStartTime >= p.peek()) {
				// next meeting starts AFTER last meeting, so no need of new room.
				p.poll();
			}

			p.add(nextMeetingEndTime);
		}
		return p.size();
	}
}
