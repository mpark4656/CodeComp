package edu.odu.cs.cs350.red2.LexicalTools;

/**
 * Token Class, stores the token type, the actual string, 
 * and the location (line number and column)
 * @author mpark
 */
public class Token implements Cloneable
{
	/**
	 * The type of token, see TokenTypes.java for more details.
	 */
	private TokenTypes type;
	
	/**
	 * This represents the actual character string.
	 */
	private Object lexeme;
	
	/**
	 * The line number where this lexeme was found
	 */
	private int lineNumber;
	
	/**
	 * The column number where this lexeme was found
	 */
	private int columnNumber;
	
	
	/**
	 * Constructor that accepts the type, the line number, and the column number.
	 * @param theType
	 * @param line
	 * @param column
	 */
	public Token( final TokenTypes theType , final int line , final int column )
	{
		type = theType;
		lineNumber = line;
		columnNumber = column;
		lexeme = null;
	}
	
	/**
	 * Constructor that accepts the type, the line number, the column number and the lexeme.
	 * @param theType
	 * @param line
	 * @param column
	 * @param theLex
	 */
	public Token( final TokenTypes theType , final int line , final int column , final Object theLex )
	{
		type = theType;
		lineNumber = line;
		columnNumber = column;
		lexeme = theLex;
	}
	
	/**
	 * Copy Constructor
	 * @param toCopy Token Object to copy
	 */
	public Token( Token toCopy )
	{
		this.type = toCopy.type;
		this.lineNumber = toCopy.lineNumber;
		this.columnNumber = toCopy.columnNumber;
		// Need to copy lexeme. Will figure this out later
		
	}
	
	/**
	 * Return the token type.
	 * @return
	 */
	public TokenTypes getTokenType()
	{
		return type;
	}
	
	/**
	 * Return the lexeme.
	 * @return Object lexeme
	 */
	public Object getLexeme()
	{
		return lexeme;
	}
	
	/**
	 * Return the line number of this token.
	 * @return int Line Number
	 */
	public int getLineNumber()
	{
		return lineNumber;
	}
	
	/**
	 * Return the column number of this token.
	 * @return int Column Number
	 */
	public int getColumnNumber()
	{
		return columnNumber;
	}
	
	/**
	 * Override clone() in Object
	 */
	@Override
	public Object clone()
	{
		return new Token( this );
	}
	
	/**
	 * Override equals() in Object
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
	 * Override hashCode method in Object
	 */
	@Override
	public int hashCode()
	{
		return type.hashCode() + lexeme.hashCode() + lineNumber + columnNumber;
	}
	
	
}