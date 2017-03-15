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
		// Instantiate ArgumentParser and pass args
		ArgumentParser param = new ArgumentParser( args );
		
		// Check that the command-line parameter is proper
		if( !param.properArgs(args) ) {
			System.out.println( "Usage: java -jar CodeComp.jar [options] assignmentDirectory outputSpreadsheet" );
			System.exit(1);
		}
		
		// If user used the -help option, print the summary of command-line usage and options.
		// Then, exit the program.
		if( param.argsContainHelp(args) ) {
			helpUser();
			System.exit(0);
		}
		
		// Instantiate Instructor and provide the name of output directory path
		Instructor instructor = new Instructor( args[args.length - 1]);
		
		// If user provided optional argument for specifying Template, set the template
		if( param.argsContainTemplate(args) ) {
			instructor.setTemplate( param.getTemplateArg(args) );
		}
		
		// If user provided optional argument for specifying sheet name, set the sheet name
		if( param.argsContainSheetName(args) ) {
			instructor.setSheetName( param.getSheetNameArg(args) );
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
	 * Help user by printing the summary of command-line usage and options.
	 */
	public static void helpUser()
	{
		// Print Summary of Arguments
	}
	
} // End of CodeComp



