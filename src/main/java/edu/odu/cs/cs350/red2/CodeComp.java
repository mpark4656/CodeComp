/*
 *  Date: 3/14/2017
 *  Class: CS350
 *  Project: Red2 - CodeComp
 */

package edu.odu.cs.cs350.red2;

import edu.odu.cs.cs350.red2.Interface.*;
import edu.odu.cs.cs350.red2.ArgumentValidation.*;
import java.io.File;

public class CodeComp
{
	/**
	 * The main function will instantiate Instructor. It will also check that
	 * user provided correct arguments - 
	 * Make sure to check both absolute and relative path.
	 * For example, 
	 * Absolute Path: C:\Users\mpark\Documents\test.txt 
	 * Relative Path: test.txt 
	 * 
	 * The example of relative path above assumes that program is stored in 
	 * C:\Users\mpark\Documents\ 
	 * 
	 * @param args command-line arguments
	 * @author mpark
	 */
	public static void main( String[] args )
	{
		// Instantiate ArgumentParser and pass arguments
		ArgumentParser param = new ArgumentParser( args );
		
		// Check that the command-line parameter is proper
		if( !param.isProperArgs() ) {
			System.out.println( "Usage: java -jar CodeComp.jar [options] assignmentDirectory outputSpreadsheet" );
			System.exit(1);
		}
		
		// If user used the -help option, print the summary of command-line usage and options.
		// Then, exit the program.
		if( param.argsContainHelp() ) {
			helpUser();
			System.exit(0);
		}
		
		// Instantiate Instructor and provide the name of output directory path
		Instructor instructor = new Instructor( args[args.length - 1]);
		
		// If user provided optional argument for specifying Template, set the template
		if( param.argsContainTemplate() ) {
			instructor.setTemplate( param.getTemplateArg() );
		}
		
		// If user provided optional argument for specifying sheet name, set the sheet name
		if( param.argsContainSheetName() ) {
			instructor.setSheetName( param.getSheetNameArg() );
		}
		
		// Create a File instance with the Assignment Directory path that user provided
		File assignmentDirectory = new File( args[args.length - 2] );
		
		// Check to see if the path exists.
		if( !assignmentDirectory.exists() ) {
			System.out.println( "The assignment directory does not exist." );
			System.exit(2);
		}
		
		// Check to see if the path points to a directory.
		if( !assignmentDirectory.isDirectory() ) {
			System.out.println( "The assignment submissions must reside in a directory" );
			System.exit(2);
		}
		
		// Recursively search the assignment directory and get all student submissions
		instructor.acceptStudentSubmissions( assignmentDirectory );
		
		// Parse the students code (Tokenize the code files)
		instructor.process();
		
		// Analyze similarity
		instructor.analyze();
		
		// Create tables and display result
		instructor.displayResult();
		
	} // End of main
	
	/**
	 * Help user by printing the summary of command-line usage and options.
	 */
	public static void helpUser()
	{
		// Print Summary of Usage and Options
		System.out.println("Help Page");
		System.out.println("");
		System.out.println("the format for the input is");
		System.out.println("java -jar CodeComp.jar [options] assignmentDirectory outputSpreadsheet");
		System.out.println("Usage:");
		System.out.println("");
		System.out.println("The assignmentDirectory is a path to the root directory of the assignment, containing a number of submission directories.");
		System.out.println("");
		System.out.println("The outputSpreadsheet is a path to where the output (an Excel spreadsheet) should be stored.");
		System.out.println("");
		System.out.println("Options:");
		System.out.println("-template templateSpreadSheet");
		System.out.println("     Replaces the default spreadsheet template with one specified by the user.");
		System.out.println("");
		System.out.println("-raw sheetname");
		System.out.println("     Replaces the sheet name used to identify where to place the raw scores (default is “RawScores”).");
		System.out.println("");
		System.out.println("Additional Commands:");
		System.out.println("-help");
		System.out.println("     Prints a summary of the command line parameters.");
		
	}
	
} // End of CodeComp



