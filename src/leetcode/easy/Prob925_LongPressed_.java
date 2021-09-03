package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Prob925_LongPressed_ {

	public static void main(String[] args) {
		//System.out.println(isLongPressedName("alex", "aleex"));
		//System.out.println(isLongPressedName("saeed", "ssaaedd"));
		System.out.println(isLongPressedName("leelee", "lleeelee"));
		//System.out.println(isLongPressedName("laiden", "laiden"));

	}

	public static boolean isLongPressedName(String name, String typed) {
		if (name.equalsIgnoreCase(typed)) {
			return true;
		}

		List<Character> list = new ArrayList<Character>();
		for (Character c : typed.toCharArray()) {
			list.add(c);
		}
		char[] nameArray = name.toCharArray();
		for (int i = 0; i < nameArray.length; i++) {
			if (list.contains(nameArray[i])) {
				list.remove(list.indexOf(nameArray[i]));
			} else {
				return false;
			}
		}

		nameArray = name.toCharArray();
		for (int i = 0; i < nameArray.length; i++) {
			char c = nameArray[i];

			int firstIndex = typed.indexOf(c);
			int lastIndex = typed.lastIndexOf(c);

			if (firstIndex == i && lastIndex > firstIndex) {
				boolean longPressed = true;
				for (int j = firstIndex; j <= lastIndex; j++) {
					if (typed.charAt(j) != c) {
						longPressed = false;
						break;
					}
				}
				if (longPressed) {
					return longPressed;
				}
			} else {
				continue;
			}
		}
		return false;
	}
}
/*
 * 
 * Input: name = "alex", typed = "aleQex" Output: true Explanation: 'a' and 'e'
 * in 'alex' were long pressed. Example 2:
 * 
 * Input: name = "saeed", typed = "ssaaedd" Output: false Explanation: 'e' must
 * have been pressed twice, but it wasn't in the typed output.
 * 
 * Example 3:
 * 
 * Input: name = "leelee", typed = "lleeelee" Output: true Example 4:
 * 
 * Input: name = "laiden", typed = "laiden" Output: true Explanation: It's not
 * necessary to long press any character.
 * 
 */