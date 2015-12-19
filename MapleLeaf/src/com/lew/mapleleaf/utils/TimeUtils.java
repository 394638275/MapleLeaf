package com.lew.mapleleaf.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TimeUtils {

	/**
	 * 格式化成易于日常理解的逻辑时间,类似于新闻客户端的2小时前,一周前
	 */
	public static String formatLogicTime(long time) {
		Calendar today = Calendar.getInstance();
		Calendar other = Calendar.getInstance();
		other.setTimeInMillis(time);
		if (isSameDay(today.getTimeInMillis(), other.getTimeInMillis())) {
			return formatTime(time, "HH:mm");
		} else {
			long differ = differDay(time, today.getTimeInMillis());
			if (differ == -1) {
				return "昨天";
			} else if (differ == -2) {
				return "前天";
			} else {
				if (isSameYear(today.getTimeInMillis(), time)) {
					return formatTime(time, "MM-dd");
				} else {
					return formatTime(time, "yyyy-MM-dd");
				}
			}
		}
	}

	/**
	 * 格式化时间，xx分钟前，xx小时前，x月x日，x年x月x日
	 * 
	 * @param time
	 * @return
	 */
	public static String formatLogicTime2(long time) {
		Calendar today = Calendar.getInstance();
		Calendar other = Calendar.getInstance();
		other.setTimeInMillis(time);
		long currentTime = System.currentTimeMillis();
		long span = currentTime - time;
		long oneHour = 60 * 60 * 1000;
		long sixHour = 6 * oneHour;
		if (span < oneHour) {
			return (span / (1000 * 60)) + "分钟前";
		} else if (span < sixHour) {
			return (span / (1000 * 60 * 60)) + "小时前";
		} else {
			if (isSameYear(today.getTimeInMillis(), time)) {
				return formatTime(time, "MM-dd");
			} else {
				return formatTime(time, "yyyy-MM-dd");
			}
		}
	}

	/**
	 * 格式化时间， 今天，昨天，日-月
	 * 
	 * @param time
	 * @return
	 */
	public static String formatLogicTime3(long time) {
		Calendar today = Calendar.getInstance();
		Calendar other = Calendar.getInstance();
		other.setTimeInMillis(time);
		if (isSameDay(today.getTimeInMillis(), other.getTimeInMillis())) {
			return "今天";
		} else {
			long differ = differDay(time, today.getTimeInMillis());
			if (differ == -1) {
				return "昨天";
			} else {
				return formatTime(time, "ddMM月");
			}
		}
	}

	public static String formatLogicTime4(long time) {
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(time);
		return formatTime(time, "MM月dd日 HH:mm");
	}

	public static String formatTime(long time, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
		return sdf.format(time);

	}

	public static boolean isSameDay(long time1, long time2) {
		Calendar calTime1 = Calendar.getInstance();
		calTime1.setTimeInMillis(time1);
		Calendar calTime2 = Calendar.getInstance();
		calTime2.setTimeInMillis(time2);
		return (calTime1.get(Calendar.YEAR) == calTime2.get(Calendar.YEAR))
				&& (calTime1.get(Calendar.MONTH) == calTime2.get(Calendar.MONTH))
				&& (calTime1.get(Calendar.DATE) == calTime2.get(Calendar.DATE));
	}

	public static long differDay(long time1, long time2) {
		Calendar calTime1 = Calendar.getInstance();
		calTime1.setTimeInMillis(time1);
		calTime1.set(Calendar.HOUR, 0);
		calTime1.set(Calendar.MINUTE, 0);
		calTime1.set(Calendar.SECOND, 0);
		calTime1.set(Calendar.MILLISECOND, 0);
		Calendar calTime2 = Calendar.getInstance();
		calTime2.setTimeInMillis(time2);
		calTime2.set(Calendar.HOUR, 0);
		calTime2.set(Calendar.MINUTE, 0);
		calTime2.set(Calendar.SECOND, 0);
		calTime2.set(Calendar.MILLISECOND, 0);
		return (calTime1.getTimeInMillis() - calTime2.getTimeInMillis()) / (1000 * 60 * 60 * 24);
	}

	public static boolean isSameYear(long time1, long time2) {
		Calendar calTime1 = Calendar.getInstance();
		calTime1.setTimeInMillis(time1);
		Calendar calTime2 = Calendar.getInstance();
		calTime2.setTimeInMillis(time2);
		return calTime1.get(Calendar.YEAR) == calTime2.get(Calendar.YEAR);
	}
}
