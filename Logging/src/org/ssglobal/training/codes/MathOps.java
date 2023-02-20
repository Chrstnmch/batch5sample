package org.ssglobal.training.codes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MathOps {
	
	// Step 1: Create or build the private logger object
	private Logger logger = Logger.getLogger(MathOps.class.getName());

	public MathOps() {
		// Step 2: Set the level of the logging
		logger.setLevel(Level.INFO);
		
		// Step 3: Create another handler
		try {
			FileHandler fileHandler = new FileHandler("./src/config/math.log", true);
			fileHandler.setLevel(Level.ALL);
			fileHandler.setEncoding("UTF-8");
			
			// Step 4: Create Format
			SimpleFormatter sf = new SimpleFormatter();
			fileHandler.setFormatter(sf);
			
			logger.addHandler(fileHandler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MathOps(int x, int y) {
		// Step 2: Set the level of the logging
		logger.setLevel(Level.INFO);
		
		// Step 3: Create another handler
		try {
			FileHandler fileHandler = new FileHandler("./src/config/math.log");
			fileHandler.setLevel(Level.ALL);
			fileHandler.setEncoding("UTF-8");
			logger.addHandler(fileHandler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public int add(int x, int y) {
		logger.info("start of method add() with parameters: x=%d, y=%d".formatted(x, y));
		logger.warning("using custom Data() object");
		Date xmas = new Date(123, 1, 32);
		System.out.println(xmas);
		int sum = x + y;
		logger.info("end of method div() with parameters: x=%d, y=%d".formatted(x, y));
		return sum;
	}
	
	public int div(int x, int y) throws ArithmeticException, Exception{
		// This where you put your log
		logger.info("start of method div() with parameters: x=%d, y=%d".formatted(x, y));
		
		if (y == 0) {
			// before throw new, log
			logger.severe("division by zero error");
			throw new ArithmeticException();
		}
		
		// return log
		logger.info("end of method div() with parameters: x=%d, y=%d".formatted(x, y));
		return x / y;
	}
	
	public int[] displayArray(int[] arrData) {
		logger.info("start of method displayArray() with parameter: arrData=%s".formatted(Arrays.toString(arrData)));
		try {
			int len = arrData.length;
			System.out.println("length of array: %d".formatted(len));
			System.out.println(Arrays.toString(arrData));
		} catch (NullPointerException e) {
			logger.severe(e.getMessage());
		}
		logger.info("end of method displayArray() with parameter: arrData=%s".formatted(Arrays.toString(arrData)));
		return arrData;
	}
	
	
}
