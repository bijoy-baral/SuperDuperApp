package com.superdupper.component;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;
import com.superdupper.TODOList;
import com.superdupper.helper.AddRemindersToItem;
import com.superdupper.helper.DBHelper;
import com.superdupper.helper.PersistenceManager;

/**
 * @author Bijoy
 * @version 1.0
 * Implementation class for all the methods of SuperDupper Jackson Jersey JAXRS REST Application.
 *
 */
@Component
public class TODOListServiceImpl implements TODOListService {
	
	/**
	 * Add items to a list.
	 */
	@Override
	public TODOList newTODOItem(TODOList item) {

		TODOList added = new TODOList();
		added.setItemId(item.getItemId());
		added.setItemName(item.getItemName());
		added.setItemDescription(item.getItemDescription());
		added.setStatus(item.getStatus());

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		boolean flag = DBHelper.checkItem(added);
		if (flag == false) {
			em.persist(added);
		}
		em.getTransaction().commit();
		return added;
	}

	/**
	 * Mark an item as Completed.
	 */
	@Override
	public TODOList markItemAsCompleted(TODOList item) {

		TODOList itemCompleted = new TODOList();
		itemCompleted.setItemId(item.getItemId());
		itemCompleted.setItemName(item.getItemName());
		itemCompleted.setItemDescription(item.getItemDescription());
		itemCompleted.setStatus(item.getStatus());

		TODOList completed = DBHelper.markItemAsCompleted(itemCompleted);
		return completed;
	}
	
	/**
	 * Ability to delete items.
	 */
	@Override
	public String deleteAnItem(TODOList item) {

		TODOList itemToBeDeleted = new TODOList();
		itemToBeDeleted.setItemId(item.getItemId());
		itemToBeDeleted.setItemName(item.getItemName());
		itemToBeDeleted.setItemDescription(item.getItemDescription());
		itemToBeDeleted.setStatus(item.getStatus());

		String detelted = DBHelper.itemToBeDeleted(itemToBeDeleted);
		return detelted;
	}

	/**
	 * Ability to restore items.
	 */
	@Override
	public TODOList restoreItem(TODOList item) {

		TODOList added = new TODOList();
		added.setItemId(item.getItemId());
		added.setItemName(item.getItemName());
		added.setItemDescription(item.getItemDescription());
		added.setStatus(item.getStatus());

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		boolean flag = DBHelper.checkItem(added);
		if (flag == false) {
			em.persist(added);
		}
		em.getTransaction().commit();
		return added;
	}
	
	/**
	 * Support for multiple lists.
	 */
	@Override
	public TODOList addMultipleList(TODOList items) {
		TODOList addMultiple = new TODOList();
		List<TODOList> list = new ArrayList<TODOList>();
		list.add(items);
		for (int i = 0; i <= list.size(); i++) {

			addMultiple.setItemId(items.getItemId());
			addMultiple.setItemName(items.getItemName());
			addMultiple.setItemDescription(items.getItemDescription());
			addMultiple.setStatus(items.getStatus());

			EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
			em.getTransaction().begin();
			boolean flag = DBHelper.checkItem(addMultiple);
			if (flag == false) {
				em.persist(addMultiple);
			}
			em.getTransaction().commit();
		}

		return addMultiple;
	}
	/**
	 * Ability to add reminders to items.
	 */
	@Override
	public TODOList remindersItem(TODOList item) throws SchedulerException {

		TODOList reminderItem = new TODOList();
		reminderItem.setItemId(item.getItemId());
		reminderItem.setItemName(item.getItemName());
		reminderItem.setItemDescription(item.getItemDescription());
		reminderItem.setStatus(item.getStatus());

		boolean checker = DBHelper.checkItem(reminderItem);
		if (checker == true) {
			AddRemindersToItem.setScheduler(item);
		}
		return reminderItem;
	}

}
