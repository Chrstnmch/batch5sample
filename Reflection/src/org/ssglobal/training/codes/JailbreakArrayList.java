package org.ssglobal.training.codes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JailbreakArrayList {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// ArrayList
		
		List<String> nameslist = new ArrayList<>();
		
		//Requirement: Class Object
		
		Class<?> arrList2 = nameslist.getClass();
		
		try {
			Class<?> arrList3 = Class.forName("java.util.ArrayList");
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
		}
		
		// Instance from a class
		try {
			// Requirement: Class Object
			Class<?> arrList = ArrayList.class;
			ArrayList<String> arrListObj = (ArrayList<String>) arrList.getConstructor().newInstance();
			
			// Scan all the global variables
			System.out.println("------------------------------------------------------");
			Constructor<?>[] constructs = arrList.getDeclaredConstructors();
			
			for (Constructor<?> c : constructs) {
				System.out.println(Modifier.toString(c.getModifiers()));
				System.out.println(c.getParameterCount());
				
				for (Parameter p: c.getParameters()) {
					System.out.println("***" + Modifier.toString(p.getModifiers()));
					System.out.println("***" + p.getType());
					System.out.println("***" + p.getName());
				}
				System.out.println("*******************************");
			}
			
			// Scan all the global Variables
			
			System.out.println("---------------------------------");
			Field[] globalVars = arrList.getDeclaredFields();
			for (Field f : globalVars) {
				System.out.println(Modifier.toString(f.getModifiers()));
				System.out.println(f.getType());
				System.out.println(f.getName());
				System.out.println("*******************************");
			}

			System.out.println("---------------------------------");
			Method[] allMethods = arrList.getDeclaredMethods();
			for (Method m : allMethods) {
				System.out.println(Modifier.toString(m.getModifiers()));
				System.out.println(m.getReturnType());
				System.out.println(m.getName());
				System.out.println(m.getParameterCount());
				
				for (Parameter p: m.getParameters()) {
					System.out.println("***" + Modifier.toString(p.getModifiers()));
					System.out.println("***" + p.getType());
					System.out.println("***" + p.getName());
				}
				System.out.println(Arrays.toString(m.getExceptionTypes()));
				System.out.println("*******************************");
			}
			
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (InvocationTargetException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}
	}
}