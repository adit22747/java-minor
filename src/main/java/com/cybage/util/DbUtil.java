package com.cybage.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtil {
	
	/*private static String dbUrl = "jdbc:mysql://localhost:3306/cybage";
	private static String dbUser = "root";
	private static String dbPassword = "cybage@123";
	private static String className="com.mysql.cj.jdbc.Driver";

	static {
		try {
			FileReader reader = new FileReader("db.properties");
			Properties props = new Properties();
			
			props.load(reader);
			dbUrl = props.getProperty("dbUrl");
			dbUser = props.getProperty("dbUser");
			dbPassword = props.getProperty("dbPassword");
			className = props.getProperty("className");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static Connection getCon() throws Exception {
		Class.forName(className);
		Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		return conn;
//		BasicDataSource ds = new BasicDataSource();
//		ds.setUrl(dbUrl);
//		ds.setUsername(dbUser);
//		ds.setPassword(dbPassword);
//		ds.setMinIdle(5);
//		ds.setMaxIdle(10);
//		ds.setMaxOpenPreparedStatements(100);
//	
//		return ds.getConnection();

	}*/


	       
	       //private  String className = "com.mysql.cj.jdbc.Driver";
	       private static  String dbUrl;
	       private static  String dbUser; 
	       private static  String dbPassword;
	       static {   //if want to execute 
	              FileReader fr;
	              try {
	                     fr = new FileReader("d://db.properties");
	                     Properties props = new Properties();
	                     props.load(fr);
	                     dbUrl = props.getProperty("dbUrl");
	                     dbUser = props.getProperty("dbUser");
	                     dbPassword = props.getProperty("dbPassword");
	                     
	              } catch (Exception e) {
	                     // TODO Auto-generated catch block
	                     e.printStackTrace();
	              }
	              
	              
	       }
	       
	public static Connection getCon() throws Exception{
	              
	              BasicDataSource ds = new BasicDataSource();
	              ds.setUrl(dbUrl);
	              ds.setUsername(dbUser);
	              ds.setPassword(dbPassword);
	              ds.setMinIdle(5);
	              ds.setMaxIdle(10);
	              ds.setMaxOpenPreparedStatements(100);
	              return ds.getConnection();
	       }
	/*     public  static Connection getCon() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver"); //class will be provided by vendor (mysql)
	              
	              ///2. connect to database using mysql class(mysql driver)
	              Connection con
	              = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
	              return con;
	       }*/
	

	
	
}
