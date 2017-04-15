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
		
		
		//equals
		assertTrue(AsaJen.equals(AsaJen));
		assertFalse(AsaJen.equals(AsaMike));
		assertFalse(AsaJen.equals(AsaNathan));
		
		assertTrue(AsaNathan.equals(AsaNathan));
		assertFalse(AsaNathan.equals(AsaMike));
		assertFalse(AsaNathan.equals(AsaJen));
		
	}

	
	
	@Test
	public void testStudentPairStudentPair() 
	{
		StudentPair CopyAsaJen = new StudentPair(AsaJen);
		
		assertNotSame(CopyAsaJen , AsaJen);
		
		assertEquals(CopyAsaJen.toString() , AsaJen.toString());
		assertEquals(CopyAsaJen.getFirstStudentName(), AsaJen.getFirstStudentName());
		

		assertEquals("Asa", AsaJen.getFirstStudentName());
		assertEquals("Jen", AsaJen.getSecondStudentName());
		assertEquals("Asa", CopyAsaJen.getFirstStudentName());
		assertEquals("Jen", CopyAsaJen.getSecondStudentName());
		
		
		assertEquals("Asa", AsaJen.getFirstStudentName());
		assertEquals("Jen", AsaJen.getSecondStudentName());
		assertEquals("Asa", CopyAsaJen.getFirstStudentName());
		assertEquals("Jen", CopyAsaJen.getSecondStudentName());
		
		
		assertEquals( "0.0" , String.format("%.1f",CopyAsaJen.getRawScore()));
		assertEquals( "0.0" , String.format("%.1f",CopyAsaJen.getZScore()));
		
		assertFalse(CopyAsaJen.isRawScoreCalculated());
		assertFalse(CopyAsaJen.isZScoreCalculated());
		
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
		StudentPair tempPair = new StudentPair(AsaJen);
		assertFalse(tempPair.isRawScoreCalculated());
	}

	@Test
	public void testIsZScoreCalculated() 
	{
		StudentPair tempPair = new StudentPair(AsaJen);
		assertFalse(tempPair.isZScoreCalculated());
		
		
	}

	@Test
	public void testCalculateRawScore() 
	{
		Instructor instructor = new Instructor("output");
		instructor.acceptStudentSubmissions(submissionDirectory);
		instructor.parseSubmissions();
		instructor.analyze();
		StudentPair AsaJen = new StudentPair (instructor.getStudent("Asa"),instructor.getStudent("Jen"));
		
		double combinedLength = 21 + 269;
		double numerator = 4 * 2;
		double denominator = Math.pow( combinedLength, 2.0);
		double rawScore = numerator / denominator;
		
		assertEquals(String.format("%.1f", rawScore) , String.format("%.1f", AsaJen.getRawScore()));
		
	}

	@Test
	public void testCalculateZScore() 
	{
		
		Instructor instructor = new Instructor("output");
		instructor.acceptStudentSubmissions(submissionDirectory);
		instructor.parseSubmissions();
		instructor.analyze();
		StudentPair AsaJen = new StudentPair (instructor.getStudent("Asa"),instructor.getStudent("Jen"));
		
		
		assertEquals( "0.0" , String.format("%.1f", AsaJen.getZScore()));
	}

	@Test
	public void testToString() 
	{
		
		//meet this format
		//"( " + student1.toString() + " , " + student2.toString() + " )"
		assertEquals( "( Asa , Jen )" , AsaJen.toString());
				
			
		assertEquals( "( Asa , Nathan )" , AsaNathan.toString() );
				
				
		assertEquals( "( Asa , Mike )" , AsaMike.toString() );
					
				
	}

	@Test
	public void testEqualsObject() 
	{
		
		assertTrue(AsaJen.equals(AsaJen));
		assertFalse(AsaJen.equals(AsaMike));
		assertFalse(AsaJen.equals(AsaNathan));
		
		assertTrue(AsaNathan.equals(AsaNathan));
		assertFalse(AsaNathan.equals(AsaMike));
		assertFalse(AsaNathan.equals(AsaJen));
		
		StudentPair copyAsaJen = new StudentPair(AsaJen);
		
		assertTrue(AsaJen.equals(AsaJen) && copyAsaJen.equals(AsaJen));
		assertFalse(AsaJen.equals(AsaMike) || AsaMike.equals(AsaJen));
	}

	@Test
	public void testCompareTo() 
	{
		
		assertTrue(AsaJen.compareTo(AsaJen) == 0);
		assertTrue(AsaJen.compareTo(AsaMike) < 0);
		assertTrue(AsaMike.compareTo(AsaJen) > 0);
		
		assertFalse(AsaJen.compareTo(AsaMike) == 0);
		assertFalse(AsaMike.compareTo(AsaJen) < 0);
		assertFalse(AsaJen.compareTo(AsaJen) > 0);
	}
	

	@Test
	public void testHashCode() 
	{
		assertFalse( AsaJen.equals(AsaMike) || AsaMike.equals(AsaJen) );
	    assertFalse( AsaJen.hashCode() == AsaMike.hashCode() );
	    
	    StudentPair clonedJen = new StudentPair( AsaJen );
	    assertTrue( clonedJen.equals(AsaJen) && AsaJen.equals(clonedJen) );
	    assertTrue( clonedJen.hashCode() == AsaJen.hashCode() );
	}

	@Test
	public void testClone() {
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
	}

}
