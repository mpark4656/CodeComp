package edu.odu.cs.cs350.red2.LexicalTools;

/**
 * Java Token Types
 * @author mpark
 *
 */
public enum JTokenTypes implements TokenTypes
{
	// Common Reserved Words
	ABSTRACT ("a"),
	BOOLEAN ( "b" ),
	BREAK ( "c" ),
	CASE ( "d" ),
	CATCH ( "e" ),
	CHAR ( "f" ),
	CLASS ( "g" ),
	CONTINUE ( "h" ),
	DO ( "i" ),
	DOUBLE ( "j" ),
	ELSE ( "k" ),
	ENUM ( "l" ),
	EXTENDS ( "m" ),
	FINAL ( "n" ),
	FINALLY ( "o" ),
	FLOAT ( "p" ),
	FOR ( "q" ),
	DEFAULT ( "r" ),
	IMPLEMENTS ( "s" ),
	IMPORT ( "t" ),
	INSTANCEOF ( "u" ),
	INT ( "v" ),
	INTERFACE ( "w" ),
	LONG ( "x" ),
	NEW ( "y" ),
	IF ( "1" ),
	PUBLIC ( "2" ),
	SHORT ( "3" ),
	SUPER ( "4" ),
	SWITCH ( "5" ),
	PACKAGE ( "6" ),
	PRIVATE ( "7" ),
	PROTECTED ( "8" ),
	RETURN ( "9" ),
	VOID ( "A" ),
	STATIC ( "B" ),
	WHILE ( "C" ),
	THIS ( "D" ),
	THROW ( "E" ),
	THROWS ( "F" ),
	TRY ( "G" ),
	BOOLEAN_LITERAL ( "H" ),
	NULL_LITERAL ( "I" ),
	
	
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
	EQ ( "J" ),
	NOTEQ ( "K" ),
	EQEQ ( "L" ),
	GT ( "M" ),
	GTEQ ( "N" ),
	LT ( "O" ),
	LTEQ ( "P" ),
	NOT ( "Q" ),
	DIV ( "R" ), 
	MULT ( "S" ),
	MINUS ( "T" ),
	MINUSMINUS ( "U"),
	PLUS ( "V" ),
	PLUSPLUS ( "W" ),
	OR ( "X" ),
	OROR ( "Y" ),
	AND ( "`" ),
	ANDAND ( "!" ),
	MOD ( "@" ),
	PLUSEQ ( "#" ),
	MINUSEQ ( "$" ),
	MULTEQ ( "%" ),
	DIVEQ ( "^" ),
	ANDEQ ( "&" ),
	OREQ ( "*" ),
	MODEQ ( "|" ),
	
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
	
	// Separators
	LPAREN ( "(" ),
	RPAREN ( ")" ),
	LBRACE ( "[" ),
	RBRACE ( "]" ),
	LBRACK ( "{" ),
	RBRACK ( "}" ),
	SEMICOLON ( ";" ),
	COMMA ( ":" ),
	DOT ( "." ),
	
	// Identifier
	IDENTIFIER( "=" ),
	
	// Literals
	INTEGER_LITERAL ( "+" ),
	FLOATING_POINT_LITERAL ( "-" ),
	STRING_LITERAL ( "_" ),
	CHARACTER_LITERAL ( "~" ),
	
	// End of File
	EOF ( "0" );
	
	
	// String representation of the token
	private final String name;
	
	/**
	 * Constructor
	 * @param name String
	 */
	private JTokenTypes( String name )
	{
		this.name= name;
	}
	
	/**
	 * Return the String representation of this token type
	 * @return String name
	 */
	@Override
	public String toString()
	{
		return name;
	}
}