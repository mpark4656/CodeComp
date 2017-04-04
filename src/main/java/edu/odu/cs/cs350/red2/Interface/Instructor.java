package edu.odu.cs.cs350.red2.Interface;

import edu.odu.cs.cs350.codeCompCommon.SharedPhrases;
import edu.odu.cs.cs350.red2.FileFilter.DirectoryFilter;
import java.util.ArrayList;
import java.io.File;

/**
 * Instructor Class - 
 * This class will be responsible for invoking the methods of other interfaces 
 * and passing information from one interface to another.
 * @author mpark
 * @author nruf
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
	
	// Stores output directory path
	private File outputDirectory;
	
	/**
	 * Constructor - 
	 * The submission directory will be obtained via acceptStudentSubmissions(), 
	 * so it's not one of the parameters of this constructor.
	 * 
	 * @param String template specified by user
	 * @param String sheetname specified by user
	 * @param File directory where output files should be written to
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
		
		outputDirectory = new File( outputSpreadsheet );
		
		template = "";
		sheetName = "";
	}
	
	/**
	 * Public Accessor method that returns true if a specific template is set.
	 * @return boolean Return true if user specified template.
	 */
	public boolean isTemplateSpecified()
	{
		return templateSpecified;
	}
	
	/**
	 * Public Accessor method that returns true if a specific sheetname is set.
	 * @return boolean Return true if user specified sheet name.
	 */
	public boolean isSheetNameSpecified()
	{
		return sheetNameSpecified;
	}
	
	/**
	 * Public Accessor method that returns template name as String
	 * @return String Name of user-specified template
	 */
	public String getTemplate()
	{
		return template;
	}
	
	/**
	 * Public Accessor method that returns sheet name as String
	 * @return String Name of user-specified sheet name
	 */
	public String getSheetName()
	{
		return sheetName;
	}
	
	/**
	 * Public Mutator method for setting the template
	 * @param String Template name
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
	 * @param String Sheet name
	 */
	public void setSheetName( String sheetName )
	{
		this.sheetName = sheetName;
		
		sheetNameSpecified = true;
	}
	
	/**
	 * Public Accessor Method that returns true if this instructor received student
	 * submissions
	 * @return boolean Return true if this instructor accepted student submissions
	 */
	public boolean isSubmissionReceived()
	{
		return receivedSubmissions;
	}
	
	/**
	 * Public Accessor method that returns true if student codes have been parsed
	 * @return boolean Return true if submissions were parsed.
	 */
	public boolean isSubmissionParsed()
	{
		return parsedStudentSubmissions;
	}
	
	/**
	 * Public Accessor method that returns true if Token Sequences have been analyzed
	 * @return boolean Return true if raw scores and z-scores 
	 * have been calculated
	 */
	public boolean isTokenSequenceAnalyzed()
	{
		return analyzedTokenSequences;
	}
	
	/**
	 * Return Student object for the given identifier.
	 * @param String identifier
	 * @return Student student object that corresponds to the given identifier - 
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
		
		// Student Identifier Not Found, return null.
		return null;
	}
	
	/**
	 * Public Accssor method to return the total number of students
	 * @return int Total Number of Students
	 */
	public int getTotalStudentCount()
	{
		return students.size();
	}
	
	/**
	 * Public Accssor method to return the total number of student pairs
	 * @return int Total Number of Student Pairs
	 */
	public int getTotalStudentPairCount()
	{
		return stuPairs.size();
	}
	
	/**
	 * Add each student and student pairs and set receivedSubmissions to true.
	 * Then, process the data and analyze them.
	 * @param File submissionDirectory
	 * @pre receivedSubmissions == false
	 * @post receivedSubmissions == true
	 * @return boolean Return true if the submissions were successfully received.
	 */
	public boolean acceptStudentSubmissions( File submissionDirectory )
	{
		// If this instructor already received submissions, return true.
		if( receivedSubmissions ) {
			return true;
		}
		
		// If this is not a directory/folder, return.
		if( !submissionDirectory.isDirectory() ) {
			return false;
		}
		
		// Store a list of files in the submission directory
		// Apply the Directory Filter to ignore any non-directory files.
		File[] directoryFiles = submissionDirectory.listFiles(new DirectoryFilter());
				
		// Iterate through all files in the parent directory. 
		for( int i = 0 ; i < directoryFiles.length ; i++ ) {
			
			// Get the folder name
			// Examples:
			// Mike.1
			// Mike
			// Mike.2
			String folderName = directoryFiles[i].getName();
			//System.out.println( "Debugging: The folder name is " + folderName );
			
			// Get the identifier
			// Example:
			// Mike
			String id = "";
			
			// If the folder name contains . get the substring (Only the identifier portion)
			if( folderName.contains(".") ) {
				id = folderName.substring( 0, folderName.indexOf('.') );
			}
			// If the folder name does not contain . the entire string is identifier.
			else {
				id = folderName;
			}
			
			//System.out.println( "Debugging: The id is " + id );
			
			// Check to see if this student already exists in the collection
			if( getStudent(id) != null ) { // Student ID already exists
				
				// Since ID already exists, find the student and add this submission
				for( int j = 0 ; j < students.size(); j++ ) {
					if( students.get(j).toString().equals(id) ) {
						students.get(j).addSubmission( directoryFiles[i] );
					}
				}
			}
			// This is a student with new ID, add it to the collection and then add submission
			// Also, add Student Pair
			else {

				Student newStudent = new Student( id );
				
				newStudent.addSubmission( directoryFiles[i] );
				
				for( int index = 0 ; index < students.size() ; index++) {
					stuPairs.add( new StudentPair(newStudent , students.get(index)) );
				}

				students.add( newStudent );
			}
		}
		
		// Debugging Output
		/*
		for( int i = 0 ; i < students.size(); i++ ) {
			System.out.println( "Debugging: Student " + (i + 1) + ": " + students.get(i).toString() );
		}
		*/
		
		receivedSubmissions = true;
		return receivedSubmissions;
	}
	
	/**
	 * Public method to print feedback output for user
	 * @pre receivedSubmissions == true
	 */
	public void outputFeedback()
	{
		// Uh-Oh
		if( !receivedSubmissions ) {
			return;
		}
		
		// Sort student objects, so the identifiers appear in ascending order.
		students.sort( null );
		
		// Print a newline
		System.out.println();
		
		// Iterate through every student in this instructor's class
		for (int i = 0; i < students.size(); i++)
		{
			// The number of lines and the number of files can be obtained by invoking
			// getTotalCodeFileCount() and getTotalCodeLineCount() on each student object.
			System.out.print( students.get(i) + "\t\tFiles: " + students.get(i).getTotalCodeFileCount() );
			System.out.println( "\t\t" + "LOC: " + students.get(i).getTotalCodeLineCount() );															
		}				
	}
	
	/**
	 * "Tokenize" all codes in each student submission.
	 * @pre receivedSubmission == true && parsedStudentSubmissions == false
	 * @post parsedStudentSubmissions == true;
	 * @return boolean Return true if the submissions were successfully parsed.
	 */
	public boolean process()
	{
		// If the submissions are already parsed, return true
		if( parsedStudentSubmissions == true ) {
			return true;
		}
		
		// Iterate through all students
		for( int i = 0 ; i < students.size(); i++ ) {
			
			// If a student submission fails to tokenize, return false/
			if( !students.get(i).getPrioritySubmission().tokenize() ) {
				return false;
			}
		}
		
		// Debugging Output
		/*
		System.out.println();
		for( Student stud : students ) {
			System.out.println( stud.toString() + "\nToken Length: " + stud.getTokenSequenceLength() );
			System.out.println( stud.getTokenSequence() );
			System.out.println();
		}
		*/
		
		// If the control reaches here, that means all student submissions were successfully
		// parsed.
		parsedStudentSubmissions = true;
		return parsedStudentSubmissions;
	}
	
	/**
	 * Analyze similarity and calculate the raw scores and the z-scores.
	 * @pre parsedStudentSubmissions == true && analyzedTokenSequence == false
	 * @post analysedTokenSequences == true
	 * @return boolean Return true if the token sequences were 
	 * successfully analyzed.
	 */
	public boolean analyze()
	{
		// If this instructor already analyzed token sequences, return true
		if( analyzedTokenSequences ) {
			return true;
		}
		
		// Sort the student pairs
		stuPairs.sort( null );
		
		// Create SharedPhrases object - this will store token sequences of all students
		SharedPhrases phrases = new SharedPhrases();
		
		// Add each student's token sequence to phrases
		for( Student stud : students ) {
			phrases.addSentence( stud.getTokenSequence().toString() , stud.toString() );
		}
		
		// Debugging Output
		System.out.println();
		
		// Iterate through every student pair and calculate the raw score
		// Formula for T: len(p) / (k - 1)^2
		//  , where p is a shared phrase and k is the total number of students sharing the phrase
		for( StudentPair studPair : stuPairs ) {
			double T = 0;
			
			// Calculate T
			for( CharSequence phrase : phrases.allPhrases() ) {
				if( phrases.sourcesOf(phrase.toString()).contains(studPair.getFirstStudentName()) && 
					phrases.sourcesOf(phrase.toString()).contains(studPair.getSecondStudentName()) ) {
					
					int k = phrases.sourcesOf(phrase.toString()).size();
					double toAdd = phrase.length() / Math.pow( (k - 1), 2.0 );
					T = T + toAdd;
				}
			}
			
			studPair.calculateRawScore( T );
			
			// Debugging Output
			System.out.println( studPair + " has a raw score of " + studPair.getRawScore() );
		}
		
		double rawScoreAverage = calculateRawScoreAverage();
		
		// Debugging Output
		System.out.println();
		
		// Iterate through every student pair and calculate the z-score
		for( StudentPair studPair : stuPairs ) {
			studPair.calculateZScore( rawScoreAverage , calculateStandardDev( rawScoreAverage ) );
			
			// Debugging Output
			System.out.println( studPair + " has a z-score of " + studPair.getZScore() );
		}
		
		analyzedTokenSequences = true;
		return analyzedTokenSequences;
	}
	
	/**
	 * Private method to calculate the average of raw scores
	 * @pre StudentPair object must have the raw score calculated
	 * @return double average of raw scores
	 */
	private double calculateRawScoreAverage()
	{
		double rawScoreAverage = 0;
		
		for( StudentPair studPair : stuPairs ) {
			rawScoreAverage += studPair.getRawScore();
		}
		
		rawScoreAverage = rawScoreAverage / stuPairs.size();
		
		return rawScoreAverage;
	}
	
	/**
	 * Private method to calculate the standard deviation, 
	 * Formula: sqrt( sum( (average - individualScore)^2 ) / TotalCount ) 
	 * @pre StudentPair object must have the raw score calculated
	 * @param averageRawScore double average of the raw scores
	 * @return double Standard Deviation
	 */
	private double calculateStandardDev( double averageRawScore )
	{
		double standardDeviation = 0;
		double sigma = 0;
		
		// Iterate through every student pair and calculate the standard deviation
		for( StudentPair studPair : stuPairs ) {
			sigma += Math.pow( studPair.getRawScore() - averageRawScore , 2.0 );
		}
		
		standardDeviation = Math.sqrt( sigma / stuPairs.size() );
		
		return standardDeviation;
	}
	
	/**
	 * Generate and write result tables
	 * @pre analyzedTokenSequence == true
	 */
	public void displayResult()
	{
		// Not yet implemented
	}
	
	/**
	 * Private method that writes results to Excel spreadsheet
	 */
	private void writeToFile()
	{
		// Not yet implemented
	}
	
	/**
	 * Override toString() method, return the output directory name
	 * @return String output directory name
	 */
	@Override
	public String toString()
	{
		return outputDirectory.getName();
	}
	
	
} // End of Instructor Class



