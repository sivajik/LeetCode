package leetcode.revision.week02;

import java.util.ArrayList;
import java.util.List;

public class P763_PartitionLabels {

	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}

	static public List<Integer> partitionLabels(String S) {
		int[] lastIndex = new int[26];
		for (int i = 0; i < S.length(); i++) {
			lastIndex[S.charAt(i) - 'a'] = i;
		}

		List<Integer> l = new ArrayList<>();
		int start = 0, end = 0;
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(lastIndex[S.charAt(i) - 'a'], end);
			if (i == end) {
				l.add(end - start + 1);
				start = end + 1;
			}
		}
		return l;
	}
}
