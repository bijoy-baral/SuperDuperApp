package com.superdupper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Bijoy
 * @version 1.0
 * POJO class holding TODO list item details and all getters and
 * setters method for SuperDupper Jackson Jersey JAXRS REST Application.
 *
 */
@Entity
@Table(name = "TODOLIST")
public class TODOList {
	@Id
	@Column(name = "itemId", unique = true)
	private int itemId;

	@Column(name = "itemName")
	private String itemName;

	@Column(name = "itemDescription")
	private String itemDescription;

	@Column(name = "status")
	private String status;

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId - the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName - the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * @param itemDescription - the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status - the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
