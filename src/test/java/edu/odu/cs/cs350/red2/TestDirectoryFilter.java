package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.odu.cs.cs350.red2.FileFilter.DirectoryFilter;

public class TestDirectoryFilter {

	@Test
	public void testDirectoryFilter() 
	{
		//initializing directoryFilter
		DirectoryFilter filter = new DirectoryFilter( );
		filter = new DirectoryFilter( );
		
		//Need to create a proper file to test the booleans
		//first testcase
		assertFalse( filter.accept(null) );
		
		//second testcase
		assertTrue(filter.accept(null));
		
		
		
	}

}
