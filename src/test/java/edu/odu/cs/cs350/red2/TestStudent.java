package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;
import java.io.File;
import edu.odu.cs.cs350.red2.Interface.*;
import org.junit.Test;

public class TestStudent {

	private Instructor instructor;
	private File submissionDirectory;
	
	public TestStudent()
	{
		instructor = new Instructor( "output" );
		submissionDirectory = new File( ".\\src\\test\\data\\testSubmissionDirectory" );
		instructor.acceptStudentSubmissions(submissionDirectory);
	}
	
	@Test
	public void testStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSubmission() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrioritySubmission() {
		
		// Create Student objects
		Student Jen = instructor.getStudent( "Jen" );
		Student Mike = instructor.getStudent( "Mike" );
		Student Nathan = instructor.getStudent( "Nathan" );
		
		// Jen's priority submission is the "Jen" directory
		assertEquals( "Jen" , Jen.getPrioritySubmission().toString() );
		
		// Mike's priority submission is the "Mike" directory
		assertEquals( "Mike" , Mike.getPrioritySubmission().toString() );
		
		// Nathan's priority submission is the "Nathan.2" directory
		assertEquals( "Nathan.2" , Nathan.getPrioritySubmission().toString() );
		
	}

	@Test
	public void testGetTotalCodeFileCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalCodeLineCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
