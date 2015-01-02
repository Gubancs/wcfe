package hu.mortoff.wcfe.common;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.util.Assert;

/**
 * 
 * @author Gabor Kokeny
 *
 */
public class DateUtils {

	public static long getDayDiff(Date targetDate) {
		return getDateDiff(targetDate, DateUtils.now(), TimeUnit.DAYS);
	}

	public static long getDayDiff(Date targetDate, Date sourceDate) {
		return getDateDiff(targetDate, sourceDate, TimeUnit.DAYS);
	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date1.getTime() - date2.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	public static Date addMilliseconds(Date date, int amount) {
		return add(date, Calendar.MILLISECOND, amount);
	}

	public static Date addSeconds(Date date, int amount) {
		return add(date, Calendar.SECOND, amount);
	}

	public static Date addHours(Date date, int amount) {
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}

	public static Date addMinutes(Date date, int amount) {
		return add(date, Calendar.MINUTE, amount);
	}

	public static Date addYears(Date date, int years) {
		return add(date, Calendar.YEAR, years);
	}

	public static Date addMonths(Date date, int months) {
		return add(date, Calendar.MONTH, months);
	}

	public static Date addDays(Date date, int days) {
		return add(date, Calendar.DATE, days);
	}

	public static Date addWeeks(Date date, int weeks) {
		return add(date, Calendar.WEEK_OF_YEAR, weeks);
	}

	private static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	public static Date now() {
		return new Date();
	}

	public static Long nowInMills() {
		return now().getTime();
	}

	public static int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	public static Date todayStart() {
		return getDateWithoutTimePart(new Date());
	}

	public static Date todayStart(Date date) {
		return getDateWithoutTimePart(date);
	}

	public static Date yesterdayStart() {
		return DateUtils.addDays(todayStart(), -1);
	}

	public static Date yesterdayStart(Date date) {
		return DateUtils.addDays(date, -1);
	}

	public static Date tomorrowStart() {
		return DateUtils.addDays(todayStart(), 1);
	}

	public static Date tomorrowStart(Date date) {
		return DateUtils.addDays(date, 1);
	}

	public static Date getDateWithoutTimePart(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();

	}

	public static Date getStartOfWeek() {
		return getStartOfWeek(new Date());
	}

	public static Date getEndOfWeek() {
		return getEndOfWeek(new Date());
	}

	public static Date getEndOfWeek(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			calendar.add(Calendar.DATE, 1);
		}
		return getDateWithoutTimePart(calendar.getTime());
	}

	public static Date getStartOfWeek(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
			calendar.add(Calendar.DATE, -1);
		}
		return getDateWithoutTimePart(calendar.getTime());

	}

	public static boolean isSameDay(Date d1, Date d2) {
		return getDateWithoutTimePart(d1).compareTo(getDateWithoutTimePart(d2)) == 0;
	}

	public static Date getDate(int year, int week) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, 2);
		return getDateWithoutTimePart(cal.getTime());
	}

	public static boolean isInThePast(Date date) {
		return date.before(new Date());
	}

	public static int getWeekOfYear(Date date) {
		Assert.notNull(date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return cal.get(Calendar.WEEK_OF_YEAR);
	}

}