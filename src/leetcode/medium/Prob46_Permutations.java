package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob46_Permutations {

	public static void main(String[] args) {
		for (List<Integer> eachList : permuteUnique(new int[] { 1, 1,2})) {
			System.out.println(eachList);
		}

	}

	static public List<List<Integer>> permuteUnique(int[] nums) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, 1 + map.get(i));
			} else {
				map.put(i, 1);
			}
		}

		// A2 B1 C1
		int[] str = new int[map.size()];
		int[] counts = new int[map.size()];
		int index = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			str[index] = entry.getKey();
			counts[index] = entry.getValue();
			index++;
		}
		// A B C 2 1 1
		List<List<Integer>> finalList = new ArrayList<>();

		permuteUtil(str, counts, 0, new int[nums.length], finalList);
		return finalList;
	}

	private static void permuteUtil(int[] str, int[] counts, int level, int[] result, List<List<Integer>> finalList) {
		if (level == result.length) {
			print(result, finalList);
			return;
		}

		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == 0) {
				continue;
			}
			result[level] = str[i];
			counts[i]--;
			permuteUtil(str, counts, level + 1, result, finalList);
			counts[i]++;
		}

	}

	private static void print(int[] result, List<List<Integer>> finalList) {
		/* System.out.println(Arrays.toString(result));*/
		finalList.add(IntStream.of(result).boxed().collect(Collectors.toCollection(ArrayList::new)));
	}

}
