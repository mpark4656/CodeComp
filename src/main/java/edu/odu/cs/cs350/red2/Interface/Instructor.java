package edu.odu.cs.cs350.red2.Interface;

import java.util.ArrayList;
import java.io.File;

/**
 * Instructor Class - 
 * This class will be responsible for invoking the methods of other interfaces 
 * and passing information from one interface to another.
 * @author mpark
 */
public class Instructor
{
	// List of all students in this instructor's class
	private ArrayList<Student>  students;
	
	// List of all possible Student Pairs
	private ArrayList<StudentPair> stuPairs;
	
	// Check command-line arguments
	private boolean templateSpecified;
	private boolean sheetnameSpecified;
	
	// Unless user provided optional arguments, these are empty strings
	String template;
	String sheetname;
	
	// These boolean variables will serve as preconditions for some methods
	// These should be initialized to false when Instructor is first instantiated
	private boolean receivedSubmissions;
	private boolean parsedStudentSubmissions;
	private boolean analyzedTokenSequence;
	
	/**
	 * Constructor - 
	 * The submission directory will be obtained via acceptStudentSubmissions(), 
	 * so it's not one of the parameters of this constructor.
	 * 
	 * @param template String template specified by user
	 * @param sheetname String sheetname specified by user
	 * @param outputSpreadsheet File directory where output files should be written to
	 */
	public Instructor( String outputSpreadsheet)
	{
		
	}
	
	/**
	 * Mutator method for setting the template
	 * @param template String
	 */
	public void setTemplate( String template )
	{
		
	}
	
	/**
	 * Mutator method for setting the raw sheetname
	 * @param sheetname String
	 */
	public void setSheetName( String sheetname )
	{
		
	}
	
	/**
	 * Return Student object for the given identifier.
	 * @param identifier
	 * @return Student object that corresponds to the given identifier
	 */
	public Student getStudent( String identifier )
	{
		return null;
	}
	
	/**
	 * Add each student and student pairs and set receivedSubmissions to true.
	 * @param parentDirectory
	 * @pre receivedSubmission == false
	 * @post receivedSubmissions == true
	 */
	public void acceptStudentSubmissions( File parentDirectory )
	{
		// Before doing anything else, ensure that parentDirectory is actually a folder not a file.
	}
	
	/**
	 * "Tokenize" all codes in each student submission.
	 * @pre receivedSubmission == true && parsedStudentSubmissions == false
	 * @post parsedStudentSubmissions == true;
	 */
	public void process()
	{
		
	}
	
	/**
	 * Analyze similarity and calculate the raw scores and the z-scores.
	 * @pre parsedStudentSubmissions == true && analyzedTokenSequence == false
	 * @post analysedTokenSequence == true
	 */
	public void analyze()
	{
		
	}
	
	/**
	 * Generate and write result tables
	 * @pre analyzedTokenSequence == true
	 */
	public void displayResult()
	{
		
	}
	
} // End of Instructor Class



