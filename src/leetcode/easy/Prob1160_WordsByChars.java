package leetcode.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Prob1160_WordsByChars {

	public static void main(String[] args) {
		System.out.println(countCharacters(new String[] {
				"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
				"ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
				"boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
				"nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
				"hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
				"juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo",
				"oxgaskztzroxuntiwlfyufddl",
				"tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
				"qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv",
				"sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
				"hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
				"cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob",
				"qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
				"qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs" },
				"usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"));

		// System.out.println(countCharacters(new String[] {"cat","bt","hat","tree"},
		// "atach"));
		// System.out.println(countCharacters(new String[] {"hello","world","leetcode"},
		// "welldonehoneyr"));
	}

	public static int countCharacters(String[] words, String chars) {
		Map<Character, Integer> cMap = new HashMap<Character, Integer>();
		for (char c : chars.toCharArray()) {
			if (cMap.containsKey(c)) {
				cMap.put(c, 1 + cMap.get(c));
			} else {
				cMap.put(c, 1);
			}
		}

		int sum = 0;
		for (String word : words) {
			Map<Character, Integer> wMap = new HashMap<Character, Integer>();

			boolean wordProcessed = true;

			for (char c : word.toCharArray()) {
				if (!cMap.containsKey(c)) {
					wMap = null;
					// System.out.println("Skipping: " + word);
					wordProcessed = false;
					break;
				} else {
					if (wMap.containsKey(c)) {
						wMap.put(c, 1 + wMap.get(c));
					} else {
						wMap.put(c, 1);
					}
				}
			}

			if (wMap != null && wMap.size() > 0 && wordProcessed) {
				Set<java.util.Map.Entry<Character, Integer>> entries = wMap.entrySet();
				Iterator<java.util.Map.Entry<Character, Integer>> itr = entries.iterator();
				boolean validWord = true;
				while (itr.hasNext()) {
					java.util.Map.Entry<Character, Integer> entry = itr.next();
					Character c = entry.getKey();
					Integer freq = entry.getValue();

					if (cMap.get(c) < freq) {
						validWord = false;
					}
				}

				if (validWord) {
					// System.out.println("Valid word: " + word);
					sum = sum + word.length();
				}
			}
			wMap = null;
		}
		return sum;
	}
}
/*
 * a 2 t 1 c 1 h 1 ===== c 1 a 1 t 1
 */