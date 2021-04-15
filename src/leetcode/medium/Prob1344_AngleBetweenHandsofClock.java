package leetcode.medium;

public class Prob1344_AngleBetweenHandsofClock {

	public static void main(String[] args) {
		System.out.println(angleClock(3, 30) == 75);
		System.out.println(angleClock(12, 30) == 165);
		System.out.println(angleClock(3, 15) == 7.5);
		System.out.println(angleClock(12, 30) == 165);
		System.out.println(angleClock(4, 50) == 155);
		System.out.println(angleClock(12, 0) == 0);
		System.out.println(angleClock(1, 57) == 76.50000);

		System.out.println(angleClock(4, 0) == 120);
	}

	static public double angleClock(int hour, int minutes) {
		double eachMinAngle = 360.0 / 60; // we got 60 mins for 360 degrees
		double hourAngle = 360.0 / 12; // we got 12 hrs for 360 degress

		double minAngle = minutes * eachMinAngle;
		double hrsAngle = (hour % 12 + minutes / 60.0) * hourAngle;

		double diff = Math.abs(hrsAngle - minAngle);
		return Math.min(diff, 360 - diff);

	}

	static public double angleClock1(int hour, int minutes) {
		if (hour == 12) {
			hour = 0;
		}

		int b = minutes * 6; // 180
		double a = hour;
		double eachMinuteTravel = 5.0 / 60.0;
		if (minutes > 0) {
			a = ((hour * 5) + (minutes * eachMinuteTravel)) * 6;
		} else {
			a = ((hour * 5)) * 6;
		}
		System.out.println("Angle is: " + Math.min(360 - Math.abs(a - b), Math.abs(a - b)));
		return Math.min(360 - Math.abs(a - b), Math.abs(a - b));
	}
}
