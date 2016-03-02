package com.hao.schoa.tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

public class SchoaUtil {

	/**
	 * 将日期时间的字符串变为unix时间戳
	 * 
	 * @param dateTime
	 *            字符串类型yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static long getUnixTimes(String dateTime) {
		try {
			return getUnixTimes(Constant.FULLDATE.parse(dateTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0L;
	}

	/**
	 * 得到当前年份
	 * @return
	 */
	public static int getCurYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}
	
	public static int getDateYear(Date dt) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 将日期时间变为unix时间戳
	 * 
	 * @param dateTime 日期类型
	 * @return
	 */
	public static long getUnixTimes(Date dateTime) {
		return dateTime.getTime() / 1000;
	}

	/**
	 * 截取字符串 2012-5-11, 下午4:42:17 方法描述：
	 * 
	 * @param str 原始字符串
	 * @param length 要截取的长度
	 * @return
	 */
	public static String substring(String str, float length) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		String tmp = "";
		try {
			if (str.getBytes("GBK").length <= length * 2) {
				return str;
			}
			for (int i = 0; i < str.length(); i++) {
				String y = str.substring(0, i + 1);
				if (y.getBytes("GBK").length > length * 2) {
					break;
				}
				tmp = y;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return tmp + "...";
	}

	/**
	 * 得到指定日期所在周的第一天的日期, 时分为00:00:00
	 * 
	 * @param date
	 * @param locale
	 * @return
	 */
	public static String getFirstDayInWeekStr(Date date) {
		Date dt = getFirstDayInWeek(date);
		return Constant.DATE.format(dt);
	}

	/**
	 * 日期加减N天
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addDay(Date date, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.add(Calendar.DATE, amount);
		return calendar.getTime();
	}

	/**
	 * 日期加减N天
	 * @param date
	 * @param amount
	 * @return
	 */
	public static String addDayStr(Date date, int amount) {
		Date dt = addDay(date, amount);
		return Constant.DATE.format(dt);
	}

	/**
	 * 得到指定日期所在周的第一天日期
	 * @param date
	 * @return
	 */
	public static Date getFirstDayInWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.setFirstDayOfWeek(Calendar.MONDAY); // 设置每周的第一天为星期一
		int firstDayOfWeek = calendar.getFirstDayOfWeek();// 一周的第一天是星期几
		int week = calendar.get(Calendar.DAY_OF_WEEK);// 当前是星期几, 1表示星期日
		int dayOfWeek = 0; // 当前是这周的第几天
		if (firstDayOfWeek == week) {// 当前是这周的第一天
			dayOfWeek = 1;
		} else if (firstDayOfWeek > week) {
			dayOfWeek = 7 - week + firstDayOfWeek - 1;
		} else if (firstDayOfWeek < week) {
			dayOfWeek = week - firstDayOfWeek + 1;
		}
		calendar.add(Calendar.DAY_OF_WEEK, 1 - dayOfWeek);
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE,
				calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND,
				calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 得到指定日期所在周的周末的日期
	 * 
	 * @param date
	 * @param locale
	 * @return
	 */
	public static Date getLastDayInWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.setFirstDayOfWeek(Calendar.MONDAY); // 设置每周的第一天为星期一
		int firstDayOfWeek = calendar.getFirstDayOfWeek();// 一周的第一天是星期几
		int week = calendar.get(Calendar.DAY_OF_WEEK);// 当前是星期几
		int dayOfWeek = 0; // 当前是这周的第几天
		if (firstDayOfWeek == week) {// 当前是这周的第一天
			dayOfWeek = 1;
		} else if (firstDayOfWeek > week) {
			dayOfWeek = 7 - week + firstDayOfWeek - 1;
		} else if (firstDayOfWeek < week) {
			dayOfWeek = week - firstDayOfWeek + 1;
		}
		calendar.add(Calendar.DAY_OF_WEEK, 7 - dayOfWeek);
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE,
				calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND,
				calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 得到指定日期所在周的周末的日期
	 * @param date
	 * @return
	 */
	public static String getLastDayInWeekStr(Date date) {
		Date dt = getLastDayInWeek(date);
		return Constant.DATE.format(dt);
	}

	/**
	 * 时间选择数据 08:00 - 22:00, 每条记录隔5分钟
	 * @return
	 */
	public static List<String> getTimeList(){
		List<String> ls = new ArrayList<String>();
		for (int hour = 8; hour < 22; hour++) {
			for (int i = 0; i <= 55; i += 5) {
				String h = hour < 10 ? "0" : "";
				String m = i < 10 ? "0" : "";
				ls.add(h + hour + ":" + m + i);
			}
		}
		ls.add("22:00");
		return ls;
	}
	
	/**
	 * 生成随机路径
	 * @param length
	 * @param max
	 * @return
	 */
	public static String getRandomPath(int length, int max) {
		StringBuffer buffer = new StringBuffer("/");
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			buffer.append(r.nextInt(max) + "/");
		}
		return buffer.toString();
	}
	
	/**
	 * 创建文件夹，返回目标文件
	 * @param path
	 * @param name
	 * @return
	 */
	public static File genDestFile(String path, String name){
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		if(StringUtils.isBlank(name)){
			return null;
		}
		return new File(path + name);
	}
	
	/**
	 * 星期下标
	 * @param dt
	 * @return
	 */
	public static int getWeekIndex(Date dt){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.DAY_OF_WEEK)-1;
	}
	
	/**
	 * 日期加减N天
	 * @param dt
	 * @param i
	 * @return
	 */
	public static Date addDate(Date dt, int i){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DATE, i);
		return cal.getTime();
	}
	
	/**
	 * 得到两个日期间的星期下标，拼成字符串，以“,”分割
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static String getWeekIndexBetweenDate(Date d1, Date d2){
		StringBuffer sbr = new StringBuffer();
		int i = 0;
		while(true){
			d1 = addDate(d1, 1);
			int index = getWeekIndex(d1)-1;
			index = index==-1?6:index;
			if(i != 0){
				sbr.append(",");
			}
			sbr.append(index);
			if(d1.equals(d2)){
				break;
			}
			i++;
		}
		return sbr.toString();
	}
	
	/**
	 * 两个日期相隔的天数
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Long selectDaysBetweenDate(Date d1, Date d2) { 
		return (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * 拼排课时间
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date pinPaikeTime(String time) throws ParseException{
		return Constant.FULLDATE.parse(pinPaikeTimeStr(time));
	}
	
	public static String pinPaikeTimeStr(String time) {
		return "2013-01-01 " + time + ":00";
	}
	
	public static String getDefalutImage(){
		String classPath = SchoaUtil.class.getResource("/").getPath();
		return  classPath.substring(0, classPath.indexOf("WEB-INF")) + "imgs/pic_no.png";
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println(getDateYear(new Date()));
	}
	
	public static void runShell(String sh) throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(new String[]{"/bin/sh", sh},null,null);
		
		InputStreamReader ir = new InputStreamReader(process.getInputStream());  
		LineNumberReader input = new LineNumberReader(ir);  
		String line;  
        	process.waitFor();  
        	while ((line = input.readLine()) != null){  
        		System.out.println(line);
        	}  
	}
	
	public static String splitTags(String tags){
		if(StringUtils.isNotBlank(tags)){
			String[] tagsArr = tags.split(System.getProperty("line.separator"));
			StringBuffer sbr = new StringBuffer();
			for(String str : tagsArr){
				sbr.append(str.trim()).append(" ");
			}
			return sbr.toString();
		}else{
			return "";
		}
	}
	
	public static String collectionToString(Collection<Integer> c){
		if(c == null){
			return "";
		}
		int i = 0;
		StringBuffer sbr = new StringBuffer();
		for (int obj : c) {
			if(i != 0){
				sbr.append(",");
			}
			sbr.append(obj);
			i += 1;
		}
		return sbr.toString();
	}
	public static String collectionStrToString(Collection<String> c){
		if(c == null){
			return "";
		}
		int i = 0;
		StringBuffer sbr = new StringBuffer();
		for (String obj : c) {
			if(i != 0){
				sbr.append(",");
			}
			sbr.append(obj.trim());
			i += 1;
		}
		return sbr.toString();
	}
	
}
