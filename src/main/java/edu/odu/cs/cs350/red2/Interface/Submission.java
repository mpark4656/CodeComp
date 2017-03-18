package edu.odu.cs.cs350.red2.Interface;

import java.util.ArrayList;
import java.io.File;

/**
 * Submission Class - 
 * Represents individual submission by students - 
 * Stores token sequence.
 * @author mpark
 */
public class Submission implements Comparable<Submission>
{
	// The submission directory
	private File directory;
	
	// These are non-directory files
	private ArrayList<File> allFiles;
	
	// Collection of Token Sequences for each function block in the code files
	private ArrayList<TokenSequence> tSeq;
	
	// A flag to indicate if this submission has been tokenized (Parsed)
	private boolean tokenized;
	
	/**
	 * Calls private method, searchAllFiles to recursively search all
	 * files in the given directory and add each file to the collection.
	 * @param directory
	 */
	public Submission( File directory )
	{
		this.directory = directory;
		allFiles = new ArrayList<File>();
		tSeq = new ArrayList<TokenSequence>();
		searchAllFiles( this.directory );
	}
	
	/**
	 * Recursively search all files in directory and add each file
	 * to allFiles.
	 */
	private void searchAllFiles( File dir )
	{
		for( int i = 0 ; i < dir.listFiles().length ; i++ ) {
			if( dir.listFiles()[i].isDirectory() ) {
				searchAllFiles( dir.listFiles()[i] );
			}
			else {
				allFiles.add( dir.listFiles()[i] );
			}
		}
	}
	
	/**
	 * Parse this submission and produce the token sequence.
	 */
	public void tokenize()
	{
		
	}
	
	/**
	 * Return true if this submission has been parsed and token sequence 
	 * has been generated.
	 * @return True boolean true if this submission has been parsed 
	 */
	public boolean isTokenized()
	{
		return false;
	}
	
	/**
	 * Not all files in the submission directory are code files - 
	 * identify code files by the file extension and return the list.
	 * @return codeFiles ArrayList<File> collection of all code files  
	 */
	public ArrayList<File> getCodeFiles()
	{
		return null;
	}
	
	/**
	 * Return ArrayList of all the files regardless of whether they
	 * are code files or not
	 * @return allFiles ArrayList<File> collection of all files
	 */
	public ArrayList<File> getAllFiles()
	{
		return null;
	}
	
	/**
	 * Return the length of all token sequences in this submission
	 * @return length int Length of All Token Sequences
	 */
	public int getTokenSequenceLength()
	{
		return 0;
	}
	
	/**
	 * Return the number of LOC in all code files in this submission
	 * @return num int number of code lines in the code files
	 */
	public int getNumCodeLines()
	{
		return 0;
	}
	
	/**
	 * Return the number of code files in this submission.
	 * @return num int Number of Code Files in this submission
	 */
	public int getNumCodeFiles()
	{
		return getCodeFiles().size();
	}
	
	/**
	 * Override the equals method from java.lang.Object
	 * @return True boolean true if toCompare equals this Submission object
	 */
	@Override
	public boolean equals( Object theSubmission )
	{
		return false;
	}
	
	/**
	 * Override the hashCode method from java.lang.Object
	 */
	@Override
	public int hashCode()
	{
		return 0;
	}
	
	/**
	 * Clone this object
	 * @return obj Object cloned object
	 */
	@Override
	public Object clone()
	{
		return null;
	}
	
	/**
	 * Compare String directory name
	 * 1. Return value < 0 if this Submission follows obj
	 * 2. Return 0 if they have the same name
	 * 3. Return value > 0 if this Submission precedes obj
	 */
	@Override
	public int compareTo( Submission obj )
	{
		return this.toString().compareTo( obj.toString() );
	}
	
	/**
	 * Return the relative path (Folder name) as String
	 * @return folderName String Name of the Submission Directory
	 */
	@Override
	public String toString()
	{
		return directory.getName();
	}
}