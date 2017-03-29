package edu.odu.cs.cs350.red2.LexicalTools;

/**
 * Token Class, stores the token type, the actual string, 
 * and the location (line number and column)
 * @author mpark
 */
public class Token
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
	 * Constructor that creates an empty token, should rarely be 
	 * invoked.
	 */
	public Token()
	{
		type = null;
		lexeme = null;
		lineNumber = 0;
		columnNumber = 0;
	}
	
	/**
	 * 
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
	
	public Token( final TokenTypes theType , final int line , final int column , final Object theLex )
	{
		type = theType;
		lineNumber = line;
		columnNumber = column;
		lexeme = theLex;
	}
	

	
	
}