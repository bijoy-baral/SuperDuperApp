/**
 * 
 */
package com.superdupper.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.superdupper.TODOList;

/**
 * @author Bijoy
 * @version 1.0
 * DB helper class for SuperDupper Jackson Jersey JAXRS REST Application.
 *
 */
public class DBHelper {

	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet resultSet = null;

	/**
	 * Returning SQL statement for execution.
	 * @return
	 */
	public static Statement returnStatement() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

	/**
	 * This method return completed item.
	 * @param itemCompleted
	 * @return
	 */
	public static TODOList markItemAsCompleted(TODOList itemCompleted) {
		TODOList updatedItem = new TODOList();
		Statement statement = returnStatement();
		String selectQuery = Constants.SELECT_QUERY;

		try {
			resultSet = statement.executeQuery(selectQuery);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				try {
					int itemId = resultSet.getInt("ITEMID");
					String itemName = resultSet.getString("ITEMNAME");
					String itemDescription = resultSet.getString("ITEMDESCRIPTION");
					if (itemId == itemCompleted.getItemId()) {
						updatedItem.setItemId(itemId);
						updatedItem.setItemName(itemName);
						updatedItem.setItemDescription(itemDescription);
						updatedItem.setStatus(itemCompleted.getStatus());
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return updatedItem;
	}

	/**
	 * This method delete the item and send successful deletion 
	 * message for an item to the user.
	 * @param itemDeleted
	 * @return
	 */
	public static String itemToBeDeleted(TODOList itemDeleted) {
		Statement statement = returnStatement();
		String deleteQuery = Constants.DELETE_QUERY;
		String selectQuery = Constants.SELECT_QUERY;
		String message = "Item doesn't exist!";

		try {
			resultSet = statement.executeQuery(selectQuery);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				try {
					int itemId = resultSet.getInt("ITEMID");
					if (itemId == itemDeleted.getItemId()) {
						statement.executeUpdate(deleteQuery + itemId);
						message = "Item deleted Successfully!";
						break;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return message;
	}

	/**
	 * This method check item present in DB table or not. This will return true if present
	 * otherwise return false.
	 * @param rItem
	 * @return
	 */
	public static boolean checkItem(TODOList rItem) {
		boolean flag = false;
		Statement statement = returnStatement();
		String selectQuery = Constants.SELECT_QUERY;

		try {
			resultSet = statement.executeQuery(selectQuery);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				try {
					int itemId = resultSet.getInt("ITEMID");
					if (itemId == rItem.getItemId()) {
						flag = true;
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return flag;
	}

}
