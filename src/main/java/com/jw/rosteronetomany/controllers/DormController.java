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

import com.jw.rosteronetomany.models.Dorm;
import com.jw.rosteronetomany.services.DormService;

@Controller
public class DormController {
	@Autowired
	DormService serv;
	
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
		m.addAttribute("d", this.serv.findById(id));
		return "viewdorm.jsp";
	}
}
