package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prob0811_SubdomainCount {

	public static void main(String[] args) {
		String[] ip = new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		List<String> op = subdomainVisits(ip);
		System.out.println(op);
	}

	public static List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String domain : cpdomains) {
			String[] parts = domain.split(" ");

			String domainName = parts[1];
			Integer domainFreq = Integer.parseInt(parts[0]);
			//map.put(domainName, domainFreq);

			String concat = "";
			String subdomains[] = domainName.split("\\.");			
			for (int i = subdomains.length - 1; i >= 0; i--) {
				String subdomain = subdomains[i];
				concat = concat.length() > 0 ? subdomain + "." + concat : subdomain;
				//if (!concat.equalsIgnoreCase(domainName)) {
					if (map.containsKey(concat)) {
						map.put(concat, map.get(concat) + domainFreq);
					} else {
						map.put(concat, domainFreq);
					}
				//}
			}
		}

		List<String> result = new ArrayList<String>();
		map.forEach((k, v) -> {
			result.add(v + " " + k);
		});
		return result;
	}
}
