package com.example.wei.springbootfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"","/"})
public class HomeController {

	@GetMapping()
	public String home(Model model) {
		model.addAttribute("username", "盧力維");
		return "index";
	}
}
