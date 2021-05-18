package com.love.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor 
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
     private int id;
	 
	 @Column(name="first_name")
	 private String firstName;
	    
	 @Column(name="last_name")
	 private String lastName;
	    
	 @Column(name="email")
	 private String email;
	 
	 @OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="instructor_detail_id")
	 private Instructordetail instructordetailid;
	 
	 @OneToMany(fetch=FetchType.LAZY,mappedBy="instructor",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	 private List<Course> courses; 
	 
	 
	 public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Instructor()
	 {
		 
	 }

	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instructordetail getInstructordetailid() {
		return instructordetailid;
	}

	public void setInstructordetailid(Instructordetail instructordetailid) {
		this.instructordetailid = instructordetailid;
	}

	
	
	//Add covinence method for bi directional relation ship
	
		public void add(Course temp)
		{
			if(courses==null)
			{
				courses=new ArrayList<>();
			}
			
			courses.add(temp);
			
			temp.setInstructor(this);
			
		}

		@Override
		public String toString() {
			return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", instructordetailid=" + instructordetailid + "]";
		}
	
	
	 
	 
}