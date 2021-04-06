package leetcode.medium;

import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class Prob1195_FizzBuzzMultithreaded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class FizzBuzz {
		private int n;
		final AtomicInteger counter;

		public FizzBuzz(int n) {
			this.n = n;
			this.counter = new AtomicInteger(1);
		}

		// printFizz.run() outputs "fizz".
		public void fizz(Runnable printFizz) throws InterruptedException {
			int count;
			while ((count = counter.get()) <= n) {
				if (count % 3 == 0 && count % 5 != 0) {
					printFizz.run();
					update(count);
				}
			}
		}

		// printBuzz.run() outputs "buzz".
		public void buzz(Runnable printBuzz) throws InterruptedException {
			int count;
			while ((count = counter.get()) <= n) {
				if (count % 3 != 0 && count % 5 == 0) {
					printBuzz.run();
					update(count);
				}
			}
		}

		// printFizzBuzz.run() outputs "fizzbuzz".
		public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
			int count;
			while ((count = counter.get()) <= n) {
				if (count % 3 == 0 && count % 5 == 0) {
					printFizzBuzz.run();
					update(count);
				}
			}
		}

		// printNumber.accept(x) outputs "x", where x is an integer.
		public void number(IntConsumer printNumber) throws InterruptedException {
			int count;
			while ((count = counter.get()) <= n) {
				if (count % 3 != 0 && count % 5 != 0) {
					printNumber.accept(count);
					update(count);
				}
			}
		}

		private void update(int count) {
			if (!counter.compareAndSet(count, count + 1)) {
				throw new ConcurrentModificationException();
			}

		}

	}
}
