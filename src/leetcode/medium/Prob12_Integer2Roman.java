package leetcode.medium;

public class Prob12_Integer2Roman {

	public static void main(String[] args) {
		System.out.println(intToRoman(49));

	}

	static public String intToRoman(int num) {
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
		String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		StringBuilder sbr = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (values[i] <= num) {
				num -= values[i];
				sbr.append(symbols[i]);
			}
		}
		return sbr.toString();
	}
}

/*
Symbol       Value
I             1    IV 4
V             5    IX 9
X             10   XL 40
L             50   XC 90
C             100  CD 400
D             500  CM 900
M             1000


*/