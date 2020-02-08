package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob1282_GroupPeople {

	public static void main(String[] args) {
		System.out.println(groupThePeople(new int[] { 2, 1, 3, 3, 3, 2 }));
		System.out.println(groupThePeople(new int[] { 3, 3, 3, 3, 3, 1, 3 }));
	}

	public static List<List<Integer>> groupThePeople(int[] groupSizes) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++) {
			int groupNumber = groupSizes[i];
			if (map.containsKey(groupNumber)) {
				map.get(groupNumber).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(groupNumber, list);
			}
		}
		List<List<Integer>> finalList = new ArrayList<>();

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int index = entry.getKey();
			List<Integer> list = entry.getValue();

			if (list.size() > index) {
				// split the list into "list.size() / index" parts.
				int times = list.size() / index;
				int fromIndex = 0;
				int toIndex = fromIndex + index;
				for (int i = 0; i < times; i++) {
					finalList.add(list.subList(fromIndex, toIndex));
					fromIndex = toIndex;
					toIndex = fromIndex + index;
				}
			} else {
				finalList.add(list);
			}
		}
		return finalList;
	}
}
