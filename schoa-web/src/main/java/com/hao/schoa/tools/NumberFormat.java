package com.hao.schoa.tools;

import java.text.DecimalFormat;

/**
 * 数字格式化
 * 
 * @author bjhaoguowei
 * 
 */
public class NumberFormat {

	private static String PATTERN_BAIFENBI = "#.##%"; // 百分比
	private static String PATTERN_DOUBLE = "#.##"; // 保留两位小数
	private static String PATTERN_MONEY = "#,##0.00"; // money
	private static String PATTERN_FENGE = ",###"; // 每三位以逗号进行分隔。 299,792,458

	public static String format(String pattern, Object val) {
		return new DecimalFormat(pattern).format(val);
	}

	// money
	public static String formatMoney(double money) {
		return format(PATTERN_MONEY, money);
	}

	// 保留两位小数
	public static String formatDouble(double d) {
		return format(PATTERN_DOUBLE, d);
	}

	// 百分比
	public static String formatBaiFenBi(double d) {
		return format(PATTERN_BAIFENBI, d);
	}

	public static void main(String[] args) {
		System.out.println(formatDouble(12.3451));
	}
}
