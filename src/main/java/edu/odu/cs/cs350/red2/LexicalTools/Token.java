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
	private String lexeme;
	
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
<<<<<<< HEAD
		// Testing JFlex
		String inputString = "123\tident1 \nKEYWORD   42\n";
		Reader input = new StringReader( inputString );
<<<<<<< HEAD
		// GeneratedScanner = new GeneratedScanner ( input );
		
	}
=======
		//GeneratedScanner = new GeneratedScanner ( input );
		
=======
		type = null;
		lexeme = "";
		lineNumber = 0;
		columnNumber = 0;
>>>>>>> master
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
		lexeme = "";
	}
	
	public Token( final TokenTypes theType , final int line , final int column , final String theLex )
	{
		type = theType;
		lineNumber = line;
		columnNumber = column;
		lexeme = theLex;
	}
	

	
	
>>>>>>> master
}