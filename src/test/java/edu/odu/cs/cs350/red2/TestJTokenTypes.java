package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.odu.cs.cs350.red2.LexicalTools.JTokenTypes;

public class TestJTokenTypes {

	@Test
	public void testToString() {
		assertEquals( "1" , JTokenTypes.BOOLEAN.toString() );
		assertEquals( "A" , JTokenTypes.FINAL.toString() );
		assertEquals( "%" , JTokenTypes.LT.toString() );
		assertEquals( "+" , JTokenTypes.PLUS.toString() );
		assertEquals( "Z" , JTokenTypes.XOREQ.toString() );
	}
}
