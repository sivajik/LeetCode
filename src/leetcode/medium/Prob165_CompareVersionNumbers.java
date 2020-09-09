package leetcode.medium;

public class Prob165_CompareVersionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersion("1.2.3", "1.3"));
	}
	static public int compareVersion(String version1, String version2) {

		String[] t1 = version1.split("\\.");
		String[] t2 = version2.split("\\.");

		int i = 0;
		int j = 0;
		while (i < t1.length && j < t2.length) {
			int a = Integer.parseInt(t1[i]);
			int b = Integer.parseInt(t2[j]);

			if (a == b) {
				i++;
				j++;
			} else {
				return compare(a, b);
			}
		}

		if (i == t1.length && j < t2.length) {
			while (j < t2.length) {
				if (Integer.parseInt(t2[j++]) > 0) {
					return -1;
				}
			}
			return 0;
		}

		if (i < t1.length && j == t2.length) {
			while (i < t1.length) {
				if (Integer.parseInt(t1[i++]) > 0) {
					return 1;
				}
			}
			return 0;
		}
		return 0;        
    }

	static private int compare(int a, int b) {
		if (a < b) {
			return -1;
		} else {
			return 1;
		}
	}
}
