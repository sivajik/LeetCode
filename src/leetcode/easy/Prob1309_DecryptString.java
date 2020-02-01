package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob1309_DecryptString {

	public static void main(String[] args) {
		System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#10#"));
		System.out.println(freqAlphabets("10#11#12"));
		System.out.println(freqAlphabets("1326#"));
		System.out.println(freqAlphabets("25#"));
	}

	public static String freqAlphabets(String s) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("10#", "j");
		map.put("11#", "k");
		map.put("12#", "l");
		map.put("13#", "m");
		map.put("14#", "n");
		map.put("15#", "o");
		map.put("16#", "p");
		map.put("17#", "q");
		map.put("18#", "r");
		map.put("19#", "s");
		map.put("20#", "t");
		map.put("21#", "u");
		map.put("22#", "v");
		map.put("23#", "w");
		map.put("24#", "x");
		map.put("25#", "y");
		map.put("26#", "z");

		while (s.indexOf("#") != -1) {
			int hashIndex = s.indexOf('#');
			String strToDecrypt = s.substring(hashIndex - 2, hashIndex + 1);
			s = s.replace(strToDecrypt, map.get(strToDecrypt));
		}
		
		s = s.replaceAll("1", "a");
		s = s.replaceAll("2", "b");
		s = s.replaceAll("3", "c");
		s = s.replaceAll("4", "d");
		s = s.replaceAll("5", "e");
		s = s.replaceAll("6", "f");
		s = s.replaceAll("7", "g");
		s = s.replaceAll("8", "h");
		s = s.replaceAll("9", "i");
		
		return s;
	}
}
