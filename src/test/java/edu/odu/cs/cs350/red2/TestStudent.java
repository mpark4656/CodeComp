package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;
import java.io.File;
import edu.odu.cs.cs350.red2.Interface.*;
import org.junit.Test;

public class TestStudent {

	private Instructor instructor;
	private File submissionDirectory;
	private Student Asa;
	private Student Jen;
	private Student Mike;
	private Student Nathan;
	
	public TestStudent()
	{
		instructor = new Instructor( "output" );
		
		// On linux, the path should have forward slashes (/). On Windows, the path should have
		// backslashes (\\).
		submissionDirectory = new File( "./src/test/data/testSubmissionDirectory" );
		instructor.acceptStudentSubmissions(submissionDirectory);
		
		Asa = instructor.getStudent( "Asa" );
		Jen = instructor.getStudent( "Jen" );
		Mike = instructor.getStudent( "Mike" );
		Nathan = instructor.getStudent( "Nathan" );
	}


	@Test
	public void testStudent() {

		// Unit Tests for Asa
		assertEquals( "Asa" , Asa.toString() );
		assertTrue( Asa.equals(Asa) );
		assertFalse( Asa.equals(Jen) );
		assertFalse( Asa.equals(Nathan) );
		assertFalse( Asa.equals(Mike) );
		assertEquals( 1 , Asa.getSubmissionCount() );
		assertEquals( "Asa.1" , Asa.getPrioritySubmission().toString() );
		assertEquals( 1 , Asa.getTotalCodeFileCount() );
		assertEquals( 13 , Asa.getTotalCodeLineCount() );
		
		// Unit Tests for Jen
		assertEquals( "Jen" , Jen.toString() );
		assertTrue( Jen.equals(Jen) );
		assertFalse( Jen.equals(Asa) );
		assertFalse( Jen.equals(Nathan) );
		assertFalse( Jen.equals(Mike) );
		assertEquals( 2 , Jen.getSubmissionCount() );
		assertEquals( "Jen" , Jen.getPrioritySubmission().toString() );
		assertEquals( 1 , Jen.getTotalCodeFileCount() );
		assertEquals( 4 , Jen.getTotalCodeLineCount() );
		
		// Unit Tests for Mike
		assertEquals( "Mike" , Mike.toString() );
		assertTrue( Mike.equals(Mike) );
		assertFalse( Mike.equals(Asa) );
		assertFalse( Mike.equals(Jen) );
		assertFalse( Mike.equals(Nathan) );
		assertEquals( 3 , Mike.getSubmissionCount() );
		assertEquals( "Mike" , Mike.getPrioritySubmission().toString() );
		assertEquals( 1 , Mike.getTotalCodeFileCount() );
		assertEquals( 2 , Mike.getTotalCodeLineCount() );
		
		// Unit Tests for Nathan
		assertEquals( "Nathan" , Nathan.toString() );
		assertTrue( Nathan.equals(Nathan) );
		assertFalse( Nathan.equals(Asa) );
		assertFalse( Nathan.equals(Jen) );
		assertFalse( Nathan.equals(Mike) );
		assertEquals( 2 , Nathan.getSubmissionCount() );
		assertEquals( "Nathan.2" , Nathan.getPrioritySubmission().toString() );
		assertEquals( 5 , Nathan.getTotalCodeFileCount() );
		assertEquals( 43 , Nathan.getTotalCodeLineCount() );
	}
	
	@Test
	public void testGetSubmission() {
		
		assertEquals( null , Asa.getSubmission("ThisDoesNotExist") );
		assertEquals( null , Jen.getSubmission("ThisDoesNotExist") );
		assertEquals( null , Mike.getSubmission("ThisDoesNotExist") );
		assertEquals( null , Nathan.getSubmission("ThisDoesNotExist") );
		
		assertEquals( Asa.getPrioritySubmission() , Asa.getSubmission("Asa.1") );
		assertEquals( Jen.getPrioritySubmission() , Jen.getSubmission("Jen") );
		assertEquals( Mike.getPrioritySubmission() , Mike.getSubmission("Mike") );
		assertEquals( Nathan.getPrioritySubmission() , Nathan.getSubmission("Nathan.2") );
		
	} // End of testGetSubmission
	
