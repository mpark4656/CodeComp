import java.util.Scanner;

public class PerfectNumbers
{
	/**
	 * Description: Main Driver
	 * @author Michael Park
	 * @param args argument to the main method
	 */
	public static void main( String[] args )
	{
		Scanner input = new Scanner( System.in );
		
		/**
		 * Prompt user to enter the number
		 */
		System.out.print( "Enter the number up to which you would like to look for perfect numbers:" );
		int number = input.nextInt();
		
		System.out.println( "Looking for perfect numbers from 1 to " + number );
		
		/**
		 * From 1 to the number, test if the value is perfect. If so, print the factors
		 */
		for( int i = 1 ; i <= number ; i++ ) {
			if( isPerfect(i) ) {
				System.out.print( i + " is a perfect number ");
				printFactors( i );
			}
		}
		
		input.close();
	}
	
	/**
	 * Description: Invoke the recursive method to print all factors
	 * @param number must be a perfect number
	 */
	public static void printFactors( int number )
	{
		System.out.print( "it's factors are: 1 ");
		printFactors( number , 2 );
		System.out.println();
	}
	
	/**
	 * Description: Private recursive method to print all factors
	 * @param number must be a perfect number
	 * @param index If this variable is a factor, it will be printed
	 */
	private static void printFactors( int number , int index )
	{
		if( index <= Math.sqrt(number) ) {
			if( number % index == 0 ) {
				System.out.print( index + " " );
				printFactors( number , index + 1 );
				
				if( number / index > index ) {
					System.out.print( (number / index) + " " );
				}
				
			}
			else {
				printFactors( number , index + 1 );
			}	
		}
		else {
			return;
		}
	}
	
	/**
	 * Description: Public method that tests if the number is perfect.
	 * @param number the number to test
	 * @return true if the number is perfect or false if it is not perfect
	 */
	public static boolean isPerfect( int number )
	{
		/**
		 * If the number is odd, return false
		 * since there is no known odd perfect number.
		 */
		if( number % 2 != 0 ) {
			return false;
		}

		int total = 1;
		
		/**
		 * Find all factors of the number and add them to total.
		 * Add both factors to the total and test up to the sqrt of the number.
		 */
		for( int i = 2 ; i <= Math.sqrt(number) ; i++ ) {
			if( number % i == 0 ) {
				total += i;
				
				// Prevent adding duplicate factor
				if( number / i > i ) {
					total = total + number / i;
				}
			}
		}
		
		return total == number;
	}
}