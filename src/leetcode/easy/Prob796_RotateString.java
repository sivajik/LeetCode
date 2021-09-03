package leetcode.easy;

public class Prob796_RotateString {

	public static void main(String[] args) {
		System.out.println(rotateString("abcde", "cdeab"));

	}
	 static public boolean rotateString(String A, String B) {
		 return A.length() == B.length() && (A+A).contains(B);
	  }
}
