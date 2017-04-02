package edu.odu.cs.cs350.red2.Interface;

import edu.odu.cs.cs350.red2.LexicalTools.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import edu.odu.cs.cs350.red2.FileFilter.CodeFileFilter;
import edu.odu.cs.cs350.red2.LexicalTools.TokenSequence;

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
	
	// Collection of Token Sequences for each code file
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
		String filename = filePath.getName();
		
		return filename.substring( filename.lastIndexOf('.') + 1 );
	}
	
	/**
	 * Parse this submission and produce the token sequence.
	 * @return boolean True if this submission  was successfully parsed.
	 */
	public boolean tokenize()
	{
		for( File file : codeFiles ) {
			if( getExtension(file).equals("java") ) {
				
				StringBuilder strBuilder = new StringBuilder();
				
				try {
					BufferedReader bReader = new BufferedReader( new FileReader(file) );
					
					String ls = System.getProperty("line.separator");
					String line = null;
					
					try {
						while( (line = bReader.readLine()) != null ) {
							strBuilder.append( line );
							strBuilder.append( ls );
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Reader readerInput = new StringReader( strBuilder.toString() );
				TokenSequence tokenSeq = new TokenSequence( readerInput , LanguageTypes.JAVA );
				
				// Debugging Output
				System.out.println();
				System.out.println( "\nTokens found in " + file.getName() );
				System.out.println( "A total of " + tokenSeq.getTokenCount() + " tokens found in this file." );
				for( Token t : tokenSeq ) {
					System.out.print( t.getTokenType() );
				}
				
				tSeq.add( tokenSeq );
			}
			// The code file is C++ if it is not java
			else {
				// TODO To be implemented
			}
		}
		
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
		int total = 0;
		
		for( TokenSequence tSeq : this.tSeq ) {
			total += tSeq.getTokenCount();
		}
		
		return total;
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
				
				// Close the BufferedReader
				buffer.close();
				
				// Close the FileReader
				freader.close();

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
	
	/**
	 * Overrides equals() method, 
	 * Two submissions are equal if they both point to the same submission directory
	 */
	@Override
	public boolean equals( Object obj )
	{
		Submission thatObj = (Submission) obj;
		
		return this.directory.getAbsolutePath().equals( thatObj.directory.getAbsolutePath() );
	}
}



