package edu.odu.cs.cs350.red2.Interface;

import java.util.ArrayList;
import java.io.File;

/**
 * Student Class -
 * Contains code submissions that belong to this student and unique identifier.
 * @author mpark
 */
public class Student implements Cloneable, Comparable<Student>
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
	}
	
	/**
	 * Recursively search the submission directory for all files
	 * @param submissionDirectory File the submission directory
	 * @pre submissionDirectory.isDirectory() == true
	 */
	public void addSubmission( File submissionDirectory )
	{
		
	}
	
	/**
	 * Return the object of the Submission that "counts" and will
	 * be graded.
	 * @return prioritySub Submission priority Submission object
	 */
	public Submission getPrioritySubmission()
	{
		submissions.sort( null );
		for (int i = 0; i < submissions.size();i++)
		{
			if !(submissions contains("."))
			{
				return submissions[0];
			}
			
				
		}
		
		return submissions[submissions.size() - 1];
		
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
	 * Override the hashCode method from java.lang.Object
	 */
	@Override
	public int hashCode()
	{
		return 0;
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
	
	}
	
	/**
	 * Return the unique identifier as String
	 * @return id String identifier
	 */
	@Override
	public String toString()
	{
		return null;
	}
	
	/**
	 * Clone this object
	 * @return this Object cloned object
	 */
	@Override
	public Object clone()
	{
		return null;
	}
	
} // End of Student



