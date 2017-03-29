package edu.odu.cs.cs350.red2.LexicalTools;

/**
 * Enumeration for Token Types, 
 * Currently supported types are 
 * Keyword, 
 * Integer Literal, 
 * Identifier, 
 * Operator, 
 * EOF
 * 
 * @author mpark
 *
 */
public enum TokenTypes
{
	/**
	 * Java Keywords, 
	 * Examples: int, String, if
	 */
	KEYWORD,
	
	/**
	 * Any integer values
	 */
	INTEGER_LITERAL,
	
	/**
	 * Any string literals not enclosed by ""
	 */
	IDENTIFIER,
	
	/**
	 * Java Operators
	 * Examples: +, -, () , []
	 */
	OPERATOR,
	
	/**
	 * End of File
	 */
	EOF
	
}