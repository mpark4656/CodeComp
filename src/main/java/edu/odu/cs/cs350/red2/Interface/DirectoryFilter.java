package edu.odu.cs.cs350.red2.Interface;

import java.io.*;

/**
 * This is a helper class that filters out any files that is not a 
 * directory.
 * @author mpark
 */
public class DirectoryFilter implements FileFilter
{
	/**
	 * Accept only the file paths that are folders.
	 * @return boolean Return true if the file path is a directory.
	 */
	@Override
	public boolean accept( File filePath )
	{
		if( filePath.isDirectory() ) {
			return true;
		}
		
		return false;
	}
}