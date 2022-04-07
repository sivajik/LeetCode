package leetcode.g5.easy;

public class Prob1108_DefangingAnIPAddress {

	public static void main(String[] args) {
		System.out.println(defangIPaddr("1.1.1.1").equalsIgnoreCase("1[.]1[.]1[.]1"));
		System.out.println(defangIPaddr("255.100.50.0").equalsIgnoreCase("255[.]100[.]50[.]0"));
	}
	static public String defangIPaddr(String address) {
        // return address.replaceAll("\\.", "\\[\\.\\]");
		char[] op = new char[address.length() + 6];
		char[] c = address.toCharArray();
		
		int cnt = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '.') {
				op[cnt++] = '[';
				op[cnt++] = '.';
				op[cnt++] = ']';
			} else {
				op[cnt++] = c[i];
			}
		}
		return new String(op);
    }
}
