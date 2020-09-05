package leetcode.thirtydays.sep;

import java.util.ArrayList;
import java.util.List;

public class Day04_PartitionLabels {

	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}

	static public List<Integer> partitionLabels(String S) {
		// S cant be blank as per problem.

		int[] lastIndex = new int[26];
		for (int i = 0; i < S.length(); i++) {
			lastIndex[S.charAt(i) - 'a'] = i;
		}

		int start = 0;
		int end = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, lastIndex[S.charAt(i) - 'a']);
			if (i == end) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		return result;
	}
}