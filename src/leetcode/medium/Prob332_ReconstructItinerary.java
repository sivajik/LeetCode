package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Prob332_ReconstructItinerary {

	public static void main(String[] args) {
		List<List<String>> l = new ArrayList<>();
		l.add(Arrays.asList(new String[] { "MUC", "LHR" }));
		l.add(Arrays.asList(new String[] { "JFK", "MUC" }));
		l.add(Arrays.asList(new String[] { "SFO", "SJC" }));
		l.add(Arrays.asList(new String[] { "LHR", "SFO" }));

		System.out.println(findItinerary(l));
	}

	static public List<String> findItinerary(List<List<String>> tickets) {
		java.util.Map<String, PriorityQueue<String>> map = new java.util.HashMap<String, PriorityQueue<String>>();

		for (List<String> pair : tickets) {
			if (map.containsKey(pair.get(0))) {
				PriorityQueue<String> p = map.get(pair.get(0));
				p.add(pair.get(1));
				map.put(pair.get(0), p);
			} else {
				PriorityQueue<String> p = new PriorityQueue<>();
				p.add(pair.get(1));
				map.put(pair.get(0), p);
			}
		}

		List<String> result = new ArrayList<String>();
		dfs("JFK", map, result);
		return result;
	}

	private static void dfs(String startFrom, Map<String, PriorityQueue<String>> map, List<String> result) {
		PriorityQueue<String> p = map.get(startFrom);
		while (p != null && !p.isEmpty()) {
			String x = p.poll();
			if (x != null)
				dfs(x, map, result);
		}
		result.add(0, startFrom);
	}

}
