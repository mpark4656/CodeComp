package edu.odu.cs.cs350.red2;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.odu.cs.cs350.red2.LexicalTools.CTokenTypes;

public class TestCTokenTypes {

	@Test
	public void testToString() {
		assertEquals( "1" , CTokenTypes.BOOLEAN.toString() );
		assertEquals( "C" , CTokenTypes.EXPLICIT.toString() );
		assertEquals( "%" , CTokenTypes.LT.toString() );
		assertEquals( "+" , CTokenTypes.PLUS.toString() );
		assertEquals( "Z" , CTokenTypes.XOREQ.toString() );
	}
}
