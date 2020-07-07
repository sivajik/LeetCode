package leetcode.medium;

public class Prob537_ComplexNumberMultiplication {

	public static void main(String[] args) {
		System.out.println(complexNumberMultiply("1+1i", "1+1i"));
		System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
	}

	static public String complexNumberMultiply(String a, String b) {
		String[] aTokens = a.split("\\+");
		ComplexNumber c1 = new ComplexNumber(Integer.parseInt(aTokens[0]),
				Integer.parseInt(aTokens[1].replaceAll("i", "")));
		// System.out.println(c1);

		String[] bTokens = b.split("\\+");
		ComplexNumber c2 = new ComplexNumber(Integer.parseInt(bTokens[0]),
				Integer.parseInt(bTokens[1].replaceAll("i", "")));
		// System.out.println(c2);

		ComplexNumber c3 = mult(c1, c2);

		return c3.toString();
	}

	private static ComplexNumber mult(ComplexNumber c1, ComplexNumber c2) {
		int ac = c1.a * c2.a;
		int bd = -1 * (c1.b * c2.b);

		int adbc = (c1.a * c2.b) + (c1.b * c2.a);

		return new ComplexNumber(ac + bd, adbc);
	}

	static class ComplexNumber {
		int a;
		int b;

		public ComplexNumber(int x, int y) {
			this.a = x;
			this.b = y;
		}

		@Override
		public String toString() {
			return "" + a + "+" + b + "i";
		}
	}
}
