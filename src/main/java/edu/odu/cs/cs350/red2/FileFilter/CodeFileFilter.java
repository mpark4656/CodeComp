package edu.odu.cs.cs350.red2.FileFilter;

import java.io.*;
import java.util.ArrayList;

/**
 * This is a helper class that filters out any files that is not a code file.
 * This will only accept Code Files and Directories.
 * 
 * @author mpark
 */
public class CodeFileFilter implements FileFilter
{
	/**
	 * Accept only the code files and directories
	 * @return boolean Return true if the file path is a directory.
	 */
	@Override
	public boolean accept( File filePath )
	{
		// If the file path is a directory, accept it.
		if( filePath.isDirectory() ) {
			return true;
		}
		
		// Get the file name from filePath
		String filename = filePath.getName();
		
		// Get the file extension
		String extension = filename.substring( filename.lastIndexOf('.') + 1 );
		
		// Get a list of all extensions that program accepts
		// In the future, these will be read from a data file
		ArrayList<String> validExtensions = new ArrayList<String> ();
		validExtensions.add( "cpp" );
		validExtensions.add( "hpp" );
		validExtensions.add( "java" );
		validExtensions.add( "h" );
		
		// If the extension is one of the allowed extensions, accept the file.
		if( validExtensions.contains(extension) ) {
			return true;
		}
		
		// Otherwise, do not accept.
		return false;
	}
}