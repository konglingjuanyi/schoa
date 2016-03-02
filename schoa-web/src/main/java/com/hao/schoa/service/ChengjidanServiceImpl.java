package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hao.schoa.container.ContainerChengjidan;
import com.hao.schoa.po.ChengjidanPrintHistory;
import com.hao.schoa.po.ChengjidanPrintHistoryPeer;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.Score;
import com.hao.schoa.po.Student;
import com.hao.schoa.po.SubjectMarks;
import com.hao.schoa.tools.Constant;

public class ChengjidanServiceImpl {

	/**
	 * 学生在某个班级的成绩单数据
	 * @param studentId
	 * @param classesId
	 */
	public static ContainerChengjidan genSubjectMarks(int studentId, int classesId, List<SubjectMarks> subjectMarksList){
		Student student = StudentServiceImpl.getById(studentId);
		Classes classes = ClassesServiceImpl.getById(classesId);
		
		StringBuffer dateCn = new StringBuffer("自");
		dateCn.append(Constant.CNDATE.format(classes.getXueqi().getStartDate()))
		.append("至").append(Constant.CNDATE.format(classes.getXueqi().getEndDate()));
		
		StringBuffer dateEn = new StringBuffer("From ");
		dateEn.append(Constant.ENDATE.format(classes.getXueqi().getStartDate()))
		.append(" To ").append(Constant.ENDATE.format(classes.getXueqi().getEndDate()));
		
		
		ContainerChengjidan obj = new ContainerChengjidan();
		obj.setStudentId(studentId);
		obj.setClassesId(classesId);
		obj.setClassesName(classes.getName());
		obj.setPassportNumber(student.getPassNumb());
		obj.setStudentName(student.getCname());
		obj.setStudentEName(student.getEname().toUpperCase());
		obj.setSexEName(student.getSex()==0?"M":"F");
		obj.setNationEName(student.getCountry()==null?"":student.getCountry().getEname().toUpperCase());
		obj.setSex(student.getSex()==0?"男":"女");
		obj.setNation(student.getCountry().getCname());
		obj.setDateCn(dateCn.toString());
		obj.setDateEn(dateEn.toString());
		
		obj.setXueqiStartDate(classes.getXueqi().getStartDate());
		obj.setXueqiEndDate(classes.getXueqi().getEndDate());
		
		if(subjectMarksList == null){
			//班级下的课程
			List<Kecheng> kechengList = PaikeServiceImpl.getClassesKecheng(classesId);
			
			//课程对应的成绩
			Map<Integer,Score> kechengScoreMap = ScoreServiceImpl.getStudentScoreKCMap(classesId, studentId);
			List<SubjectMarks> subjectMarks = new ArrayList<SubjectMarks>();
			if(kechengList != null && kechengList.size() > 0){
				for(Kecheng kc : kechengList){
					SubjectMarks sm = new SubjectMarks();
					sm.setSubject(kc.getName());
					sm.setKechengId(kc.getId());
					if(kechengScoreMap != null){
						Score score = kechengScoreMap.get(kc.getId());
						if(score != null){
							sm.setQizhong(score.getScQizhong());
							sm.setQimo(score.getScJuanmian());
							sm.setTotal(score.getScAll());
						}
					}
					subjectMarks.add(sm);
				}
			}
			obj.setSubjectMarks(subjectMarks);
		}else{
			obj.setSubjectMarks(subjectMarksList);
		}
		return obj;
	}
	
	public static ChengjidanPrintHistory getChengjidanHistoryById(int historyId){
		ChengjidanPrintHistory his = null;
		try {
			his = ChengjidanPrintHistoryPeer.retrieveByPK(historyId);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return his;
	}

	/**
	 * 学生在某个班级的成绩单数据，从打印历史记录中取
	 * @param historyId
	 * @return
	 */
	public static ContainerChengjidan genSubjectMarks(int historyId) {
		ChengjidanPrintHistory his = getChengjidanHistoryById(historyId);
		if(his != null){
			return genSubjectMarks(his.getStudentId(), his.getClassesId(), fromJson(his.getSnapshot()));
		}
		return null;
	}
	
	public static List<SubjectMarks> fromJson(String jsonStr){
		return new Gson().fromJson(jsonStr, new TypeToken<List<SubjectMarks>>(){}.getType());  
	}
	
	public static List<ChengjidanPrintHistory> selectHistory(int studentId, int classesId) {
		Criteria c = new Criteria();
		c.add(ChengjidanPrintHistoryPeer.STUDENT_ID, studentId);
		c.add(ChengjidanPrintHistoryPeer.CLASSES_ID, classesId);
		c.addDescendingOrderByColumn(ChengjidanPrintHistoryPeer.CREATE_TIME);
		c.setLimit(5);
		try {
			List<ChengjidanPrintHistory> ls = ChengjidanPrintHistoryPeer.doSelect(c);
			for(ChengjidanPrintHistory cph : ls){
				cph.setChengjidan(fromJson(cph.getSnapshot()));
			}
			return ls;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
