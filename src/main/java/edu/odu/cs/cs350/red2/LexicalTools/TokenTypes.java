package edu.odu.cs.cs350.red2.LexicalTools;

/**
 * Enumeration for Token Types, 
 * Mainly Divided into 5 Parts 
 * 1. Reserved Words
 * 2. Operators
 * 3. Separators
 * 4. Identifier
 * 5. Literals
 * This will combine both C++ and Java Token Types
 * 
 * @author mpark
 *
 */
public enum TokenTypes
{
	// Reserved Words
	ABSTRACT ("abstract"),
	BOOLEAN ( "boolean" ),
	BREAK ( "break" ),
	BYTE ( "byte" ),
	CASE ( "case" ),
	CATCH ( "catch" ),
	CHAR ( "char" ),
	CLASS ( "class" ),
	CONST ( "const" ),
	CONTINUE ( "continue" ),
	DO ( "do" ),
	DOUBLE ( "double" ),
	ELSE ( "else" ),
	EXTENDS ( "extends" ),
	FINAL ( "final" ),
	FINALLY ( "finally" ),
	FLOAT ( "float" ),
	FOR ( "for" ),
	DEFAULT ( "default" ),
	IMPLEMENTS ( "implements" ),
	IMPORT ( "import" ),
	INSTANCEOF ( "instanceof" ),
	INT ( "int" ),
	INTERFACE ( "interface" ),
	LONG ( "long" ),
	NATIVE ( "native" ),
	NEW ( "new" ),
	GOTO ( "goto" ),
	IF ( "if" ),
	PUBLIC ( "public" ),
	SHORT ( "short" ),
	SUPER ( "super" ),
	SWITCH ( "switch" ),
	SYNCHRONIZED ( "synchronized" ),
	PACKAGE ( "package" ),
	PRIVATE ( "private" ),
	PROTECTED ( "protected" ),
	TRANSIENT ( "transient" ),
	RETURN ( "return" ),
	VOID ( "void" ),
	STATIC ( "static" ),
	WHILE ( "while" ),
	THIS ( "this" ),
	THROW ( "throw" ),
	THROWS ( "throws" ),
	TRY ( "try" ),
	VOLATILE ( "volatile" ),
	STRICTFP ( "strictfp" ),
	BOOLEAN_LITERAL ( "boolean_literal" ),
	NULL_LITERAL ( "null_literal" ),
	
	// Operators
	EQ ( "eq" ),
	NOTEQ ( "noteq" ),
	EQEQ ( "eqeq" ),
	GT ( "gt" ),
	GTEQ ( "gteq" ),
	LT ( "lt" ),
	LTEQ ( "lteq" ),
	NOT ( "not" ),
	COMP ( "comp" ),
	QUESTION ( "question" ),
	COLON ( "colon" ),
	DIV ( "div" ), 
	MULT ( "mult" ),
	MINUS ( "minus" ),
	MINUSMINUS ( "minusminus"),
	PLUS ( "plus" ),
	PLUSPLUS ( "plusplus" ),
	OR ( "or" ),
	OROR ( "oror" ),
	XOR ( "xor" ),
	AND ( "and" ),
	ANDAND ( "andand" ),
	MOD ( "mod" ),
	LSHIFT ( "lshift" ),
	RSHIFT ( "rshift" ),
	URSHIFT ( "urshift" ),
	PLUSEQ ( "pluseq" ),
	MINUSEQ ( "minuseq" ),
	MULTEQ ( "multeq" ),
	DIVEQ ( "diveq" ),
	ANDEQ ( "andeq" ),
	OREQ ( "oreq" ),
	XOREQ ( "xoreq" ),
	MODEQ ( "modeq" ),
	LSHIFTEQ ( "lshifteq" ),
	RSHIFTEQ ( "rshifteq" ),
	URSHIFTEQ ( "urshifteq" ),
	
	// Separators
	LPAREN ( "lparen" ),
	RPAREN ( "rparen" ),
	LBRACE ( "lbrace" ),
	RBRACE ( "rbrace" ),
	LBRACK ( "lbrack" ),
	RBRACK ( "rbrack" ),
	SEMICOLON ( "semicolon" ),
	COMMA ( "comma" ),
	DOT ( "dot" ),
	
	// Identifier
	IDENTIFIER( "identifier" ),
	
	// Literals
	INTEGER_LITERAL ( "integer_literal" ),
	FLOATING_POINT_LITERAL ( "floating_point_literal" ),
	STRING_LITERAL ( "string_literal" ),
	CHARACTER_LITERAL ( "character_literal" ),
	
	// Comment
	COMMENT ( "comment" ),
	
	// End of File
	EOF ( "eof" );
	
	// String representation of the token
	private final String name;
	
	/**
	 * Constructor
	 * @param name String
	 */
	private TokenTypes( String name )
	{
		this.name = name;
	}
	
	/**
	 * Override toString() method
	 * @return String Returns the type of token in String
	 */
	@Override
	public String toString()
	{
		return this.name;
	}
}