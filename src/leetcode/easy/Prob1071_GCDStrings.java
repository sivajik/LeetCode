package leetcode.easy;

public class Prob1071_GCDStrings {

	public static void main(String[] args) {
		System.out.println(gcdOfStrings("ABCABC", "ABC"));
		System.out.println(gcdOfStrings("ABABAB", "ABAB"));
		System.out.println(gcdOfStrings("LEET", "LEET"));
		System.out.println(gcdOfStrings("LEETLEETLEETLEET", "LEETLEETLEET"));
		System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX",
		"TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
		
		
		System.out.println(gcdOfStrings("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM",
		"NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"));
	}

	public static String gcdOfStrings(String str1, String str2) {
		if (str1.equals(str2)) {
			return str1;
		}

		String result = "";
		for (int i = 0; i < str2.length(); i++) {
			String subStr = str2.substring(0, i + 1);
			
			String[] tokensStr1 = str1.split(subStr);
			String[] tokensStr2 = str2.split(subStr);
			
			if (tokensStr1.length == 0 && tokensStr2.length == 0 ) {
				result = subStr;
			}
		}
		return result;
	}

}
