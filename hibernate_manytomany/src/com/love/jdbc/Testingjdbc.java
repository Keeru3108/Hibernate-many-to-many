package com.love.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testingjdbc 
{
public static void main(String[] args) {
	String url="jdbc:mysql://localhost:3306/hb-03-one-to-many-uni?useSSL=false";
	String user="hbstudent";
	String pwd="hbstudent";
	Connection con;

	try
	{
		System.out.println("Coonecting to database");
		con=DriverManager.getConnection(url, user, pwd);
		System.out.println("Connection successful");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
