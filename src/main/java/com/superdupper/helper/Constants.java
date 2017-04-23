package com.superdupper.helper;

/**
 * @author Bijoy
 * @version 1.0
 * This class contains all the constants for SuperDupper Jackson Jersey
 * JAXRS REST Application.
 *
 */
public class Constants {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERNAME = "Bijoy";
	public static final String PASSWORD = "oracle";
	public static final String SELECT_QUERY = "select * from bijoy.todolist";
	public static final String DELETE_QUERY = "delete from bijoy.todolist where itemid=";
	public static final String UPDATE_QUERY = "update bijoy.todolist set status='Yes' where itemid=";
	public static final String SELECT = "select t.itemid, t.itemname, t.itemdescription from todolist t";
}
