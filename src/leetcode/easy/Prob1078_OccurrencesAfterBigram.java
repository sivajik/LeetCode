package leetcode.easy;

public class Prob1078_OccurrencesAfterBigram {

	public static void main(String[] args) {
		for (String s : findOcurrences("alice is a good girl she is a good student", "a", "good")) {
			System.out.println(s);
		}
		System.out.println();
		for (String s : findOcurrences("we will we will rock you", "we", "will")) {
			System.out.println(s);
		}
	}

	public static String[] findOcurrences(String text, String first, String second) {
		java.util.Map<String, java.util.List<String>> map = new java.util.HashMap<>();

		String[] tokens = text.split(" ");
		for (int i = 0; i < tokens.length - 2; i++) {
			String key = tokens[i] + "_" + tokens[i + 1];
			String value = tokens[i + 2];

			if (map.containsKey(key)) {
				java.util.List<String> l = map.get(key);
				l.add(value);
				map.put(key, l);
			} else {
				java.util.List<String> l = new java.util.ArrayList<>();
				l.add(value);
				map.put(key, l);
			}
		}

		java.util.List<String> l = map.get(first + "_" + second);
		if (l != null && l.size() > 0) {
			String[] res = new String[l.size()];
			l.toArray(res);
			return res;
		} else {
			return new String[] {};
		}
	}
}
