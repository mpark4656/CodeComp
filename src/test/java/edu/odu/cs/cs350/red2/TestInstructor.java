package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.odu.cs.cs350.red2.Interface.*;
import java.io.File;

public class TestInstructor {

	@Test
	public void testInstructor() {
		
		/***************************************************************/
		/*
		 * Ensure that newly instantiated object has correct flags set
		 */
		Instructor instructor = new Instructor( "output" );
		
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
		
	} // End of testInstructor()

	@Test
	public void testIsTemplateSpecified() {
		
		/***************************************************************/
		/*
		 * Ensure the class state is correct after template has been set
		 */
		Instructor instructor = new Instructor( "output" );
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
		/***************************************************************/
		
	} // End of testIsTemplateSpecified()

	@Test
	public void testIsSheetNameSpecified() {
		
		/***************************************************************/
		/*
		 * Ensure the class state is correct after sheetname has been set
		 */
		Instructor instructor = new Instructor( "output" );
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
		/***************************************************************/
		
	} // End of testIsSheetNameSpecified()

	@Test
	public void testGetTemplate() {
		
		/***************************************************************/
		/*
		 * Ensure that the returned template name is correct.
		 */
		Instructor instructor = new Instructor( "output" );
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
		/***************************************************************/
		
	} // End of testGetTemplate()

	@Test
	public void testGetSheetName() {
		
		/***************************************************************/
		/*
		 * Ensure that the returned sheet name is correct.
		 */
		Instructor instructor = new Instructor( "output" );
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
		/***************************************************************/
		
	} // End of testGetSheetName()

	@Test
	public void testSetTemplate() {
		
		/***************************************************************/
		/*
		 * Ensure the class state is correct after template has been set
		 */
		Instructor instructor = new Instructor( "output" );
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
		/***************************************************************/
		
	} // End of testSetTemplate()

	@Test
	public void testSetSheetName() {
		
		/***************************************************************/
		/*
		 * Ensure the class state is correct after sheetname has been set
		 */
		Instructor instructor = new Instructor( "output" );
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
		/***************************************************************/
		
	} // End of testSetSheetName()

	@Test
	public void testIsSubmissionReceived() {
		
		/***************************************************************/
		/*
		 * Check the state before submission is accepted
		 */
		Instructor instructor = new Instructor( "output" );
		
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
		File submissionDirectory = new File( ".\\src\\test\\data\\testSubmissionDirectory" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 3 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		/***************************************************************/
		
	} // End of testIsSubmissionReceived()

	@Test
	public void testIsSubmissionParsed() {
		fail("Not yet implemented");

		
	} // End of testIsSubmissionParsed()

	@Test
	public void testIsTokenSequenceAnalyzed() {
		fail("Not yet implemented");

		
	} // End of testIsTokenSequenceAnalyzed()

	@Test
	public void testGetStudent() {
		
		/***************************************************************/
		/*
		 * Accept Student Submission and verify that the obj is in the 
		 * correct state.
		 */
		Instructor instructor = new Instructor( "output" );
		File submissionDirectory = new File( ".\\src\\test\\data\\testSubmissionDirectory" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		Student Mike = instructor.getStudent( "Mike" );
		Student Nathan = instructor.getStudent( "Nathan" );
		Student testSubmission = instructor.getStudent( "testSubmission" );
		
		assertEquals( "Mike" , Mike.toString() );
		assertEquals( "Nathan" , Nathan.toString() );
		assertEquals( "testSubmission" , testSubmission.toString() );
		
		assertTrue( Mike.compareTo(Nathan) < 0 );
		assertTrue( Nathan.compareTo(Mike) > 0 );
		assertTrue( testSubmission.compareTo(Mike) > 0 );
		assertTrue( Mike.compareTo(testSubmission) < 0 );
		assertTrue( testSubmission.compareTo(Nathan) > 0 );
		assertTrue( Nathan.compareTo(testSubmission) < 0 );
		/***************************************************************/
		
	} // End of testGetStudent()

	@Test
	public void testGetTotalStudentCount() {

		/***************************************************************/
		/*
		 * Check the state before submission is accepted
		 */
		Instructor instructor = new Instructor( "output" );
		
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
		File submissionDirectory = new File( ".\\src\\test\\data\\testSubmissionDirectory" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 3 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		/***************************************************************/
		
	} // End of testGetTotalStudentCount()
	
	@Test
	public void testGetTotalStudentPairCount() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAcceptStudentSubmissions() {

		/***************************************************************/
		/*
		 * Check the state before submission is accepted
		 */
		Instructor instructor = new Instructor( "output" );
		
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
		File submissionDirectory = new File( ".\\src\\test\\data\\testSubmissionDirectory" );
		instructor.acceptStudentSubmissions( submissionDirectory );
		
		assertFalse( instructor.isTemplateSpecified() );
		assertFalse( instructor.isSheetNameSpecified() );
		assertEquals( "" , instructor.getTemplate() );
		assertEquals( "" , instructor.getSheetName() );
		assertTrue( instructor.isSubmissionReceived() );
		assertFalse( instructor.isSubmissionParsed() );
		assertFalse( instructor.isTokenSequenceAnalyzed() );
		assertEquals( 3 , instructor.getTotalStudentCount() );
		assertEquals( 0 , instructor.getTotalStudentPairCount() );
		/***************************************************************/
		
	} // End of testAcceptStudentSubmission()

	@Test
	public void testOutputFeedback() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testProcess() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAnalyze() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDisplayResult() {
		fail("Not yet implemented");
	}

} // End of TestInstructor
