package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob721_AccountsMerge {

	public static void main(String[] args) {
		List<List<String>> a = new ArrayList<>();

		a.add(Arrays.asList(new String[] { "John", "johnsmith@mail.com", "john00@mail.com" }));
		a.add(Arrays.asList(new String[] { "John", "johnnybravo@mail.com" }));
		a.add(Arrays.asList(new String[] { "John", "johnsmith@mail.com", "john_newyork@mail.com" }));
		a.add(Arrays.asList(new String[] { "Mary", "mary@mail.com" }));

		for (List<String> l : accountsMerge(a)) {
			System.out.println(l);
		}

	}

	static public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> email2Name = new HashMap<>();
		Map<String, Integer> email2Id = new HashMap<>();
		int id = 0;
		DisjoinSet d = new DisjoinSet();
		for (List<String> listOfStr : accounts) {
			String name = "";
			String firstEmail = listOfStr.get(1);
			for (String email : listOfStr) {
				if (name.equals("")) {
					name = email;
					continue;
				}
				email2Name.put(email, name);
				if (!email2Id.containsKey(email)) {
					email2Id.put(email, id++);
				}
				d.union(email2Id.get(firstEmail), email2Id.get(email));
			}
		}

		Map<Integer, List<String>> ans = new HashMap<>();
		for (String email : email2Name.keySet()) {
			int index = d.find(email2Id.get(email));
			ans.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
		}
		for (List<String> component : ans.values()) {
			Collections.sort(component);
			component.add(0, email2Name.get(component.get(0)));
		}
		return new ArrayList(ans.values());
	}
}

class DisjoinSet {
	int[] parents;

	DisjoinSet() {
		int n = 20000;
		this.parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	public int find(int i) {
		if (parents[i] == i) {
			return i;
		}
		return parents[i] = find(parents[i]);
	}

	public void union(int a, int b) {
		int repOfA = find(a);
		int repOfB = find(b);
		this.parents[repOfA] = repOfB;
	}
}