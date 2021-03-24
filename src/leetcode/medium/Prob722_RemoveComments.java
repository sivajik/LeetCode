package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob722_RemoveComments {

	public static void main(String[] args) {
		System.out.println(removeComments(new String[] { "/*Test program */", "int main()", "{ ",
				"  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ",
				"   testing */", "a = b + c;", "}" }));
	}

	static public List<String> removeComments(String[] source) {
		boolean inBlock = false;

		List<String> ans = new ArrayList<>();
		StringBuilder newLine = new StringBuilder();
		for (String line : source) {
			if (!inBlock) {
				newLine = new StringBuilder();
			}

			char[] chars = line.toCharArray();
			int i = 0;
			while (i < line.length()) {
				if (!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '*') {
					inBlock = true;
					i++;
				} else if (inBlock && i + 1 < line.length() && chars[i] == '*' && chars[i + 1] == '/') {
					inBlock = false;
					i++;
				} else if (!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '/') {
					// inBlock = false;
					break;
				} else if (!inBlock) {
					newLine.append(chars[i]);
				}
				i++;
			}

			// after whole line is processed, add to result
			if (!inBlock && newLine.length() > 0) {
				ans.add(new String(newLine));
			}
		}

		return ans;
	}
}
