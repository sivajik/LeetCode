package leetcode.medium;

public class DPPatterns {

	public static void main(String[] args) {
		// singleString();
		twoStrings();
	}

	private static void singleString() {
		String s1 = "jodhasri";
		int n = s1.length();
		for (int len = 1; len < n; len++) {
			for (int i = 0; i + len < n; i++) {
				int j = i + len;
				System.out.println(i + "," + j +"  " +s1.charAt(i) + " " + s1.charAt(j) + " " + s1.substring(i, j+1));
			}
			System.out.println("---");
		}
	}

	private static void  twoStrings() {
		String s1 = "jodha";
		String s2 = "srisiri";
		
		int m = s1.length();
		int n = s2.length();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(s1.charAt(i) + "" + s2.charAt(j) + "   ");
			}
			System.out.println();
		}
	}
}
