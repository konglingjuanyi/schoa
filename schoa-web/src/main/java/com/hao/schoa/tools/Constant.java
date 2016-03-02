package com.hao.schoa.tools;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.hao.schoa.container.JiaoxueFileScore;

public class Constant {
	
	public static final long _1M = 1024 * 1024; //1M
	
	public static String IMAGEURL = ""; //图片地址
	public static String IMAGEPATH = ""; //图片服务器保存路径
	
	public static Set<String> allPrivilegeSet = null;//所有目录树结构url

	public static final SimpleDateFormat FULLDATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat HMDATE = new SimpleDateFormat("HH:mm");
	public static final SimpleDateFormat ENDATE = new SimpleDateFormat("dd.MMMM.yyyy", Locale.ENGLISH);
	public static final SimpleDateFormat CNDATE = new SimpleDateFormat("yyyy年MM月dd日");
	public static final SimpleDateFormat CNDATEMIN = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
	public static final SimpleDateFormat DATE2 = new SimpleDateFormat("yyyy/MM/dd");
	
	public static final short HEIGTH = 500; //excel 一般高度
	
	public static final String TOTAL = "total";
	public static final String DATA = "data";
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	public static final String MSG = "msg";
	
	public static final int LIMIT = 20;
	
	public static final int valid = 1; //有效
	public static final int unvalid = 0;//无效
	
	public static final String SYS_MEMBER_LOGIN = "sys_member_login";
	public static final String SYS_MEMBER_PRI = "sys_member_pri";
	public static final String LONIN_NAME = "loginName";
	public static final String LONIN_SHOWNAME = "loginShowName";
	
	public static final String LONIN_URL = "initLogin.do";
	public static final String MAIN_URL = "initMain.do";
	public static final String PRIVILEGES_URL = "initNoPrivileges.do";
	
	public static final String JSON_MSG = "msg";
	public static final String JSON_SUCCESS = "success";
	public static final String JSON_DATA = "data";
	
	//上传文件总得分
	public static final double sc_teacher_file = 20;
	//上课出勤总得分
	public static final double sc_teacher_chuqin = 15;
	
	//0正编，1外聘
	public static final int teacher_zhengbian = 0;
	public static final int teacher_waipin = 1;
	
	//学生出勤
	public static LinkedHashMap<Integer,String> kaoqinTypeMap = new LinkedHashMap<Integer,String>();
	static{
		kaoqinTypeMap.put(0, "出勤:√");
		kaoqinTypeMap.put(-2, "迟到:Δ");
		kaoqinTypeMap.put(2, "病假:O");
		kaoqinTypeMap.put(3, "事假:⊙");
		kaoqinTypeMap.put(4, "缺勤:X");
		kaoqinTypeMap.put(5, "早退:∝");
		kaoqinTypeMap.put(6, "回国:回国");
		kaoqinTypeMap.put(-1, "未报到:未报到");
		kaoqinTypeMap.put(-3, "放假:放假");
		kaoqinTypeMap.put(-4, "取消:");
	}
	
	//学生经费来源
	public static Map<Integer,String> costFromMap = new HashMap<Integer,String>();
	static{
		costFromMap.put(1, "自费");
		costFromMap.put(2, "公费");
		costFromMap.put(3, "奖学金");
	}
	//学生来源
	public static Map<Integer,String> stuFromMap = new HashMap<Integer,String>();
	static{
		stuFromMap.put(1, "朋友推荐");
		stuFromMap.put(2, "网络搜索");
		stuFromMap.put(3, "老师推荐");
		stuFromMap.put(4, "中介推荐");
		stuFromMap.put(5, "其他原因");
	}
	
	//州
	public static Map<Integer,String> statesMap = new HashMap<Integer,String>();
	static{
		statesMap.put(1, "亚洲");
		statesMap.put(2, "欧洲");
		statesMap.put(3, "非洲");
		statesMap.put(4, "美洲");
		statesMap.put(5, "大洋洲");
	}
	
	public static Map<Integer,String> WEEKMAP = new LinkedHashMap<Integer, String>();
	static{
		WEEKMAP.put(0,"周一Monday");
		WEEKMAP.put(1,"周二Tuesday");
		WEEKMAP.put(2,"周三Wednesday");
		WEEKMAP.put(3,"周四Thursday");
		WEEKMAP.put(4,"周五Friday");
		WEEKMAP.put(5,"周六Saturday");
		WEEKMAP.put(6,"周日Sunday");
	}
	
	/** 
	 * 教师出勤情况
	 */
	public static Map<Integer,String> teacherChuqinMap = new LinkedHashMap<Integer, String>();
	static{
		teacherChuqinMap.put(-2,"取消");
		teacherChuqinMap.put(-1,"迟到");
		teacherChuqinMap.put(0,"出勤");
		teacherChuqinMap.put(1,"缺勤");
		teacherChuqinMap.put(-3,"换课（扣分）");
		teacherChuqinMap.put(-4,"换课（不扣分）");
	}
	
