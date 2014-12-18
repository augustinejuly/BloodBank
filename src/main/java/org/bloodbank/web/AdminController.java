package org.bloodbank.web;

import javax.validation.Valid;

import org.bloodbank.form.beans.Login;
import org.bloodbank.mongo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
	This class is only for my personal use
**/
@Controller
@RequestMapping(value="/loginadmin")
public class AdminController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showAdminForm(Model model) {
		model.addAttribute("adminLogin", new Login());
		return "adminLogin";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String createAdminUser(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				if(login.getRole().isEmpty()) {
					bindingResult.reject("role", "choose any role");
				}
				return "adminLogin";
			}
			registrationService.saveUser(login);
			
		return "redirect:/login";
	}
}
