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
	private boolean sheetNameSpecified;
	
	// Unless user provided optional arguments, these are empty strings
	private String template;
	private String sheetName;
	
	// These boolean variables will serve as preconditions for some methods
	// These should be initialized to false when Instructor is first instantiated
	private boolean receivedSubmissions;
	private boolean parsedStudentSubmissions;
	private boolean analyzedTokenSequences;
	
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
		students = new ArrayList<Student> ();
		stuPairs = new ArrayList<StudentPair> ();
		
		templateSpecified = false;
		sheetNameSpecified = false;
		
		receivedSubmissions = false;
		parsedStudentSubmissions = false;
		analyzedTokenSequences = false;
		
		template = "";
		sheetName = "";
	}
	
	/**
	 * Public Accessor method that returns true if a specific template is set.
	 * @return templateSpecified boolean Return true if user specified template.
	 */
	public boolean isTemplateSpecified()
	{
		return templateSpecified;
	}
	
	/**
	 * Public Accessor method that returns true if a specific sheetname is set.
	 * @return sheetNameSpecified boolean Return true if user specified sheet name.
	 */
	public boolean isSheetNameSpecified()
	{
		return sheetNameSpecified;
	}
	
	/**
	 * Public Accessor method that returns template name as String
	 * @return template String Name of user-specified template
	 */
	public String getTemplate()
	{
		return template;
	}
	
	/**
	 * Public Accessor method that returns sheet name as String
	 * @return sheetName String Name of user-specified sheet name
	 */
	public String getSheetName()
	{
		return sheetName;
	}
	
	/**
	 * Public Mutator method for setting the template
	 * @param template String
	 * @pre templateSpecified == false
	 * @post templateSpecified == true
	 */
	public void setTemplate( String template )
	{
		this.template = template;
		
		templateSpecified = true;
	}
	
	/**
	 * Public Mutator method for setting the raw sheetname
	 * @param sheetname String
	 */
	public void setSheetName( String sheetName )
	{
		this.sheetName = sheetName;
		
		sheetNameSpecified = true;
	}
	
	/**
	 * Public Accessor Method that returns true if this instructor received student
	 * submissions
	 * @return
	 */
	public boolean isSubmissionReceived()
	{
		return receivedSubmissions;
	}
	
	/**
	 * Public Accessor method that returns true if student codes have been parsed
	 * @return parsedStudentSubmissions boolean Return true if submissions were parsed.
	 */
	public boolean isSubmissionParsed()
	{
		return parsedStudentSubmissions;
	}
	
	/**
	 * Public Accessor method that returns true if Token Sequences have been analyzed
	 * @return analyzedTokenSequences boolean Return true if raw scores and z-scores 
	 * have been calculated
	 */
	public boolean isTokenSequenceAnalyzed()
	{
		return analyzedTokenSequences;
	}
	
	/**
	 * Return Student object for the given identifier.
	 * @param identifier
	 * @return Student object that corresponds to the given identifier - 
	 * If not found, return null;
	 */
	public Student getStudent( String identifier )
	{
		// Iterate through Student ArrayList and find student item with the same identifier
		for( int i = 0 ; i < students.size(); i++ ) {
			// If the same identifier student obj is found, return it.
			if( students.get(i).toString().equals(identifier) ) {
				return students.get(i);
			}
		}
		
		// Student Identifier Not Found, return null or throw
		return null;
	}
	
	/**
	 * Public Accssor method to return the total number of students
	 * @return count int Total Number of Students
	 */
	public int getTotalStudentCount()
	{
		return students.size();
	}
	
	/**
	 * Public Accssor method to return the total number of student pairs
	 * @return count int Total Number of Student Pairs
	 */
	public int getTotalStudentPairCount()
	{
		return stuPairs.size();
	}
	
	/**
	 * Add each student and student pairs and set receivedSubmissions to true.
	 * Then, process the data and analyze them.
	 * @param parentDirectory
	 * @pre receivedSubmission == false
	 * @post receivedSubmissions == true
	 */
	public void acceptStudentSubmissions( File parentDirectory )
	{
		// Not yet implemented
		receivedSubmissions = true;
		
		process();
		analyze();
	}
	
	/**
	 * "Tokenize" all codes in each student submission.
	 * @pre receivedSubmission == true && parsedStudentSubmissions == false
	 * @post parsedStudentSubmissions == true;
	 */
	private void process()
	{
		// Not yet implemented
		parsedStudentSubmissions = true;
	}
	
	/**
	 * Analyze similarity and calculate the raw scores and the z-scores.
	 * @pre parsedStudentSubmissions == true && analyzedTokenSequence == false
	 * @post analysedTokenSequence == true
	 */
	private void analyze()
	{
		// Not yet implemented
		analyzedTokenSequences = true;
	}
	
	/**
	 * Generate and write result tables
	 * @pre analyzedTokenSequence == true
	 */
	public void displayResult()
	{
		// Not yet implemented
	}
	
} // End of Instructor Class



