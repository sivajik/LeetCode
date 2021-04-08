package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Prob68_TextJustification {

	public static void main(String[] args) {
		for (String s : fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." },
				16)) {
			System.out.println(s);
		}

	}

	static public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> workingList = new ArrayList<>();
		List<String> ans = new ArrayList<>();

		int i = 0;
		int lineLength = 0;

		for (i = 0; i < words.length;) {
			String word = words[i];
			int wordLen = word.length();

			if (lineLength == 0) {
				lineLength = wordLen;
				workingList.add(word);
				i++;
			} else if (wordLen + lineLength + 1 <= maxWidth) {
				lineLength += wordLen + 1; // +1 is mainly for a space.
				workingList.add(word);
				i++;
			} else {
				// need to justify now.
				ans.add(justify(workingList, maxWidth));
				lineLength = 0;
				workingList.clear();
			}
		}

		// last line
		ans.add(justifyLeft(workingList, maxWidth));
		return ans;
	}

	private static String justify(List<String> workingList, int maxWidth) {
		int wordsLen = 0;

		for (String word : workingList) {
			wordsLen += word.length();
		}

		int totalSpaces = maxWidth - wordsLen;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < workingList.size(); i++) {
			sb.append(workingList.get(i));
			int appendSpaces = totalSpaces;

			if (workingList.size() - i - 1 > 1) {
				appendSpaces = totalSpaces / (workingList.size() - i - 1);
				if (totalSpaces - (appendSpaces * (workingList.size() - i - 1)) != 0) {
					appendSpaces++;
				}
			}
			totalSpaces -= appendSpaces;
			addSpaces(sb, appendSpaces);
		}

		return sb.toString();
	}

	private static String justifyLeft(List<String> workingList, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		int wordsLen = 0;
		for (int i = 0; i < workingList.size(); i++) {
			String w = workingList.get(i);
			sb.append(w);
			wordsLen += w.length();

			if (i != workingList.size() - 1) {
				sb.append(" ");
				wordsLen += 1;
			}
		}

		addSpaces(sb, maxWidth - wordsLen);
		return sb.toString();
	}

	private static void addSpaces(StringBuilder sb, int num) {
		for (int i = 0; i < num; i++) {
			sb.append(" ");
		}
	}
}
