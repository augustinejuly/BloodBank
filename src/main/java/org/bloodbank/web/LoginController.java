package org.bloodbank.web;

import org.bloodbank.form.beans.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		System.out.println("Loing Controller Called >>>>>>>>>>>>>");
		model.addAttribute("userLogin", new Login());
		return "login";
	}
}
