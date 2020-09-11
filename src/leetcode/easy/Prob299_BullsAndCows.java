package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob299_BullsAndCows {

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1123", "0111"));
		System.out.println(getHint("11231", "01111"));
	}

	static public String getHint(String secret, String guess) {
		int bullCounter = 0;
		int cowCounter = 0;

		char[] s = secret.toCharArray();
		char[] g = guess.toCharArray();

		Map<Integer, Integer> map = new HashMap<>();

		
		for (int i = 0; i < secret.length(); i++) {
			if (s[i] == g[i]) {
				bullCounter++;
				s[i] = '*';
				g[i] = '*';
			} else {
				if (map.containsKey((s[i] - '0'))) {
					map.put(s[i] - '0', 1 + map.get(s[i] - '0'));
				} else {
					map.put(s[i] - '0', 1);
				}
			}
		}

		for (int i = 0; i < g.length; i++) {
			if (g[i] != '*') {
				if (map.containsKey(g[i] - '0') && map.get(g[i] - '0') > 0) {
					cowCounter++;
					map.replace(g[i] - '0', map.get(g[i] - '0') - 1);
				} else {
					continue;
				}
			}
		}

		return (bullCounter + "A") + (cowCounter + "B");
	}
}