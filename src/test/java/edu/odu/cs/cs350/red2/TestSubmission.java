package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import edu.odu.cs.cs350.red2.Interface.*;
import java.util.ArrayList;

public class TestSubmission {

	private Instructor instructor;
	private File submissionDirectory;
	
	private Submission AsaSub;
	private Submission JenSub;
	private Submission MikeSub;
	private Submission NathanSub;
	
	public TestSubmission()
	{
		instructor = new Instructor( "output" );
		
		// On linux, the path should have forward slashes (/). On Windows, the path should have
		// backslashes (\\).
		submissionDirectory = new File( "./src/test/data/testSubmissionDirectory" );
		instructor.acceptStudentSubmissions(submissionDirectory);
		
		// Initialize Submissions
		AsaSub = instructor.getStudent("Asa").getPrioritySubmission();
		JenSub = instructor.getStudent("Jen").getPrioritySubmission();
		MikeSub = instructor.getStudent("Mike").getPrioritySubmission();
		NathanSub = instructor.getStudent("Nathan").getPrioritySubmission();
	}
	

	@Test
	public void testSubmission() {
		
		// Asa's unit tests
		assertFalse( AsaSub.isTokenized() );
		assertEquals( 1 , AsaSub.getNumCodeFiles() );
		assertEquals( 3 , AsaSub.getNumCodeLines() );
		assertEquals( "Asa.1" , AsaSub.toString() );
		
		// Jen's unit tests
		assertFalse ( JenSub.isTokenized() );
		assertEquals( 1 , JenSub.getNumCodeFiles() );
		assertEquals( 4 , JenSub.getNumCodeLines() );
		assertEquals( "Jen" , JenSub.toString() );
		
		// Mike's unit tests
		assertFalse ( MikeSub.isTokenized() );
		assertEquals( 1 , MikeSub.getNumCodeFiles() );
		assertEquals( 2 , MikeSub.getNumCodeLines() );
		assertEquals( "Mike" , MikeSub.toString() );
		
		// Nathan's unit tests
		assertFalse ( NathanSub.isTokenized() );
		assertEquals( 3 , NathanSub.getNumCodeFiles() );
		assertEquals( 8 , NathanSub.getNumCodeLines() );
		assertEquals( "Nathan.2" , NathanSub.toString() );
		
	} // End of testSubmission()


	@Test
	public void testTokenize() {
		//fail("Not yet implemented");
	}


	@Test
	public void testIsTokenized() {
		
		assertFalse( AsaSub.isTokenized() );
		assertFalse ( JenSub.isTokenized() );
		assertFalse ( MikeSub.isTokenized() );
		assertFalse ( NathanSub.isTokenized() );
		
	} // End of testIsTokenized()


	@Test
	public void testGetTokenSequenceLength() {
		//fail("Not yet implemented");
	}


	@Test
	public void testGetNumCodeLines() {
		
		assertEquals( 3 , AsaSub.getNumCodeLines() );
		assertEquals( 4 , JenSub.getNumCodeLines() );
		assertEquals( 2 , MikeSub.getNumCodeLines() );
		assertEquals( 8 , NathanSub.getNumCodeLines() );
		
	} // End of testGetNumCodeLines()


	@Test
	public void testGetNumCodeFiles() {
		
		assertEquals( 1 , AsaSub.getNumCodeFiles() );
		assertEquals( 1 , JenSub.getNumCodeFiles() );
		assertEquals( 1 , MikeSub.getNumCodeFiles() );
		assertEquals( 3 , NathanSub.getNumCodeFiles() );
		
	} // End of testGetNumCodeFiles()

	@Test
	public void testSearchAllFiles() {
		
		// Get a list of all files in Nathan.2 submission
		// Only nathan has subdirectory structure complex enough for testing
		ArrayList<File> allFiles = NathanSub.getAllFiles();
		
		// These are files that should be present
		File file1 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/code4.cpp" );
		File file2 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/codeFile.c" );
		File file3 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/codeFile1.java" );
		File file4 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/subDir/codeFile3.cpp" );
		
		assertTrue( allFiles.contains(file1) );
		assertTrue( allFiles.contains(file2) );
		assertTrue( allFiles.contains(file3) );
		assertTrue( allFiles.contains(file4) );
		assertEquals( 4 , allFiles.size() );
		
	} // End of testSearchAllFiles()
	
	@Test
	public void testSearchAllCodeFiles() {
		
		// Get a list of all code files in Nathan.2 submission
		ArrayList<File> codeFiles = NathanSub.getCodeFiles();
		
		// These are files that should be present
		// Note that codeFile.c is c code file and it is not yet supported, so it should not be in here
		File file1 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/code4.cpp" );
		File file2 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/codeFile.c" );
		File file3 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/codeFile1.java" );
		File file4 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/subDir/codeFile3.cpp" );
		
		assertTrue( codeFiles.contains(file1) );
		assertFalse( codeFiles.contains(file2) );
		assertTrue( codeFiles.contains(file3) );
		assertTrue( codeFiles.contains(file4) );
		assertEquals( 3 , codeFiles.size() );
		
	} // End of testSearchAllCodeFiles()
	
	@Test
	public void testCompareTo() {
		// Will mainly compare Mike, Mike.1, Mike.2
		//
		// Mike.2 should be the highest - Mike.2 > Mike.1 && Mike.2 > Mike
		// Mike.1 should be the next highest - Mike.2 > Mike
		// Mike is the lowest
		
		// Obtain 3 submissions that belong to Mike
		Submission Mike = instructor.getStudent("Mike").getSubmission("Mike");
		Submission Mike1 = instructor.getStudent("Mike").getSubmission("Mike.1");
		Submission Mike2 = instructor.getStudent("Mike").getSubmission("Mike.2");
		
		assertTrue( Mike.compareTo(Mike) == 0 );
		assertTrue( Mike.compareTo(Mike1) < 0 );
		assertTrue( Mike.compareTo(Mike2) < 0 );
		
		assertTrue( Mike1.compareTo(Mike) > 0 );
		assertTrue( Mike1.compareTo(Mike1) == 0 );
		assertTrue( Mike1.compareTo(Mike2) < 0 );
		
		assertTrue( Mike2.compareTo(Mike) > 0 );
		assertTrue( Mike2.compareTo(Mike1) > 0 );
		assertTrue( Mike2.compareTo(Mike2) == 0 );
		
	} // End of testCompareTo()

	
	@Test
	public void testToString() {
		
		assertEquals( "Asa.1" , AsaSub.toString() );
		assertEquals( "Jen" , JenSub.toString() );
		assertEquals( "Mike" , MikeSub.toString() );
		assertEquals( "Nathan.2" , NathanSub.toString() );
		
	} // End of testCompareTo()

}
