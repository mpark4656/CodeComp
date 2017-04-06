package edu.odu.cs.cs350.red2.LexicalTools;

/**
 * <pre>
 * Token Class
 * This stores the token type, the actual string, 
 * and the location (line number and column) where
 * the lexeme was found.
 *  
 * The design of this interface is from 
 * Dr. Steven Zeil's jflexdemo repository
 * 
 * It has been modified for this project.
 * </pre>
 */
public class Token implements Cloneable
{
	
	// The type of token, see TokenTypes.java for more details.
	private TokenTypes type;
	
	
	// This represents the actual character string.
	private String lexeme;
	
	// The line number where this lexeme was found
	private int lineNumber;
	
	
	// The column number where this lexeme was found
	private int columnNumber;
	
	/**
	 * Constructor that accepts the type, the line number, and the column number
	 * @param theType <b>TokenTypes</b>
	 * @param line <b>int</b>
	 * @param column <b>int</b>
	 */
	public Token( final TokenTypes theType , final int line , final int column )
	{
		type = theType;
		lineNumber = line;
		columnNumber = column;
		lexeme = null;
	}
	
	/**
	 * Constructor that accepts the type, the line number, the column number and the lexeme
	 * @param theType <b>TokenTypes</b>
	 * @param line <b>int</b>
	 * @param column <b>int</b>
	 * @param theLex <b>Object</b>
	 */
	public Token( final TokenTypes theType , final int line , final int column , final Object theLex )
	{
		type = theType;
		lineNumber = line;
		columnNumber = column;
		lexeme = theLex.toString();
	}
	
	/**
	 * Copy Constructor
	 * @param toCopy <b>Token</b>
	 */
	public Token( Token toCopy )
	{
		this.type = toCopy.type;
		this.lineNumber = toCopy.lineNumber;
		this.columnNumber = toCopy.columnNumber;
		this.lexeme = new String(toCopy.lexeme);
	}
	
	/**
	 * Return the token type
	 * @return <b>TokenTypes</b> - Token type
	 */
	public TokenTypes getTokenType()
	{
		return type;
	}
	
	/**
	 * Return the lexeme
	 * @return <b>String</b> - lexeme
	 */
	public String getLexeme()
	{
		return lexeme;
	}
	
	/**
	 * Return the line number of this token
	 * @return <b>int</b> - Line number
	 */
	public int getLineNumber()
	{
		return lineNumber;
	}
	
	/**
	 * Return the column number of this token
	 * @return <b>int</b> - Column number
	 */
	public int getColumnNumber()
	{
		return columnNumber;
	}
	
	/**
	 * Override clone() method
	 * @return <b>Object</b> - A deep copy of this object
	 */
	@Override
	public Object clone()
	{
		return new Token( this );
	}
	
	/**
	 * Override equals() method
	 * @param obj <b>Object</b> object being compared
	 * @return <b>boolean</b> - Return true if this object is equal to obj
	 */
	@Override
	public boolean equals( Object obj )
	{
		if( obj == null ) {
			return false;
		}
		
		if( !(obj instanceof Token) ) {
			return false;
		}
		
		if( this == obj ) {
			return true;
		}
		
		Token otherObj = (Token)obj;
		
		return this.lexeme.equals(otherObj.lexeme) && 
			   this.type.equals(otherObj.type) && 
			   this.lineNumber == otherObj.lineNumber && 
			   this.columnNumber == otherObj.columnNumber;
	}
	
	/**
	 * Override hashCode() method
	 * @return <b>int</b> - The hash code of this object
	 */
	@Override
	public int hashCode()
	{
		int result = 11;
		
		if( this.type != null ) {
			result = 31 * result + type.hashCode();
		}
		else {
			result = 31 * result + 0;
		}
		
		if( this.lexeme != null ) {
			result = 31 * result + lexeme.hashCode();
		}
		else {
			result = 31 * result + 0;
		}
		
		result = 31 * result + lineNumber;
		result = 31 * result + columnNumber;
		
		return result;
	}
	
	/**
	 * Override toString() method
	 * @return <b>String</b> - Return lexeme
	 */
	@Override
	public String toString()
	{
		return lexeme;
	}
}


