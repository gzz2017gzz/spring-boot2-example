package com.gzz.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @类说明 任务调度器的配置
 * @author 高振中 MWW
 * @date 2019-02-28 09:44:27
 **/
@Configuration
public class SchedulerConfig {
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) {
		// Spring提供SchedulerFactoryBean为Scheduler提供配置信息,并被Spring容器管理其生命周期
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		// 设置自定义Job Factory，用于Spring管理Job bean
		schedulerFactoryBean.setJobFactory(jobFactory);
		return schedulerFactoryBean;
	}

	@Bean
	public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean) {
		schedulerFactoryBean.setOverwriteExistingJobs(true);
		return schedulerFactoryBean.getScheduler();
	}
}
