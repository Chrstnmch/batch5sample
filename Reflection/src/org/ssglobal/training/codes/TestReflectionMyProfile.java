package org.ssglobal.training.codes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflectionMyProfile {

	public static void main(String[] args) {
		
		try {
			Class<?> profileClass = MyProfile.class;
			MyProfile profile = (MyProfile) profileClass.getConstructor().newInstance();
			
			// Annotation checking
			Annotation[] annots = profileClass.getAnnotations();
			
			for (Annotation a : annots) {
				System.out.println(a.annotationType());
				System.out.println(a.toString());
				
				if (a.annotationType().equals(MyAnnotation.class)) {
					MyAnnotation ma = (MyAnnotation) a;
					System.out.println(ma.id());
					System.out.println(Arrays.toString(ma.salary()));
					System.out.println(ma.name());
					System.out.println(ma.age());
					System.out.println(MyAnnotation.companyName);
				}
			}
			
			System.out.println("----------------------------------------");
			Field fnameField = profileClass.getDeclaredField("fname");
			Annotation[] fieldAnnots = fnameField.getAnnotations();
			
			for (Annotation a : fieldAnnots) {
				System.out.println(a.annotationType());
				System.out.println(a.toString());
				
				if (a.annotationType().equals(MyAnnotation.class)) {
					MyAnnotation ma = (MyAnnotation) a;
					System.out.println(ma.id());
					System.out.println(Arrays.toString(ma.salary()));
					System.out.println(ma.name());
					System.out.println(ma.age());
					System.out.println(MyAnnotation.companyName);
				}
			}
			
			System.out.println("----------------------------------------");
			Field lnameField = profileClass.getDeclaredField("lname");
			Annotation[] fieldAnnots2 = lnameField.getAnnotations();
			
			for (Annotation a : fieldAnnots2) {
				System.out.println(a.annotationType());
				System.out.println(a.toString());
				
				if (a.annotationType().equals(MyAnnotation.class)) {
					MyAnnotation ma = (MyAnnotation) a;
					System.out.println(ma.id());
					System.out.println(Arrays.toString(ma.salary()));
					System.out.println(ma.name());
					System.out.println(ma.age());
					System.out.println(MyAnnotation.companyName);
				}
			}

			
			System.out.println("----------------------------------------");
			Method displayMethod = profileClass.getDeclaredMethod("display");
			Annotation[] methodAnnots = displayMethod.getAnnotations();
			
			for (Annotation a : methodAnnots) {
				System.out.println(a.annotationType());
				System.out.println(a.toString());
				
				if (a.annotationType().equals(MyAnnotation.class)) {
					MyAnnotation ma = (MyAnnotation) a;
					System.out.println(ma.id());
					System.out.println(Arrays.toString(ma.salary()));
					System.out.println(ma.name());
					System.out.println(ma.age());
					System.out.println(MyAnnotation.companyName);
				}
			}
			
			System.out.println("----------------------------------------");
			Method displayMethod2 = profileClass.getDeclaredMethod("extractDetails");
			Annotation[] methodAnnots2 = displayMethod2.getAnnotations();
			
			for (Annotation a : methodAnnots2) {
				System.out.println(a.annotationType());
				System.out.println(a.toString());
				
				if (a.annotationType().equals(MyAnnotation.class)) {
					MyAnnotation ma = (MyAnnotation) a;
					System.out.println(ma.id());
					System.out.println(Arrays.toString(ma.salary()));
					System.out.println(ma.name());
					System.out.println(ma.age());
					System.out.println(MyAnnotation.companyName);
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace(); 
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
	}

}
