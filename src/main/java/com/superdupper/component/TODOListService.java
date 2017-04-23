package com.superdupper.component;

import org.quartz.SchedulerException;
import com.superdupper.TODOList;

/**
 * @author Bijoy
 * @version 1.0 
 * Interface holding all the implementation for SuperDupper Jackson
 * Jersey JAXRS REST Application.
 *
 */
public interface TODOListService {
	public TODOList newTODOItem(TODOList item);

	public TODOList markItemAsCompleted(TODOList item);

	public String deleteAnItem(TODOList item);

	public TODOList restoreItem(TODOList item);

	public TODOList addMultipleList(TODOList item);

	public TODOList remindersItem(TODOList item) throws SchedulerException;

}
