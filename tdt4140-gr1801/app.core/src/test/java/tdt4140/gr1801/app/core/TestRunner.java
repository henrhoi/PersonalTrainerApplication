package tdt4140.gr1801.app.core;

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestJunit.class);
		
		for (Failure fail: result.getFailures()) {
			System.out.println(fail.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}
}
