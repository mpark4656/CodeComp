package edu.odu.cs.cs350.red2.Interface;

/**
 * <pre>
 * <b>StudentPair Class</b>
 * This sub-interface represents every possible pair of students in the instructor's class
 * A pair must include 2 different students. A duplicate pair cannot exist. A raw core
 * and a z-score is calulated for each pair of students.
 * </pre>
 */
public class StudentPair implements Comparable<StudentPair> , Cloneable
{
	private Student student1;
	private Student student2;
	
	private double rawScore;
	private double zScore;
	
	private boolean rawScoreCalculated;
	private boolean zScoreCalculated;
	
	/**
	 * This constructor that accepts 2 Student objects
	 * @param student1 <b>Student</b>
	 * @param student2 <b>Student</b>
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
	 * Copy Constructor
	 * @param obj <b>StudentPair</b> object to copy
	 */
	public StudentPair( StudentPair obj )
	{
		this.student1 = (Student) obj.student1.clone();
		this.student2 = (Student) obj.student2.clone();
		this.rawScore = obj.rawScore;
		this.zScore = obj.zScore;
		this.rawScoreCalculated = obj.rawScoreCalculated;
		this.zScoreCalculated = obj.zScoreCalculated;
	}
	
	/**
	 * Public method that returns the raw score for this pair
	 * @return <b>double</b> - Raw score
	 */
	public double getRawScore()
	{
		return rawScore;
	}
	
	/**
	 * Public method that returns the z-score
	 * @return <b>double</b> - Z-score
	 */
	public double getZScore()
	{
		return zScore;
	}
	
	/**
	 * Public method that returns the identifier of the first student
	 * @return <b>String</b> - Identifier of the first student
	 */
	public String getFirstStudentName()
	{
		return student1.toString();
	}
	
	/**
	 * Public method that returns the identifier of the second student
	 * @return <b>String</b> - Identifier of the second student
	 */
	public String getSecondStudentName()
	{
		return student2.toString();
	}
	
	/**
	 * Public method that returns true if the raw score has been calculated
	 * @return <b>boolean</b> - Return true if the raw score has been calculated
	 */
	public boolean isRawScoreCalculated()
	{
		return rawScoreCalculated;
	}
	
	/**
	 * Public method that returns true if the z-score has been calculated
	 * @return <b>boolean</b> - Return true if the z-score has been calculated
	 */
	public boolean isZScoreCalculated()
	{
		return zScoreCalculated;
	}
	
	/**
	 * <pre>
	 * Calculate the raw score for this pair.
	 * 
	 * Precondition: rawScoreCalculated == false
	 * Postcondition: rawScoreCalculated == true
	 * 
	 * Formula:
	 *  
	 * (4 * T) / ( L1 + L2)^2
	 *  
	 *  where L1 is the sequence length of Student 1
	 *  and L2 is the sequence length of Student 2
	 * </pre>
	 * @param T <b>double</b>
	 */
	public void calculateRawScore( double T )
	{
		// If the raw score has been calculated already, just return
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
	 * <pre>
	 * Calculate the z-score for this pair. If the raw score hasn't been calculated yet,
	 * this method will do nothing.
	 * 
	 * Precondition: rawScoreCalculated == true and zScoreCalculated == false
	 * Postcondition: zScoreCalculated == true
	 * 
	 * Formula: 
	 * 
	 * (x - u) / s
	 * 
	 * where x is the raw score, u is the average raw score and s is the standard deviation.
	 * </pre>
	 * @param average <b>double</b>
	 * @param standardDeviation <b>double</b>
	 */
	public void calculateZScore( double average , double standardDeviation )
	{
		// If the z-score has been calculated already, just return
		if( zScoreCalculated ) {
			return;
		}
		
		// The raw score hasn't been calculated yet
		if( !rawScoreCalculated ) {
			return;	// Or throw
		}
		
		zScore = ( rawScore - average ) / standardDeviation;
		
		zScoreCalculated = true;
	}
	
	/**
	 * Override toString() method to represent this pair as String
	 * @return <b>String</b> - String representation of this pair
	 */
	@Override
	public String toString()
	{
		return "( " + student1.toString() + " , " + student2.toString() + " )";
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
	 * <pre>
	 * Override compareTo() from Comparable to allow sorting of StudentPair.
	 * 
	 * It will always compare the first students. If the first students are equal,
	 * second students are compared.
	 * </pre>
	 * @param obj <b>StudentPair</b>
	 * @return <b>int</b> - Value
	 */
	@Override
	public int compareTo( StudentPair obj )
	{
		if( this.student1.compareTo(obj.student1) == 0 ) {
			return this.student2.compareTo(obj.student2);
		}
		
		return this.student1.compareTo(obj.student1);
	}
	
	/**
	 * Override hashCode() method
	 * @return <b>int</b> The hash code of this object
	 */
	@Override
	public int hashCode()
	{
		int result = 11;
		
		result = 31 * result + student1.hashCode();
		result = 31 * result + student2.hashCode();
		
		long f = Double.doubleToLongBits(rawScore);
		
		result = 31 * result + (int) ( f ^ ( f >>> 32));
		
		f = Double.doubleToLongBits(zScore);
				
		result = 31 * result + (int) ( f ^ ( f >>> 32));
		
		result = 31 * result + ( rawScoreCalculated ? 1 : 0 );
		
		result = 31 * result + ( zScoreCalculated ? 1 : 0 );
		
		return result;
	}
	
	/**
	 * Override clone() method
	 * @return <b>Object</b> A deep copy of this object
	 */
	@Override
	public Object clone()
	{
		return new StudentPair( this );
	}
	
} // End of StudentPair.java



