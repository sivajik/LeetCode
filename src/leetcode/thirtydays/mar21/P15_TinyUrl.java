package leetcode.thirtydays.mar21;

import java.util.HashMap;

public class P15_TinyUrl {

	public static void main(String[] args) {
		String url = "https://leetcode.com/problems/design-tinyurl";
		Codec codec = new Codec();
		System.out.println(codec.encode(url));
		System.out.println(codec.decode(codec.encode(url)));
	}

}

class Codec {
	HashMap<String, String> cache = new HashMap<String, String>();
	private static final String shortURLPrefix = "http://tinyurl.com/";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String hash = String.valueOf(Math.abs(longUrl.hashCode()));
		cache.put(hash, longUrl);
		return shortURLPrefix + hash;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		String hash = shortUrl.replaceAll(shortURLPrefix, "");
		if (cache.containsKey(hash)) {
			return cache.get(hash);
		} else {
			return null;
		}
	}
}
