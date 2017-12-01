package com.springBook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBook.dao.StudentRepository;
import com.springBook.entitys.Student;

@Controller
@RequestMapping(value="/students")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value="/index")
	public String Index(Model model,@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="search",defaultValue="") String search) {
		
		Page<Student> pageStudents = studentRepository.getStudentByFullName("%"+search+"%",new PageRequest(page, 20));
		int pagesCount = pageStudents.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pages.length; i++) pages[i]=i;
		
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourante",page);
		model.addAttribute("students",pageStudents);
		model.addAttribute("search",search);
		return "students";
	}
}
