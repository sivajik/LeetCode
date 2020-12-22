package leetcode.revision.week03;

import java.util.*;

public class P332_ReconstructItinerary {

	public static void main(String[] args) {
		List<List<String>> l = new ArrayList<>();
		l.add(Arrays.asList(new String[] { "MUC", "LHR" }));
		l.add(Arrays.asList(new String[] { "JFK", "MUC" }));
		l.add(Arrays.asList(new String[] { "SFO", "SJC" }));
		l.add(Arrays.asList(new String[] { "LHR", "SFO" }));

		System.out.println(findItinerary(l));

	}

	static public List<String> findItinerary(List<List<String>> tickets) {
		List<String> l = new ArrayList<>();

		Map<String, PriorityQueue<String>> m = new HashMap<>();

		for (List<String> paifOfTkts : tickets) {
			String start = paifOfTkts.get(0);
			String end = paifOfTkts.get(1);

			if (m.containsKey(start)) {
				PriorityQueue<String> q = m.get(start);
				q.add(end);
				m.put(start, q);
			} else {
				PriorityQueue<String> q = new PriorityQueue<>();
				q.add(end);
				m.put(start, q);
			}
		}

		dfs("JFK", l, m);
		return l;
	}

	private static void dfs(String startAt, List<String> l, Map<String, PriorityQueue<String>> m) {
		PriorityQueue<String> p = m.get(startAt);
		while (p != null && !p.isEmpty()) {
			String dest = p.poll();
			dfs(dest, l, m);
		}
		l.add(0, startAt);
	}
}
