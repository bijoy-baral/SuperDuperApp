package com.superdupper.helper;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * This class enable execution of scheduler for repetitive 
 * reminder about an TODO list item. 
 * @author Bijoy
 *
 */
public class ScheduleJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
	}
}
