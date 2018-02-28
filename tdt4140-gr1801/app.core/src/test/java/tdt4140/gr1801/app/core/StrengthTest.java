package tdt4140.gr1801.app.core;

import java.util.Arrays;
import java.util.Date;

import junit.framework.TestCase;

public class StrengthTest extends TestCase {
	
	Strength strength;
	Exercise e1, e2, e3, e4;

	@SuppressWarnings("deprecation")
	protected void setUp() {
		e1 = new Exercise("Benchpress", 80, Arrays.asList(15, 12, 10));
		e2 = new Exercise("DeadLift", 60, Arrays.asList(8, 6, 5));
		e3 = new Exercise("Squats", 90, Arrays.asList(5, 5, 4));
		e4 = new Exercise("Burpees", 0, Arrays.asList(20, 15, 10));
		strength = new Strength(new Date(28, 02, 2018), 60, Arrays.asList(e1, e2, e3, e4));
	}

	public void testGetExercises() {
		assertEquals(Arrays.asList(e1, e2, e3, e4), strength.getExercises());
	}

	public void testGetSpecificExercise() {
		assertEquals(e3, strength.getSpecificExercise("Squats"));
	}
	
}
