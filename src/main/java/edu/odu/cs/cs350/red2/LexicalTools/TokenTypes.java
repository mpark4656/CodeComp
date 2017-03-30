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
	ABSTRACT,
	BOOLEAN,
	BREAK,
	BYTE,
	CASE,
	CATCH,
	CHAR,
	CLASS,
	CONST,
	CONTINUE,
	DO,
	DOUBLE,
	ELSE,
	EXTENDS,
	FINAL,
	FINALLY,
	FLOAT,
	FOR,
	DEFAULT,
	IMPLEMENTS,
	IMPORT,
	INSTANCEOF,
	INT,
	INTERFACE,
	LONG,
	NATIVE,
	NEW,
	GOTO,
	IF,
	PUBLIC,
	SHORT,
	SUPER,
	SWITCH,
	SYNCHRONIZED,
	PACKAGE,
	PRIVATE,
	PROTECTED,
	TRANSIENT,
	RETURN,
	VOID,
	STATIC,
	WHILE,
	THIS,
	THROW,
	THROWS,
	TRY,
	VOLATILE,
	STRICTFP,
	BOOLEAN_LITERAL,
	NULL_LITERAL,
	
	// Operators
	EQ,
	NOTEQ,
	EQEQ,
	GT,
	GTEQ,
	LT,
	LTEQ,
	NOT,
	COMP,
	QUESTION,
	COLON,
	DIV, 
	MULT,
	MINUS,
	MINUSMINUS,
	PLUS,
	PLUSPLUS,
	OR,
	OROR,
	XOR,
	AND,
	ANDAND,
	MOD,
	LSHIFT,
	RSHIFT,
	URSHIFT,
	PLUSEQ,
	MINUSEQ,
	MULTEQ,
	DIVEQ,
	ANDEQ,
	OREQ,
	XOREQ,
	MODEQ,
	LSHIFTEQ,
	RSHIFTEQ,
	URSHIFTEQ,
	
	// Separators
	LPAREN,
	RPAREN,
	LBRACE,
	RBRACE,
	LBRACK,
	RBRACK,
	SEMICOLON,
	COMMA,
	DOT,
	
	// Identifier
	IDENTIFIER,
	
	// Literals
	INTEGER_LITERAL,
	FLOATING_POINT_LITERAL,
	STRING_LITERAL,
	CHARACTER_LITERAL,
	
	// End of File
	EOF
}