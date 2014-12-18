package org.bloodbank.mongo.model;

public enum BloodGroup {

	A1_POSITIVE("A1 +ve"), 
	A1_NEGATIVE("A1 -ve"),
	A1B_POSITIVE("A1B +ve"),
	A1B_NEGATIVE("A1B -ve"),
	A2_POSITIVE("A2 +ve"),
	A2_NEGATIVE("A2 -ve"),
	A2B_POSITIVE("A2B +ve"),
	A2B_NEGATIVE("A2B -ve"),
	B_POSITIVE("B +ve"),
	B_NEGATIVE("B -ve"),
	O_POSITIVE("O +ve"),
	O_NEGATIVE("O -ve"),
	AB_POSITIVE("AB +ve"),
	AB_NEGATIVE("AB -ve"),
	A_POSITIVE("A +ve"),
	A_NEGATIVE("A -ve");

	private final String bloodGroupName;

	BloodGroup(String bloodGroupName){
		this.bloodGroupName = bloodGroupName;
	}

	public String getBloodGroupName() {
		return bloodGroupName;
	}

}
