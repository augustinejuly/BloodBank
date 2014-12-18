package org.bloodbank.web;

import org.bloodbank.mongo.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/delete")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class DeleteController {
	
	@Autowired
	private DeleteService deleteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String deleteCollections() {
		return "deleteAll";
	}
	
	@RequestMapping(value="/userProfile",method=RequestMethod.GET)
	public String deleteUserProfile() {
		System.out.println("deleteUserProfile is called >>>");
		deleteService.deleteUserProfiles();
		return "redirect:/blood";
	}
	
	@RequestMapping(value="/bloodRequest",method=RequestMethod.GET)
	public String deleteBloodRequest() {
		System.out.println("deleteBloodRequest is called >>>");
		deleteService.deleteBloodRequests();
		return "redirect:/blood";
	}
	
	@RequestMapping(value="/userCredential",method=RequestMethod.GET)
	public String deleteUserCredentialExceptAdmin() {
		System.out.println("deleteUserCredentialExceptAdmin is called >>>");
		deleteService.deleteUserCredentials();
		return "redirect:/blood";
	}

}
