package org.ssglobal.training.codes;

@MyAnnotation(age = 45, salary = {60000.00, 100000.00, 200000.00}, id = 10)
public class MyProfile {

	@MyAnnotation(age = 35, salary = {40000.00})
	private String fname;
	@MyAnnotation(age = 30, salary = {30000.00})
	private String lname;
	private Integer age;
	
	public MyProfile() {
	}
	
	public MyProfile(String fname, String lname, Integer age) {
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}

	@MyAnnotation(age = 30, salary = {10000.00})
	public void display() {
		System.out.println("%s %s %d".formatted(fname, lname, age));
	}
	
	public String extractDetails() {
		return "%s %s %d".formatted(fname, lname, age);
	}
}
