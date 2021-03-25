package leetcode.hard;

public class Prob273_IntegertoEnglishWords {

	public static void main(String[] args) {
		System.out.println(numberToWords(123));
		System.out.println(numberToWords(12345));
		System.out.println(numberToWords(1234567));
		System.out.println(numberToWords(1234567891));
	}

	static public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}

		int billion = num / 1000000000;
		int million = (num - billion * 1000000000) / 1000000;
		int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
		int rest = (num - billion * 1000000000 - million * 1000000 - thousand * 1000);

		String result = "";

		if (billion != 0) {
			result = three(billion) + " Billion";
		}
		if (million != 0) {
			if (result.length() > 0) {
				result += " ";
			}
			result += three(million) + " Million";
		}
		if (thousand != 0) {
			if (result.length() > 0) {
				result += " ";
			}
			result += three(thousand) + " Thousand";
		}
		if (rest != 0) {
			if (result.length() > 0) {
				result += " ";
			}
			result += three(rest);
		}
		return result;
	}

	private static String three(int num) {
		int hundred = num / 100;
		int rest = (num - hundred * 100);
		String res = "";

		if (hundred > 0 && rest > 0) {
			res = one(hundred) + " Hundred " + two(rest);
		} else if (hundred != 0 && rest == 0) {
			res = one(hundred) + " Hundred";
		} else if (hundred == 0 && rest != 0) {
			res = two(rest);
		}
		return res;
	}

	private static String two(int num) {
		String res = "";
		if (num == 0) {
			return "";// key thing is this.
		} else if (num < 10) {
			return one(num);
		} else if (num < 20) {
			return twoLessThan20(num);
		} else {
			int tenner = num / 10; 
			int rest = (num - tenner * 10); 
			if (tenner > 0 && rest > 0) {
				return ten(tenner) + " " + one(rest);
			} else {
				return ten(tenner);
			}
		}
	}

	static public String ten(int num) {
		switch (num) {
		case 2:
			return "Twenty";
		case 3:
			return "Thirty";
		case 4:
			return "Forty";
		case 5:
			return "Fifty";
		case 6:
			return "Sixty";
		case 7:
			return "Seventy";
		case 8:
			return "Eighty";
		case 9:
			return "Ninety";
		}
		return "";
	}

	static public String twoLessThan20(int num) {
		switch (num) {
		case 10:
			return "Ten";
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 14:
			return "Fourteen";
		case 15:
			return "Fifteen";
		case 16:
			return "Sixteen";
		case 17:
			return "Seventeen";
		case 18:
			return "Eighteen";
		case 19:
			return "Nineteen";
		}
		return "";
	}

	static public String one(int num) {
		switch (num) {
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		}
		return "";
	}
}
