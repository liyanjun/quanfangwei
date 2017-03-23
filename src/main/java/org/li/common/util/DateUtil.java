package org.li.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {

    public static final String PATTERN_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YMD = "yyyy-MM-dd";
    public static final String PATTERN_HMS = "HH:mm:ss";
    public static final String PATTERN_HM = "HH:mm";

    public static final Integer MS_DAY = 86400000;
    public static final Integer MS_HOUR = 3600000;
    public static final Integer MS_MINUTE = 60000;

    public static void main(String[] args) {
        try {
            System.out.println(strToDate("25:00", PATTERN_HM));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取系统当前时间，返回Timestamp类型
     *
     * @return
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 获取系统当前日期，返回String"yyyy-MM-dd HH:mm:ss"格式
     *
     * @return
     */
    public static String getCurrentDateStr() {
        Date date = new Date();
        return getYMDHMS(date);
    }

    /**
     * 通过String格式得到Timestamp
     *
     * @param str 格式必须为"yyyy-mm-dd hh:mm:ss"
     * @return
     * @throws ParseException
     */
    public static Timestamp strToTimestamp(String str) throws ParseException {
        if (null == str || "".equals(str)) {
            return null;
        } else {
            str += ".0";
        }
        Timestamp ts = Timestamp.valueOf(str);
        return ts;
    }

    /**
     * 通过String格式得到Date——通过format定义格式
     *
     * @param str
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str, String format) throws ParseException {
        if (null == str || "".equals(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(str);
    }

    /**
     * Date格式化为String类型——通过format自定义格式
     *
     * @param date
     * @param format 格式 如"yyyy-MM-dd hh:mm:ss"
     * @return
     */
    public static String getStr(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Date转换为String，格式为"yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * @return
     */
    public static String getYMDHMS(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMDHMS); //大写H才是24小时制
        return sdf.format(date);
    }

    /**
     * Date转换为String，格式为"yyyy-MM-dd"
     *
     * @param date
     * @return
     */
    public static String getYMD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMD);
        return sdf.format(date);
    }

    /**
     * Date转换为String，格式为"hh:mm:ss"
     *
     * @param date
     * @return
     */
    public static String getHMS(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_HMS);
        return sdf.format(date);
    }

    //获取年月日时分秒
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DATE);
    }

    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }


    /**
     * 返回一星期的第几天，如星期一则返回1
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 返回中文星期，如"星期一"
     *
     * @param date
     * @return
     */
    public static String getChineseWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        switch (c.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "未知";

        }
    }

    //日期计算

    /**
     * 年数加n（n可以为负数）
     *
     * @param date
     * @return
     */
    public static Timestamp addYear(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, n);
        return new Timestamp(c.getTime().getTime());
    }

    /**
     * 月数加n（n可以为负数）
     *
     * @param date
     * @return
     */
    public static Timestamp addMonth(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, n);
        return new Timestamp(c.getTime().getTime());
    }

    /**
     * 天数加n（n可以为负数）
     *
     * @param date
     * @return
     */
    public static Timestamp addDay(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, n);
        return new Timestamp(c.getTime().getTime());
    }

    /**
     * 小时加n（n可以为负数）
     *
     * @param date
     * @return
     */
    public static Timestamp addHour(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, n);
        return new Timestamp(c.getTime().getTime());
    }

    /**
     * 分钟加n（n可以为负数）
     *
     * @param date
     * @return
     */
    public static Timestamp addMinute(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, n);
        return new Timestamp(c.getTime().getTime());
    }

    /**
     * 秒数加n（n可以为负数）
     *
     * @param date
     * @return
     */
    public static Timestamp addSecond(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, n);
        return new Timestamp(c.getTime().getTime());
    }

    /**
     * 计算两个日期相差的天数，只考虑年月日，不考虑时分秒(如果加上时分秒，可能导致天数计算错误)
     *
     * @param before
     * @param after
     * @return int 相差的天数，有可能为负数
     */
    public static int getDateDiff(Date before, Date after) {
        if (before == null || after == null)
            return 0;
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(before);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        calendar2.setTime(after);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);
        int diff = (int) ((calendar2.getTime().getTime() - calendar1.getTime().getTime()) / (24 * 60 * 60 * 1000));
        return diff;
    }

    /**
     * 计算两个日期相差的分钟
     *
     * @param before
     * @param after
     * @return int 相差的分钟
     */
    public static long getDateMinuteDiff(Date before, Date after) {
        if (before == null || after == null)
            return 0;
        long day = (before.getTime() - after.getTime()) / (60 * 1000);
        return day;
    }

    /**
     * 计算两个日期相差的天数，不考虑日期前后，返回结果>=0
     *
     * @param before
     * @param after
     * @return
     */
    public static int getAbsDateDiff(Date before, Date after) {
        int diff = getDateDiff(before, after);
        return Math.abs(diff);
    }

    //日期比较

    /**
     * 比较第一个日期是否早于第二个日期
     * 利用了getDateDiff方法，如果两者相差天数>0,则为true;
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean getDateIsBefore(Date d1, Date d2) {
        if (d1 == null || d2 == null)
            return false;
        int diff = getDateDiff(d1, d2);
        if (diff > 0) return true;
        return false;
    }

    /**
     * 比较第一个日期是否晚于第二个日期
     * 利用了getDateDiff方法，如果两者相差天数<0,则为true;
     *
     * @param d1
     * @param d2
     * @return boolean
     */
    public static boolean getDateIsAfter(Date d1, Date d2) {
        if (d1 == null || d2 == null)
            return false;
        int diff = getDateDiff(d1, d2);
        if (diff < 0) return true;
        return false;
    }

    /**
     * 毫秒数转指定格式的日期字符串
     *
     * @param millSec
     * @param format
     * @return
     */
    public static String millSecToDate(Long millSec, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    /**
     * 天，小时，分钟转成毫秒数.3个参数其中一个小于0，则返回0.
     *
     * @param day
     * @param hour
     * @param minute
     * @return
     */
    public static Long ToMillSec(int day, int hour, int minute) {
        if (day < 0 || hour < 0 || minute < 0) {
            return Long.valueOf(0);
        }
        return Long.valueOf(day * MS_DAY + hour * MS_HOUR + minute * MS_MINUTE);
    }

    /**
     * 将日期字符串数组转为日期数组
     *
     * @param dates
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date[] stringToDates(String[] dates, String format) throws ParseException {
        Date[] d = new Date[dates.length];
        for (int i = 0; i < dates.length; i++) {
            d[i] = strToDate(dates[i], format);
        }
        return d;
    }
}
