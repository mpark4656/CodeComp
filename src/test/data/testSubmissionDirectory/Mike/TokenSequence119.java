package edu.odu.cs.cs350.red2.LexicalTools;

import java.util.LinkedList;
import java.io.Reader;
import java.util.Iterator;
import java.io.IOException;

/**
 * TokenSequenbce Class, 
 * Stores tokens from one code file, 
 * The design of this interface was borrowed from 
 * Dr. Steven Zeil, 
 * http://forge350.cs.odu.edu:8090/zeil/jflexdemo
 * @author mpark
 *
 */
public class TokenSequence implements Iterable<Token>
{
	
	// collection of tokens in a linked list
	private LinkedList<Token> tokens;
	
	// Language Type - Jave or Cpluspus
	LanguageTypes langType;
	
	/**
	 * Constructor
	 * @param input Reader object obtained from input file path
	 * @param langType LanguageTypes which programming language is it?
	 */
	public TokenSequence( final Reader input , LanguageTypes langType )
	{
		tokens = new LinkedList<Token> ();
		this.langType = langType;
		
		// The language is JAVA
		if( this.langType == LanguageTypes.JAVA ) {
			JavaScanner scanner = new JavaScanner( input );
			
			try {
				Token token = scanner.yylex();
				
				while( token != null && token.getTokenType() != TokenTypes.EOF ) {
					tokens.add( token );
					token = scanner.yylex();
				}
			}
			catch( IOException e ) {
				// Not necessarily a problem - Let it continue to run. 
			}
		}
		// The Language is Cplusplus
		else {
			CppScanner scanner = new CppScanner( input );
			
			try {
				Token token = scanner.yylex();
				
				while( token != null && token.getTokenType() != TokenTypes.EOF ) {
					tokens.add( token );
					token = scanner.yylex();
				}
			}
			catch( IOException e ) {
				// Not necessarily a problem - Let it continue to run. 
			}
		}
		
	} // End of TokenSequence()
	
	/**
	 * Override iterator()
	 * @return Iterator<Token>
	 */
	@Override
	public final Iterator<Token> iterator()
	{
		return tokens.iterator();
	}
	
	/**
	 * Public get method that returns the number of tokens in this sequence
	 * @return int Total count of tokens in this sequence
	 */
	public int getTokenCount()
	{
		return tokens.size();
	}
	
	/**
	 * Public get method that returns the token ordinal sequence as StringBuilder
	 * @return StringBuilder Sequence of tokens
	 */
	public StringBuilder getOrdinalSequence()
	{
		StringBuilder result = new StringBuilder();
		
		for( Token t : tokens ) {
			result.append( t.getTokenType().ordinal() );
		}
		
		return result;
	}
	
	/**
	 * Public get method that returns the token String sequence as StringBuilder
	 * @return StringBuilder Sequence of tokens
	 */
	public StringBuilder getStringSequence()
	{
		StringBuilder result = new StringBuilder();
		
		for( Token t : tokens ) {
			result.append( t.getTokenType().toString() );
		}
		
		return result;
	}
}
