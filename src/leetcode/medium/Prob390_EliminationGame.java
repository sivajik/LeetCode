package leetcode.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Prob390_EliminationGame {
	public static void main(String[] args) throws Exception {
		/*System.out.println(lastRemaining(9));
		System.out.println(lastRemaining(6));
		System.out.println(lastRemaining(1));
		System.out.println(lastRemaining(2));*/
		System.out.println(lastRemaining(10000000));
	}

	public static int lastRemaining(int n) {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		/*int x = 0;
		while (list.size() != 1) {
			Iterator<Integer> itr = list.iterator();
			
			if (x % 2 == 0) {
				
			} else {
				if (itr.hasNext()) {
					itr.next();
				}
			}
			while (itr.hasNext()) {
				Integer number = itr.next();
				System.out.println("LEFT -> Processed: " + number);
				itr.remove();
				if (itr.hasNext()) {
					itr.next();
				}
			}
			x = x + 1;
			//Collections.reverse(list);
		}*/
		return list.get(0);
	}
}
