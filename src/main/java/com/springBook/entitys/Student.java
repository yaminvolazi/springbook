package com.springBook.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length=30)
	private String fullName;
	private Date birthday;
	private String email;
	private String photo;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String fullName, Date birthday, String email, String photo) {
		super();
		this.fullName = fullName;
		this.birthday = birthday;
		this.email = email;
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
