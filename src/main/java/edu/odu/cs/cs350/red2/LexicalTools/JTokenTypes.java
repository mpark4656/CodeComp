package edu.odu.cs.cs350.red2.LexicalTools;

/**
 * <pre>
 * Enumeration of Java Token Types
 * Each type will be represented with a single character.
 * This enum includes token types specific to Java only.
 * This enum implements TokenTypes interface which provides
 * a method for generating the character as String
 * </pre>
 */
public enum JTokenTypes implements TokenTypes
{
	// Shared with C++
	BOOLEAN ( "1" ),
	BREAK ( "2" ),
	CASE ( "3" ),
	CATCH ( "4" ),
	CHAR ( "5" ),
	CLASS ( "6" ),
	CONTINUE ( "7" ),
	DO ( "8" ),
	DOUBLE ( "9" ),
	ELSE ( "a" ),
	ENUM ( "b" ),
	FLOAT ( "c" ),
	FOR ( "d" ),
	DEFAULT ( "e" ),
	INT ( "f" ),
	LONG ( "g" ),
	NEW ( "h" ),
	IF ( "i" ),
	PUBLIC ( "j" ),
	SHORT ( "k" ),
	SWITCH ( "l" ),
	PRIVATE ( "m" ),
	PROTECTED ( "n" ),
	RETURN ( "o" ),
	VOID ( "p" ),
	STATIC ( "q" ),
	WHILE ( "r" ),
	THIS ( "s" ),
	THROW ( "t" ),
	TRY ( "u" ),
	BOOLEAN_LITERAL ( "v" ),
	NULL_LITERAL ( "w" ),
	
	// Common Java Reserved Words
	ABSTRACT ("x"),
	EXTENDS ( "y" ),
	FINAL ( "A" ),
	FINALLY ( "B" ),
	IMPLEMENTS ( "C" ),
	IMPORT ( "D" ),
	INSTANCEOF ( "E" ),
	INTERFACE ( "F" ),
	SUPER ( "G" ),
	PACKAGE ( "H" ),
	THROWS ( "I" ),
	
	// Uncommon Reserved Words
	BYTE ( "z" ),
	CONST ( "z" ),
	NATIVE ( "z" ),
	GOTO ( "z" ),
	SYNCHRONIZED ( "z" ),
	TRANSIENT ( "z" ),
	VOLATILE ( "z" ),
	STRICTFP ( "z" ),
	
	// Common Operators
	EQ ( "~" ),
	NOTEQ ( "!" ),
	EQEQ ( "@" ),
	GT ( "#" ),
	GTEQ ( "$" ),
	LT ( "%" ),
	LTEQ ( "^" ),
	NOT ( "&" ),
	DIV ( "/" ), 
	MULT ( "*" ),
	MINUS ( "-" ),
	MINUSMINUS ( "`"),
	PLUS ( "+" ),
	PLUSPLUS ( ":" ),
	OR ( "|" ),
	PLUSEQ ( "S" ),
	MINUSEQ ( "T" ),
	MULTEQ ( "U" ),
	MOD ( "V" ),
	ANDAND ( "W" ),
	AND ( "X" ),
	OROR ( "Y" ),
	
	// Uncommon Operators
	COMP ( "Z" ),
	QUESTION ( "Z" ),
	COLON ( "Z" ),
	XOR ( "Z" ),
	LSHIFT ( "Z" ),
	RSHIFT ( "Z" ),
	URSHIFT ( "Z" ),
	XOREQ ( "Z" ),
	LSHIFTEQ ( "Z" ),
	RSHIFTEQ ( "Z" ),
	URSHIFTEQ ( "Z" ),
	MODEQ ( "Z" ),
	DIVEQ ( "Z" ),
	ANDEQ ( "Z" ),
	OREQ ( "Z" ),
	
	// Separators
	LPAREN ( "(" ),
	RPAREN ( ")" ),
	LBRACE ( "[" ),
	RBRACE ( "]" ),
	LBRACK ( "{" ),
	RBRACK ( "}" ),
	SEMICOLON ( ";" ),
	COMMA ( "," ),
	DOT ( "." ),
	
	// Identifier
	IDENTIFIER( "=" ),
	
	// Literals
	INTEGER_LITERAL ( "?" ),
	FLOATING_POINT_LITERAL ( "\\" ),
	STRING_LITERAL ( "\"" ),
	CHARACTER_LITERAL ( "'" ),
	
	// End of File
	EOF ( "0" );
	
	// String representation of the token
	private final String name;
	
	/**
	 * <pre>
	 * Constructor
	 * The name is the character that will represent this token.
	 * </pre>
	 * @param name <b>String</b>
	 */
	private JTokenTypes( String name )
	{
		this.name= name;
	}
	
	/**
	 * Return the name as String
	 * @return <b>String</b> - name
	 */
	@Override
	public String toString()
	{
		return name;
	}
}