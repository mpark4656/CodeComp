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
 * <pre>
 * Submission Class 
 * This sub-interface encapsulates the attributes of a real-life
 * code submission by students learning a programming language.
 * This sub-interface is responsible for converting codes into a sequence
 * of tokens.
 * </pre>
 */
public class Submission implements Comparable<Submission> , Cloneable
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
	 * A constructor that accepts a directory path and recursively search
	 * for all files in subdirectories.
	 * @param directory <b>File</b>
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
	 * Copy Constructor
	 * @param obj <b>Submission</b> object to copy
	 */
	@SuppressWarnings("unchecked")
	public Submission( Submission obj )
	{
		this.directory = new File( obj.directory.getPath() );
		this.allFiles = (ArrayList<File>) obj.allFiles.clone();
		this.codeFiles = (ArrayList<File>) obj.codeFiles.clone();
		this.tSeq = (ArrayList<TokenSequence>) obj.tSeq.clone();
		this.tokenized = obj.tokenized;
	}
	
	/**
	 * Recursively search all files in directory and add each file to this submission
	 * @param dir <b>File</b>
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
	 * Recursively search for all code files in directory
	 * @param dir <b>File</b>
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
	 * Public method that returns all files as ArrayList&lt;File&gt;
	 * @return <b>ArrayList&lt;File&gt;</b> - All files in this submission
	 */
	public ArrayList<File> getAllFiles()
	{
		return allFiles;
	}
	
	/**
	 * Public method that returns all code files as ArrayList&lt;File&gt;
	 * @return <b>ArrayList&lt;File&gt;</b> - All code files in this submission
	 */
	public ArrayList<File> getCodeFiles()
	{
		return codeFiles;
	}
	
	/**
	 * <pre>
	 * Private method to return the file extension for the given file path.
	 * For example, for "test.java", this method would return "java".
	 * @param filePath <b>File</b>
	 * @return <b>String</b> - File extension
	 */
	private String getExtension( File filePath )
	{
		String filename = filePath.getName();
		
		return filename.substring( filename.lastIndexOf('.') + 1 );
	}
	
	/**
	 * <pre>
	 * Parse this submission and produce the token sequence.
	 * 
	 * Precondition: tokenized == false
	 * Postcondition: tokenized == true
	 * </pre>
	 * @return <b>boolean</b> - Return true if this submission has been successfully parsed
	 */
	public boolean tokenize()
	{
		// If this submission has been tokenized already, return true.
		if( tokenized ) {
			return true;
		}
		
		for( File file : codeFiles ) {
			// Temporary storage for token sequence
			TokenSequence tokenSeq = null;

			BufferedReader bReader = null;
			
			try {
				bReader = new BufferedReader( new FileReader(file) );
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			StringBuilder strBuilder = new StringBuilder();
			String ls = System.getProperty( "line.separator" );
			String line = null;
			
			if( getExtension(file).equals("java") ) {
				try {
					while( (line = bReader.readLine()) != null ) {
						strBuilder.append( line );
						strBuilder.append( ls );
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				Reader readerInput = new StringReader( strBuilder.toString() );
				tokenSeq = new TokenSequence( readerInput , LanguageTypes.JAVA );
				
				// Debugging Output Lines - Must be removed later
				//System.out.println();
				//System.out.println( "\nTokens found in " + file.getName() );
				//System.out.println( "A total of " + tokenSeq.getTokenCount() + " tokens found in this file." );
				//System.out.print( tokenSeq.getTokenSequence() );
				//System.out.println();
			}
			// The code file is C++ if it is not java
			else {
				try {
					while( (line = bReader.readLine()) != null ) {
						strBuilder.append( line );
						strBuilder.append( ls );
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				Reader readerInput = new StringReader( strBuilder.toString() );
				tokenSeq = new TokenSequence( readerInput , LanguageTypes.CPLUSPLUS );
				
				// Debugging Output Lines - Must be removed later
				//System.out.println();
				//System.out.println( "\nTokens found in " + file.getName() );
				//System.out.println( "A total of " + tokenSeq.getTokenCount() + " tokens found in this file." );
				//System.out.print( tokenSeq.getTokenSequence() );
				//System.out.println();
			}
			
			tSeq.add( tokenSeq );
		}
		
		tokenized = true;
		return tokenized;
	}
	
	/**
	 * Return true if this submission has been parsed and token sequence has been generated.
	 * @return <b>boolean</b> - Return true if this submission has been parsed 
	 */
	public boolean isTokenized()
	{
		return tokenized;
	}
	
	/**
	 * Return the length of all token sequences in this submission
	 * @return <b>int</b> - Length of all token Sequences
	 */
	public int getTokenCount()
	{
		int total = 0;
		
		for( TokenSequence seq : this.tSeq ) {
			total += seq.getTokenCount();
		}
		
		return total;
	}
	
	/**
	 * <pre>
	 * Return the token sequences of this submission as StringBuilder. 
	 * This method combines token sequences from all code files.
	 * </pre>
	 * @return <b>StringBuilder</b> - Combined token sequence
	 */
	public StringBuilder getTokenSequence()
	{
		StringBuilder result = new StringBuilder();
		
		for( TokenSequence seq : tSeq ) {
			result.append( seq.getTokenSequence() );
		}
		
		return result;
	}
	
	/**
	 * Return the number of LOC in all code files in this submission
	 * @return <b>int</b> - The number of code lines
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
				e.printStackTrace();
			}
		}
		
		// Return the count
		return total;
	}
	
	/**
	 * Return the number of code files in this submission.
	 * @return <b>int</b> - Number of code files in this submission
	 */
	public int getNumCodeFiles()
	{
		return codeFiles.size();
	}
	
	/**
	 * Override compareTo() to compare the submission directory name 
	 * @param obj <b>Submission</b>
	 * @return <b>int</b> - Value
	 */
	@Override
	public int compareTo( Submission obj )
	{
		return this.toString().compareTo( obj.toString() );
	}
	
	/**
	 * Return the submission directory name
	 * @return <b>String</b> - Submission directory name
	 */
	@Override
	public String toString()
	{
		return directory.getName();
	}
	
	/**
	 * <pre>
	 * Override equals() method, 
	 * Two submissions are equal if they both point to the same submission directory
	 * </pre>
	 * @param obj <b>Object</b>
	 * @return <b>boolean</b> - Return true if the two objects are equal
	 */
	@Override
	public boolean equals( Object obj )
	{
		if( obj == null ) {
			return false;
		}
		
		if( !(obj instanceof Submission) ) {
			return false;
		}
		
		if( this == obj ) {
			return true;
		}
		
		Submission thatObj = (Submission) obj;
		
		return this.directory.getAbsolutePath().equals( thatObj.directory.getAbsolutePath() ) &&
			   this.tokenized == thatObj.tokenized &&
			   this.allFiles.equals( thatObj.allFiles ) &&
			   this.codeFiles.equals( thatObj.codeFiles ) &&
			   this.tSeq.equals( thatObj.tSeq );
	}
	
	/**
	 * Override clone() method
	 * @return <b>Object</b> - A deep copy of this object
	 */
	@Override
	public Object clone()
	{
		return new Submission( this );
	}
	
	/**
	 * Override hashCode() method
	 * @return <b>int</b> - The hash code of this object
	 */
	@Override
	public int hashCode()
	{
		int result = 11;
		
		if( this.directory != null ) {
			result = 37 * result + directory.hashCode();
		}
		else {
			result = 37 * result + 0;
		}
		
		if( this.allFiles != null ) {
			result = 37 * result + allFiles.hashCode();
		}
		else {
			result = 37 * result + 0;
		}
		
		if( this.codeFiles != null ) {
			result = 37 * result + codeFiles.hashCode();
		}
		else {
			result = 37 * result + 0;
		}
		
		if( this.tSeq != null ) {
			result = 37 * result + tSeq.hashCode();
		}
		else {
			result = 37 * result + 0;
		}
		
		result = 37 * result + ( this.tokenized ? 0 : 1 );
		
		return result;
	}
}



