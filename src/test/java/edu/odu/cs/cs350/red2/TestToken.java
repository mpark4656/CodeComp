package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.odu.cs.cs350.red2.LexicalTools.Token;
import edu.odu.cs.cs350.red2.LexicalTools.TokenTypes;
import edu.odu.cs.cs350.red2.LexicalTools.JTokenTypes;
import edu.odu.cs.cs350.red2.LexicalTools.CTokenTypes;

public class TestToken {

	

	@Test
	public void testTokenTokenTypesIntIntObject() 
	{
		
		Token testToken = new Token (JTokenTypes.ABSTRACT, 1 , 1 );
		assertEquals(JTokenTypes.ABSTRACT, testToken.getTokenType());
		assertEquals(null , testToken.getLexeme());
		assertEquals(1, testToken.getLineNumber());
		assertEquals(1, testToken.getColumnNumber());
		assertEquals(null , testToken.toString());
		
	}


	@Test
	public void testTokenTokenTypesIntInt() 
	{
		Token testToken = new Token(CTokenTypes.PUBLIC, 2000 , 5, "words");
		assertEquals(CTokenTypes.PUBLIC, testToken.getTokenType());
		assertEquals("words",testToken.getLexeme());
		assertEquals(2000, testToken.getLineNumber());
		assertEquals(5,testToken.getColumnNumber());
		assertEquals("words", testToken.toString());
		
		
	}


	@Test
	public void testTokenToken() 
	{
		Token testToken = new Token(CTokenTypes.INT, 5,5,"stuff");
		Token c = new Token(testToken);
		
		assertEquals(testToken, c);
		assertNotSame(testToken,c);
		assertEquals(c.getTokenType(),testToken.getTokenType());
		assertEquals(c.getLexeme(), testToken.getLexeme());
		assertEquals(c.getLineNumber(),testToken.getLineNumber());
		assertEquals(c.getColumnNumber(), testToken.getColumnNumber());
		assertEquals(c.toString(), testToken.toString());
		
	}
	


	@Test
	public void testGetTokenType() 
	{
		Token testToken = new Token(CTokenTypes.PRIVATE,1,1);
		assertEquals(CTokenTypes.PRIVATE, testToken.getTokenType());
	}

	@Test
	public void testGetLexeme() 
	{
		Token testToken = new Token(JTokenTypes.PRIVATE,1 ,1, "var");
		assertEquals("var", testToken.getLexeme());
		
		Token testToken1 = new Token(JTokenTypes.PRIVATE,1,1);
		assertEquals(null, testToken1.getLexeme());
	}

	@Test
	public void testGetLineNumber() 
	{
		Token testToken = new Token(CTokenTypes.PRIVATE,2 ,2);
		
		assertEquals(2,testToken.getLineNumber());
	}

	@Test
	public void testGetColumnNumber() {
		Token testToken = new Token(CTokenTypes.PRIVATE,2,2);
		
		assertEquals(2,testToken.getColumnNumber());
	}

	@Test
	public void testClone() {
		// fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		Token testToken = new Token(JTokenTypes.PRIVATE,2,2);
		
		//assertFalse(null, testToken.equals());
	}

	@Test
	public void testHashCode() 
	{
		// fail("Not yet implemented");
	}
	@Test
	public void testToString() {
		Token testToken = new Token(JTokenTypes.ABSTRACT,3,3,"testwords");
		
		assertEquals("testwords", testToken.toString());
	}

}
