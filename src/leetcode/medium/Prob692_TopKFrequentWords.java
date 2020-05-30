package leetcode.medium;

public class Prob692_TopKFrequentWords {

	public static void main(String[] args) {
		System.out.println(topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
		System.out.println(topKFrequent(
				new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
		System.out.println(topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 1));
	}

	public static java.util.List<String> topKFrequent(String[] words, int k) {
		java.util.Map<String, Integer> map = new java.util.HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		java.util.PriorityQueue<String> q = new java.util.PriorityQueue<>(new java.util.Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (map.get(o1) == map.get(o2)) {
					return o1.compareTo(o2);
				} else {
					return -map.get(o1) + map.get(o2);
				}
			}
		});

		for (String word : map.keySet()) {
			q.add(word);
		}

		java.util.List<String> res = new java.util.ArrayList<String>();
		int cnt = k;
		while (cnt-- > 0) {
			res.add(q.poll());
		}
		return res;
	}
}
