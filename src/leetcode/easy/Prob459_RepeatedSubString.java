package leetcode.easy;

public class Prob459_RepeatedSubString {

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("ab"));
		System.out.println(repeatedSubstringPattern("aaaa"));
		System.out.println(repeatedSubstringPattern("a"));
		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
		
		repeatedSubstringPattern1("abab");
	}

	public static boolean repeatedSubstringPattern(String s) {
		return s.matches("^([a-z]+)\\1+$");
	}
	
    public static void repeatedSubstringPattern1(String s) {
        System.out.println((s + s).substring(1, 2 * s.length() - 1));
        System.out.println((s + s).substring(1, 2 * s.length() - 1).contains(s));
    }
}