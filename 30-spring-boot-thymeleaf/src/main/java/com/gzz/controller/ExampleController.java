package com.gzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {

	public String helloWorld() {
		return "index";
	}

	@RequestMapping("/exercise/1")
	public String exercise1(Model model) {
		model.addAttribute("name", "Dear");
		return "exercise/1";
	}

	@RequestMapping("/exercise/2")
	public String exercise2(Model model) {
		model.addAttribute("index", "1");
		return "exercise/2";
	}

	@RequestMapping("/exercise/3")
	public String exercise3(Model model) {
		model.addAttribute("name", "Dear");
		return "exercise/3";
	}

	@RequestMapping("/exercise/4")
	public String exercise4(Model model) {
		model.addAttribute("count1", 4);
		model.addAttribute("count2", 5);
		return "exercise/4";
	}

	@RequestMapping("/exercise/5")
	public String exercise5(Model model) {
		model.addAttribute("count", "2");
		return "exercise/5";
	}

	@RequestMapping("/exercise/6")
	public String exercise6(Model model) {
		int[] ids = { 1, 2, 3, 4, 5, 6, 7 };
		model.addAttribute("ids", ids);
		return "exercise/6";
	}

	@RequestMapping("/exercise/7")
	public String exercise7(Model model) {
		return "exercise/7";
	}
}
