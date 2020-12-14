package leetcode.revision.week02;

public class P468_ValidateIPAddress {

	public static void main(String[] args) {
		System.out.println(validIPAddress("1.1.1.1.").equalsIgnoreCase("Neither"));
		System.out.println(validIPAddress("256.256.256.256").equalsIgnoreCase("Neither"));
		System.out.println(validIPAddress("172.16.254.1").equalsIgnoreCase("IPv4"));
		System.out.println(validIPAddress("172.16.254.01").equalsIgnoreCase("Neither"));
		System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334").equalsIgnoreCase("IPv6"));
		System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334").equalsIgnoreCase("IPv6"));
		System.out.println(validIPAddress("2001:0db8:85a3::8A2E:0370:7334").equalsIgnoreCase("Neither"));
		System.out.println(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334").equalsIgnoreCase("Neither"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370::::7334").equalsIgnoreCase("Neither"));
	}

	static public String validIPAddress(String ip) {
		if (ip == null || ip.length() == 0) {
			return "Neither";
		}

		if (ip.contains(".")) {
			String[] t = ip.split("\\.", Integer.MIN_VALUE);
			if (t.length != 4) {
				return "Neither";
			}
			for (String tkn : t) {
				if (!tkn.matches("[0-9]|1[0-9]{1,2}|2[0-5]{2}|2[0-9]{1}")) {
					return "Neither";
				}
			}
			return "IPv4";
		}

		if (ip.contains(":")) {
			String[] t = ip.split("\\:", Integer.MIN_VALUE);
			if (t.length != 8) {
				return "Neither";
			}
			for (String tkn : t) {
				if (!tkn.matches("[a-fA-F0-9]{1,4}")) {
					return "Neither";
				}
			}
			return "IPv6";

		}

		return "Neither";
	}
}
