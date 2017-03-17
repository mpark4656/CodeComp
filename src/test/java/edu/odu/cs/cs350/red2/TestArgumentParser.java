package edu.odu.cs.cs350.red2;

import edu.odu.cs.cs350.red2.ArgumentValidation.ArgumentParser;
import static org.junit.Assert.*;

import org.junit.Test;
import java.io.File;

public class TestArgumentParser {

	@Test
	public void testArgumentParser() {
		
		
		/************************************************************/
		/*
		 * Create an array of String with 0 element (No arguments given)
		 * Instantiate ArgumentParser with no argument
		 * This is improper.
		 * 
		 * java -jar CodeComp.jar
		 */
		String[] args = new String[0];
		ArgumentParser parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide 1 option, -help
		 * This is proper.
		 * 
		 * java -jar CodeComp.jar -help
		 */
		args = new String[1];
		args[0] = "-help";
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		assertTrue( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters
		 * Both folders already exist
		 * 
		 * java -jar CodeComp.jar testName submission output
		 */
		// First, create a test submission folder and output folder
		File submissionDirectory = new File( "submission" );
		File outputDirectory = new File( "output" );
		
		// Create the submission folder
		submissionDirectory.mkdir();
		outputDirectory.mkdir();
		
		// Create an array of String representing args
		args = new String[2];
		args[0] = submissionDirectory.getPath();
		args[1] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Use options in place of submissionDirectory and outputDirectory
		 * 
		 * java -jar CodeComp.jar -raw -template
		 */
		args = new String[2];
		args[0] = "-raw";
		args[1] = "-template";

		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -raw option
		 * 
		 * java -jar CodeComp.jar -raw testName submission output
		 */
		args = new String[4];
		args[0] = "-raw";
		args[1] = "testName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertTrue( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( "testName" , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -template option
		 * 
		 * java -jar CodeComp.jar -template tempName submission output
		 */
		args = new String[4];
		args[0] = "-template";
		args[1] = "tempName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertTrue( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( "tempName" , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters and both options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -template templateName submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertTrue( parser.argsContainSheetName() );
		assertTrue( parser.argsContainTemplate() );
		assertEquals( "sheetName" , parser.getSheetNameArg() );
		assertEquals( "templateName" , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Same as previous test case, but switch the position of
		 * -raw and -template 
		 * 
		 * java -jar CodeComp.jar -template sheetName -raw templateName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertTrue( parser.argsContainSheetName() );
		assertTrue( parser.argsContainTemplate() );
		assertEquals( "templateName" , parser.getSheetNameArg() );
		assertEquals( "sheetName" , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -template
		 * 
		 * java -jar CodeComp.jar -template sheetName -template tempName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "tempName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -raw
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw secondSheet submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "secondSheet";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw tempName -template test -template eww submission output
		 */
		args = new String[10];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "tempName";
		args[4] = "-template";
		args[5] = "test";
		args[6] = "-template";
		args[7] = "eww";
		args[8] = submissionDirectory.getPath();
		args[9] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		assertFalse( parser.argsContainHelp() );
		assertFalse( parser.argsContainSheetName() );
		assertFalse( parser.argsContainTemplate() );
		assertEquals( null , parser.getSheetNameArg() );
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Remove the test directories after testing
		 */
		submissionDirectory.delete();
		outputDirectory.delete();
		/************************************************************/
		
	} // End of testArgumentParser()

	@Test
	public void testIsProperArgs() {
		
		
		/************************************************************/
		/*
		 * Create an array of String with 0 element (No arguments given)
		 * Instantiate ArgumentParser with no argument
		 * This is improper.
		 * 
		 * java -jar CodeComp.jar
		 */
		String[] args = new String[0];
		ArgumentParser parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide 1 option, -help
		 * This is proper.
		 * 
		 * java -jar CodeComp.jar -help
		 */
		args = new String[1];
		args[0] = "-help";
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters
		 * Both folders already exist
		 * 
		 * java -jar CodeComp.jar testName submission output
		 */
		// First, create a test submission folder and output folder
		File submissionDirectory = new File( "submission" );
		File outputDirectory = new File( "output" );
		
		// Create the submission folder
		submissionDirectory.mkdir();
		outputDirectory.mkdir();
		
		// Create an array of String representing args
		args = new String[2];
		args[0] = submissionDirectory.getPath();
		args[1] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Use options in place of submissionDirectory and outputDirectory
		 * 
		 * java -jar CodeComp.jar -raw -template
		 */
		args = new String[2];
		args[0] = "-raw";
		args[1] = "-template";

		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -raw option
		 * 
		 * java -jar CodeComp.jar -raw testName submission output
		 */
		args = new String[4];
		args[0] = "-raw";
		args[1] = "testName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -template option
		 * 
		 * java -jar CodeComp.jar -template tempName submission output
		 */
		args = new String[4];
		args[0] = "-template";
		args[1] = "tempName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters and both options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -template templateName submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Same as previous test case, but switch the position of
		 * -raw and -template 
		 * 
		 * java -jar CodeComp.jar -template sheetName -raw templateName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -template
		 * 
		 * java -jar CodeComp.jar -template sheetName -template tempName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "tempName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -raw
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw secondSheet submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "secondSheet";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw tempName -template test -template eww submission output
		 */
		args = new String[10];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "tempName";
		args[4] = "-template";
		args[5] = "test";
		args[6] = "-template";
		args[7] = "eww";
		args[8] = submissionDirectory.getPath();
		args[9] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.isProperArgs() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Remove the test directories after testing
		 */
		submissionDirectory.delete();
		outputDirectory.delete();
		/************************************************************/
		
	} // End of testIsProperArgs()

	@Test
	public void testArgsContainHelp() {
		/************************************************************/
		/*
		 * Create an array of String with 0 element (No arguments given)
		 * Instantiate ArgumentParser with no argument
		 * This is improper.
		 * 
		 * java -jar CodeComp.jar
		 */
		String[] args = new String[0];
		ArgumentParser parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide 1 option, -help
		 * This is proper.
		 * 
		 * java -jar CodeComp.jar -help
		 */
		args = new String[1];
		args[0] = "-help";
		parser = new ArgumentParser( args );
		
		assertTrue( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters
		 * Both folders already exist
		 * 
		 * java -jar CodeComp.jar testName submission output
		 */
		// First, create a test submission folder and output folder
		File submissionDirectory = new File( "submission" );
		File outputDirectory = new File( "output" );
		
		// Create the submission folder
		submissionDirectory.mkdir();
		outputDirectory.mkdir();
		
		// Create an array of String representing args
		args = new String[2];
		args[0] = submissionDirectory.getPath();
		args[1] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Use options in place of submissionDirectory and outputDirectory
		 * 
		 * java -jar CodeComp.jar -raw -template
		 */
		args = new String[2];
		args[0] = "-raw";
		args[1] = "-template";

		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -raw option
		 * 
		 * java -jar CodeComp.jar -raw testName submission output
		 */
		args = new String[4];
		args[0] = "-raw";
		args[1] = "testName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -template option
		 * 
		 * java -jar CodeComp.jar -template tempName submission output
		 */
		args = new String[4];
		args[0] = "-template";
		args[1] = "tempName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters and both options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -template templateName submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Same as previous test case, but switch the position of
		 * -raw and -template 
		 * 
		 * java -jar CodeComp.jar -template sheetName -raw templateName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -template
		 * 
		 * java -jar CodeComp.jar -template sheetName -template tempName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "tempName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -raw
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw secondSheet submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "secondSheet";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw tempName -template test -template eww submission output
		 */
		args = new String[10];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "tempName";
		args[4] = "-template";
		args[5] = "test";
		args[6] = "-template";
		args[7] = "eww";
		args[8] = submissionDirectory.getPath();
		args[9] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainHelp() );;
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Remove the test directories after testing
		 */
		submissionDirectory.delete();
		outputDirectory.delete();
		/************************************************************/
		
	} // End of testArgsContainHelp()

	@Test
	public void testArgsContainSheetName() {
		/************************************************************/
		/*
		 * Create an array of String with 0 element (No arguments given)
		 * Instantiate ArgumentParser with no argument
		 * This is improper.
		 * 
		 * java -jar CodeComp.jar
		 */
		String[] args = new String[0];
		ArgumentParser parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide 1 option, -help
		 * This is proper.
		 * 
		 * java -jar CodeComp.jar -help
		 */
		args = new String[1];
		args[0] = "-help";
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters
		 * Both folders already exist
		 * 
		 * java -jar CodeComp.jar testName submission output
		 */
		// First, create a test submission folder and output folder
		File submissionDirectory = new File( "submission" );
		File outputDirectory = new File( "output" );
		
		// Create the submission folder
		submissionDirectory.mkdir();
		outputDirectory.mkdir();
		
		// Create an array of String representing args
		args = new String[2];
		args[0] = submissionDirectory.getPath();
		args[1] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );

		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Use options in place of submissionDirectory and outputDirectory
		 * 
		 * java -jar CodeComp.jar -raw -template
		 */
		args = new String[2];
		args[0] = "-raw";
		args[1] = "-template";

		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -raw option
		 * 
		 * java -jar CodeComp.jar -raw testName submission output
		 */
		args = new String[4];
		args[0] = "-raw";
		args[1] = "testName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -template option
		 * 
		 * java -jar CodeComp.jar -template tempName submission output
		 */
		args = new String[4];
		args[0] = "-template";
		args[1] = "tempName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters and both options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -template templateName submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Same as previous test case, but switch the position of
		 * -raw and -template 
		 * 
		 * java -jar CodeComp.jar -template sheetName -raw templateName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -template
		 * 
		 * java -jar CodeComp.jar -template sheetName -template tempName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "tempName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );

		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -raw
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw secondSheet submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "secondSheet";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw tempName -template test -template eww submission output
		 */
		args = new String[10];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "tempName";
		args[4] = "-template";
		args[5] = "test";
		args[6] = "-template";
		args[7] = "eww";
		args[8] = submissionDirectory.getPath();
		args[9] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainSheetName() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Remove the test directories after testing
		 */
		submissionDirectory.delete();
		outputDirectory.delete();
		/************************************************************/
		
	} // End of testContainSheetName()

	@Test
	public void testGetTemplateArg() {

		/************************************************************/
		/*
		 * Create an array of String with 0 element (No arguments given)
		 * Instantiate ArgumentParser with no argument
		 * This is improper.
		 * 
		 * java -jar CodeComp.jar
		 */
		String[] args = new String[0];
		ArgumentParser parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide 1 option, -help
		 * This is proper.
		 * 
		 * java -jar CodeComp.jar -help
		 */
		args = new String[1];
		args[0] = "-help";
		parser = new ArgumentParser( args );

		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters
		 * Both folders already exist
		 * 
		 * java -jar CodeComp.jar testName submission output
		 */
		// First, create a test submission folder and output folder
		File submissionDirectory = new File( "submission" );
		File outputDirectory = new File( "output" );
		
		// Create the submission folder
		submissionDirectory.mkdir();
		outputDirectory.mkdir();
		
		// Create an array of String representing args
		args = new String[2];
		args[0] = submissionDirectory.getPath();
		args[1] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Use options in place of submissionDirectory and outputDirectory
		 * 
		 * java -jar CodeComp.jar -raw -template
		 */
		args = new String[2];
		args[0] = "-raw";
		args[1] = "-template";

		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -raw option
		 * 
		 * java -jar CodeComp.jar -raw testName submission output
		 */
		args = new String[4];
		args[0] = "-raw";
		args[1] = "testName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );

		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -template option
		 * 
		 * java -jar CodeComp.jar -template tempName submission output
		 */
		args = new String[4];
		args[0] = "-template";
		args[1] = "tempName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );

		assertEquals( "tempName" , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters and both options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -template templateName submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( "templateName" , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Same as previous test case, but switch the position of
		 * -raw and -template 
		 * 
		 * java -jar CodeComp.jar -template sheetName -raw templateName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );

		assertEquals( "sheetName" , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -template
		 * 
		 * java -jar CodeComp.jar -template sheetName -template tempName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "tempName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -raw
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw secondSheet submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "secondSheet";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw tempName -template test -template eww submission output
		 */
		args = new String[10];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "tempName";
		args[4] = "-template";
		args[5] = "test";
		args[6] = "-template";
		args[7] = "eww";
		args[8] = submissionDirectory.getPath();
		args[9] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getTemplateArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Remove the test directories after testing
		 */
		submissionDirectory.delete();
		outputDirectory.delete();
		/************************************************************/
		
	} // End of testGetTemplateArg()

	@Test
	public void testGetSheetNameArg() {
		/************************************************************/
		/*
		 * Create an array of String with 0 element (No arguments given)
		 * Instantiate ArgumentParser with no argument
		 * This is improper.
		 * 
		 * java -jar CodeComp.jar
		 */
		String[] args = new String[0];
		ArgumentParser parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide 1 option, -help
		 * This is proper.
		 * 
		 * java -jar CodeComp.jar -help
		 */
		args = new String[1];
		args[0] = "-help";
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters
		 * Both folders already exist
		 * 
		 * java -jar CodeComp.jar testName submission output
		 */
		// First, create a test submission folder and output folder
		File submissionDirectory = new File( "submission" );
		File outputDirectory = new File( "output" );
		
		// Create the submission folder
		submissionDirectory.mkdir();
		outputDirectory.mkdir();
		
		// Create an array of String representing args
		args = new String[2];
		args[0] = submissionDirectory.getPath();
		args[1] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Use options in place of submissionDirectory and outputDirectory
		 * 
		 * java -jar CodeComp.jar -raw -template
		 */
		args = new String[2];
		args[0] = "-raw";
		args[1] = "-template";

		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -raw option
		 * 
		 * java -jar CodeComp.jar -raw testName submission output
		 */
		args = new String[4];
		args[0] = "-raw";
		args[1] = "testName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( "testName" , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -template option
		 * 
		 * java -jar CodeComp.jar -template tempName submission output
		 */
		args = new String[4];
		args[0] = "-template";
		args[1] = "tempName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );

		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters and both options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -template templateName submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( "sheetName" , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Same as previous test case, but switch the position of
		 * -raw and -template 
		 * 
		 * java -jar CodeComp.jar -template sheetName -raw templateName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( "templateName" , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -template
		 * 
		 * java -jar CodeComp.jar -template sheetName -template tempName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "tempName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -raw
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw secondSheet submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "secondSheet";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw tempName -template test -template eww submission output
		 */
		args = new String[10];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "tempName";
		args[4] = "-template";
		args[5] = "test";
		args[6] = "-template";
		args[7] = "eww";
		args[8] = submissionDirectory.getPath();
		args[9] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );

		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertEquals( null , parser.getSheetNameArg() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Remove the test directories after testing
		 */
		submissionDirectory.delete();
		outputDirectory.delete();
		/************************************************************/
		
	} // End of testGetSheetNameArg()

	@Test
	public void testArgsContainTemplate() {
		/************************************************************/
		/*
		 * Create an array of String with 0 element (No arguments given)
		 * Instantiate ArgumentParser with no argument
		 * This is improper.
		 * 
		 * java -jar CodeComp.jar
		 */
		String[] args = new String[0];
		ArgumentParser parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide 1 option, -help
		 * This is proper.
		 * 
		 * java -jar CodeComp.jar -help
		 */
		args = new String[1];
		args[0] = "-help";
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters
		 * Both folders already exist
		 * 
		 * java -jar CodeComp.jar testName submission output
		 */
		// First, create a test submission folder and output folder
		File submissionDirectory = new File( "submission" );
		File outputDirectory = new File( "output" );
		
		// Create the submission folder
		submissionDirectory.mkdir();
		outputDirectory.mkdir();
		
		// Create an array of String representing args
		args = new String[2];
		args[0] = submissionDirectory.getPath();
		args[1] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Use options in place of submissionDirectory and outputDirectory
		 * 
		 * java -jar CodeComp.jar -raw -template
		 */
		args = new String[2];
		args[0] = "-raw";
		args[1] = "-template";

		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -raw option
		 * 
		 * java -jar CodeComp.jar -raw testName submission output
		 */
		args = new String[4];
		args[0] = "-raw";
		args[1] = "testName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameter and -template option
		 * 
		 * java -jar CodeComp.jar -template tempName submission output
		 */
		args = new String[4];
		args[0] = "-template";
		args[1] = "tempName";
		args[2] = submissionDirectory.getPath();
		args[3] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide the 2 required parameters and both options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -template templateName submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Same as previous test case, but switch the position of
		 * -raw and -template 
		 * 
		 * java -jar CodeComp.jar -template sheetName -raw templateName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "templateName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertTrue( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -template
		 * 
		 * java -jar CodeComp.jar -template sheetName -template tempName submission output
		 */
		args = new String[6];
		args[0] = "-template";
		args[1] = "sheetName";
		args[2] = "-template";
		args[3] = "tempName";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate -raw
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw secondSheet submission output
		 */
		args = new String[6];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "secondSheet";
		args[4] = submissionDirectory.getPath();
		args[5] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Duplicate options
		 * 
		 * java -jar CodeComp.jar -raw sheetName -raw tempName -template test -template eww submission output
		 */
		args = new String[10];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-raw";
		args[3] = "tempName";
		args[4] = "-template";
		args[5] = "test";
		args[6] = "-template";
		args[7] = "eww";
		args[8] = submissionDirectory.getPath();
		args[9] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Provide incorrect options - Including -help with other arguments
		 * 
		 * java -jar CodeComp.jar -raw sheetName -help submission output
		 */
		args = new String[5];
		args[0] = "-raw";
		args[1] = "sheetName";
		args[2] = "-help";
		args[3] = submissionDirectory.getPath();
		args[4] = outputDirectory.getPath();
		
		parser = new ArgumentParser( args );
		
		assertFalse( parser.argsContainTemplate() );
		/************************************************************/
		
		
		/************************************************************/
		/*
		 * Remove the test directories after testing
		 */
		submissionDirectory.delete();
		outputDirectory.delete();
		/************************************************************/
		
	} // End of testArgsContainTemplate()

} // End of TestArgumentParser.java




