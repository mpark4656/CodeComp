package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import edu.odu.cs.cs350.red2.Interface.*;

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
		assertFalse ( AsaSub.isTokenized() );
		
		assertFalse ( JenSub.isTokenized() );
		
		assertFalse ( MikeSub.isTokenized() );
		
		assertFalse ( NathanSub.isTokenized() );
	}

	

	@Test
	public void testTokenize() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testIsTokenized() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testGetTokenSequenceLength() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testGetNumCodeLines() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testGetNumCodeFiles() {
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
