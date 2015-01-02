package hu.mortoff.wcfe.common.test;

import static hu.mortoff.wcfe.common.DateUtils.addDays;
import static hu.mortoff.wcfe.common.DateUtils.getDateWithoutTimePart;
import static hu.mortoff.wcfe.common.DateUtils.getEndOfWeek;
import static hu.mortoff.wcfe.common.DateUtils.getStartOfWeek;
import static hu.mortoff.wcfe.common.DateUtils.getWeekOfYear;
import static hu.mortoff.wcfe.common.DateUtils.isInThePast;
import static hu.mortoff.wcfe.common.DateUtils.todayStart;
import static hu.mortoff.wcfe.common.DateUtils.tomorrowStart;
import static hu.mortoff.wcfe.common.DateUtils.yesterdayStart;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import hu.mortoff.wcfe.common.DateUtils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Gabor Kokeny
 *
 */
public class DateUtilsTest {

	@Test
	public void testTodayStart() {
		assertTimePartCleared(todayStart());
	}

	@Test
	public void testYesterdayStart() {

		Date yesterdayStart = yesterdayStart();

		assertTimePartCleared(yesterdayStart);
		assertEquals(addDays(todayStart(), -1), yesterdayStart);
	}

	@Test
	public void testTomorrowStart() {

		Date tomorrowStart = tomorrowStart();

		assertTimePartCleared(tomorrowStart);
		assertEquals(addDays(todayStart(), 1), tomorrowStart);
	}

	@Test
	public void testGetWeekOfYear() {

		Date now = new Date();
		Calendar calendar = Calendar.getInstance();

		assertEquals(calendar.get(Calendar.WEEK_OF_YEAR), getWeekOfYear(now));
	}

	@Test
	public void testGetStartOfWeek() {

		Date startOfWeek = getStartOfWeek();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, 1);

		assertEquals(getDateWithoutTimePart(startOfWeek), startOfWeek);

	}

	@Test
	public void testGetEndOfWeek() {

		Date endOfWeek = getEndOfWeek();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, 7);

		assertEquals(getDateWithoutTimePart(endOfWeek), endOfWeek);

	}

	@Test
	public void testAddDays() {
		int days = 6;
		Date now = new Date();
		assertAddField(now, DateUtils.addDays(now, days), Calendar.DATE, days);
		assertAddField(now, DateUtils.addDays(now, -days), Calendar.DATE, -days);
	}

	@Test
	public void testAddWeeks() {
		int weeks = 3;
		Date now = new Date();
		assertAddField(now, DateUtils.addWeeks(now, weeks),
				Calendar.WEEK_OF_YEAR, weeks);
		assertAddField(now, DateUtils.addWeeks(now, -weeks),
				Calendar.WEEK_OF_YEAR, -weeks);
	}

	@Test
	public void testAddMonth() {
		int months = 5;
		Date now = new Date();
		assertAddField(now, DateUtils.addMonths(now, months), Calendar.MONTH,
				months);
		assertAddField(now, DateUtils.addMonths(now, -months), Calendar.MONTH,
				-months);
	}

	@Test
	public void testAddHours() {
		int hours = 6;
		Date now = new Date();
		assertAddField(now, DateUtils.addHours(now, hours), Calendar.HOUR,
				hours);
		assertAddField(now, DateUtils.addHours(now, -hours), Calendar.HOUR,
				-hours);
	}

	public void testAddMinutes() {
		int minutes = 34;
		Date now = new Date();
		assertAddField(now, DateUtils.addMinutes(now, minutes),
				Calendar.MINUTE, minutes);
		assertAddField(now, DateUtils.addMinutes(now, -minutes),
				Calendar.MINUTE, -minutes);
	}

	@Test
	public void testAddSeconds() {
		int seconds = 44;
		Date now = new Date();
		assertAddField(now, DateUtils.addSeconds(now, seconds),
				Calendar.SECOND, seconds);
		assertAddField(now, DateUtils.addSeconds(now, -seconds),
				Calendar.SECOND, -seconds);
	}

	@Test
	public void testAddMilliSeconds() {
		int ms = 100;
		Date now = new Date();
		assertAddField(now, DateUtils.addMilliseconds(now, ms),
				Calendar.MILLISECOND, ms);
		assertAddField(now, DateUtils.addMilliseconds(now, -ms),
				Calendar.MILLISECOND, -ms);
	}

	public void assertAddField(Date now, Date actualDate, int field, int amount) {
		assertNotNull(now);
		assertNotNull(actualDate);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(field, amount);

		assertEquals(calendar.getTime(), actualDate);
	}

	@Test
	public void testIsInThePast() {

		assertFalse(isInThePast(getEndOfWeek()));

		assertFalse(isInThePast(tomorrowStart()));

		assertTrue(isInThePast(todayStart()));

		assertTrue(isInThePast(yesterdayStart()));

		assertTrue(isInThePast(getStartOfWeek()));
	}

	@Test
	public void testGetCurrentYear() {

		int currentYear = DateUtils.getCurrentYear();

		Calendar calendar = Calendar.getInstance();

		assertEquals(calendar.get(Calendar.YEAR), currentYear);
	}

	private static void assertTimePartCleared(Date todayStart) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(todayStart);

		assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
		assertEquals(0, calendar.get(Calendar.MILLISECOND));

	}

	@Test
	public void testDayDiff() {

		int expectedDayDiff = -5;

		Date now = DateUtils.now();
		Date targetDate = DateUtils.addDays(now, expectedDayDiff);

		long dayDiff = DateUtils.getDayDiff(targetDate, now);

		Assert.assertEquals(expectedDayDiff, dayDiff);
	}

}