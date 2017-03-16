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
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		
		// Provided 1 option -help
		args = new String[1];
		args[0] = "-help";
		ArgumentParser parser1 = new ArgumentParser( args );
		
		assertTrue( parser1.isProperArgs() );
		assertTrue( parser1.argsContainHelp() );
		assertFalse( parser1.argsContainSheetName() );
		assertFalse( parser1.argsContainTemplate() );
		assertEquals( null , parser1.getSheetNameArg() );
		assertEquals( null , parser1.getTemplateArg() );
	}

	@Test
	public void testIsProperArgs() {
		// Provide no argument
		String[] args = new String[0];
		ArgumentParser parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		
		// Provide 1 invalid argument.
		args = new String[1];
		args[0] = "help";
		ArgumentParser parser1 = new ArgumentParser( args );
		
		assertFalse( parser1.isProperArgs() );
		
		// Provide 1 valid argument.
		args = new String[1];
		args[0] = "-help";
		ArgumentParser parser2 = new ArgumentParser( args );
		
		assertTrue( parser2.isProperArgs() );
	}

	@Test
	public void testArgsContainHelp() {
		// Provided 1 invalid argument.
		String[] args = new String[1];
		args[0] = "help";
		ArgumentParser parser1 = new ArgumentParser( args );
		
		assertFalse( parser1.argsContainHelp() );

		
		// Used -help option.
		args = new String[1];
		args[0] = "-help";
		ArgumentParser parser2 = new ArgumentParser( args );
		
		assertTrue( parser2.argsContainHelp() );
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
