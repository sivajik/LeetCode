package leetcode.medium;

public class Prob1451_RearrangeWordsInSent {

	public static void main(String[] args) {
		System.out.println(arrangeWords("Leetcode is cool"));
		System.out.println(arrangeWords("Keep calm and code on"));
		System.out.println(arrangeWords("To be or not to be"));
		System.out.println(arrangeWords("t"));
		System.out.println(arrangeWords("T"));
		System.out.println(arrangeWords("You and i"));
	}

	public static String arrangeWords(String text) {
		text = text + " ";
		char[] c = text.toCharArray();
		c[0] = Character.toLowerCase(c[0]);

		java.util.Map<Integer, java.util.List<StringBuilder>> m = new java.util.HashMap<>();
		StringBuilder sbr = new StringBuilder();

		for (int i = 0, j = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				if (m.containsKey(j)) {
					java.util.List<StringBuilder> list = m.get(j);
					list.add(sbr);
					m.put(j, list);
				} else {
					java.util.List<StringBuilder> list = new java.util.ArrayList<>();
					list.add(sbr);
					m.put(j, list);
				}
				j = 0;
				sbr = new StringBuilder();
			} else {
				sbr.append(c[i]);
				j++;
			}

		}

		StringBuilder sb = new StringBuilder();
		for (java.util.Map.Entry<Integer, java.util.List<StringBuilder>> entry : m.entrySet()) {
			for (StringBuilder s : entry.getValue()) {
				sb.append(s);
				sb.append(" ");
			}
		}

		String res = sb.toString();
		char[] x = res.toCharArray();
		x[0] = Character.toUpperCase(x[0]);
		return (new String(x)).trim();
	}

	public static String arrangeWords1(String text) {
		String[] words = text.split(" ");

		java.util.Map<Integer, java.util.List<String>> m = new java.util.HashMap<>();
		for (String word : words) {
			int len = word.length();
			if (m.containsKey(len)) {
				java.util.List<String> list = m.get(len);
				list.add(word);
				m.put(len, list);
			} else {
				java.util.List<String> list = new java.util.ArrayList<>();
				list.add(word);
				m.put(len, list);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (java.util.Map.Entry<Integer, java.util.List<String>> entry : m.entrySet()) {
			for (String s : entry.getValue()) {
				sb.append(s);
				sb.append(" ");
			}
		}
		String res = sb.toString();
		String a = res.substring(0, 1);
		String b = res.substring(1).toLowerCase().trim();
		return a.toUpperCase() + b;
	}
}
