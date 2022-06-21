package leetcode.f7.easy;

public class Prob1108_DefangingAnIPAddress {

	public static void main(String[] args) {
		System.out.println(defangIPaddr("1.1.1.1"));

	}

	public static String defangIPaddr(String address) {
		return address.replaceAll("\\.", "\\[\\.\\]");
	}
}
