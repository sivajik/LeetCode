package leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prob895_MaximumFrequencyStack {

	public static void main(String[] args) {
		FreqStack freqStack = new FreqStack();
		freqStack.push(5); // The stack is [5]
		freqStack.push(7); // The stack is [5,7]
		freqStack.push(5); // The stack is [5,7,5]
		freqStack.push(7); // The stack is [5,7,5,7]
		freqStack.push(4); // The stack is [5,7,5,7,4]
		freqStack.push(5); // The stack is [5,7,5,7,4,5]
		System.out.println(freqStack.pop()); // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
		System.out.println(freqStack.pop()); // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
												// The stack becomes [5,7,5,4].
		System.out.println(freqStack.pop()); // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
		System.out.println(freqStack.pop()); // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the
												// top. The stack becomes [5,7].
	}

	static class FreqStack {
		Map<Integer, Integer> freq;
		Map<Integer, Stack<Integer>> group;
		int maxFreq;

		public FreqStack() {
			this.freq = new HashMap<>();
			this.group = new HashMap<>();
			this.maxFreq = 0;
		}

		public void push(int val) {
			if (freq.containsKey(val)) {
				freq.put(val, 1 + freq.get(val));
			} else {
				freq.put(val, 1);
			}

			if (freq.get(val) > maxFreq) {
				maxFreq = freq.get(val);
			}

			int f = freq.get(val);

			if (group.get(f) != null) {
				Stack<Integer> s = group.get(f);
				s.push(val);
				group.put(f, s);
			} else {
				Stack<Integer> s = new Stack<>();
				s.push(val);
				group.put(f, s);
			}
		}

		public int pop() {
			int x = group.get(maxFreq).pop();
			freq.put(x, freq.get(x) - 1);

			if (group.get(maxFreq).size() == 0) {
				maxFreq--;
			}

			return x;
		}
	}
}
