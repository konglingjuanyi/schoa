package com.hao.schoa.job;


public abstract class SchoaJob {

	protected abstract void work();

	public void execute() {
		System.out.println("定时任务开始执行");
		long start = System.currentTimeMillis();
		work();
		System.out.println("定时任务结束执行，共耗时：" + (System.currentTimeMillis() - start) + "ms");
	}
}
