package edu.odu.cs.cs350.red2.FileFilter;

import java.io.*;

/**
 * This is a helper class that filters out any files that is not a 
 * directory.
 * This is helpful because when the program searches the submissionDirectory,
 * it's expected that it will only scan folders only.
 * @author mpark
 */
public class DirectoryFilter implements FileFilter
{
	/**
	 * Accept only the file paths that are folders.
	 * @param filePath File
	 * @return boolean Return true if the file path is a directory.
	 */
	@Override
	public boolean accept( File filePath )
	{
		// If the file path is a directory, accept it.
		if( filePath.isDirectory() ) {
			return true;
		}
		
		// Otherwise, do not accept.
		return false;
	}
}