package com.love.hibernate;

import java.text.ParseException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love.entity.Course;
import com.love.entity.Instructor;
import com.love.entity.Instructordetail;
import com.love.entity.Review;



public class CreatecoursesandreviewsDemo 
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
			               .buildSessionFactory();
	
	Session session=factory.getCurrentSession();
	try
	{
		//begin the transaction
	    session.beginTransaction();
	    
        int theid=1;
		
		Instructor temp=session.get(Instructor.class,theid);
				
		//create the courses
	    
	    Course c1=new Course("The Pacman");
	    
	    temp.add(c1);
	  
        
	    
	    
	    //add the reviews
	    c1.add(new Review("Great story and Loved it"));
	    c1.add(new Review("Cool course Good Job"));
	    c1.add(new Review("What a dumb course!!!"));
	    
	    
	    //save the course and leverage the review by using cascade
	    
	    System.out.println("saving the course");
	    session.save(c1);
		
		
		
		
		
		
		
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
