package leetcode.easy;

public class Prob1576_ReplaceAllAvoidConsecutiveRepeating {

	public static void main(String[] args) {
		System.out.println(modifyString("?zs"));
		System.out.println(modifyString("ubv?w"));
		System.out.println(modifyString("j?qg??b"));
		System.out.println(modifyString("?zs"));
	}

	static public String modifyString(String s) {
		if (s.length() == 1 && s.equals("?")) {
			return "a";
		}

		char[] op = s.toCharArray();
		for (int i = 0; i < op.length; i++) {
			char currChar = op[i];
			if (currChar == '?') {
				op[i] = getNext(i, op);
			} else {
				op[i] = currChar;
			}
		}
		return new String(op);
	}

	private static char getNext(int i, char[] op) {
		if (i + 1 < op.length && i - 1 >= 0) {
			// geneuine case
			char prev = op[i - 1];
			char next = op[i + 1];
			for (int x = 0; x < 26; x++) {
				if (x + 'a' != prev && x + 'a' != next) {
					return (char) (x + 'a');
				}
			}
		}
		// ?aaaaa
		if (i - 1 < 0) {
			char next = op[i + 1];
			for (int x = 0; x < 26; x++) {
				if (x + 'a' != next) {
					return (char) (x + 'a');
				}
			}
		}

		if (i + 1 == op.length) {
			char prev = op[i - 1];
			for (int x = 0; x < 26; x++) {
				if (x + 'a' != prev) {
					return (char) (x + 'a');
				}
			}
		}

		return 0;
	}
}
