package com.springBook.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springBook.entitys.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findByFullName(String fullName);
	public Page<Student> findByFullName(String fullName,Pageable pageable);
	@Query("select s from Student s where s.fullName like :x")
	public Page<Student> getStudentByFullName(@Param("x")String fullName,Pageable pageable);
	
}
