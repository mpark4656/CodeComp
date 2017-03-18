package edu.odu.cs.cs350.red2.Interface;

import edu.odu.cs.cs350.red2.Interface.*;

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