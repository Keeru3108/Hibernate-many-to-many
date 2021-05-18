package com.love.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class Instructordetail 
{
	//Add new filed resource instructor
	@OneToOne(mappedBy="instructordetailid",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}) 
	private Instructor instructor;
	 
	 public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
     private int id;
	 
	 @Column(name="youtube_channel")
	 private String youtube;
	 
	 @Column(name="hobby")
	 private String hobby;
	 public Instructordetail()
	 {
		 
	 }

	public Instructordetail(String youtube, String hobby) {
		super();
		this.youtube = youtube;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Instructordetail [id=" + id + ", youtube=" + youtube + ", hobby=" + hobby + "]";
	}
	 
	 
}
