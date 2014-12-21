package org.bloodbank.web;

import java.util.List;

import org.blood.mongo.repo.BloodRequestRepository;
import org.blood.mongo.repo.UserCredentialRepository;
import org.blood.mongo.repo.UserProfileRepository;
import org.bloodbank.mongo.model.BloodRequest;
import org.bloodbank.mongo.model.CommonUserProfile;
import org.bloodbank.mongo.model.UserCredential;
import org.bloodbank.mongo.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/admin/delete")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class DeleteController {
	
	@Autowired
	private DeleteService deleteService;
	
	@Autowired
	private UserCredentialRepository userCredentialRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private BloodRequestRepository bloodRequestRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String deleteCollections() {
		return "deleteAll";
	}
	
	@RequestMapping(value="/userProfile",method=RequestMethod.GET)
	public String deleteUserProfile(Model model) {
		List<CommonUserProfile> userProfiles = userProfileRepository.findAll();
		model.addAttribute("userProfileList", userProfiles);
		return "adminPages/deleteUserProfile";
	}
	
	@RequestMapping(value="/currentUserProfile",method=RequestMethod.GET)
	public String deleteUserSelectedUserProfile(@RequestParam("username") String username) {
		userProfileRepository.delete(username);
		return "redirect:/admin/delete/userProfile";
	}
	
	@RequestMapping(value="/bloodRequest",method=RequestMethod.GET)
	public String deleteBloodRequest(Model model) {
		List<BloodRequest> bloodRequests = bloodRequestRepository.findAll();
		model.addAttribute("bloodRequests", bloodRequests);
		return "adminPages/deleteBloodRequests";
	}
	
	@RequestMapping(value="/currentBloodRequest",method=RequestMethod.GET)
	public String deleteSelectedBloodRequest(@RequestParam("id") Long id) {
		bloodRequestRepository.delete(id);
		return "redirect:/admin/delete/bloodRequest";
	}
	
	@RequestMapping(value="/userCredential",method=RequestMethod.GET)
	public String deleteUserCredentialExceptAdmin(Model model) {
		List<UserCredential> userCredentials = userCredentialRepository.findAll();
		model.addAttribute("userCredentialList", userCredentials);
		return "adminPages/deleteUserCredential";
	}
	
	@RequestMapping(value="/currentUserCredential",method=RequestMethod.GET)
	public String deleteSelectedUserCredentail(@RequestParam("username") String username) {
		userCredentialRepository.delete(username);
		return "redirect:/admin/delete/userCredential";
	}

}
