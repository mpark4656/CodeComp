package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.odu.cs.cs350.red2.LexicalTools.LanguageTypes;
import edu.odu.cs.cs350.red2.LexicalTools.Token;
import edu.odu.cs.cs350.red2.LexicalTools.TokenSequence;

import java.io.*;
public class TestTokenSequence {


	@Test
	public void testTokenSequenceReaderLanguageTypes() 
	{
		int count = 0;
		Reader j = new StringReader("public class");
		TokenSequence TS = new TokenSequence(j, LanguageTypes.JAVA);
		
		//checking iterator to make sure it has two elements.
		for (@SuppressWarnings("unused") Token T : TS)
		{
			count++;
		}
		
		assertEquals(count, 2);
		assertEquals(TS.getTokenCount(), 2);
		assertEquals(TS.toString(),"j6");
		assertEquals(TS.getTokenSequence().toString(), "j6");
	}

	@Test
	public void testTokenSequenceTokenSequence() 
	{
		Reader j = new StringReader("public class");
		TokenSequence TS = new TokenSequence(j,LanguageTypes.JAVA);
		
		TokenSequence copyTS = new TokenSequence(TS);
		
		assertEquals(copyTS, TS);
		assertNotSame(copyTS,TS);
		
		assertEquals(copyTS.getTokenCount(),TS.getTokenCount());
		assertEquals(copyTS.toString(),TS.toString());
		
		assertEquals(copyTS.getTokenSequence().toString(),TS.getTokenSequence().toString());
	}


	@Test
	public void testGetTokenCount() 
	{
		Reader j = new StringReader("public class nathanIsAmazing{}");
		TokenSequence TS= new TokenSequence(j,LanguageTypes.JAVA);
		
		assertEquals(TS.getTokenCount(), 5);
	}
	

	@Test
	public void testGetTokenSequence() 
	{
		Reader j = new StringReader("public class int");
		TokenSequence TS = new TokenSequence(j, LanguageTypes.JAVA);
		
		assertEquals(TS.getTokenSequence().toString(), "j6f");
	}

	@Test
	public void testEqualsObject() 
	{
		
		Reader j = new StringReader("public class nathanIsAmazing{}");
		
		TokenSequence TS 	= new TokenSequence(j,LanguageTypes.JAVA);
		j = new StringReader("public class nathanIsAmazing{}");
		
		TokenSequence TS1	= new TokenSequence(j,LanguageTypes.JAVA);
		TokenSequence TS2	= new TokenSequence(j,LanguageTypes.CPLUSPLUS);
	
		assertTrue(TS1.equals(TS));
		assertFalse(TS1.equals(TS2));
	}

	@Test
	public void testToString() 
	{
		Reader j = new StringReader("public class int");
		
		TokenSequence TS = new TokenSequence(j,LanguageTypes.JAVA);
		
		assertEquals(TS.getTokenSequence().toString(), "j6f");
	}
	
	@Test
	public void testHashCode() 
	{
		Reader j = new StringReader("public class nathanIsAmazing{}");
		
		TokenSequence TS 	= new TokenSequence(j,LanguageTypes.JAVA);
		
		j = new StringReader("public class nathanIsAmazing{}");
		
		TokenSequence TS1	= new TokenSequence(j,LanguageTypes.JAVA);
		TokenSequence TS2	= new TokenSequence(j,LanguageTypes.CPLUSPLUS);
		
		assertEquals(TS.hashCode(),TS1.hashCode());
		assertNotEquals(TS.hashCode(),TS2.hashCode());
	}

	@Test
	public void testClone() 
	{
		Reader j = new StringReader("public class");
		TokenSequence TS = new TokenSequence(j,LanguageTypes.JAVA);
		
		TokenSequence copyTS = (TokenSequence)TS.clone();
		
		assertEquals(copyTS, TS);
		assertNotSame(copyTS,TS);
		
		assertEquals(copyTS.getTokenCount(),TS.getTokenCount());
		assertEquals(copyTS.toString(),TS.toString());
		
		assertEquals(copyTS.getTokenSequence().toString(),TS.getTokenSequence().toString());
	}

}
