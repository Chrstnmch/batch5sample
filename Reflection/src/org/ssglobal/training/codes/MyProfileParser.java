package org.ssglobal.training.codes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyProfileParser {

	public static void main(String[] args) {
		try {
			Class<?> profileClass = MyProfile.class;
			MyProfile profile = (MyProfile) profileClass.getConstructor().newInstance();

			
			// Annotation checking
			boolean isClassAnnotated = false;
			Annotation[] annots = profileClass.getAnnotations();
			
			for (Annotation a : annots) {
				if (a.annotationType().equals(MyAnnotation.class)) {
					isClassAnnotated = true;
					break;
				}
			}
			
			if (isClassAnnotated) {
				Field[] fields = profileClass.getDeclaredFields();
				
				for (Field field : fields) {
					Annotation[] fieldAnnots = field.getAnnotations();
					
					for (Annotation a : fieldAnnots) {
						if (a.annotationType().equals(MyAnnotation.class)) {
							if (field.getName().equalsIgnoreCase("fname")) {
								field.setAccessible(true);
								field.set(profile, "Juan");
								String value = (String) field.get(profile);
								System.out.println("%s: %s".formatted(field.getName(), value));
							} else if(field.getName().equalsIgnoreCase("lname")) {
								field.setAccessible(true);
								field.set(profile, "Luna");
								String value = (String) field.get(profile);
								System.out.println("%s: %s".formatted(field.getName(), value));
							}
						}
					}
				}
				
				Method[] methods = profileClass.getDeclaredMethods();
				
				for (Method m : methods) {
					Annotation[] methodAnnots = m.getAnnotations();
					
					for (Annotation a : methodAnnots) {
						if (a.annotationType().equals(MyAnnotation.class)) {
							if (m.getReturnType().equals(void.class)) {
								m.invoke(profile);
							} else {
								Object value = m.invoke(profile);
								System.out.println(value);
							}
						}
					}
				}
			} else {
				System.out.println("Invalid class");
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
		}

	}

}
