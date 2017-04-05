package edu.odu.cs.cs350.red2.FileFilter;

import java.io.*;

/**
 * <pre>
 * A helper class that filters out any paths that are not referencing
 * a directory. It will only scan folders in a parent directory and any files
 * will be ignored.
 * </pre>
 */
public class DirectoryFilter implements FileFilter
{
	/**
	 * Accept only the file paths that are folders.
	 * @param filePath File
	 * @return <b>boolean</b> - Return true if the file path is a directory.
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