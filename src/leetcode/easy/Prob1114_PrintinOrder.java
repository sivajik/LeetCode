package leetcode.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class Prob1114_PrintinOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Foo {

		AtomicInteger firstOne = new AtomicInteger(0);
		AtomicInteger secondOne = new AtomicInteger(0);

		public Foo() {

		}

		public void first(Runnable printFirst) throws InterruptedException {
			printFirst.run();
			firstOne.incrementAndGet();
		}

		public void second(Runnable printSecond) throws InterruptedException {
			while (firstOne.get() != 1) {

			}
			printSecond.run();
			secondOne.incrementAndGet();
		}

		public void third(Runnable printThird) throws InterruptedException {
			while (secondOne.get() != 1) {

			}
			printThird.run();
		}
	}
}
