package leetcode.medium;

public class Prob1487_MakingFileNamesUnique {

	public static void main(String[] args) {
		for (String s : getFolderNames(new String[] { "pes", "fifa", "gta", "pes(2019)" })) {
			System.out.print(s + " ");
		}
		System.out.println();

		for (String s : getFolderNames(new String[] { "gta", "gta(1)", "gta", "avalon" })) {
			System.out.print(s + " ");
		}
		System.out.println();

		for (String s : getFolderNames(
				new String[] { "onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece" })) {
			System.out.print(s + " ");
		}
		System.out.println();

		for (String s : getFolderNames(new String[] { "wano", "wano", "wano", "wano" })) {
			System.out.print(s + " ");
		}
		System.out.println();

		for (String s : getFolderNames(new String[] { "kaido", "kaido(1)", "kaido", "kaido(1)" })) {
			System.out.print(s + " ");
		}
		System.out.println();

		for (String s : getFolderNames(new String[] { "kaido","kaido(1)","kaido","kaido(1)","kaido(2)" })) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
/*
 Input
["kaido","kaido(1)","kaido","kaido(1)","kaido(2)"]

Output
["kaido","kaido(1)","kaido(2)","kaido(1)(1)","kaido(2)(3)"]

Expected
["kaido","kaido(1)","kaido(2)","kaido(1)(1)","kaido(2)(1)"]

 */
	static public String[] getFolderNames(String[] names) {
		java.util.Map<String, Integer> map = new java.util.HashMap<>();
		java.util.List<String> l = new java.util.ArrayList<>();

		for (String name : names) {
			if (!map.containsKey(name)) {
				map.put(name, 0);
				l.add(name);
			} else {
		        int max = map.get(name);
		        String s1 = name + "(" + (++max) + ")";
		        while (map.containsKey(s1)) {
		          s1 = name + "(" + (++max) + ")";
		        }
		        map.put(name, max);
		        map.put(s1, 0);
		        
/*				int freq = map.get(name) + 1;
				String newName = name + "(" + freq + ")";
				while (map.containsKey(newName)) {
					freq = getFreq(newName) + 1;
					newName = name + "(" + freq + ")";
				}
				map.put(newName, 0);
				map.put(name, freq);
*/				
				l.add(s1);
				
			}
		}

		return l.toArray(new String[l.size()]);
	}
}
