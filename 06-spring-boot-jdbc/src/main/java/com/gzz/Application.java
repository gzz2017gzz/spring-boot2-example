package com.gzz;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gzz.common.quartz.TestJob;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@SpringBootApplication
public class Application {

	@Autowired
	private Scheduler scheduler;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void run() throws SchedulerException {
		JobKey jobKey = new JobKey("availableTopic", "robot");
		JobDetail job = JobBuilder.newJob(TestJob.class).withIdentity(jobKey).build();
		SimpleTriggerImpl trigger = new SimpleTriggerImpl();
		trigger.setName("SimpleTrigger+planName+planId");
		trigger.setStartTime(new Date());// 开始运行时间
		trigger.setRepeatInterval(1000);
		trigger.setRepeatCount(Integer.MAX_VALUE); // 运行次数
		trigger.setEndTime(new Date(new Date().getTime() + 3600));
		scheduler.scheduleJob(job, trigger);
	}
}
