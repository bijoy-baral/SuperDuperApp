package com.superdupper.helper;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.superdupper.TODOList;

/**
 * @author Bijoy
 * @version 1.0 
 * Quartz job scheduler class for SuperDupper Jackson Jersey JAXRS
 * REST Application.
 *
 */
public class AddRemindersToItem {

	public static void setScheduler(TODOList item) throws SchedulerException {
		JobDetail job = JobBuilder.newJob(ScheduleJob.class).withIdentity("reminders", item.getItemName()).build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triggereven", item.getItemName())
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(24).repeatForever()).build();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

}
