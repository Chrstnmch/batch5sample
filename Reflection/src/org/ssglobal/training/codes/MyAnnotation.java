package org.ssglobal.training.codes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface MyAnnotation {

	// default annotation variables
	int id() default 100;
	String name() default "annot";
	String[] config() default {"Anna", "Lorna", "Fe"};
	
	// non default annotation variables
	double[] salary();
	int age();
	
	// static annotation variables
	String companyName = "77Global";
	
}
