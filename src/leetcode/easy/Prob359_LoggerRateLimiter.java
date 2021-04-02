package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob359_LoggerRateLimiter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Logger {
		Map<String, Integer> map;

		public Logger() {
			this.map = new HashMap<>();
		}

		public boolean shouldPrintMessage(int timestamp, String message) {
			if (map.containsKey(message)) {
				int currTime = map.get(message);
				if (timestamp < currTime + 10) {
					return false;
				} else {
					map.put(message, timestamp);
					return true;
				}
			} else {
				map.put(message, timestamp);
				return true;
			}
		}
	}

}
