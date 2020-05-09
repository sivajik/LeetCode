package leetcode.easy;

public class Prob1002_allLowerCase {
	public static void main(String[] a) throws Exception {
		System.out.println(commonChars(new String[] { "bella", "label", "roller" }));
		System.out.println(commonChars(new String[] { "cool", "lock", "cook" }));
		System.out.println(commonChars(new String[] { "cool" }));
		System.out.println(commonChars(new String[] { "a", "b", "c" }));
	}

	public static java.util.List<String> commonChars(String[] A) {

		java.util.Map<Integer, java.util.Map<Character, Integer>> map = new java.util.HashMap<>();
		for (int i = 0; i < A.length; i++) {
			String str = A[i];
			map.put(i, new java.util.HashMap<>());

			for (char c : str.toCharArray()) {
				if (map.get(i).containsKey(c)) {
					map.get(i).put(c, 1 + map.get(i).get(c));
				} else {
					map.get(i).put(c, 1);
				}
			}
		}

		java.util.List<String> l = new java.util.ArrayList<>();

		for (int i = 'a'; i <= 'z'; i++) {
			boolean thisCharExists = true;
			int localFre = Integer.MAX_VALUE;

			for (int j = 0; j < map.size(); j++) {
				if (map.get(j).containsKey((char) i)) {
					if (map.get(j).get((char) i) < localFre) {
						localFre = map.get(j).get((char) i);
					}
				} else {
					thisCharExists = false;
					break;
				}
			}
			if (thisCharExists) {
				for (int k = 0; k < localFre; k++) {
					l.add("" + (char) i);
				}
			}
		}

		return l;
	}
}
