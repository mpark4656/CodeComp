package edu.odu.cs.cs350.red2.Interface;

import edu.odu.cs.cs350.red2.Interface.*;

/**
 * This class represent each pair of students in the instructor's class
 * Once all codes are parsed, token sequences from 2 students are compared.
 * @author mpark
 */
public class StudentPair
{
	private Student student1;
	private Student student2;
	
	public StudentPair( Student student1 , Student student2 )
	{
		this.student1 = student1;
		this.student2 = student2;
	}
	
	@Override
	public boolean equals( Object obj )
	{
		return true;
	}
	
}