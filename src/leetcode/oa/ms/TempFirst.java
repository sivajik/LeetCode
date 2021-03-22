package leetcode.oa.ms;

public class TempFirst {

	public static void main(String[] args) {
		// System.out.println(isPalin("1"));
		System.out.println(solution("?ab??a"));
		System.out.println(solution("bab??a"));
		System.out.println(solution("?a?"));
		System.out.println(solution("a?a"));
	}
	static public String solution(String S) {
		if (S == null || S.length() == 0) {
			return S;
		}
		
		if (S.indexOf('?') == -1) {
			// nothing to replace.. hopefully no input of this sort.
			return S;
		}
		
		int l = 0;
		int r = S.length()  -1;
		char[] chars = new char[S.length()];
		// use 2 pointes (left, right) and check respective chars
		// O(n) is enough to do this.
		while (l <= r) {
			char lC = S.charAt(l);
			char rC = S.charAt(r);
			if (lC == '?' && rC != '?') {
				chars[l] = rC;
				chars[r] = rC;
			} else if (lC != '?' && rC == '?') {
				chars[l] = lC;
				chars[r] = lC;
			} else if (lC == '?' && rC == '?') {
				chars[l] = 'a';
				chars[r] = 'a';				
			} else {
				if (lC != rC) {
					return "NO";
				} else {
					chars[l] = lC;
				}
			}
			l++;
			r--;
		}
        return new String(chars);
    }
	
	static boolean isPalin(String s) {
		int l = 0;
		int r = s.length()-1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
