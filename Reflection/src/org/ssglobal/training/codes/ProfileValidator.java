package org.ssglobal.training.codes;

public class ProfileValidator {

	public boolean isProfile(Class<?> profile) {
		return Profile.class.equals(profile);
	}
	
	public void process(Class<?> profile) {
		if (isProfile(profile)) {
			System.out.println("Continue processing");
		} else {
			System.out.println("Invalid Class");
		}
	}
	
}
