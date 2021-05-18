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



public class CreatecoursesandstudentsDemo2 
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
	    
       //  create the course
	    
	    Course c1=new Course("The Pacman");
	    
	    System.out.println("saving the course");
	    session.save(c1);
	    System.out.println("saving"+c1);
	    
	    //createing the students
	    
	    Student s1=new Student("Keeru","RV","krv318@gmail.com");
	    Student s2=new Student("Kushal","RV","kush@gmail.com");
	    
	  c1.addstudent(s1);
	  c1.addstudent(s2);
	  
	  //saving the students
	  
	  session.save(s1);
	  session.save(s2);
	  System.out.println("getting the students"+c1.getStudents());
	  
	  
       
		
		
		
		
		
		
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
