package edu.odu.cs.cs350.red2.FileFilter;

import java.io.*;
import java.util.ArrayList;

/**
 * <pre>
 * A helper class that filters out any paths that do not have the extension of
 * a code file. This filter will be used during a recursive search for code files
 * in a parent directory. For this reason, directory paths will not be filtered out.
 * 
 * The accepted file extensions are
 * 1. .cpp
 * 2. hpp
 * 3. java
 * 4. h
 * </pre>
 */
public class CodeFileFilter implements FileFilter
{
	/**
	 * Accept only the code files and directories
	 * @param filePath File
	 * @return <b>boolean</b> - Return true if the file path is a directory or a code file.
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