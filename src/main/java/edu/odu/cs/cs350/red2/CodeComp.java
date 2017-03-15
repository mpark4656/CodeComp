/*
 *  Date: 3/14/2017
 *  Class: CS350
 *  Project: Red2 - CodeComp
 */

package edu.odu.cs.cs350.red2;

import edu.odu.cs.cs350.red2.Interface.*;
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
		// Check that the command-line arguments provided by user are proper
		if( !properArgs(args) ) {
			System.out.println( "Usage: java -jar CodeComp.jar [options] assignmentDirectory outputSpreadsheet" );
			System.exit(1);
		}
		
		// If user used the -help option, print the summary of command-line usage and options.
		// Then, exit the program.
		if( argsContainHelp(args) ) {
			helpUser();
			System.exit(0);
		}
		
		// Instantiate Instructor and provide the name of output directory path
		Instructor instructor = new Instructor( args[args.length - 1]);
		
		// If user provided optional argument for specifying Template, set the template
		if( argsContainTemplate(args) ) {
			instructor.setTemplate( getTemplateArg(args) );
		}
		
		// If user provided optional argument for specifying sheet name, set the sheet name
		if( argsContainSheetName(args) ) {
			instructor.setSheetName( getSheetNameArg(args) );
		}
		
		// Create a File instance with the Assignment Directory path that user provided
		File assignmentDirectory = new File( args[args.length - 2] );
		
		// Check to see if the path exists.
		if( !assignmentDirectory.exists() ) {
			System.out.println( "The assignment directory does not exist." );
		}
		
		// Check to see if the path points to a directory.
		if( !assignmentDirectory.isDirectory() ) {
			System.out.println( "" );
		}
		
		// Recursively search the assignment directory and get all student submissions
		instructor.acceptStudentSubmissions( assignmentDirectory );
		
		// Parse the students code (Tokenize the code files)
		instructor.parseStudentSubmissions();
		
		// Analyze similarity
		instructor.analyzeAllSequences();
		
		// Generate report
		instructor.generateReport();
		
	} // End of main
	
	/**
	 * Return -template arg as String
	 * @param args
	 * @return tempArg String The string after -template
	 */
	public static String getTemplateArg( String[] args )
	{
		return null;
	}
	
	/**
	 * Return -raw arg as String
	 * @param args
	 * @return rawArg String The string after -raw
	 */
	public static String getSheetNameArg( String[] args )
	{
		return null;
	}
	
	/**
	 * Checks the command-line arguments and see if user specified -template
	 * @param args
	 * @return True boolean true if user used the -template option
	 */
	public static boolean argsContainTemplate( String[] args )
	{
		return false;
	}
	
	/**
	 * Checks the command-line arguments and see if user specified -raw
	 * @param args
	 * @return True boolean True if user used the -raw option
	 */
	public static boolean argsContainSheetName( String[] args )
	{
		return false;
	}
	
	/**
	 * Checks the command-line arguments and see if user asked for help
	 * by including the -help option.
	 * @param args
	 * @return True boolean true if user used the -help option
	 */
	public static boolean argsContainHelp( String[] args )
	{
		return false;
	}
	
	/**
	 * Checks the command-line arguments and see if the usage is proper.
	 * 
	 * @param args
	 * @return True boolean true if the arguments are proper.
	 */
	public static boolean properArgs( String[] args )
	{
		// Implementation
		return false;
	}
	
	/**
	 * Help user by printing the summary of command-line usage and options.
	 * @pre argsContainHelp == true
	 */
	public static void helpUser()
	{
		// Print Summary of Arguments
	}
}