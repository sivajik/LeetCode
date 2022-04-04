package leetcode.g5.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Prob1859_SortingTheSentence {

	public static void main(String[] args) {
		System.out.println(sortSentence("is2 sentence4 This1 a3"));
		System.out.println(sortSentence("Myself2 Me1 I4 and3"));
	}

	public static String sortSentence(String s) {
		String[] res = new String[9];
		String[] tokens = s.split("\\s+");
		for (String tkn : tokens) {
			int index = tkn.charAt(tkn.length() - 1) - '1';
			res[index] = tkn.substring(0, tkn.length() - 1);
		}
		StringBuilder sbr = new StringBuilder();
		for (String s1 : res) {
			if (s1 != null) {
				sbr.append(s1);
				sbr.append(" ");
			}
		}
		return sbr.toString().trim();
	}

	// useless complex version without taking fact that s can have max of 9 strings.
	public static String sortSentence1(String s) {
		Comparator<String> cmp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int index1 = o1.charAt(o1.length() - 1) - '0';
				int index2 = o2.charAt(o2.length() - 1) - '0';
				if (index1 == index2) {
					return 0;
				} else if (index1 < index2) {
					return -1;
				} else {
					return 1;
				}
			}
		};

		List<String> list = new ArrayList<>();
		String[] tokens = s.split("\\s+");
		for (String tkn : tokens) {
			list.add(tkn);
		}
		list.sort(cmp);
		StringBuilder sbr = new StringBuilder();
		for (String s1 : list) {
			sbr.append(s1.substring(0, s1.length() - 1));
			sbr.append(" ");
		}

		return sbr.toString().trim();
	}
}
