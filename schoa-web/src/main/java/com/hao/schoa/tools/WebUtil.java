package com.hao.schoa.tools;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hao.schoa.po.ClassesKecheng;
import com.hao.schoa.po.QuestionTixing;
import com.hao.schoa.po.WaipinTeacherJixiao;

public class WebUtil {

	private static final boolean WaipinTeacherJixiao = false;

	public static String getMapValue(Map<String, String> map, String key) {
		String val = map.get(key);
		return StringUtils.isBlank(val) ? "" : val;
	}

	public static String getKecheng(Map<Integer, ClassesKecheng> map, int key) {
		ClassesKecheng ck = map.get(key);
		return ck == null ? "" : (ck.getKechengName() + "-" + ck.getTeacherName());
	}

	public static String getKechengbiaoKecheng(String time, int weekIndex,
			Map<ClassesKecheng, ClassesKecheng> paikeMap) {
		ClassesKecheng ck = paikeMap.get(new ClassesKecheng(time, weekIndex));
		return ck == null ? "" : (ck.getKechengName() + "-" + ck.getTeacherName());
	}

	public static String getWeekTitle(int weekIndex) {
		if (Constant.WEEKMAP.containsKey(weekIndex)) {
			return Constant.WEEKMAP.get(weekIndex);
		}
		return "";
	}
	
	public static String getCostFrom(int costFrom){
		String val = Constant.costFromMap.get(costFrom);
		return StringUtils.isBlank(val)?"":val;
	}
	
	public static boolean isContains(List<Integer> ls,int key){
		if(ls == null){
			return false;
		}
		return ls.contains(key);
	}
	
	//0正常；1返校；2离校
	public static String getStudentState(int state){
		switch (state) {
		case 0:
			return "正常";
		case 1:
			return "返校";
		case 2:
			return "<span style=\"color:red;\">离校</span>";
		}
		return "";
	}
	
	public static String calSumScore(WaipinTeacherJixiao jixiao){
		double sum = 0;
		sum += jixiao.getScKaopin();
		sum += jixiao.getScChuqin();
		sum += jixiao.getScJiaoxuefile();
		sum += jixiao.getScTingke();
		sum += jixiao.getScKaihui();
		sum += jixiao.getScHuodong();
		sum += jixiao.getScYinxiang();
		sum += jixiao.getScGongxian();
		
		return NumberFormat.formatDouble(sum);
	}
	
	
	public static String numToCh(int num){
        switch (num){
        case 1 :  return "一";
        case 2 : return "二";
        case 3 : return "三";
        case 4 : return "四";
        case 5 : return "五";
        case 6 : return "六";
        case 7 : return "七";
        case 8 : return "八";
        case 9 : return "九";
        default : return "零";
        }
    }
	
	public static String outCh(int num){
        if(num <= 10){
            return numToCh(num%10);
        }else{
        	    return numToCh(num/10) + "十" + numToCh(num%10);
        }
	}
	
	public static QuestionTixing getTixingObj(Map<Integer,QuestionTixing> tixingMap, int tixingId){
		if(tixingMap == null || tixingId <= 0){
			return null;
		}
		return tixingMap.get(tixingId);
	}
	
	public static boolean getIsCheckBank(String[] mustIdArray, String f){
		if(mustIdArray == null || mustIdArray.length == 0){
			return false;
		}
		for(String str : mustIdArray){
			if(str.equals(f)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(outCh(9));
	}
}
