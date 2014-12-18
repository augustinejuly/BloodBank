package org.bloodbank.web;

import java.util.ArrayList;
import java.util.List;

import org.bloodbank.mongo.dao.BloodRequestDao;
import org.bloodbank.mongo.model.BloodGroup;
import org.bloodbank.mongo.model.BloodRequest;
import org.bloodbank.mongo.model.BloodRequestType;
import org.bloodbank.mongo.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/bloodRequestDetail")
public class BloodRequestDetailController {

	@Autowired
	private BloodRequestDao bloodRequestDao;

	@RequestMapping(value = "/demand", method=RequestMethod.GET)
	public String getBloodDemandDetail(@RequestParam("bgs") BloodGroup bgs, Model model) {

		List<BloodRequest> bloodRequests = bloodRequestDao.getBloodRequest(bgs, BloodRequestType.DEMAND);
		List<BloodRequest> requestFromMember = new ArrayList<BloodRequest>();
		List<BloodRequest> requestFromProvider = new ArrayList<BloodRequest>();

		for (BloodRequest bloodRequest : bloodRequests) {
			if(bloodRequest.getRequestPostedBy().getUserType().equals(UserType.MEMBER)) {
				requestFromMember.add(bloodRequest);
			}else {
				requestFromProvider.add(bloodRequest);
			}
		}
		model.addAttribute("memberList", requestFromMember);
		model.addAttribute("providerList", requestFromProvider);

		return "bloodDetail";
	}


	@RequestMapping(value = "/donate", method=RequestMethod.GET)
	public String getBloodAvialableDetail(@RequestParam("bgs") BloodGroup bgs, Model model) {

		List<BloodRequest> bloodRequests = bloodRequestDao.getBloodRequest(bgs, BloodRequestType.DONATE);
		List<BloodRequest> requestFromMember = new ArrayList<BloodRequest>();
		List<BloodRequest> requestFromProvider = new ArrayList<BloodRequest>();

		for (BloodRequest bloodRequest : bloodRequests) {
			if(bloodRequest.getRequestPostedBy().getUserType().equals(UserType.MEMBER)) {
				requestFromMember.add(bloodRequest);
			}else {
				requestFromProvider.add(bloodRequest);
			}
		}
		model.addAttribute("memberList", requestFromMember);
		model.addAttribute("providerList", requestFromProvider);

		return "bloodDetail";
	}


}
