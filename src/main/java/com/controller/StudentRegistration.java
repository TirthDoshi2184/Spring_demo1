package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.BoxCricketReg;

@Controller
public class StudentRegistration{

	@GetMapping("/boxcricketregistration")
	public String boxRegistration() {
		return "BoxCricket";// jsp name
	}

	@PostMapping("/savereg")
	public String saveRegistration(BoxCricketReg studentBox, Model model) {
		// bean ->variable : jsp form
		System.out.println(studentBox.getStudentName());
		System.out.println(studentBox.getPlayerType());
		System.out.println(studentBox.getFoodPreference());
		System.out.println(studentBox.getDrink());

		boolean isError = false;
		String alphaRegex  = "[A-Za-z]+";

		if (studentBox.getStudentName() == null || studentBox.getStudentName().trim().length() == 0) {
			isError = true;
			model.addAttribute("studentNameError","Please Enter Student Name");
		}
		else if(studentBox.getStudentName().matches(alphaRegex) == false) {
			isError = true;
			model.addAttribute("studentNameError","Please Enter valid Student Name");
		}

		if (studentBox.getPlayerType() == null) {
			isError = true;
			model.addAttribute("playerTypeError","Please Select PlayerType");
		}

		if (studentBox.getFoodPreference().equals("-1") == true) {
			isError = true;
			model.addAttribute("foodPreferenceError","Please Selecct FoodPreference");
		}

		if (isError == true) {
			return "BoxCricket";
		} else {
			// how to send data to jsp from controller ?
			model.addAttribute("")
			model.addAttribute("reg", studentBox);// data name -> data value
			return "RegDetail";
		}
	}

	// jsp open -> url -> Get mapping
	// jsp form ->data -> Post mapping

}