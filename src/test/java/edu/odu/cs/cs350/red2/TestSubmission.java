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
		assertEquals( 13 , AsaSub.getNumCodeLines() );
		assertEquals( "Asa.1" , AsaSub.toString() );
		
		// Jen's unit tests
		assertFalse ( JenSub.isTokenized() );
		assertEquals( 2 , JenSub.getNumCodeFiles() );
		assertEquals( 56 , JenSub.getNumCodeLines() );
		assertEquals( "Jen" , JenSub.toString() );
		
		// Mike's unit tests
		assertFalse ( MikeSub.isTokenized() );
		assertEquals( 2 , MikeSub.getNumCodeFiles() );
		assertEquals( 171 , MikeSub.getNumCodeLines() );
		assertEquals( "Mike" , MikeSub.toString() );
		
		// Nathan's unit tests
		assertFalse ( NathanSub.isTokenized() );
		assertEquals( 5 , NathanSub.getNumCodeFiles() );
		assertEquals( 43 , NathanSub.getNumCodeLines() );
		assertEquals( "Nathan.2" , NathanSub.toString() );
		
	} // End of testSubmission()

	// Test the copy constructor
	@Test
	public void testSubmissionSubmission() {
		Submission clonedMike = new Submission( MikeSub );
		
		assertEquals( clonedMike , MikeSub );
		assertNotSame( clonedMike , MikeSub );
		
		assertEquals( clonedMike.isTokenized() , MikeSub.isTokenized() );
		assertEquals( clonedMike.getNumCodeFiles() , MikeSub.getNumCodeFiles() );
		assertEquals( clonedMike.getNumCodeLines() , MikeSub.getNumCodeLines() );
		assertEquals( clonedMike.getAllFiles() , MikeSub.getAllFiles() );
		assertEquals( clonedMike.getCodeFiles() , MikeSub.getCodeFiles() );
		assertEquals( clonedMike.getTokenCount() , MikeSub.getTokenCount() );
		//assertEquals( clonedMike.getTokenSequence() , MikeSub.getTokenSequence() );
		assertEquals( clonedMike.toString() , MikeSub.toString() );
		assertEquals( clonedMike.hashCode() , MikeSub.hashCode() );
	}

	@Test
	public void testSearchAllFiles() {
		
		// Get a list of all files in Nathan.2 submission
		// Only nathan has subdirectory structure complex enough for testing
		ArrayList<File> allFiles = NathanSub.getAllFiles();
		
		// These are files that should be present
		File file1 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/code4.cpp" );
		File file2 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/codeFile.c" );
		File file3 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/codeFile1.java" );
		File file4 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/nat15.java" );
		File file5 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/subDir/codeFile3.cpp" );
		File file6 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/subDir/nat20.java" );
		
		assertTrue( allFiles.contains(file1) );
		assertTrue( allFiles.contains(file2) );
		assertTrue( allFiles.contains(file3) );
		assertTrue( allFiles.contains(file4) );
		assertTrue( allFiles.contains(file5) );
		assertTrue( allFiles.contains(file6) );
		assertEquals( 6 , allFiles.size() );
		
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
		assertEquals( 5, codeFiles.size() );
		
	} // End of testSearchAllCodeFiles()
	
	@Test
	public void testGetAllFiles() {
		assertEquals( 1 , AsaSub.getAllFiles().size() );
		assertEquals( 2 , JenSub.getAllFiles().size() );
		assertEquals( 2 , MikeSub.getAllFiles().size() );
		assertEquals( 6 , NathanSub.getAllFiles().size() );
	}
	
	@Test
	public void testGetCodeFiles() {
		assertEquals( 1 , AsaSub.getCodeFiles().size() );
		assertEquals( 2 , JenSub.getCodeFiles().size() );
		assertEquals( 2 , MikeSub.getCodeFiles().size() );
		assertEquals( 5 , NathanSub.getCodeFiles().size() );
	}
	
	// getExtension() is a private method invoked by tokenize()
	@Test
	public void testGetExtension() {
		
		Submission clonedMike = new Submission( MikeSub );
		
		clonedMike.tokenize();
		assertTrue( clonedMike.isTokenized() ); 
		assertEquals( 611 , clonedMike.getTokenSequence().length() );
		assertEquals( 611 , clonedMike.getTokenCount() );
	}
	
	// Actual contents of token sequence will be tested in another unit test
	@Test
	public void testTokenize() {
		assertFalse( AsaSub.isTokenized() );
		assertFalse( JenSub.isTokenized() );
		assertFalse( MikeSub.isTokenized() );
		assertFalse( NathanSub.isTokenized() );
		
		Submission clonedAsa = new Submission( AsaSub );
		Submission clonedJen = new Submission( JenSub );
		Submission clonedMike = new Submission( MikeSub );
		Submission clonedNathan = new Submission( NathanSub );
		
		clonedAsa.tokenize();
		clonedJen.tokenize();
		clonedMike.tokenize();
		clonedNathan.tokenize();
		
		assertTrue( clonedAsa.isTokenized() );
		assertTrue( clonedJen.isTokenized() );
		assertTrue( clonedMike.isTokenized() );
		assertTrue( clonedNathan.isTokenized() );
	}

	@Test
	public void testIsTokenized() {
		
		assertFalse( AsaSub.isTokenized() );
		assertFalse( JenSub.isTokenized() );
		assertFalse( MikeSub.isTokenized() );
		assertFalse( NathanSub.isTokenized() );
		
		Submission clonedAsa = new Submission( AsaSub );
		Submission clonedJen = new Submission( JenSub );
		Submission clonedMike = new Submission( MikeSub );
		Submission clonedNathan = new Submission( NathanSub );
		
		clonedAsa.tokenize();
		clonedJen.tokenize();
		clonedMike.tokenize();
		clonedNathan.tokenize();
		
		assertTrue( clonedAsa.isTokenized() );
		assertTrue( clonedJen.isTokenized() );
		assertTrue( clonedMike.isTokenized() );
		assertTrue( clonedNathan.isTokenized() );
		
	} // End of testIsTokenized()


	@Test
	public void testGetTokenSequenceLength() {
		Submission clonedAsa = new Submission( AsaSub );
		clonedAsa.tokenize();
		
		Submission clonedJen = new Submission( JenSub );
		clonedJen.tokenize();
		
		Submission clonedMike = new Submission( MikeSub );
		clonedMike.tokenize();
		
		Submission clonedNathan = new Submission( NathanSub );
		clonedNathan.tokenize();
		
		assertEquals( 21 , clonedAsa.getTokenCount() );
		assertEquals( 269 , clonedJen.getTokenCount() );
		assertEquals( 611 , clonedMike.getTokenCount() );
		assertEquals( 144 , clonedNathan.getTokenCount() );
	}

	@Test
	public void testGetTokenSequences() {
		Submission clonedAsa = new Submission( AsaSub );
		clonedAsa.tokenize();
		
		Submission clonedJen = new Submission( JenSub );
		clonedJen.tokenize();
		
		Submission clonedMike = new Submission( MikeSub );
		clonedMike.tokenize();
		
		Submission clonedNathan = new Submission( NathanSub );
		clonedNathan.tokenize();
		
		assertEquals( 21 , clonedAsa.getTokenSequence().length() );
		assertEquals( 269 , clonedJen.getTokenSequence().length() );
		assertEquals( 611 , clonedMike.getTokenSequence().length() );
		assertEquals( 144 , clonedNathan.getTokenSequence().length() );
	}
	
	@Test
	public void testGetNumCodeLines() {
		assertEquals( 13 , AsaSub.getNumCodeLines() );
		assertEquals( 56 , JenSub.getNumCodeLines() );
		assertEquals( 171 , MikeSub.getNumCodeLines() );
		assertEquals( 43 , NathanSub.getNumCodeLines() );
		
	} // End of testGetNumCodeLines()


	@Test
	public void testGetNumCodeFiles() {
		assertEquals( 1 , AsaSub.getNumCodeFiles() );
		assertEquals( 2 , JenSub.getNumCodeFiles() );
		assertEquals( 2 , MikeSub.getNumCodeFiles() );
		assertEquals( 5 , NathanSub.getNumCodeFiles() );
		
	} // End of testGetNumCodeFiles()

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
	
	@Test
	public void testEquals() {
		// Unit Tests for Asa
		assertTrue( AsaSub.equals(AsaSub) );
		assertFalse( AsaSub.equals(JenSub) );
		assertFalse( AsaSub.equals(NathanSub) );
		assertFalse( AsaSub.equals(MikeSub) );
		
		// Unit Tests for Jen
		assertTrue( JenSub.equals(JenSub) );
		assertFalse( JenSub.equals(AsaSub) );
		assertFalse( JenSub.equals(NathanSub) );
		assertFalse( JenSub.equals(MikeSub) );
		
		// Unit Tests for Mike
		assertTrue( MikeSub.equals(MikeSub) );
		assertFalse( MikeSub.equals(AsaSub) );
		assertFalse( MikeSub.equals(JenSub) );
		assertFalse( MikeSub.equals(NathanSub) );
		
		// Unit Tests for Nathan
		assertTrue( NathanSub.equals(NathanSub) );
		assertFalse( NathanSub.equals(AsaSub) );
		assertFalse( NathanSub.equals(JenSub) );
		assertFalse( NathanSub.equals(MikeSub) );
	}
	
	@Test
	public void testClone() {
		Submission clonedNathan = (Submission) NathanSub.clone();
		
		assertEquals( clonedNathan , NathanSub);
		assertNotSame( clonedNathan , NathanSub );
		
		assertEquals( clonedNathan.isTokenized() , NathanSub.isTokenized() );
		assertEquals( clonedNathan.getNumCodeFiles() , NathanSub.getNumCodeFiles() );
		assertEquals( clonedNathan.getNumCodeLines() , NathanSub.getNumCodeLines() );
		assertEquals( clonedNathan.getAllFiles() , NathanSub.getAllFiles() );
		assertEquals( clonedNathan.getCodeFiles() , NathanSub.getCodeFiles() );
		assertEquals( clonedNathan.getTokenCount() , NathanSub.getTokenCount() );
		//assertEquals( clonedNathan.getTokenSequence() , NathanSub.getTokenSequence() );
		assertEquals( clonedNathan.toString() , NathanSub.toString() );
		assertEquals( clonedNathan.hashCode() , NathanSub.hashCode() );
	}
	
	@Test
	public void testHashCode() {
	    assertFalse( AsaSub.equals(JenSub) || JenSub.equals(AsaSub) );
	    assertFalse( AsaSub.hashCode() == JenSub.hashCode() );
	    
	    Submission clonedJen = new Submission( JenSub );
	    assertTrue( clonedJen.equals(JenSub) && JenSub.equals(clonedJen) );
	    assertTrue( clonedJen.hashCode() == JenSub.hashCode() );
	}

}
