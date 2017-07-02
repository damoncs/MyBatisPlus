package org.aries;

import java.text.SimpleDateFormat;

public final class DateFormatUtil {
	public static SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat dateTime_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public static SimpleDateFormat dateTime2 = new SimpleDateFormat("yyyyMMddHHmmss");
	public static SimpleDateFormat dateTime3 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public static SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat date1 = new SimpleDateFormat("yyyy/MM/dd");
	public static SimpleDateFormat date2 = new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat date_yyyy_MM = new SimpleDateFormat("yyyy-MM");
	public static SimpleDateFormat dateyyyyMM = new SimpleDateFormat("yyyyMM");
}
