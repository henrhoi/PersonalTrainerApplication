package tdt4140.gr1801.app.core;

import java.util.Arrays;
import junit.framework.TestCase;
import tdt4140.gr1801.app.core.Exercise;


public class ExerciseTest extends TestCase {
	
	Exercise exercise;
	
	@Override 
	protected void setUp() {
		exercise = new Exercise("Benchpress", 110, Arrays.asList(15, 12, 10));
	}
	
	public void testGetName() {
		assertEquals("Benchpress", exercise.getName());
	}
	
	public void testGetWeight() {
		assertEquals(110.0, exercise.getWeight());
	}
	
	public void testGetRepsPerSet() {
		assertEquals(Arrays.asList(15, 12, 10), exercise.getRepsPerSet());
	}
	
	public void testGetNumberOfSets() {
		assertEquals(3, exercise.getNumberOfSets());
	}
	
//	public void testGetTotalReps() {
//		assertEquals(37, exercise.getTotalReps());
//	}
	
	public void testExerciseWithouthException() {
		try {
			new Exercise("Benchpress", 110.25, Arrays.asList(15, 12, 10));
			new Exercise("Pullups", 20, Arrays.asList(10, 8, 8, 8, 7, 4));
			new Exercise("Pushdown", 70, Arrays.asList(100, 33, 59));
			new Exercise("Manualpress incline", 50, Arrays.asList(15, 12, 10));
			// Supposed to get her
		}
		catch (Exception e) {
			System.err.println(e);
			fail(); // Not supposed to get here
		}
	}
	
	public void testEmptyNameException() {
		try {
			new Exercise("", 110, Arrays.asList(15, 12, 10));
			fail(); // Not supposed to get here
		}
		catch (IllegalArgumentException iae) {
			// Supposed to get here
		}
		catch (Exception e) {
			fail(); // Not supposed to get here
		}
	}
	
	public void testInvalidNameException() {
		try {
			new Exercise("B3nchpr3ss", 110, Arrays.asList(15, 12, 10));
			fail(); // Not supposed to get here
		}
		catch (IllegalArgumentException iae) {
			// Supposed to get here
		}
		catch (Exception e) {
			fail(); // Not supposed to get here
		}
	}
	
	public void testNegativeWeightException() {
		try {
			new Exercise("Benchpress", -10, Arrays.asList(15, 12, 10));
			fail(); // Not supposed to get here
		}
		catch (IllegalArgumentException iae) {
			// Supposed to get here
		}
		catch (Exception e) {
			fail(); // Not supposed to get here
		}
	}
	
	public void testEmptyRepsPerSetException() {
		try {
			new Exercise("Benchpress", 110, Arrays.asList());
			fail(); // Not supposed to get here
		}
		catch (IllegalArgumentException iae) {
			// Supposed to get here
		}
		catch (Exception e) {
			fail(); // Not supposed to get here
		}
	}
	
	public void testNegativeRepsException() {
		try {
			new Exercise("Benchpress", 110, Arrays.asList(15, -12, 10));
			fail(); // Not supposed to get here
		}
		catch (IllegalArgumentException iae) {
			// Supposed to get here
		}
		catch (Exception e) {
			fail(); // Not supposed to get here
		}
	}
	
	public void testSetName() {
		exercise.setName("Deadlift");
		assertEquals("Deadlift", exercise.getName());
	}
	
	//public void setRepsPerSet()
	
	
}
