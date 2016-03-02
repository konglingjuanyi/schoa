package com.hao.schoa.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.PaperAnalysis;
import com.hao.schoa.po.PaperAnalysisPeer;
import com.hao.schoa.po.Score;
import com.hao.schoa.tools.NumberFormat;

public class PaperAnalysisServiceImpl {

	
	public static PaperAnalysis getPaperAnalysis(int xueqiId, int banjiId, int kechengId,String pin) {
		PaperAnalysis paperAnalysis = searchPaperAnalysis(xueqiId,banjiId,kechengId);
		if(paperAnalysis == null){
			paperAnalysis = save(xueqiId,banjiId,kechengId,pin);
		}
		if(paperAnalysis != null){
			paperAnalysis.setXueqi(XueqiServiceImpl.getById(xueqiId));
			paperAnalysis.setBanji(ClassesServiceImpl.retrieveByPK(banjiId));
			paperAnalysis.setKecheng(KechengServiceImpl.retrieveByPK(kechengId));
			fullPaperAnalysisScoreInfo(paperAnalysis);
		}
		return paperAnalysis;
	}
	
	public static PaperAnalysis getPaperById(int id){
		PaperAnalysis pa = null;
		try {
			pa = PaperAnalysisPeer.retrieveByPK(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(pa != null){
			pa.setXueqi(XueqiServiceImpl.getById(pa.getXueqiId()));
			pa.setBanji(ClassesServiceImpl.retrieveByPK(pa.getClassesId()));
			pa.setKecheng(KechengServiceImpl.retrieveByPK(pa.getKechengId()));
			fullPaperAnalysisScoreInfo(pa);
		}
		return pa;
	}
	
	public static void fullPaperAnalysisScoreInfo(PaperAnalysis pa){
		Map<Integer,Score> map = ScoreServiceImpl.getStudentScoreMap(pa.getClassesId(), pa.getKechengId());
		if(map == null || map.isEmpty()){
			return;
		}
		int total = map.size();
		double totalBili = 100;
		
		int fen90 = 0;
		double fen90Bili = 0;
		int fen8089 = 0;
		double fen8089Bili = 0;
		int fen7079 = 0;
		double fen7079Bili = 0;
		int fen6069 = 0;
		double fen6069Bili = 0;
		int fen59 = 0;
		double fen59Bili = 0;
		
		for(int sId : map.keySet()){
			double score = map.get(sId).getScJuanmian();
			if(score >= 90){
				fen90 += 1;
			}else if(score >= 80){
				fen8089 += 1;
			}else if(score >= 70){
				fen7079 += 1;
			}else if(score >= 60){
				fen6069 += 1;
			}else{
				fen59 += 1;
			}
		}
		fen90Bili = Double.parseDouble(NumberFormat.formatDouble(fen90 * 100/total));
		fen8089Bili = Double.parseDouble(NumberFormat.formatDouble(fen8089 * 100/total));
		fen7079Bili = Double.parseDouble(NumberFormat.formatDouble(fen7079 * 100/total));
		fen6069Bili = Double.parseDouble(NumberFormat.formatDouble(fen6069 * 100/total));
		fen59Bili = Double.parseDouble(NumberFormat.formatDouble(fen59 * 100/total));
		
		pa.setFen90(fen90);
		pa.setFen8089(fen8089);
		pa.setFen7079(fen7079);
		pa.setFen6069(fen6069);
		pa.setFen59(fen59);
		pa.setFen90Bili(fen90Bili);
		pa.setFen8089Bili(fen8089Bili);
		pa.setFen7079Bili(fen7079Bili);
		pa.setFen6069Bili(fen6069Bili);
		pa.setFen59Bili(fen59Bili);
		
		pa.setTotal(total);
		pa.setTotalBili(totalBili);
	}
	
	private static PaperAnalysis save(int xueqiId, int banjiId, int kechengId,String pin) {
		PaperAnalysis p = new PaperAnalysis();
		p.setXueqiId(xueqiId);
		p.setClassesId(banjiId);
		p.setKechengId(kechengId);
		
		p.setMember(pin);
		p.setUpdateTime(new Date());
		try {
			PaperAnalysisPeer.doInsert(p);
			return p;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static PaperAnalysis searchPaperAnalysis(int xueqiId, int banjiId, int kechengId){
		Criteria c = new Criteria();
		c.add(PaperAnalysisPeer.XUEQI_ID, xueqiId);
		c.add(PaperAnalysisPeer.CLASSES_ID, banjiId);
		c.add(PaperAnalysisPeer.KECHENG_ID, kechengId);
		try {
			List<PaperAnalysis> ls = PaperAnalysisPeer.doSelect(c);
			if(ls!=null && !ls.isEmpty()){
				return ls.get(0);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

}
