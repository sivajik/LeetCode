package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob1189_Baloons {

	public static void main(String[] args) {
		System.out.println(maxNumberOfBalloons("nlaebolko"));
		System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
	}

	public static int maxNumberOfBalloons(String text) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : text.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, 1 + map.get(c));
			} else {
				map.put(c, 1);
			}
		}
		
		int totalCount = 0;
		while ( (map.containsKey('b') && map.get('b') >= 1) &&
				(map.containsKey('a') && map.get('a') >= 1) && 
				(map.containsKey('l') && map.get('l') >= 2) &&
				(map.containsKey('o') && map.get('o') >= 2) &&
				(map.containsKey('n') && map.get('n') >= 1) ) {
			totalCount++;
			map.put('b', map.get('b') - 1);
			map.put('a', map.get('a') - 1);
			map.put('l', map.get('l') - 2);
			map.put('o', map.get('o') - 2);
			map.put('n', map.get('n') - 1);
		}
		return totalCount;
	}
}