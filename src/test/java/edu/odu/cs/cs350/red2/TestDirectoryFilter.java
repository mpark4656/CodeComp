package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;
import java.io.File;
import edu.odu.cs.cs350.red2.FileFilter.DirectoryFilter;

import org.junit.Test;

public class TestDirectoryFilter {

	// This filter only accepts Directory paths
	private DirectoryFilter testFilter;
	
	public TestDirectoryFilter()
	{
		testFilter = new DirectoryFilter();
	}
	
	@Test
	public void testAccept() {
		File dir1 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2" );
		File dir2 = new File( "./src/test/data/testSubmissionDirectory/Jen" );
		File nonCodeFile1 = new File( "./src/test/data/testSubmissionDirectory/Nathan.1/None.txt" );
		File nonCodeFile2 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/subDir/codeFile.c" );
		File codeFile1 = new File( "./src/test/data/testSubmissionDirectory/Jen/code4.java" );
		File codeFile2 = new File( "./src/test/data/testSubmissionDirectory/Nathan.2/code4.cpp" );
		File codeFile3 = new File( "./src/test/data/testSubmissionDirectory/Mike/subDir/Graph1229.h" );
		
		assertTrue( testFilter.accept(dir1) );
		assertTrue( testFilter.accept(dir2) );
		assertFalse( testFilter.accept(codeFile1) );
		assertFalse( testFilter.accept(codeFile2) );
		assertFalse( testFilter.accept(codeFile3) );
		assertFalse(testFilter.accept(nonCodeFile1) );
		assertFalse(testFilter.accept(nonCodeFile2) );
	}

}
