package leetcode.easy;

public class Prob1528_ShuffleString {

	public static void main(String[] args) {
		System.out.println(restoreString("codeleet", new int[] { 4, 5, 6, 7, 0, 2, 1, 3 }));
		System.out.println(restoreString("abc", new int[] { 0, 1, 2 }));
		System.out.println(restoreString("aiohn", new int[] { 3, 1, 4, 2, 0 }));
		System.out.println(restoreString("aaiougrt", new int[] { 4, 0, 2, 6, 7, 3, 1, 5 }));
		System.out.println(restoreString("art", new int[] { 1, 0, 2 }));
	}

	public static String restoreString(String s, int[] indices) {
		java.util.TreeMap<Integer, Character> map = new java.util.TreeMap<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < indices.length; i++) {
			map.put(indices[i], chars[i]);
		}
	
		char[] res = new char[indices.length];
		int c = 0;
		for (Integer i : map.keySet()) {
			res[c++] = map.get(i);
		}
		return new String(res);
	}
}
