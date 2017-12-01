package com.springBook;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.springBook.dao.StudentRepository;
import com.springBook.entitys.Student;

@SpringBootApplication
public class SpringBookApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = SpringApplication.run(SpringBookApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		
		DateFormat birthday = new SimpleDateFormat("yyy-MM-dd");
		for (int i = 0; i < 30; i++) {
		    studentRepository.save(new Student("Yamin MECHQI", birthday.parse("1993-04-29"), "mr.yamin.mechqi@gmail.com", "image/yamin.png"));
		    studentRepository.save(new Student("Adnan MRAKXI", birthday.parse("1992-04-29"), "adnan@gmail.com", "image/adnan.png"));			
		}
	
	    Page<Student> Students = studentRepository.findAll(new PageRequest(0, 5));
	    
	    Students.forEach(s->System.out.println(s.getFullName()));
	
	}
}
