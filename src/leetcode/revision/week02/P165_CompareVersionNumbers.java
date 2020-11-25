package leetcode.revision.week02;

public class P165_CompareVersionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersion("1.01", "1.001"));
		System.out.println(compareVersion("1.0", "1.0.0"));
		System.out.println(compareVersion("0.1", "1.1"));
		System.out.println(compareVersion("1.0.1", "1"));
		System.out.println(compareVersion("7.5.2.4", "7.5.3"));
	}

	static public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int i = 0, j = 0;

		while (i < v1.length && j < v2.length) {
			if (Integer.parseInt(v1[i]) == Integer.parseInt(v2[j])) {
				i++;
				j++;
			} else {
				int aa = Integer.parseInt(v1[i++]);
				int bb = Integer.parseInt(v2[j++]);
				return aa > bb ? 1 : (aa == bb ? 0 : -1);
			}
		}

		if (i == v1.length && j < v2.length) {
			while (j < v2.length) {
				if (Integer.parseInt(v2[j++]) > 0) {
					return -1;
				}
			}
			return 0;
		}

		if (i < v1.length && j == v2.length) {
			while (i < v1.length) {
				if (Integer.parseInt(v1[i++]) > 0) {
					return 1;
				}
			}
			return 0;
		}
		return 0; // we dont reach here.
	}
}
