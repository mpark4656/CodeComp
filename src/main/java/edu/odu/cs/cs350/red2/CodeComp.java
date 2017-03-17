/*
 *  Date: 3/14/2017
 *  Class: CS350
 *  Project: Red2 - CodeComp
 */

package edu.odu.cs.cs350.red2;

import edu.odu.cs.cs350.red2.Interface.*;
import edu.odu.cs.cs350.red2.ArgumentValidation.*;
import java.io.File;

/**
 * The Main Driver - 
 * Instantiates Instructor class
 * 
 * @author mpark
 * @author nruf
 */
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
	 */
	public static void main( String[] args )
	{
		// Instantiate ArgumentParser and pass arguments
		ArgumentParser param = new ArgumentParser( args );
		
		// Check that the command-line parameter is proper
		if( !param.isProperArgs() ) {
			System.out.println( "Usage: java -jar CodeComp.jar [options] assignmentDirectory outputSpreadsheet" );
			System.out.println();
			System.out.println( "For Help: java -jar CodeComp.jar -help" );
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
		// ArgumentParser already checked that the assignmentDirectory is an existing directory.
		File assignmentDirectory = new File( args[args.length - 2] );
		
		// Recursively search the assignment directory and get all student submissions
		instructor.acceptStudentSubmissions( assignmentDirectory );
		
		// Create tables and display result
		instructor.displayResult();
		
	} // End of main
	
	/**
	 * Help user by printing the summary of command-line usage and options.
	 */
	public static void helpUser()
	{
		// Print Summary of Usage and Options
		System.out.println( "Usage: java -jar CodeComp.jar [Options] [assignmentDirectory] [outputSpreadsheet]" );
		System.out.println();
		System.out.print  ( "\tThe [assignmentDirectory] is a path to the root directory of the assignment, " );
		System.out.println( "containing a number of submission directories." );
		System.out.println();
		System.out.print  ( "\tThe [outputSpreadsheet] is a path to where the output " );
		System.out.println( "(an Excel spreadsheet) should be stored." );
		System.out.println();
		System.out.println( "Options:" );
		System.out.println( "\t-template templateSpreadSheet" );
		System.out.println( "\t\tReplaces the default spreadsheet template with one specified by the user." );
		System.out.println();
		System.out.println( "\t-raw sheetname" );
		System.out.print  ( "\t\tReplaces the sheet name used to identify where to place the raw scores " );
		System.out.println( "(default is “RawScores”)." );
		System.out.println();
		System.out.println( "Additional Commands" );
		System.out.println( "\tjava -jar CodeComp.jar -help" );
		System.out.println( "\t\tPrints a summary of the command line parameters." );
		
	} // End of helpUser()
	
} // End of CodeComp



