package edu.odu.cs.cs350.red2.Interface;

import java.util.ArrayList;
import java.io.File;


/**
 * <pre>
 * <b>Student Class</b>
 * This is serves as a sub-interface that encapsulates attributes of
 * a real-life students. A student has a unique identifier (name) and
 * his or her own code submissions.
 * </pre>
 */
public class Student implements Comparable<Student> , Cloneable
{
	// This unique identifier is the Submission directory name minus the version ID
	private String identifier;
	
	// All submissions that belong to this student
	private ArrayList<Submission> submissions;
	
	/**
	 * Instantiate a student with an identifier
	 * @param identifier <b>String</b>
	 */
	public Student( String identifier )
	{
		this.identifier = identifier;
		submissions = new ArrayList<Submission> ();
	}
	
	/**
	 * Copy Constructor
	 * @param obj <b>Student</b> Student object to copy
	 */
	@SuppressWarnings("unchecked")
	public Student( Student obj )
	{
		this.identifier = new String(obj.identifier);
		this.submissions = (ArrayList<Submission>) obj.submissions.clone();
	}
	
	/**
	 * Public method that adds a submission to ArrayList submissions
	 * @param submissionDirectory <b>File</b> The submission directory
	 */
	public void addSubmission( File submissionDirectory )
	{
		submissions.add( new Submission(submissionDirectory) );
	}
	
	/**
	 * <pre>
	 * Public method that returns a Submission object.
	 * Returns null if not found.
	 * </pre>
	 * @param subName <b>String</b>
	 * @return <b>Submission</b> Submission object
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
	 * Public method that returns the total number of submissions for this student
	 * @return <b>int</b> Total number of submissions
	 */
	public int getSubmissionCount()
	{
		return submissions.size();
	}
	
	/**
	 * <pre>
	 * Public method that returns the submission that "counts" and 
	 * will be graded.
	 * 
	 * See the Requirements Definition for rules that determine the priority submission.
	 * </pre>
	 * @see https://www.cs.odu.edu/~tkennedy/cs350/s17-tkennedy/Protected/codecompProject/index.html
	 * @return <b>Submission</b> The priority submission
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
	 * Public method that returns the total number of code files in the priority submission.
	 * @return <b>int</b> - Total number of code files
	 */
	public int getTotalCodeFileCount()
	{
		return getPrioritySubmission().getNumCodeFiles();
	}
	
	/**
	 * Public method that returns the total number of LOC in the priority submission
	 * @return <b>int</b> - Total number of lines of code
	 */
	public int getTotalCodeLineCount()
	{
		return getPrioritySubmission().getNumCodeLines();
	}
	
	/**
	 * Public method that returns the token sequence from the priority submission
	 * @return <b>StringBuilder</b> - Token Sequence
	 */
	public StringBuilder getTokenSequence()
	{
		return getPrioritySubmission().getTokenSequence();
	}
	
	/**
	 * Public method that returns the length of the token sequence from the
	 * priority submission
	 * @return <b>int</b> length
	 */
	public int getTokenSequenceLength()
	{
		return getTokenSequence().length();
	}
	
	/**
	 * Override equals() method
	 * @param obj <b>Object</b>
	 * @return <b>boolean</b> - Return true if the two objects are equal
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
	 * <pre>
	 * Compare this student to another student.
	 * This method will be used by default for sorting a collection
	 * of Student objects.
	 * 
	 * If this object precedes the other, return a value less than 0.
	 * If this object is equal to the other, return 0.
	 * If this object follows the other, re turn a value larger than 0.
	 * </pre>
	 * @param theStudent <b>Student</b> A non-null Student object
	 * @return <b>int</b> - value
	 */
	@Override
	public int compareTo( Student theStudent )
	{
		return this.identifier.compareTo( theStudent.identifier );
	}
	
	/**
	 * Override toString() to return the unique identifier as String
	 * @return <b>String</b> identifier
	 */
	@Override
	public String toString()
	{
		return identifier;
	}
	
	/**
	 * Override hashCode() method
	 * @return <b>int</b> - The hash code
	 */
	@Override
	public int hashCode()
	{
		int result = 11;
		
		if( this.identifier != null ) {
			result = 37 * result + identifier.hashCode();
		}
		else {
			result = 37 * result + 0;
		}
		
		if( this.submissions != null ) {
			result = 37 * result + submissions.hashCode();
		}
		else {
			result = 37 * result + 0;
		}
		
		return result;
	}
	
	/**
	 * Override clone() method
	 * @return <b>Object</b> - A deep copy of this object
	 */
	@Override
	public Object clone()
	{
		return new Student( this );
	}
	
	
} // End of Student



