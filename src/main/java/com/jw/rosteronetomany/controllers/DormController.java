package com.jw.rosteronetomany.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jw.rosteronetomany.models.Dorm;
import com.jw.rosteronetomany.models.Student;
import com.jw.rosteronetomany.services.DormService;
import com.jw.rosteronetomany.services.StudentService;

@Controller
public class DormController {
	@Autowired
	DormService serv;
	
	@Autowired
	StudentService sServ;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dorms";
	}
	
	@GetMapping("/dorms")
	public String dorms(Model m) {
		m.addAttribute("dorms", serv.findAll());
		return "dorms.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String newDormForm(
			@ModelAttribute("d") Dorm d
			) {
		return "newdorms.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String save(
			@Valid @ModelAttribute("d") Dorm d,
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "newdorms.jsp";
		} else {
			serv.save(d);
			return "redirect:/dorms";
		}
	}

	@GetMapping("/dorms/view/{dormId}")
	public String viewOne(
			@PathVariable("dormId") Long id,
			Model m
			) {
		m.addAttribute("students",sServ.findAll());
		m.addAttribute("d", this.serv.findById(id));
		return "viewdorm.jsp";
	}
	
	@PostMapping("/dorms/{dormID}/remove/{studentID}")
	public String removeStudent(
			@PathVariable("studentID") Long studentID,
			@PathVariable("dormID") Long dormID
			) {
		sServ.removeFromDorm(sServ.findById(studentID));
		return "redirect:/dorms/view/" + dormID;
	}
	
	@PostMapping("/dorms/{dormID}/add/student")
	public String addStudent(
			@RequestParam("student_id") Long studentID,
			@PathVariable("dormID") Long dormID
			) {
		//get a student using id
		Student oneStudent = sServ.findById(studentID);
		//set student object's dorm to the dorm id from URL
		oneStudent.setDorm(serv.findById(dormID));
		//save the student in the DB with its dorm
		sServ.save(oneStudent);
		return "redirect:/dorms/view/" + dormID;
	}
	
}
