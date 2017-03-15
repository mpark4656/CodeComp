/*
 *  Date: Today, 2017
 *  Class: CS350
 *  Project: Red2 - CodeComp
 */

package edu.odu.cs.cs350.red2;


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
		// Check the number of command-line arguments
		switch( args.length )
		{
		// If user provided zero parameter argument - No Go
		case 0:
			System.out.println( "Usage: java -jar CodeComp.jar [options] assignmentDirectory outputSpreadsheet" );
			break;
		
		// If user provided just one argument, it has to be -help
		case 1:
			if( args[0] == "-help" ) {
				helpUser();
				break;
			}
			
		// If user provided 2 arguments, they must be assignmentDirectory and outputSpreadsheet
		case 2:
			// Check to see if user provided absolute path
			// Check to see if user provided relative path
			// If both checks failed, then they provided incorrect input
		
		// There cannot be 3 arguments if user followed the correct usage!
		case 3:
			;
			
		// If user provided 4 arguments, they must have provided 1 optional arg and
		// 2 required args. Check that this is the case.
		case 4:
			// Optional arg is either -template or -raw
			// The two required args are assignmentDirectory and outputSpreadsheet
			
		
		default:
			
		}
		
		
		
	}
	
	public static void helpUser()
	{
		// Print Summary of Arguments
	}
}