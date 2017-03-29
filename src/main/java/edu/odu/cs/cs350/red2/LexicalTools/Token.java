package edu.odu.cs.cs350.red2.LexicalTools;

import java.io.Reader;
import java.io.StringReader;

/**
 * Token Class
 * @author mpark
 */
public class Token
{
	public Token()
	{
		// Testing JFlex
		String inputString = "123\tident1 \nKEYWORD   42\n";
		Reader input = new StringReader( inputString );
		// GeneratedScanner = new GeneratedScanner ( input );
		
	}
}