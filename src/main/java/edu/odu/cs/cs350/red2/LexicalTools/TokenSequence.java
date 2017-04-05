package edu.odu.cs.cs350.red2.LexicalTools;

import java.util.LinkedList;

import edu.odu.cs.cs350.red2.Interface.Student;

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
public class TokenSequence implements Iterable<Token> , Cloneable
{
	
	// collection of tokens in a linked list
	private LinkedList<Token> tokens;
	
	// Language Type - Jave or Cpluspus
	LanguageTypes langType;
	
	/**
	 * Constructor
	 * @param input Reader
	 * @param langType LanguageTypes
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
				
				while( token != null && token.getTokenType() != JTokenTypes.EOF ) {
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
				
				while( token != null && token.getTokenType() != CTokenTypes.EOF ) {
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
	 * Copy Constructor
	 * @param obj TokenSequence
	 */
	@SuppressWarnings("unchecked")
	public TokenSequence( TokenSequence obj )
	{
		this.tokens = (LinkedList<Token>) obj.tokens.clone();
		this.langType = obj.langType;
	}
	
	/**
	 * Override iterator()
	 * @return Iterator for Token ArrayList
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
	 * Public get method that returns the token String sequence as StringBuilder
	 * @return StringBuilder Sequence of tokens
	 */
	public StringBuilder getTokenSequence()
	{
		StringBuilder result = new StringBuilder();
		
		for( Token t : tokens ) {
			result.append( t.getTokenType().toString() );
		}
		
		return result;
	}
	
	/**
	 * Override hashCode()
	 * @return int hash code of this object
	 */
	@Override
	public int hashCode()
	{
		int result = 11;
		
		result = 31 * result + tokens.hashCode();
		result = 31 * result + langType.ordinal();
		
		return result;
	}
	
	/**
	 * Override equals() method
	 * @param obj Object
	 * @return boolean true if the two objects are equal
	 */
	@Override
	public boolean equals( Object obj )
	{
		if( obj == null ) {
			return false;
		}
		
		if( !(obj instanceof TokenSequence) ) {
			return false;
		}
		
		if( this == obj ) {
			return true;
		}
		
		TokenSequence otherObj = (TokenSequence) obj;
		
		return this.tokens.equals( otherObj.tokens ) && this.langType.equals( otherObj.langType );
	}
	
	/**
	 * Return the token sequence as String, 
	 * Override toString()
	 * @return String token sequence
	 */
	@Override
	public String toString()
	{
		return getTokenSequence().toString();
	}
	
	/**
	 * Override clone()
	 * @return Object a deep copy of this object
	 */
	@Override
	public Object clone()
	{
		return new TokenSequence( this );
	}
}


