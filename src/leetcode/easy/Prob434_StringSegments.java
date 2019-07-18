package leetcode.easy;

public class Prob434_StringSegments {

	public static void main(String[] args) {
		System.out.println(countSegments("Hello, my name is John"));
	}

	public static int countSegments(String s) {
		return s.trim().length() == 0 ? 0 : s.trim().split("[\\s]+").length;
	}
}
