package com.jw.rosteronetomany.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jw.rosteronetomany.models.Student;
import com.jw.rosteronetomany.services.DormService;
import com.jw.rosteronetomany.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService serv;
	@Autowired
	DormService dServ;
	
	@GetMapping("/students/new")
	public String newStudentForm(
			Model m
			) {
		m.addAttribute("s", new Student());
		m.addAttribute("dorms", dServ.findAll());
		return "newstudents.jsp";
	}
	
	@PostMapping("/students/new")
	public String save(
			@Valid @ModelAttribute("s") Student s,
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "newstudents.jsp";
		} else {
			serv.save(s);
			return "redirect:/dorms/view/" + s.getDorm().getId();
		}
	}
}
