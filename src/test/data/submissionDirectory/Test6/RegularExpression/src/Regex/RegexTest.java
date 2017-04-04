package Regex;

import java.util.Scanner;




public class RegexTest
{
	public static void main( String[] args )
	{
		Scanner input = new Scanner(System.in);
		
		System.out.printf( "%s: ", "Enter a string literal");
		String str = input.nextLine();
		
		if( str.matches("\\d+")) {
			System.out.println( "The string literal matches the regular expression." );
		}
		else {
			System.out.println( "The string literal does NOT match the regular expression." );
		}
		
		input.close();
	}
}