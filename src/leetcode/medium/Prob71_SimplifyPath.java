package leetcode.medium;

import java.util.Stack;

public class Prob71_SimplifyPath {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/../aggu"));

	}

	public static String simplifyPath(String path) {
		StringBuilder sbr = new StringBuilder();

		Stack<String> s = new Stack<>();

		String[] tokens = path.split("/");
		for (String dirName : tokens) {
			if (dirName.equalsIgnoreCase(".") || dirName.isEmpty()) {
				;//
			} else if (dirName.equalsIgnoreCase("..")) {
				if (!s.isEmpty()) {
					s.pop();
				}
			} else {
				s.push(dirName);
			}
		}

		for (String str : s) {
			sbr.append("/");
			sbr.append(str);
		}
		String res = sbr.toString();

		return res.length() > 0 ? res : "/";

	}
}
