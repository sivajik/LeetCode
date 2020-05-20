package leetcode.easy;

public class Prob1408_StrMatchingInArray {

	public static void main(String[] args) {
		for (String str : stringMatching(new String[] { "mass", "as", "hero", "superhero" })) {
			System.out.println(str);
		}
		System.out.println();

		for (String str : stringMatching(new String[] { "leetcode", "et", "code" })) {
			System.out.println(str);
		}
		System.out.println();

		for (String str : stringMatching(new String[] { "blue", "green", "bu" })) {
			System.out.println(str);
		}
		System.out.println();
	}

	public static java.util.List<String> stringMatching(String[] words) {
		java.util.Set<String> set = new java.util.HashSet<>();

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i != j) {
					if (words[i].indexOf(words[j]) != -1) {
						set.add(words[j]);
					}
				}
			}
		}
		java.util.List<String> l = new java.util.ArrayList<>();
		for (String s : set) {
			l.add(s);
		}
		return l;
	}
}
