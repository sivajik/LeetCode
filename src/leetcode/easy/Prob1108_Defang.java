package leetcode.easy;

public class Prob1108_Defang {

	public static void main(String[] args) {
		System.out.println(defangIPaddr("1.1.1.1"));
		System.out.println(defangIPaddr("255.100.50.0"));

	}
    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "\\[.\\]");
    }
}
