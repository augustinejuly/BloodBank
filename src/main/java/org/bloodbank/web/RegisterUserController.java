package org.bloodbank.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.bloodbank.form.beans.MemberForm;
import org.bloodbank.form.beans.ProviderForm;
import org.bloodbank.mongo.model.BloodGroup;
import org.bloodbank.mongo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterUserController {

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(value="/registerMember", method = RequestMethod.GET)
	public String showMemberRegistrationForm(Model model, HttpServletRequest request) {

		HttpSession httpSession = request.getSession(false);
		if(httpSession != null && httpSession.getAttribute("username") != null) {
			// already registered user
			return "redirect:/blood";
		}

		model.addAttribute("bg", BloodGroup.values());
		model.addAttribute("memberForm", new MemberForm());

		return "memberRegistration";
	}


	@RequestMapping(value="/registerMember", method = RequestMethod.POST)
	public String registerMember(@ModelAttribute("memberForm") @Valid MemberForm memberForm,BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors() || !memberForm.getPassword().equals(memberForm.getConfirmPassword())) {
			// temporary ugly fix as JSR 303 does not have validation with another variable
			if(!memberForm.getPassword().equals(memberForm.getConfirmPassword())) {
				bindingResult.reject("confirmPassword", "Password and the Confirm Password should be the same");
			}
			model.addAttribute("bg", BloodGroup.values());
			return "memberRegistration";
		}

		registrationService.saveMemberDetails(memberForm);
		return "redirect:/login";
	}

	@RequestMapping(value="/registerProvider", method = RequestMethod.GET)
	public String showProviderRegistrationForm(Model model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		if(httpSession != null && httpSession.getAttribute("username") != null) {
			// already registered user
			return "redirect:/blood";
		}
		ProviderForm providerForm = new ProviderForm();
		model.addAttribute("providerForm", providerForm);

		return "providerRegistration";
	}


	@RequestMapping(value="/registerProvider", method = RequestMethod.POST)
	public String registerProvider(@ModelAttribute("providerForm") @Valid ProviderForm providerForm,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors() || !providerForm.getPassword().equals(providerForm.getConfirmPassword())) {
			// temporary ugly fix as JSR 303 does not have validation with another variable
			if(!providerForm.getPassword().equals(providerForm.getConfirmPassword())) {
				bindingResult.reject("confirmPassword", "Password and the Confirm Password should be the same");
			}
			return "providerRegistration";
		}

		registrationService.saveProviderDetails(providerForm);
		return "redirect:/login";
	}

}