	/**
	 * 上传文件标识
	 */
	public static Map<Integer,JiaoxueFileScore> fileFlagMap = new LinkedHashMap<Integer, JiaoxueFileScore>();
	static{
		fileFlagMap.put(0,new JiaoxueFileScore(0,"教学计划表（学期开始）",2.5));
		fileFlagMap.put(8,new JiaoxueFileScore(8,"教学计划表（学期开始）",2));
		
		fileFlagMap.put(1,new JiaoxueFileScore(1,"教学计划表（学期末）",2.5));
		fileFlagMap.put(9,new JiaoxueFileScore(9,"教学计划表（学期末）",2));
		
		fileFlagMap.put(2,new JiaoxueFileScore(2,"期中考试（教师卷）",2.5));
		fileFlagMap.put(10,new JiaoxueFileScore(10,"期中考试（教师卷）",2));
		
		fileFlagMap.put(3,new JiaoxueFileScore(3,"期中考试（学生卷）",2.5));
		fileFlagMap.put(11,new JiaoxueFileScore(11,"期中考试（学生卷）",2));
		
		fileFlagMap.put(4,new JiaoxueFileScore(4,"期中考试（答案卷）",2.5));
		fileFlagMap.put(12,new JiaoxueFileScore(12,"期中考试（答案卷）",2));
		
		fileFlagMap.put(5,new JiaoxueFileScore(5,"期末考试（教师卷）",2.5));
		fileFlagMap.put(13,new JiaoxueFileScore(13,"期末考试（教师卷）",2));
		
		fileFlagMap.put(6,new JiaoxueFileScore(6,"期末考试（学生卷）",2.5));
		fileFlagMap.put(14,new JiaoxueFileScore(14,"期末考试（学生卷）",2));
		
		fileFlagMap.put(7,new JiaoxueFileScore(7,"期末考试（答案卷）",2.5));
		fileFlagMap.put(15,new JiaoxueFileScore(15,"期末考试（答案卷）",2));
		
		fileFlagMap.put(16,new JiaoxueFileScore(16,"期中试卷录音",2));
		fileFlagMap.put(17,new JiaoxueFileScore(17,"期末试卷录音",2));
		
		fileFlagMap.put(18,new JiaoxueFileScore(18,"期中口语考试录音",2));
		fileFlagMap.put(19,new JiaoxueFileScore(19,"期末口语考试录音",2));
		
		fileFlagMap.put(20,new JiaoxueFileScore(20,"期中口语考试录音文本转写",2));
		fileFlagMap.put(21,new JiaoxueFileScore(21,"期末口语考试录音文本转写",2));
	}
	
	/**
	 * Question 问题
	 */
	public static Map<String,String> questionMap = new LinkedHashMap<String, String>();
	static{
		questionMap.put("anshi","1.老师按时上课、下课吗？Do teachers go to class or leave class on time?");
		questionMap.put("youyiyi","2.老师上课有意思吗？How do you feel about their ways of teaching?");
		questionMap.put("neirong","3.老师上课讲的内容你懂吗？Do you understand what teachers say in class?");
		questionMap.put("shouhuo","4.你觉得上课收获大吗？Do you have any gains from their classes?");
		questionMap.put("shuohuaQingchu","5.老师上课说话清楚吗？说话速度快慢合适吗？What do you think of teachers` speaking during  the class?");
		questionMap.put("heibanziQingchu","6.老师在黑板上写的字清楚吗？ What do you think of teachers’ writing on the blackboard?");
		questionMap.put("heibanziZhongyao","7.老师在黑板上写的内容你觉得是很重要的吗? Is it necessary for you to look at what teachers write on the blackboard?");
		questionMap.put("shuliangHeshi","8.你觉得每节课学到的内容数量合适吗？ How do you feel about the content and the amount during the class？");
		questionMap.put("hanziJihui","9.你觉得上课练习汉语的机会多吗？ Are there many opportunities for you to practice your Chinese?");
		questionMap.put("huodongYouxiao","10.你觉得上课时老师设计的活动有效吗？ What do you think of activities during the class?");
		questionMap.put("zuoyeHeshi","11.老师布置的作业数量合适吗？  Is homework too much for you?");
		questionMap.put("zuoyeBangzhu","12.你觉得老师批改作业对你帮助大吗？ Do you think it helpful for teachers to check and correct your assignments?");
		questionMap.put("naixin","13.老师回答你的问题时耐心、有用吗？ Are teachers patient when they answer your questions?");
		questionMap.put("jinbu","14.从开学到现在，你觉得这门课进步大吗？ Do you have any progress so far?");
		questionMap.put("yange","15.老师对你的要求严格吗？ Are teachers strict to you?");
		questionMap.put("yuanyi","16.你愿意来上这门课吗？ How do you like these courses?");
		questionMap.put("liaotian","17.老师下课后和你聊天儿吗？ Does teacher talk to you after class?");
	}
	public static Map<String,String> keyMapping = new LinkedHashMap<String, String>();
	static{
		keyMapping.put("shuohuaQingchu","shuohua_qingchu");
		keyMapping.put("heibanziQingchu","heibanzi_qingchu");
		keyMapping.put("heibanziZhongyao","heibanzi_zhongyao");
		keyMapping.put("shuliangHeshi","shuliang_heshi");
		keyMapping.put("hanziJihui","hanzi_jihui");
		keyMapping.put("huodongYouxiao","huodong_youxiao");
		keyMapping.put("zuoyeHeshi","zuoye_heshi");
		keyMapping.put("zuoyeBangzhu","zuoye_bangzhu");
	}
}
