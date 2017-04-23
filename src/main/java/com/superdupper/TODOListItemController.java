package com.superdupper;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.superdupper.component.TODOListServiceImpl;

/**
 * @author Bijoy
 * @version 1.0
 * Controller class holding all the POST methods for storing and retrieving TODO list item details
 * for SuperDupper Jackson Jersey JAXRS REST Application.
 *
 */
@RestController
@RequestMapping("/jaxrs")
public class TODOListItemController {
	@Autowired
	private TODOListServiceImpl toDoListService;
	
	/**
	 * Add items to a list.
	 * @param list
	 * @return
	 */
	@Consumes({ MediaType.APPLICATION_JSON })
	@RequestMapping(value = "/new/additemstolist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody TODOList addItem(@RequestBody TODOList list) {
		TODOList toDoList = toDoListService.newTODOItem(list);
		return toDoList;
	}

	/**
	 * Mark an item as Completed.
	 * @param list
	 * @return
	 */
	@Consumes({ MediaType.APPLICATION_JSON })
	@RequestMapping(value = "/markitemcompleted", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody TODOList completedIted(@RequestBody TODOList list) {
		TODOList toDoList = toDoListService.markItemAsCompleted(list);
		return toDoList;
	}

	/**
	 * Ability to delete items.
	 * @param list
	 * @return
	 */
	@Consumes({ MediaType.APPLICATION_JSON })
	@RequestMapping(value = "/deletItem", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody String deletedItem(@RequestBody TODOList list) {
		String toDoList = toDoListService.deleteAnItem(list);
		return toDoList;
	}
	
	/**
	 * Ability to restore items.
	 * @param list
	 * @return
	 */
	@Consumes({ MediaType.APPLICATION_JSON })
	@RequestMapping(value = "/restoreItem", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody TODOList restoreItem(@RequestBody TODOList list) {
		TODOList toDoList = toDoListService.restoreItem(list);
		return toDoList;
	}

	/**
	 * Support for multiple lists.
	 * @param list
	 * @return
	 */
	@Consumes({ MediaType.APPLICATION_JSON })
	@RequestMapping(value = "/multiplelists", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody TODOList supportMultipleList(@RequestBody TODOList list) {
		TODOList multipleToDoList = toDoListService.addMultipleList(list);
		return multipleToDoList;
	}
	
	/**
	 * Ability to add reminders to items.
	 * @param list
	 * @return
	 * @throws SchedulerException
	 */
	@Consumes({ MediaType.APPLICATION_JSON })
	@RequestMapping(value = "/remindersItem", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody TODOList remindersItem(@RequestBody TODOList list) throws SchedulerException {
		TODOList toDoList = toDoListService.remindersItem(list);
		return toDoList;
	}
}