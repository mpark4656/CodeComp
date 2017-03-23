package edu.odu.cs.cs350.red2.Interface;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.odu.cs.cs350.red2.FileFilter.CodeFileFilter;

/**
 * Submission Class - 
 * Represents individual submission by students - 
 * Stores token sequence.
 * @author mpark
 * @author nruf
 */
public class Submission implements Comparable<Submission>
{
	// The submission directory
	private File directory;
	
	// These are non-directory files
	private ArrayList<File> allFiles;
	private ArrayList<File> codeFiles;
	
	// Collection of Token Sequences for each function block in the code files
	private ArrayList<TokenSequence> tSeq;
	
	// A flag to indicate if this submission has been tokenized (Parsed)
	private boolean tokenized;
	
	/**
	 * Calls private method, searchAllFiles to recursively search all
	 * files in the given directory and add each file to the collection.
	 * @param File directory
	 */
	public Submission( File directory )
	{
		this.directory = directory;
		allFiles = new ArrayList<File> ();
		codeFiles = new ArrayList<File> ();
		tSeq = new ArrayList<TokenSequence>();
		tokenized = false;
		searchAllFiles( this.directory );
		searchAllCodeFiles( this.directory );
	}
	
	/**
	 * Recursively search all files in directory and add each file
	 * to allFiles.
	 */
	private void searchAllFiles( File dir )
	{
		// Search for all files
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
	 * Recursively search all code files in directory and add each file
	 * to codeFiles.
	 */
	private void searchAllCodeFiles( File dir )
	{
		// Search for code files only by applying CodeFileFilter
		for( int i = 0 ; i < dir.listFiles( new CodeFileFilter() ).length ; i++ ) {
			if( dir.listFiles(new CodeFileFilter())[i].isDirectory() ) {
				searchAllCodeFiles( dir.listFiles(new CodeFileFilter())[i] );
			}
			else {
				codeFiles.add( dir.listFiles(new CodeFileFilter())[i] );
			}
		}
	}
	
	/**
	 * Public method to print the names of all files in this submission - 
	 * This is mostly for testing and debugging
	 */
	public void printAllFiles()
	{
		System.out.println( "\nList of All Files in " + this.toString() );
		
		for( int i = 0 ; i < allFiles.size(); i++ ) {
			System.out.println( allFiles.get(i).getName() );
		}
	}
	
	/**
	 * Public method to print the names of all code files in this submission - 
	 * This is mostly for testing and debugging
	 */
	public void printCodeFiles()
	{
		System.out.println( "\nList of All Code Files in " + this.toString() );
		
		for( int i = 0 ; i < codeFiles.size(); i++ ) {
			System.out.println( codeFiles.get(i).getName() );
		}
	}
	
	/**
	 * Public accessor that returns all files in ArrayList
	 * @return ArrayList<File> All files in this submission
	 */
	public ArrayList<File> getAllFiles()
	{
		return allFiles;
	}
	
	/**
	 * Public accessor that returns all code files in ArrayList
	 * @return ArrayList<File> All code files in this submission
	 */
	public ArrayList<File> getCodeFiles()
	{
		return codeFiles;
	}
	
	/**
	 * Private method to return the file extension for the given
	 * file path.
	 * For example, test.java would return "java"
	 * @param File filePath
	 * @return String File extension
	 */
	private String getExtension( File filePath )
	{
		// Get the file name from filePath
		String filename = filePath.getName();
		
		// Return the extension
		return filename.substring( filename.lastIndexOf('.') + 1 );
	}
	
	/**
	 * Parse this submission and produce the token sequence.
	 * @return boolean True if this submission  was successfully parsed.
	 */
	public boolean tokenize()
	{
		// Not yet implemented
		
		tokenized = true;
		return tokenized;
	}
	
	/**
	 * Return true if this submission has been parsed and token sequence 
	 * has been generated.
	 * @return boolean True if this submission has been parsed 
	 */
	public boolean isTokenized()
	{
		return tokenized;
	}
	
	/**
	 * Return the length of all token sequences in this submission
	 * @return int Length of All Token Sequences
	 */
	public int getTokenSequenceLength()
	{
		// Not yet implemented
		return 0;
	}
	
	/**
	 * Return the number of LOC in all code files in this submission
	 * @return int The number of code lines in all code files
	 */
	public int getNumCodeLines()
	{
		// Counter variable
		int total = 0;
		
		// Iterate through all code files in this submission
		for( int i = 0 ; i < codeFiles.size() ; i++ ) {
			
			// Create FileReader initialize to null
			FileReader freader = null;
			
			// Instantiate FileReader with the current code file.
			// FileReader constructor throws exception that needs to be handled.
			try {
				freader = new FileReader( codeFiles.get(i) );
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Instantiate BufferedReader with the FileReader
			BufferedReader buffer = new BufferedReader( freader );
			
			// Read the file one line at a time, keeping a count
			// readLine() may throw exception.
			try {
				while( buffer.readLine() != null ) {
					total++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Return the count
		return total;
	}
	
	/**
	 * Return the number of code files in this submission.
	 * @return int Number of Code Files in this submission
	 */
	public int getNumCodeFiles()
	{
		return codeFiles.size();
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
	 * @return String Name of the Submission Directory
	 */
	@Override
	public String toString()
	{
		return directory.getName();
	}
}