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
	
	//Global line count variable for counting lines.
	//may or may not be necessary depending on where files are being counted
	private int lineCount;
	private int filesCount;
	
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
	 * @return receivedSubmission boolean Return true if the submissions were successfully received.
	 */
	public boolean acceptStudentSubmissions( File parentDirectory )
	{
		// If this is not a directory/folder, return.
		if( !parentDirectory.isDirectory() ) {
			return false;
		}
		
		// Iterate through all files in the parent directory. Apply the Directory Filter to ignore
		// any non-directory files.
		for( int i = 0 ; i < parentDirectory.listFiles(new DirectoryFilter()).length ; i++ ) {
			
		}
		
		receivedSubmissions = true;
		return receivedSubmissions;
	}
	
	/**
	 * Public method to print feedback output for user
	 * @pre receivedSubmissions == true
	 */
	public void outputFeedback()
	{	//need to complete other functions before this is viable
		//just essentially pseudocoding for now
		//just starting this function,NRUF
		
		//stuList needs to be set to the list of students parsed
		private int stuList = 5
		for (int i = 0; i < stuList; i++)
		{
			//student name variable replace "student"
			//filesCount and lineCount need to be appropriately assigned.
		System.out.println("student\t" + "files:  " + filesCount + "\t" + "LOC  " + lineCount);
																		
		}				
		
		
		
	}
	
	/**
	 * "Tokenize" all codes in each student submission.
	 * @pre receivedSubmission == true && parsedStudentSubmissions == false
	 * @post parsedStudentSubmissions == true;
	 * @return parsedStudentSubmission boolean Return true if the submissions were successfully parsed.
	 */
	public boolean process()
	{
		// Not yet implemented
		parsedStudentSubmissions = true;
		return parsedStudentSubmissions;
	}
	
	/**
	 * Analyze similarity and calculate the raw scores and the z-scores.
	 * @pre parsedStudentSubmissions == true && analyzedTokenSequence == false
	 * @post analysedTokenSequence == true
	 * @return analyzedTokenSequences boolean Return true if the token sequences were 
	 * successfully analyzed.
	 */
	public boolean analyze()
	{
		// Not yet implemented
		analyzedTokenSequences = true;
		return analyzedTokenSequences;
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



