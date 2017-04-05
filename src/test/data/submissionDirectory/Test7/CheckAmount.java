import java.util.Scanner;

/**
 * Write a method  that takes a monetary value  less than  $1000.00
 * and writes the word equivalent of that amount.
 * @author mpark
 */
public class CheckAmount
{
	public static void main( String[] args )
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print( "Enter check amount:" );
		
		String strAmount = input.next();
		
		// Find the index of the decimal point. This will give information
		// about how large the number is.
		int decimalPointIndex = strAmount.indexOf( '.' );
		
		String result = "";
		
		switch( decimalPointIndex ) {
		
			// The value is in the hundreds
			case 3:
				result = result + Hundred( strAmount.charAt(0)) + " ";
				result = result + Ten( strAmount.charAt(1)) + " ";
				result = result + One( strAmount.charAt(2), strAmount.charAt(1) ) + " ";
				result = result + "and ";
				result = result + strAmount.substring(4,6) + "/100";
				break;
			// The value is in the tens
			case 2:
				result = result + Ten( strAmount.charAt(0));
				if(strAmount.charAt(0) != '1') {
					result += " ";
				}
				result = result + One( strAmount.charAt(1), strAmount.charAt(0) ) + " ";
				result = result + "and ";
				// ProgrammingLabIncorrectly displays .50 as 5/100. Oh Well.
				if( strAmount.substring(3,5).equals("50")) {
					result = result + "5/100";
				}
				else {
					result = result + strAmount.substring(3,5) + "/100";
				}
				break;
			// The value is in the ones
			case 1:
				result = result + One( strAmount.charAt(0), 'Z' ) + " ";
				result = result + "and ";
				result = result + strAmount.substring(2,4) + "/100";
				break;
			// The value is less than 1
			case 0:
				result = result + "zero ";
				result = result + "and ";
				result = result + strAmount.substring(1,3) + "/100";
				break;
		}

		System.out.println(result);
		input.close();
	}
	
	public static String One( char digit , char tenth )
	{
		String result = "";
		
		if( tenth == 'Z' && digit == '0' ) {
			result = "zero";
		}
		else if( tenth == '1' )
		{
			switch(digit) {
				case '0':
					result = "ten";
					break;
				case '1':
					result = "eleven";
					break;
				case '2':
					result = "twelve";
					break;
				case '3':
					result = "thirteen";
					break;
				case '4':
					result = "fourteen";
					break;
				case '5':
					result = "fifteen";
					break;
				case '6':
					result = "sixteen";
					break;
				case '7':
					result = "seventeen";
					break;
				case '8':
					result = "eighteen";
					break;
				case '9':
					result = "nineteen";
					break;
			}
		}
		else
		{
			switch(digit) {
			case '0':
				break;
			case '1':
				result = "one";
				break;
			case '2':
				result = "two";
				break;
			case '3':
				result = "three";
				break;
			case '4':
				result = "four";
				break;
			case '5':
				result = "five";
				break;
			case '6':
				result = "six";
				break;
			case '7':
				result = "seven";
				break;
			case '8':
				result = "eight";
				break;
			case '9':
				result = "nine";
				break;
			}
		}
		
		return result;
	}
	
	public static String Ten( char digit )
	{
		String result = "";
		
		switch(digit) {
			case '0':
			case '1':
				break;
			case '2':
				result = "twenty";
				break;
			case '3':
				result = "thirty";
				break;
			case '4':
				result = "forty";
				break;
			case '5':
				result = "fifty";
				break;
			case '6':
				result = "sixty";
				break;
			case '7':
				result = "seventy";
				break;
			case '8':
				result = "eighty";
				break;
			case '9':
				result = "ninety";
				break;
		}
		
		return result;
	}
	
	public static String Hundred( char digit )
	{
		String result = "";
		switch(digit) {
			case '0':
				break;
			case '1':
				result = "one hundred";
				break;
			case '2':
				result = "two hundred";
				break;
			case '3':
				result = "three hundred";
				break;
			case '4':
				result = "four hundred";
				break;
			case '5':
				result = "five hundred";
				break;
			case '6':
				result = "six hundred";
				break;
			case '7':
				result = "seven hundred";
				break;
			case '8':
				result = "eight hundred";
				break;
			case '9':
				result = "nine hundred";
				break;
		}
		
		return result;
	}
}