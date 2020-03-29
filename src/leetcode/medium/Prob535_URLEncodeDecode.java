package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob535_URLEncodeDecode {
	Map<String, String> longToShort = new HashMap<String, String>();
	Map<String, String> shortToLong = new HashMap<String, String>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String value = getDigest(longUrl);
		longToShort.put(longUrl, value);
		shortToLong.put(value, longUrl);
		return value;
	}

	private String getDigest(String longUrl) {
		return "http://tinyurl.com/" + longUrl.hashCode();
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return shortToLong.get(shortUrl);
	}

	public static void main(String[] args) {
		Prob535_URLEncodeDecode x = new Prob535_URLEncodeDecode();
		String value = x.encode("https://leetcode.com/problems/design-tinyurl");
		String value1 = x.decode(value);
		System.out.println(value);
		System.out.println(value1);
	}

}
