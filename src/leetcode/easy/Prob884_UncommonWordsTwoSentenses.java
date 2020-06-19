package leetcode.easy;

public class Prob884_UncommonWordsTwoSentenses {

	public static void main(String[] args) {
		for (String str : uncommonFromSentences("this apple is sweet", "this apple is sour")) {
			System.out.println(str + " ");
		}
		System.out.println("-----");
		for (String str : uncommonFromSentences("apple apple", "banana")) {
			System.out.println(str + " ");
		}
		System.out.println("-----");
		for (String str : uncommonFromSentences("", "")) {
			System.out.println(str + " ");
		}
		System.out.println("-----");		
	}

	static public String[] uncommonFromSentences(String A, String B) {
		java.util.Map<String, Integer> map = new java.util.HashMap<>();

		String c = A + " " + B;
		for (String token : c.split(" ")) {
			if (map.containsKey(token)) {
				map.put(token, 1 + map.get(token));
			} else {
				map.put(token, 1);
			}
		}
		java.util.List<String> list = new java.util.ArrayList<>();
		for (java.util.Map.Entry<String, Integer> entries : map.entrySet()) {
			if (entries.getValue() == 1) {
				list.add(entries.getKey());
			}
		}
		String[] res = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
