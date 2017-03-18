package edu.odu.cs.cs350.red2.Interface;

import java.util.ArrayList;
import java.io.File;

/**
 * Student Class -
 * Contains code submissions that belong to this student and unique identifier.
 * @author mpark
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
	 * @param identifier
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
	 * Return the object of the Submission that "counts" and will
	 * be graded.
	 * @return prioritySub Submission priority Submission object
	 */
	public Submission getPrioritySubmission()
	{
		// Sort the submissions
		// Example: If we have Mike.1 Mike Mike.2
		// Sorted items would look like
		// Mike Mike.1 Mike.2
		submissions.sort( null );
<<<<<<< HEAD
		for (int i = 0; i < submissions.size();i++)
		{
			if !(submissions[i] contains("."))
			{
				return submissions[i];
=======
	
		for( int i = 0 ; i < submissions.size() ; i++ ) {
			if( !submissions.get(i).toString().contains(".") ) {
				return submissions.get(i);
>>>>>>> 90f2decb609b560a59501bf95a6da2af6e1cf4c9
			}
		}
		
		// Return the last element.
		return submissions.get(submissions.size() - 1);
		
	} // End of getPrioritySubmission()
	
	
	/**
	 * Return the total number of code file count in the priority submission.
	 * @return count int Total number of Code Files this student submitted
	 */
	public int getTotalCodeFileCount()
	{
		return 0;
	}
	
	/**
	 * Return the total number of lines of code in the priority submission
	 * @return count int Total number of lines of code
	 */
	public int getTotalCodeLineCount()
	{
		return 0;
	}
	
	/**
	 * Override the equals method from java.lang.Object
	 * @return True boolean true if toCompare equals this Student object
	 */
	@Override
	public boolean equals( Object theStudent )
	{
		return this.toString().equals(theStudent.toString());
	}
	
	/**
	 * Compare this contact to another.
	 * @return val int value > 0 if this contact precedes the other,
	 * == 0 if the two are equal, and < 0 if this contact
	 * follows the other.  
	 */
	@Override
	public int compareTo( Student theStudent )
	{
<<<<<<< HEAD
		
=======
		return this.identifier.compareTo( theStudent.identifier );
>>>>>>> 90f2decb609b560a59501bf95a6da2af6e1cf4c9
	}
	
	/**
	 * Return the unique identifier as String
	 * @return id String identifier
	 */
	@Override
	public String toString()
	{
		return identifier;
	}
	
} // End of Student



