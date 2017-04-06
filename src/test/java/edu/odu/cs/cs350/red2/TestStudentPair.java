package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


import edu.odu.cs.cs350.red2.Interface.*;
import java.io.*;

import edu.odu.cs.cs350.red2.Interface.Instructor;
import edu.odu.cs.cs350.red2.Interface.Student;
import edu.odu.cs.cs350.red2.Interface.StudentPair;

public class TestStudentPair {

	private Instructor instructor;
	private File submissionDirectory;
	private Student Asa;
	private Student Jen;
	private Student Mike;
	private Student Nathan;
	
	
	
	public void testStudentPairStudentStudent() 
	{
		instructor = new Instructor("output");
		submissionDirectory = new File( "./src/test/data/testSubmissionDirectory" );
		instructor.acceptStudentSubmissions(submissionDirectory);
		
		Asa = instructor.getStudent( "Asa" );
		Jen = instructor.getStudent( "Jen" );
		Mike = instructor.getStudent( "Mike" );
		Nathan = instructor.getStudent( "Nathan" );
		
		

		StudentPair SP = new StudentPair(Asa, Nathan);
		
		assertEquals("Asa",Asa.toString());
		assertEquals("Jen",Jen.toString());
		assertEquals("Mike",Mike.toString());
		assertEquals("Nathan",Nathan.toString());
		assertFalse(SP.isRawScoreCalculated());
		assertFalse(SP.isZScoreCalculated());
	}

	@Test
	public void testStudentPairStudentPair() {
		// fail("Not yet implemented");
	}

	@Test
	public void testGetRawScore() 
	{
		// fail("Not yet implemented");
	}

	@Test
	public void testGetZScore() {
		// fail("Not yet implemented");
	}

	@Test
	public void testGetFirstStudentName() 
	{
		// fail("Not yet implemented");
	}

	@Test
	public void testGetSecondStudentName() {
		// fail("Not yet implemented");
	}

	@Test
	public void testIsRawScoreCalculated() {
		// fail("Not yet implemented");
	}

	@Test
	public void testIsZScoreCalculated() {
		// fail("Not yet implemented");
	}

	@Test
	public void testCalculateRawScore() {
		// fail("Not yet implemented");
	}

	@Test
	public void testCalculateZScore() {
		// fail("Not yet implemented");
	}

	@Test
	public void testToString() 
	{
		//preliminary 
		//meet this format
		//"( " + student1.toString() + " , " + student2.toString() + " )"
		// assertEquals( "( Asa , Jen )" , Asa.toString() );
				
			
		// assertEquals( "( Asa , Nathan )" , Jen.toString() );
				
				
		// assertEquals( "( Asa , Mike )" , Mike.toString() );
				
				
		// assertEquals( "( Nathan , Jen )" , Nathan.toString() );
		
				
	}

	@Test
	public void testEqualsObject() 
	{
		// fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		// fail("Not yet implemented");
	}
	

	@Test
	public void testHashCode() 
	{
		// fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		// fail("Not yet implemented");
	}

}
