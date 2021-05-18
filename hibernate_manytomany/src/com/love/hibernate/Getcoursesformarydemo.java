package com.love.hibernate;

import java.text.ParseException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love.entity.Course;
import com.love.entity.Instructor;
import com.love.entity.Instructordetail;
import com.love.entity.Review;
import com.love.entity.Student;



public class Getcoursesformarydemo 
{
public static void main(String[] args) throws ParseException 
{
	//Create the Session factory
	SessionFactory factory=new Configuration()
			               .configure("hibernate.cfg.xml")
			               .addAnnotatedClass(Instructordetail.class)
			               .addAnnotatedClass(Instructor.class)
			               .addAnnotatedClass(Course.class)
			               .addAnnotatedClass(Review.class)
			               .addAnnotatedClass(Student.class)
			               .buildSessionFactory();
	
	Session session=factory.getCurrentSession();
	try
	{
		//begin the transaction
	    session.beginTransaction();
	    
      //get the kushal from database
	    int theid=2;
	    
	    Student temp=session.get(Student.class, theid);
	    System.out.println("Loading the student"+temp);
	    System.out.println("course:"+temp.getCourses());
	    
	    
	    
		
		
		
		//commit the transaction
		session.getTransaction().commit();
		System.out.println("done");
	}
	finally
	{
		//clean the code
		session.close();
		factory.close();
	}
}
}
