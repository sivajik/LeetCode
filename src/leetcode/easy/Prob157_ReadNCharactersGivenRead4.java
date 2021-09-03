package leetcode.easy;

public class Prob157_ReadNCharactersGivenRead4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int read(char[] buf, int n) {
		char[] buf4 = new char[4];
		int copiedChars = 0;
		int readChars = 4;

		while (copiedChars < n && readChars == 4) {
			readChars = read4(buf4);

			for (int i = 0; i < readChars; i++) {
				if (copiedChars == n) {
					// we read all chars
					return n;
				}
				buf[copiedChars] = buf4[i];
				copiedChars++;
			}
		}
		return copiedChars;
	}

	static int read4(char[] buf4) {
		return -1;
	}
}
