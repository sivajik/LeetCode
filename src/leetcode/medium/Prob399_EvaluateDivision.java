package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prob399_EvaluateDivision {

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		double[] values = new double[] { 2.0, 3.0 };
		List<List<String>> queries = new ArrayList<>();

		equations.add(0, Arrays.asList(new String[] { "a", "b" }));
		equations.add(1, Arrays.asList(new String[] { "b", "c" }));

		queries.add(0, Arrays.asList(new String[] { "a", "c" }));
		queries.add(1, Arrays.asList(new String[] { "b", "a" }));
		queries.add(2, Arrays.asList(new String[] { "a", "e" }));
		queries.add(3, Arrays.asList(new String[] { "a", "a" }));
		queries.add(4, Arrays.asList(new String[] { "x", "x" }));

		System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
	}

	static public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

		Map<String, Map<String, Double>> adjMap = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			List<String> eachEq = equations.get(i);

			String dividend = eachEq.get(0);
			String divisor = eachEq.get(1);
			double quo = values[i];

			if (!adjMap.containsKey(dividend)) {
				adjMap.put(dividend, new HashMap<>());
			}
			if (!adjMap.containsKey(divisor)) {
				adjMap.put(divisor, new HashMap<>());
			}

			adjMap.get(dividend).put(divisor, quo);
			adjMap.get(divisor).put(dividend, 1 / quo);
		}

		double[] ans = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			List<String> qry = queries.get(i);
			String dividend = qry.get(0);
			String divisor = qry.get(1);

			if (!adjMap.containsKey(dividend) || !adjMap.containsKey(divisor)) {
				ans[i] = -1.0;
			} else if (dividend.equals(divisor)) {
				ans[i] = 1.0;
			} else {
				Set<String> visited = new HashSet<>();
				ans[i] = dfs(adjMap, dividend, divisor, visited, 1);
			}
		}

		return ans;
	}

	private static double dfs(Map<String, Map<String, Double>> adjMap, String start, String end, Set<String> visited,
			double prod) {
		visited.add(start);

		double ret = -1;

		Map<String, Double> neighbors = adjMap.get(start);
		if (neighbors.containsKey(end)) {
			ret = prod * neighbors.get(end);
		} else {
			for (String eachNei : neighbors.keySet()) {
				if (visited.contains(eachNei)) {
					continue;
				}
				ret = dfs(adjMap, eachNei, end, visited, prod * neighbors.get(eachNei));
				if (ret != -1) {
					break;
				}
			}
		}
		visited.remove(start);
		return ret;
	}
}
