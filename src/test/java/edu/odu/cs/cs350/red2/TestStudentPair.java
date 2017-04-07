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
	private StudentPair AsaJen;
	private StudentPair AsaMike;
	private StudentPair AsaNathan;
	
	
	public TestStudentPair()
	{
		instructor = new Instructor("output");
		submissionDirectory = new File( "./src/test/data/testSubmissionDirectory" );
		instructor.acceptStudentSubmissions(submissionDirectory);
		
		AsaJen = new StudentPair (instructor.getStudent("Asa"),instructor.getStudent("Jen"));
		AsaMike = new StudentPair (instructor.getStudent("Asa"),instructor.getStudent("Mike"));
		AsaNathan = new StudentPair (instructor.getStudent("Asa"),instructor.getStudent("Nathan"));
		
	}
	@Test
	public void testStudentPairStudentStudent() 
	{
		
		assertEquals( "0.0" , String.format("%.1f",AsaJen.getRawScore()));
		assertEquals( "0.0" , String.format("%.1f",AsaJen.getZScore()));
		
		assertFalse(AsaJen.isRawScoreCalculated());
		assertFalse(AsaJen.isZScoreCalculated());
		
		assertEquals("Asa", AsaJen.getFirstStudentName());
		assertEquals("Jen", AsaJen.getSecondStudentName());
		
		//"( " + student1.toString() + " , " + student2.toString() + " )"
		assertEquals("( Asa , Jen )", AsaJen.toString());
		assertEquals("( Asa , Mike )", AsaMike.toString());
		
	}

	
	
	@Test
	public void testStudentPairStudentPair() 
	{
		StudentPair ClonedAsaJen = new StudentPair(AsaJen);
		
		assertNotSame(ClonedAsaJen , AsaJen);
		
		assertEquals(ClonedAsaJen.toString() , AsaJen.toString());
		assertEquals(ClonedAsaJen.getFirstStudentName(), AsaJen.getFirstStudentName());
		

		assertEquals("Asa", AsaJen.getFirstStudentName());
		assertEquals("Jen", AsaJen.getSecondStudentName());
		assertEquals("Asa", ClonedAsaJen.getFirstStudentName());
		assertEquals("Jen", ClonedAsaJen.getSecondStudentName());
		
		
		assertEquals("Asa", AsaJen.getFirstStudentName());
		assertEquals("Jen", AsaJen.getSecondStudentName());
		assertEquals("Asa", ClonedAsaJen.getFirstStudentName());
		assertEquals("Jen", ClonedAsaJen.getSecondStudentName());
		
		
		assertEquals( "0.0" , String.format("%.1f",ClonedAsaJen.getRawScore()));
		assertEquals( "0.0" , String.format("%.1f",ClonedAsaJen.getZScore()));
		
		assertFalse(ClonedAsaJen.isRawScoreCalculated());
		assertFalse(ClonedAsaJen.isZScoreCalculated());
		
		//need to add hashcode
		//need to add equals
		//compareto?
	}

	@Test
	public void testGetRawScore() 
	{
		assertEquals("0.0" , String.format("%.1f",AsaJen.getRawScore()));
		assertEquals("0.0" , String.format("%.1f",AsaMike.getRawScore()));
		assertEquals("0.0" , String.format("%.1f",AsaNathan.getRawScore()));
	}

	@Test
	public void testGetZScore() 
	{
		assertEquals( "0.0" , String.format("%.1f",AsaJen.getZScore()));
		assertEquals( "0.0" , String.format("%.1f",AsaMike.getZScore()));
		assertEquals( "0.0" , String.format("%.1f",AsaNathan.getZScore()));
	}

	@Test
	public void testGetFirstStudentName() 
	{
		assertEquals("Asa", AsaJen.getFirstStudentName());
		assertEquals("Asa", AsaNathan.getFirstStudentName());
		assertEquals("Asa", AsaMike.getFirstStudentName());
		
	}

	@Test
	public void testGetSecondStudentName() 
	{
		assertEquals("Jen", AsaJen.getSecondStudentName());
		assertEquals("Nathan", AsaNathan.getSecondStudentName());
		assertEquals("Mike", AsaMike.getSecondStudentName());
	}

	@Test
	public void testIsRawScoreCalculated() 
	{
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
		assertEquals( "( Asa , Jen )" , AsaJen.toString());
				
			
		assertEquals( "( Asa , Nathan )" , AsaNathan.toString() );
				
				
		assertEquals( "( Asa , Mike )" , AsaMike.toString() );
				
				
				
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
