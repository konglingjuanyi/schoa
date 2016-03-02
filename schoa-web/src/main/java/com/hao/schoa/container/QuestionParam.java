package com.hao.schoa.container;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hao.schoa.po.QuestionTixing;

/**
 * 生成试卷的参数
 * @author haoguowei
 *
 */
public class QuestionParam {

	/**
	 * 关键字
	 */
	private String keyword;
	
	/**
	 * 题型ID,及生成数量
	 */
	private List<QuestionTixing> tixingList;
	
	/**
	 * 教材ID,只能选一个题材
	 */
	private int materialId;
	
	/**
	 * 教材课程ID,可以是多课程
	 */
	private String materialKechengIds;
	
	/**
	 * 知识点ID
	 */
	private String knowledgePointIds;
	
	/**
	 * 词汇级别
	 */
	private String wordsLevel;
	
	/**
	 * 标签
	 */
	private String tags;
	
	/**
	 * 试题创建时间 － 开始时间
	 */
	private String startDay;
	
	/**
	 * 试题创建时间 － 结束时间
	 */
	private String endDay;
	
	/**
	 * 一定能生成的题
	 * key：题型ID
	 * value：试题ID，如1,2,4
	 */
	private Map<Integer,Set<Integer>> mustHaveMap = new HashMap<Integer,Set<Integer>>();

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<QuestionTixing> getTixingList() {
		return tixingList;
	}

	public void setTixingList(List<QuestionTixing> tixingList) {
		this.tixingList = tixingList;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialKechengIds() {
		return materialKechengIds;
	}

	public void setMaterialKechengIds(String materialKechengIds) {
		this.materialKechengIds = materialKechengIds;
	}

	public String getKnowledgePointIds() {
		return knowledgePointIds;
	}

	public void setKnowledgePointIds(String knowledgePointIds) {
		this.knowledgePointIds = knowledgePointIds;
	}

	public String getWordsLevel() {
		return wordsLevel;
	}

	public void setWordsLevel(String wordsLevel) {
		this.wordsLevel = wordsLevel;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public Map<Integer, Set<Integer>> getMustHaveMap() {
		return mustHaveMap;
	}

	public void setMustHaveMap(Map<Integer, Set<Integer>> mustHaveMap) {
		this.mustHaveMap = mustHaveMap;
	}

	@Override
	public String toString() {
		return "QuestionParam [keyword=" + keyword + ", tixingList="
				+ tixingList + ", materialId=" + materialId
				+ ", materialKechengIds=" + materialKechengIds
				+ ", knowledgePointIds=" + knowledgePointIds + ", wordsLevel="
				+ wordsLevel + ", tags=" + tags + ", startDay=" + startDay
				+ ", endDay=" + endDay + ", mustHaveMap=" + mustHaveMap + "]";
	}

	
}