	@Test
	public void testGetPrioritySubmission() {
		
		// Asa's priority submission is "Asa.1"
		assertEquals( "Asa.1" , Asa.getPrioritySubmission().toString() );
		
		// Jen's priority submission is "Jen"
		assertEquals( "Jen" , Jen.getPrioritySubmission().toString() );
		
		// Mike's priority submission is "Mike"
		assertEquals( "Mike" , Mike.getPrioritySubmission().toString() );
		
		// Nathan's priority submission is "Nathan.2"
		assertEquals( "Nathan.2" , Nathan.getPrioritySubmission().toString() );
		
	} // End of testGetPrioritySubmission()

	@Test
	public void testGetTotalCodeFileCount() {
		
		// Asa'a priority submission has 1 code file
		assertEquals( 1 , Asa.getTotalCodeFileCount() );
		
		// Jen's priority submission has 1 code file.
		assertEquals( 1 , Jen.getTotalCodeFileCount() );
		
		// Mike's priority submission has 1 code file.
		assertEquals( 1 , Mike.getTotalCodeFileCount() );
		
		// Nathan's priority submission has 3 code files.
		assertEquals( 5 , Nathan.getTotalCodeFileCount() );
		
	} // End of testGetTotalCodeFileCount()

	@Test
	public void testGetTotalCodeLineCount() {
		
		assertEquals( 13 , Asa.getTotalCodeLineCount() );
		assertEquals( 4 , Jen.getTotalCodeLineCount());
		assertEquals( 2 , Mike.getTotalCodeLineCount());
		assertEquals( 43 , Nathan.getTotalCodeLineCount());
		
	} // End of testGetTotalCodeLineCount()


	@Test
	public void testEqualsObject() {
		
		// Unit Tests for Asa
		assertTrue( Asa.equals(Asa) );
		assertFalse( Asa.equals(Jen) );
		assertFalse( Asa.equals(Nathan) );
		assertFalse( Asa.equals(Mike) );
		
		// Unit Tests for Jen
		assertTrue( Jen.equals(Jen) );
		assertFalse( Jen.equals(Asa) );
		assertFalse( Jen.equals(Nathan) );
		assertFalse( Jen.equals(Mike) );
		
		// Unit Tests for Mike
		assertTrue( Mike.equals(Mike) );
		assertFalse( Mike.equals(Asa) );
		assertFalse( Mike.equals(Jen) );
		assertFalse( Mike.equals(Nathan) );
		
		// Unit Tests for Nathan
		assertTrue( Nathan.equals(Nathan) );
		assertFalse( Nathan.equals(Asa) );
		assertFalse( Nathan.equals(Jen) );
		assertFalse( Nathan.equals(Mike) );
		
	} // End of TestEqualsObject()
	

	@Test
	public void testCompareTo() {
		
		// Unit tests for Asa
		assertTrue( Asa.compareTo(Asa) == 0 );
		assertTrue( Asa.compareTo(Jen) < 0 );
		assertTrue( Asa.compareTo(Mike) < 0 );
		assertTrue( Asa.compareTo(Nathan) < 0 );
		
		// Unit tests for Jen
		assertTrue( Jen.compareTo(Asa) > 0 );
		assertTrue( Jen.compareTo(Jen) == 0 );
		assertTrue( Jen.compareTo(Mike) < 0 );
		assertTrue( Jen.compareTo(Nathan) < 0 );
		
		// Unit tests for Mike
		assertTrue( Mike.compareTo(Asa) > 0 );
		assertTrue( Mike.compareTo(Jen) > 0 );
		assertTrue( Mike.compareTo(Mike) == 0 );
		assertTrue( Mike.compareTo(Nathan) < 0 );
		
		// Unit tests for Nathan
		assertTrue( Nathan.compareTo(Asa) > 0 );
		assertTrue( Nathan.compareTo(Jen) > 0 );
		assertTrue( Nathan.compareTo(Mike) > 0 );
		assertTrue( Nathan.compareTo(Nathan) == 0 );
		
	} // End of testCompareTo()
	

	@Test
	public void testToString() {
		
		// Asa
		assertEquals( "Asa" , Asa.toString() );
		
		// Jen
		assertEquals( "Jen" , Jen.toString() );
		
		// Mike
		assertEquals( "Mike" , Mike.toString() );
		
		// Nathan
		assertEquals( "Nathan" , Nathan.toString() );
		
	} // End of TestToString()

} // End of TestStudent class




