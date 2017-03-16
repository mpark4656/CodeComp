package edu.odu.cs.cs350.red2;

import edu.odu.cs.cs350.red2.ArgumentValidation.ArgumentParser;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestArgumentParser {

	@Test
	public void testArgumentParser() {
		// Create an array of String with 0 element (No arguments given)
		// Instantiate ArgumentParser with no argument
		String[] args = new String[0];
		ArgumentParser parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		
		
	}

	@Test
	public void testIsProperArgs() {
		fail("Not yet implemented");
	}

	@Test
	public void testArgsContainHelp() {
		fail("Not yet implemented");
	}

	@Test
	public void testArgsContainSheetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTemplateArg() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSheetNameArg() {
		fail("Not yet implemented");
	}

	@Test
	public void testArgsContainTemplate() {
		fail("Not yet implemented");
	}

}
