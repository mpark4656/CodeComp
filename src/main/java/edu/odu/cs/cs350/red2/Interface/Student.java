package edu.odu.cs.cs350.red2.Interface;

import java.util.ArrayList;
import edu.odu.cs.cs350.red2.LexicalTools.TokenSequence;
import edu.odu.cs.cs350.red2.LexicalTools.Token;
import java.io.File;


/**
 * Student Class -
 * Contains code submissions that belong to this student and unique identifier.
 * @author mpark
 * @author nruf
 */
public class Student implements Comparable<Student>
{
	// This unique identifier is the Submission directory name minus the version ID
	private String identifier;
	
	// All submissions that belong to this student
	private ArrayList<Submission> submissions;
	
	/**
	 * Constructor 
	 * Instantiates Student with the given identifier
	 * @param String identifier
	 */
	public Student( String identifier )
	{
		this.identifier = identifier;
		submissions = new ArrayList<Submission> ();
	}
	
	/**
	 * Add a submission to ArrayList<Submission> submissions
	 * @param submissionDirectory File the submission directory
	 * @pre submissionDirectory.isDirectory() == true
	 */
	public void addSubmission( File submissionDirectory )
	{
		submissions.add( new Submission(submissionDirectory) );
	}
	
	/**
	 * The accessor method to return the total number of submissions
	 * this student made.
	 * @return int Number of Submissions for this student
	 */
	public int getSubmissionCount()
	{
		return submissions.size();
	}
	
	/**
	 * Public accessor to return a submission
	 * @param String subName
	 * @return Submission Submission object for the given submission name 
	 * Return null if not found
	 */
	public Submission getSubmission( String subName )
	{
		// Iterate through submissions and find matching submission name
		for( int i = 0 ; i < submissions.size() ; i++ ) {
			if( submissions.get(i).toString().equals(subName) ) {
				return submissions.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Return the object of the Submission that "counts" and will
	 * be graded.
	 * @pre submissions.size() != 0
	 * @return Submission Priority submission object
	 */
	public Submission getPrioritySubmission()
	{
		// Sort the submissions
		// Example: If we have Mike.1 Mike Mike.2
		// Sorted items would look like
		// Mike Mike.1 Mike.2
		submissions.sort( null );

		// Iterate through the submissions and see if there is a submission
		// that does not have any version number.
		for( int i = 0 ; i < submissions.size() ; i++ ) {
			if( submissions.get(i).toString().lastIndexOf('.') == -1 ) {
				return submissions.get(i);
			}
		}
		
		// Return the last element.
		return submissions.get(submissions.size() - 1);
			
	}// End of getPrioritySubmission()
	
	/**
	 * Return the token sequences of the priority submission
	 * @return ArrayList<TokenSequence> Token Sequences from the Priority Submission
	 */
	public ArrayList<StringBuilder> getTokenSequences()
	{
		return getPrioritySubmission().getTokenSequences();
	}
	
	/**
	 * Return the total number of code file count in the priority submission.
	 * @return int Total number of Code Files this student submitted
	 */
	public int getTotalCodeFileCount()
	{
		return getPrioritySubmission().getNumCodeFiles();
	}
	
	/**
	 * Return the total number of lines of code in the priority submission
	 * @return int Total number of lines of code
	 */
	public int getTotalCodeLineCount()
	{
		return getPrioritySubmission().getNumCodeLines();
	}
	
	/**
	 * Override the equals method from java.lang.Object
	 * @return boolean True if toCompare equals this Student object
	 */
	@Override
	public boolean equals( Object obj )
	{
		if( obj == null ) {
			return false;
		}
		
		if( !(obj instanceof Student) ) {
			return false;
		}
		
		if( this == obj ) {
			return true;
		}
		
		Student otherObj = (Student) obj;
		
		return this.toString().equals(otherObj.toString());
	}
	
	/**
	 * Compare this contact to another.
	 * @return int value > 0 if this object precedes the other,
	 * == 0 if the two are equal, and < 0 if this contact
	 * follows the other.  
	 */
	@Override
	public int compareTo( Student theStudent )
	{
		return this.identifier.compareTo( theStudent.identifier );
	}
	
	/**
	 * Return the unique identifier as String
	 * @return String identifier
	 */
	@Override
	public String toString()
	{
		return identifier;
	}
	
	/**
	 * Override hashCode() method
	 * @return int hash code of String identifier
	 */
	@Override
	public int hashCode()
	{
		return identifier.hashCode();
	}
	
} // End of Student



