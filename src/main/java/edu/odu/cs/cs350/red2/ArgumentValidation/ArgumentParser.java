package edu.odu.cs.cs350.red2.ArgumentValidation;

import java.io.File;

/**
 * This helper class is responsible for checking the command-line
 * parameter provided by user and ensure that it's proper - All of 
 * these methods could have resided in CodeComp.java as static methods, 
 * but I don't want CodeComp.java to be cluttered.
 * @author mpark
 */
public class ArgumentParser
{
	private String[] args;
	
	/**
	 * Constructor that accepts an array of String
	 * @param String[] command-line parameter
	 */
	public ArgumentParser( String[] args )
	{
		this.args = args;
	}
	
	/**
	 * Checks the command-line parameter and see if the usage is proper - 
	 * This also checks that the given directory paths are valid.
	 * @return boolean Return true if the arguments are proper.
	 */
	public boolean isProperArgs()
	{
		// If there is no argument, then it is improper because the program requires
		// 2 mandatory parameters or one -help option.
		if( args.length == 0 ) {
			return false;
		}
		
		// If user provided only 1 argument, it has to be -help.
		// If not, then it's not proper.
		if( args.length == 1 && !args[0].equals("-help") ) {
			return false;
		}
		
		// If there are 2 arguments, they must be assignment directory and output directory.
		// Check that the paths exist and they are folders.
		if( args.length == 2 ) {
			File assignmentDirectory = new File( args[0] );
			File outputSpreadsheet = new File( args[1] );
			
			// If the assignmentDirectory doesn't exist or it is NOT a directory, return false
			if( !assignmentDirectory.exists() || !assignmentDirectory.isDirectory() ) {
				return false;
			}

			// If the output directory doesn't exist and it can't be created, return false
			// Remember that if the output directory doesn't exist, the program is allowed to create
			// a new directory for it.
			if( !outputSpreadsheet.exists() && !outputSpreadsheet.mkdir() ) {
				return false;
			}
		}
		
		// If more than 2 arguments are provided, the total # of arguments cannot be odd
		// For example, if you provide -raw, then you have to provide the corresponding literal
		// like "-raw defaultSheetName"
		// Therefore, the total number of arguments will always be even.
		if( args.length > 2 && args.length % 2 == 1 ) {
			return false;
		}
		
		// If the number of arguments is larger than 3, we can check the index of the array that
		// is supposed to hold optional flags (-template and -raw) and verify that the array holds
		// the optional flags at those indices. If not, it is improper.
		// We can also check the indices of the array where optional flags shouldn't be (For example, 
		// having -template right after -raw does NOT make any sense!)
		if( args.length >= 4 ) {
			// Make sure that the last 2 arguments are valid file directories
			File assignmentDirectory = new File( args[args.length - 2] );
			File outputSpreadsheet = new File( args[args.length - 1] );
			
			if( !assignmentDirectory.exists() || !assignmentDirectory.isDirectory() ) {
				return false;
			}
			
			if( !outputSpreadsheet.exists() && !outputSpreadsheet.mkdir() ) {
				return false;
			}
			
			// These flags will help determine if user used duplicate options
			// For example, using -raw twice
			boolean rawUsed = false;
			boolean templateUsed = false;
			
			// Iterate through the args array at each index that holds optional flag
			for( int i = 0 ; i < args.length - 2 ; i += 2 ) {
				// -raw appeared twice, this is not the correct arg
				if( args[i].equals("-raw") && rawUsed == true ) {
					return false;
				}
				
				// -template appeared twice, this is not the correct arg
				if( args[i].equals("-template") && templateUsed == true ) {
					return false;
				}
				
				// Since -raw was used, mark it as used
				if( args[i].equals("-raw") && rawUsed == false ) {
					rawUsed = true;
				}
				
				// Since -template was used, mark it as used
				if( args[i].equals("-template") && templateUsed == false ) {
					templateUsed = true;
				}
				
				// If this index does not hold optional flag, it is not proper.
				if( !args[i].equals("-raw") && !args[i].equals("-template") ) {
					return false;
				}
				
				// If non-optional flag holder holds optional flag, it is not proper.
				if( args[i + 1].equals("-raw") || args[i + 1].equals("-template") ) {
					return false;
				}
			}
		}
		
		// If the control reaches this point, that means the arguments passed all checks
		// and they are proper, so return true.
		return true;
		
	} // End of isProperArgs()
	
	/**
	 * Checks the command-line parameter and see if user asked for help
	 * by including the -help option.
	 * @pre isProperArgs() == true
	 * @return boolean Return true if user used the -help option
	 */
	public boolean argsContainHelp()
	{
		if( args.length == 0 || isProperArgs() == false ) {
			// Or throw exception
			return false;
		}
		
		return args[0].equals( "-help" );
		
	} // End of argsContainHelp()
	
	/**
	 * Checks the command-line parameter and see if user specified -raw.
	 * @pre isProperArgs() == true
	 * @return boolean Return true if user used the -raw option
	 */
	public boolean argsContainSheetName()
	{
		if( isProperArgs() == false ) {
			// Or throw exception
			return false;
		}
		
		for( int i = 0 ; i < args.length - 2 ; i += 2 ) {
			if( args[i].equals("-raw") ) {
				return true;
			}
		}
		
		return false;
		
	} // End of argsContainSheetName()
	
	/**
	 * Checks the command-line parameter and see if user specified -template.
	 * @pre isProperArgs() == true
	 * @return boolean Return true if user used the -template option
	 */
	public boolean argsContainTemplate()
	{
		if( isProperArgs() == false ) {
			// Or throw exception
			return false;
		}
		
		for( int i = 0 ; i < args.length - 2 ; i += 2 ) {
			if( args[i].equals("-template") ) {
				return true;
			}
		}
		
		return false;
		
	} // End of argsContainTemplate()
	
	/**
	 * Return -template arg as String
	 * @return String The actual argument after -template flag
	 */
	public String getTemplateArg()
	{
		// If the arguments don't contain -template, then return null
		// We may change it and throw exception
		if( !argsContainTemplate() ) {
			// Or throw exception
			return null;
		}
		else {
			// This variable stores the index of array item that has "-template"
			int tempIndex = 0;
			
			// Find the index of "-template" in the array
			for( int i = 0 ; i < args.length ; i ++ ) {
				if( args[i].equals("-template") ) {
					tempIndex = i;
					break;
				}
			}
			
			// The index after tempIndex is the actual literal argument.
			return args[tempIndex + 1];
		}
		
	} // End of getTemplateArg()
	
	/**
	 * Return -raw arg as String
	 * @pre argsContainSheetName() == true
	 * @return String The actual argument after -raw flag
	 */
	public String getSheetNameArg()
	{
		// If the arguments don't contain -raw, then return null
		// We may change it and throw exception
		if( !argsContainSheetName() ) {
			// Or throw exception
			return null;
		}
		else {
			// This variable stores the index of array item that has "-raw"
			int rawIndex = 0;
			
			// Find the index of "-raw" in the array
			for( int i = 0 ; i < args.length ; i ++ ) {
				if( args[i].equals("-raw") ) {
					rawIndex = i;
					break;
				}
			}
			
			// The index after rawIndex is the actual literal argument.
			return args[rawIndex + 1];
		}
		
	} // End of getSheetNameArg()
	
} // End of ArgumentParser



