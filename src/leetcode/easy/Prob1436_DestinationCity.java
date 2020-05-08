package leetcode.easy;

public class Prob1436_DestinationCity {

	public static void main(String[] args) {
		java.util.List<String> one = java.util.Arrays.asList(new String[] { "a", "d" });
		java.util.List<String> two = java.util.Arrays.asList(new String[] { "d", "b" });
		java.util.List<String> three = java.util.Arrays.asList(new String[] { "c", "a" });

		java.util.List<java.util.List<String>> list = new java.util.ArrayList<>();
		list.add(one);
		list.add(two);
		list.add(three);
		System.out.println(destCity(list));
	}

	public static String destCity(java.util.List<java.util.List<String>> paths) {

		java.util.Map<String, String> map = new java.util.HashMap<>();
		for (java.util.List<String> list : paths) {
			map.put(list.get(0), list.get(1));
		}

		for (java.util.Map.Entry<String, String> entry : map.entrySet()) {
			if (!map.containsKey(map.get(entry.getKey()))) {
				return entry.getValue();
			}
		}
		return null;
	}
}
