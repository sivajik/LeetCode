package leetcode.easy;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Prob1185_DayOfTheWeek {

	public static void main(String[] args) {
		System.out.println(dayOfTheWeek(31, 8, 2019));
		System.out.println(dayOfTheWeek(18, 7, 1999));
		System.out.println(dayOfTheWeek(15, 8, 1993));
	}

	public static String dayOfTheWeek(int day, int month, int year) {
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, day);
		int result = cal.get(Calendar.DAY_OF_WEEK);
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		return (days[result - 1]);
	}
}
