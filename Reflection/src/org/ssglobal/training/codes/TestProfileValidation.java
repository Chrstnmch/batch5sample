package org.ssglobal.training.codes;

public class TestProfileValidation {

	public static void main(String[] args) {
		String str = new String();
		Profile p = new Profile();
		Integer val = Integer.valueOf(0);
		
		ProfileValidator v = new ProfileValidator();
		v.process(str.getClass());
		v.process(p.getClass());
		v.process(val.getClass());

	}

}
