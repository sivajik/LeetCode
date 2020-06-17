package leetcode.medium;

public class Prob468_ValidateIPAddress {

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

	static public String validIPAddress(String IP) {
		if (IP == null || IP.length() == 0) {
			return "Neither";
		}

		if (IP.contains(".")) {
			String[] n = IP.split("\\.", Integer.MIN_VALUE);
			if (n.length != 4)
				return "Neither";
			for (int i = 0; i < n.length; i++)
				if (!n[i].matches("[0-9]|1[0-9]{1,2}|2[0-9]{1}|2[0-5]{2}"))
					return "Neither";
			return "IPv4";
		}

		else if (IP.contains(":")) {
			String[] n = IP.split(":", Integer.MIN_VALUE);
			if (n.length != 8)
				return "Neither";
			for (int i = 0; i < n.length; i++)
				if (!n[i].matches("[a-fA-F0-9]{1,4}"))
					return "Neither";
			return "IPv6";
		}
		return "Neither";
	}

	private static boolean isIP6(String ip) {
		String[] tokens = ip.split(":");
		if (tokens.length != 8) {
			return false;
		}

		if (ip.startsWith(":") || ip.endsWith(":")) {
			return false;
		}

		for (String eachToken : tokens) {
			try {
				if (eachToken.length() < 1 || eachToken.length() > 4) {
					return false;
				} else {
					try {
						Long l = Long.parseLong(eachToken.toLowerCase(), 16);
					} catch (Exception e) {
						return false;
					}
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	private static boolean isIP4(String ip) {
		String[] tokens = ip.split("\\.");
		if (tokens.length != 4) {
			return false;
		}
		if (ip.startsWith(".") || ip.endsWith(".")) {
			return false;
		}
		for (String eachToken : tokens) {
			try {
				if (eachToken.length() < 1 || eachToken.length() > 3) {
					return false;
				} else {
					Integer i = Integer.parseInt(eachToken);
					if (i < 0 || i > 255) {
						return false;
					} else {
						if (i != 0 && eachToken.startsWith("0")) {
							return false;
						}
					}
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
}
