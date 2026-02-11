package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

	@GetMapping("/my/form1")
	public String form1() {
		return "form/form1";
	}
	@GetMapping("/my/form2")
	public String form2() {
		return "form/form2";
	}
	@GetMapping("/my/form3")
	public String form3() {
		return "form/form3";
	}
}
