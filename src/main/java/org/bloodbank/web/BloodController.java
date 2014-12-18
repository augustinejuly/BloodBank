package org.bloodbank.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.blood.mongo.repo.UserProfileRepository;
import org.bloodbank.mongo.dao.BloodRequestDao;
import org.bloodbank.mongo.model.BloodGroup;
import org.bloodbank.mongo.model.BloodRequest;
import org.bloodbank.mongo.model.MemberProfile;
import org.bloodbank.mongo.model.ProviderProfile;
import org.bloodbank.mongo.model.UserType;
import org.bloodbank.mongo.service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/blood")
public class BloodController {

	@Autowired
	private BloodRequestService bloodRequestService;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private BloodRequestDao bloodRequestDao;

	@RequestMapping(method = RequestMethod.GET)
	public String bloodHome(Model model) {
		System.out.println("Method bloodHome invoked>>>");
		Map<String, Long> bloodGroupStatusMap = bloodRequestDao.getBloodGroupStatusMap();
		model.addAllAttributes(bloodGroupStatusMap);
		return "bloodhome";
	}

	@RequestMapping(value = "/bloodRequest", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public String bloodRequest(Model model) {
		System.out.println("Method bloodRequest invoked>>>");
		model.addAttribute("bloodRequest", new BloodRequest());
		model.addAttribute("bg", BloodGroup.values());
		return "bloodRequest";
	}

	@RequestMapping(value = "/bloodRequest", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ModelAndView createbloodRequest(
			@ModelAttribute("bloodRequest") @Valid BloodRequest bloodRequest,
			BindingResult bindingResult) {

		System.out.println("Method createbloodRequest invoked>>>");
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("bloodRequest");
			modelAndView.addObject("bg", BloodGroup.values());
			return modelAndView;
		}
		System.out.println("Blood Group Request : "
				+ bloodRequest.getBloodGroup());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = (authentication != null) ? authentication.getName() : "";
		bloodRequestService.saveBloodRequest(bloodRequest, name);
		return new ModelAndView("redirect:/blood");
	}

	@RequestMapping(value = "/showRegisteredUsers", method = RequestMethod.GET)
	public String showRegisteredUsers(Model model) {

		// limited to first 100 users only
		List<MemberProfile> allMemberProfiles = userProfileRepository.findAllMemberProfiles(UserType.MEMBER, new PageRequest(0, 100));
		List<ProviderProfile> allProviderProfiles = userProfileRepository.findAllProviderProfiles(UserType.PROVIDER, new PageRequest(0, 100));

		model.addAttribute("memberList", allMemberProfiles);
		model.addAttribute("providerList", allProviderProfiles);

		return "showRegisteredUsers";
	}

}
