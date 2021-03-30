package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prov246_StrobogrammaticNumber {

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
		System.out.println(isStrobogrammatic("88"));
		System.out.println(isStrobogrammatic("692"));

	}

	static public boolean isStrobogrammatic(String num) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);

		int i = 0;
		int j = num.length() - 1;
		while (i <= j) {
			int l = num.charAt(i) - '0';
			int r = num.charAt(j) - '0';
			if (!map.containsKey(l) || map.get(l) != r) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
