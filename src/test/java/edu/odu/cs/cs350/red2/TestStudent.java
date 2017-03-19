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
		
		// On linux, the path should have forward slashes (/). On Windows, the path should have
		// backslashes (\\).
		submissionDirectory = new File( "./src/test/data/testSubmissionDirectory" );
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
		
	} // End of testGetPrioritySubmission()

	@Test
	public void testGetTotalCodeFileCount() {
		
		// Create Student objects
		Student Jen = instructor.getStudent( "Jen" );
		Student Mike = instructor.getStudent( "Mike" );
		Student Nathan = instructor.getStudent( "Nathan" );
		
		// Jen's priority submission has 1 code file.
		assertEquals( 1 , Jen.getTotalCodeFileCount() );
		
		// Mike's priority submission has 1 code file.
		assertEquals( 1 , Mike.getTotalCodeFileCount() );
		
		// Nathan's priority submission has 3 code files.
		assertEquals( 3 , Nathan.getTotalCodeFileCount() );
		
	} // End of testGetTotalCodeFileCount()

	@Test
	public void testGetTotalCodeLineCount() {
		
		// Create Student objects
		Student Jen = instructor.getStudent( "Jen" );
		Student Mike = instructor.getStudent( "Mike" );
		Student Nathan = instructor.getStudent( "Nathan" );
		
		assertEquals( 4 , Jen.getTotalCodeLineCount());
		assertEquals( 2 , Mike.getTotalCodeLineCount());
		assertEquals( 8 , Nathan.getTotalCodeLineCount());
		
	} // End of testGetTotalCodeLineCount()

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
