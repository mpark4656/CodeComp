package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.odu.cs.cs350.red2.Interface.*;
import java.io.File;

public class TestInstructor {

	private Instructor instructor;
	private File submissionDirectory;
	
	public TestInstructor()
	{
		instructor = new Instructor( "output" );
		
		// On linux, the path should have forward slashes (/). On Windows, the path should have
		// backslashes (\\). 
		submissionDirectory = new File( "./src/test/data/testSubmissionDirectory" );
	}
	
	@Test
	public void testInstructor() {
		
		/***************************************************************/
		/*
		 * Ensure that newly instantiated object has correct flags set
		 */
		instructor = new Instructor( "output" );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
	} // End of testInstructor()

	@Test
	public void testInstructorInstructor()
	{
		Instructor copyInstructor = new Instructor( instructor );
		
		assertEquals( instructor , copyInstructor );
		assertNotSame( instructor , copyInstructor );
	}
	
	@Test
	public void testIsTemplateSpecified() {
		
		/***************************************************************/
		/*
		 * Ensure the class state is correct after template has been set
		 */
		instructor.setTemplate( "templateName" );
		
		assertTrue( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "templateName" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
	} // End of testIsTemplateSpecified()

	@Test
	public void testIsSheetNameSpecified() {
		
		/***************************************************************/
		/*
		 * Ensure the class state is correct after sheetname has been set
		 */
		instructor = new Instructor( "output" );
		instructor.setSheetName( "sheetName" );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertTrue( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "sheetName" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
	} // End of testIsSheetNameSpecified()

	@Test
	public void testGetTemplate() {
		
		/***************************************************************/
		/*
		 * Ensure that the returned template name is correct.
		 */
		instructor = new Instructor( "output" );
		instructor.setTemplate( "templateName" );
		
		assertTrue( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "templateName" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
	} // End of testGetTemplate()

	@Test
	public void testGetSheetName() {
		
		/***************************************************************/
		/*
		 * Ensure that the returned sheet name is correct.
		 */
		instructor = new Instructor( "output" );
		instructor.setSheetName( "sheetName" );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertTrue( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "sheetName" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
	} // End of testGetSheetName()

	@Test
	public void testSetTemplate() {
		
		/***************************************************************/
		/*
		 * Ensure the class state is correct after template has been set
		 */
		instructor = new Instructor( "output" );
		instructor.setTemplate( "templateName" );
		
		assertTrue( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "templateName" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
	} // End of testSetTemplate()

	@Test
	public void testSetSheetName() {
		
		/***************************************************************/
		/*
		 * Ensure the class state is correct after sheetname has been set
		 */
		instructor = new Instructor( "output" );
		instructor.setSheetName( "sheetName" );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertTrue( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "sheetName" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
	} // End of testSetSheetName()

	@Test
	public void testIsSubmissionReceived() {
		
		/***************************************************************/
		/*
		 * Check the state before submission is accepted
		 */
		instructor = new Instructor( "output" );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
		
		/***************************************************************/
		/*
		 * Accept Student Submission and verify that the obj is in the 
		 * correct state.
		 */
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 4 , instructor.getTotalStudentCount() );
		assertEquals( 6 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
	} // End of testIsSubmissionReceived()

	@Test
	public void testIsSubmissionParsed() {
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		instructor.parseSubmissions();
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertTrue( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 4 , instructor.getTotalStudentCount() );
		assertEquals( 6 , instructor.getTotalStudentPairCount() );
		
	} // End of testIsSubmissionParsed()

	@Test
	public void testIsTokenSequenceAnalyzed() {
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		instructor.parseSubmissions();
		
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		
		instructor.analyze();
		
		assertTrue( instructor.isTokenSequenceAnalyzed() );

	} // End of testIsTokenSequenceAnalyzed()

	
	@Test
	public void testGetStudent() {
		
		/***************************************************************/
		/*
		 * Accept Student Submission and verify that the obj is in the 
		 * correct state.
		 */
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		Student Mike = instructor.getStudent( "Mike" );
		Student Nathan = instructor.getStudent( "Nathan" );
		Student Jen = instructor.getStudent( "Jen" );
		
		assertEquals( "Mike" , Mike.toString() );
		assertEquals( "Nathan" , Nathan.toString() );
		assertEquals( "Jen" , Jen.toString() );

		assertTrue( Jen.compareTo(Jen) == 0 );
		assertTrue( Jen.compareTo(Mike) < 0 );
		assertTrue( Jen.compareTo(Nathan) < 0 );
		assertTrue( Mike.compareTo(Nathan) < 0 );
		assertTrue( Nathan.compareTo(Mike) > 0 );
		/***************************************************************/
		
	} // End of testGetStudent()

	@Test
	public void testGetStudentPair()
	{
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		assertTrue( instructor.getStudentPair("Asa", "Mike") != null &&
				instructor.getStudentPair("Mike", "Asa") != null &&
				instructor.getStudentPair("Asa", "Mike").equals(instructor.getStudentPair("Mike", "Asa")));
		
		assertTrue( instructor.getStudentPair("Asa", "Jen") != null &&
				instructor.getStudentPair("Jen", "Asa") != null &&
				instructor.getStudentPair("Asa", "Jen").equals(instructor.getStudentPair("Jen", "Asa")));
		
		assertTrue( instructor.getStudentPair("Asa", "Abdul") == null );
	}
	
	@Test
	public void testGetTotalStudentCount() {

		/***************************************************************/
		/*
		 * Check the state before submission is accepted
		 */
		instructor = new Instructor( "output" );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		/***************************************************************/
		
		
		/***************************************************************/
		/*
		 * Accept Student Submission and verify that the obj is in the 
		 * correct state.
		 */
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 4 , instructor.getTotalStudentCount() );
		assertEquals( 6 , instructor.getTotalStudentPairCount() );
		/***************************************************************/
		
	} // End of testGetTotalStudentCount()
	
	@Test
	public void testGetTotalStudentPairCount() {

		/***************************************************************/
		/*
		 * Accept Student Submission and verify that the obj is in the 
		 * correct state.
		 */
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 4 , instructor.getTotalStudentCount() );
		assertEquals( 6 , instructor.getTotalStudentPairCount() );
		/***************************************************************/
		
	} // End of testGetTotalStudentPairCount()
	
	@Test
	public void testAcceptStudentSubmissions() {

		/***************************************************************/
		/*
		 * Check the state before submission is accepted
		 */
		instructor = new Instructor( "output" );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertFalse( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 0 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
		
		/***************************************************************/
		/*
		 * Accept Student Submission and verify that the obj is in the 
		 * correct state.
		 */
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 4 , instructor.getTotalStudentCount() );
		assertEquals( 6 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
		/***************************************************************/
		
	} // End of testAcceptStudentSubmission()
	
	@Test
	public void testParseSubmissions() {
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		instructor.parseSubmissions();
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertTrue( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 4 , instructor.getTotalStudentCount() );
		assertEquals( 6 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
	}

	@Test
	public void testAnalyze() {
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		instructor.parseSubmissions();
		instructor.analyze();
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertTrue( instructor.isSubmissionParsed() );
		assertTrue( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 4 , instructor.getTotalStudentCount() );
		assertEquals( 6 , instructor.getTotalStudentPairCount() );
		assertEquals( "output" , instructor.toString() );
	}

	@Test
	public void testDisplayResult() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testWriteToFile() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testClone()
	{
		Instructor copyInstructor = ( Instructor ) instructor.clone();
		
		assertEquals( instructor , copyInstructor );
		assertNotSame( instructor , copyInstructor );
	}
	
	@Test
	public void testEquals()
	{
		instructor = new Instructor( "output" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		Instructor copyInstructor = ( Instructor ) instructor.clone();
		
		assertTrue( instructor.equals(copyInstructor) ); 
		
		instructor.parseSubmissions();
		
		assertFalse( instructor.equals(copyInstructor) ); 
	}
	
	@Test
	public void testToString() {
		instructor = new Instructor( "output" );
		assertEquals( "output" , instructor.toString() );
		
		instructor = new Instructor( "testOutput" );
		assertEquals( "testOutput" , instructor.toString() );
	}
	
} // End of TestInstructor
