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
 * <pre>
 * Main Driver
 * 
 * This driver instantiates the Instructor class.
 * It will invoke appropriate methods of the Instructor, which, in turn,
 * will invoke the methods of sub-interfaces that perform lexical analysis and
 * produce results.
 * 
 * </pre>
 */
public class CodeComp
{
	/**
	 * <pre> 
	 * The main function will instantiate Instructor.
	 * It will also check that user provided correct arguments.
	 * It needs to check both the absolute and the relative path.
	 * 
	 * For example:
	 * Absolute Path: C:\Users\mpark\Documents\test.txt 
	 * Relative Path: .\test.txt 
	 * </pre>
	 * 
	 * @param args <b>String[]</b> command-line arguments
	 */
	public static void main( String[] args )
	{

		// Instantiate ArgumentParser and pass arguments
		ArgumentParser param = new ArgumentParser( args );
		
		// Check that the command-line parameter is proper
		if( !param.isProperArgs() ) {
			System.out.println( "\nUsage: java -jar CodeComp.jar [options] assignmentDirectory outputSpreadsheet" );
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
		Instructor instructor = new Instructor( args[args.length - 1] );
		
		// If user provided optional argument for specifying Template, set the template
		if( param.argsContainTemplate() ) {
			instructor.setTemplate( param.getTemplateArg() );
		}
		
		// If user provided optional argument for specifying sheet name, set the sheet name
		if( param.argsContainSheetName() ) {
				instructor.setSheetName( param.getSheetNameArg() );
		}

		// Check if the result file is available to be written to
		if( !instructor.lockOutputFile() ) {
			System.out.println( "The output file is already in use" );
			System.exit(0);

		}

		// Create a File instance with the Assignment Directory path that user provided
		// ArgumentParser already checked that the assignmentDirectory is an existing directory.
		File assignmentDirectory = new File( args[args.length - 2] );
		
		// Recursively search the assignment directory and get all student submissions
		// Once submissions are accepted, Instructor will automatically process and analyze the data.
		if( !instructor.acceptStudentSubmissions(assignmentDirectory) ) {
			System.out.println( "\nThere was a problem searching student submissions." );
			System.exit(2);
		}
		else {
			// Print Feedback Output
			instructor.outputFeedback();
		}
		
		// These are debugging output - Print all files and code files in the priority submission
		// instructor.getStudent("Asa").getPrioritySubmission().printAllFiles();
		// instructor.getStudent("Asa").getPrioritySubmission().printCodeFiles();
		// instructor.getStudent("Jen").getPrioritySubmission().printAllFiles();
		// instructor.getStudent("Jen").getPrioritySubmission().printCodeFiles();
		// instructor.getStudent("Mike").getPrioritySubmission().printAllFiles();
		// instructor.getStudent("Mike").getPrioritySubmission().printCodeFiles();
		// instructor.getStudent("Nathan").getPrioritySubmission().printAllFiles();
		// instructor.getStudent("Nathan").getPrioritySubmission().printCodeFiles();
		
		// Process submissions and parse the codes
		if( !instructor.parseSubmissions() ) {
			System.out.println( "\nA problem occurred during lexical analysis." );
			System.exit(3);
		}
		else {
			// Continue
			;
		}
		
		// Analyze similarity
		if( !instructor.analyze() ) {
			System.out.println( "\nA problem occurred during similarity analysis." );
			System.exit(4);
		}
		else {
			// Create tables and display result
			instructor.displayResult();
		}
		
	} // End of main
	
	/**
	 * Print a summary of the command-line usage and options.
	 */
	public static void helpUser()
	{
		// Print Summary of Usage and Options
		System.out.println( "\nUsage: java -jar CodeComp.jar [Options] [assignmentDirectory] [outputSpreadsheet]" );
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
		System.out.println( "(default is \"RawScores\")." );
		System.out.println();
		System.out.println( "Additional Commands" );
		System.out.println( "\tjava -jar CodeComp.jar -help" );
		System.out.println( "\t\tPrints a summary of the command line parameters." );
		
	} // End of helpUser()
	
} // End of CodeComp



