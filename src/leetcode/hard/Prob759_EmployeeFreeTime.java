package leetcode.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prob759_EmployeeFreeTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Interval {
		public int start;
		public int end;

		public Interval() {
		}

		public Interval(int _start, int _end) {
			start = _start;
			end = _end;
		}
	};

	class Solution {
		public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

			PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
				public int compare(Interval i1, Interval i2) {
					return i1.start - i2.start;
				}
			});

			for (List<Interval> intervals : schedule) {
				for (Interval i : intervals) {
					pq.add(i);
				}
			}
			List<Interval> list = new ArrayList<>();

			while (pq.size() > 1) {
				Interval a = pq.poll();
				Interval b = pq.poll();

				if (a.end < b.start) {
					// a ends even before next one b starts.
					// time between a.end to b.start is free time.
					list.add(new Interval(a.end, b.start));
				}
				Interval c = new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
				pq.add(c);
			}
			return list;

		}
	}
}
