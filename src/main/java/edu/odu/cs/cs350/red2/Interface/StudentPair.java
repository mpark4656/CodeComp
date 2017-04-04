package edu.odu.cs.cs350.red2.Interface;

/**
 * This class represent each pair of students in the instructor's class
 * Once all codes are parsed, token sequences from 2 students are compared.
 * @author mpark
 */
public class StudentPair implements Comparable<StudentPair>
{
	private Student student1;
	private Student student2;
	
	private double rawScore;
	private double zScore;
	
	private boolean rawScoreCalculated;
	private boolean zScoreCalculated;
	
	/**
	 * Constructor that accepts 2 Student objects
	 * @param Student student1
	 * @param Student student2
	 */
	public StudentPair( Student student1 , Student student2 )
	{
		if( student1.compareTo(student2) < 0 ) {
			this.student1 = student1;
			this.student2 = student2;
		}
		else if( student1.compareTo(student2) > 0 ) {
			this.student1 = student2;
			this.student2 = student1;
		}
		else {
			// TODO Throw - This pair cannot contain the same student
		}
		
		rawScore = 0;
		zScore = 0;
		rawScoreCalculated = false;
		zScoreCalculated = false;
	}
	
	/**
	 * Public get method that returns the Raw Score
	 * @return double Raw Score
	 */
	public double getRawScore()
	{
		return rawScore;
	}
	
	/**
	 * Public get method that returns the Z-Score
	 * @return double zScore
	 */
	public double getZScore()
	{
		return zScore;
	}
	
	/**
	 * Return the name of the first student
	 * @return String name of the first student
	 */
	public String getFirstStudentName()
	{
		return student1.toString();
	}
	
	/**
	 * Return the name of the second student
	 * @return String name of the second student
	 */
	public String getSecondStudentName()
	{
		return student2.toString();
	}
	
	/**
	 * Public get method that returns true if calculateRawScore() has been invoked
	 * @return boolean true if the raw score has been calculated for this pair
	 */
	public boolean isRawScoreCalculated()
	{
		return rawScoreCalculated;
	}
	
	/**
	 * Public get method that returns true if calculateZScore() has been invoked
	 * @return boolean true if the Z-Score has been calculated for this pair
	 */
	public boolean isZScoreCalculated()
	{
		return zScoreCalculated;
	}
	
	/**
	 * Calculate the raw score for these 2 students
	 * @post rawScoreCalculated == true
	 */
	public void calculateRawScore( double T )
	{
		if( rawScoreCalculated ) {
			return;
		}
		
		double combinedLength = student1.getTokenSequenceLength() + student2.getTokenSequenceLength();
		double numerator = 4 * T;
		double denominator = Math.pow( combinedLength , 2.0 );
		
		rawScore = numerator / denominator;
		
		rawScoreCalculated = true;
	}
	
	/**
	 * Calculate the z-score for these 2 students
	 * @post zScoreCalculated == true
	 */
	public void calculateZScore( double average , double standardDeviation )
	{
		if( zScoreCalculated ) {
			return;
		}
		
		zScore = ( rawScore - average ) / standardDeviation;
		
		zScoreCalculated = true;
	}
	
	/**
	 * Override toString() method
	 * @return String Student Pair
	 */
	@Override
	public String toString()
	{
		return "( " + student1.toString() + " , " + student2.toString() + " )";
	}
	
	/**
	 * Override equals() method
	 * @return boolean True if the objects are equal
	 */
	@Override
	public boolean equals( Object obj )
	{
		if( obj == null ) {
			return false;
		}
		
		if( !(obj instanceof StudentPair) ) {
			return false;
		}
		
		if( this == obj ) {
			return true;
		}
		
		StudentPair otherObj = (StudentPair) obj;
		
		return ( this.student1.equals(otherObj.student1) && this.student2.equals(otherObj.student2) );
	}
	
	/**
	 * Override compareTo from Comparable to allow sorting of Student Pair objects
	 * @return int value > 0 if this object precedes the other,
	 * == 0 if the two are equal, and < 0 if this contact
	 * follows the other. 
	 */
	@Override
	public int compareTo( StudentPair obj )
	{
		if( this.student1.compareTo(obj.student1) == 0 ) {
			return this.student2.compareTo(obj.student2);
		}
		
		return this.student1.compareTo(obj.student1);
	}
	
} // End of StudentPair.java



