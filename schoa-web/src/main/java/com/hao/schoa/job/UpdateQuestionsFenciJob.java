package com.hao.schoa.job;

import com.hao.schoa.service.QuestionWordsServiceImpl;

/**
 * 定时任务
 * 更新分词
 * @author haoguowei
 *
 */
public class UpdateQuestionsFenciJob extends SchoaJob{

	@Override
	protected void work() {
		QuestionWordsServiceImpl.updateWordsStandardLevel();
	}

	
}
