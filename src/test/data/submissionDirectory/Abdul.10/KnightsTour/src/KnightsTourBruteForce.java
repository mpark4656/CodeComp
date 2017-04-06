import java.security.SecureRandom;
import java.util.ArrayList;

public class KnightsTourBruteForce
{
	public static SecureRandom randomMove = new SecureRandom();
	
	public static void main( String[] args )
	{
		ArrayList<Integer> counts = new ArrayList<>();
		
		for( int i = 0 ; i < 1000 ; i++ ) {
			// Create Position, Knight and Board instance
			Position initialPosition = new Position( 3 , 4 );
			Knight knight = new Knight( initialPosition );
			Board board = new Board( 8 , 8 , knight );
			
			counts.add( move(board , knight) );
		}
		
		counts.sort(null);
		
		System.out.println( counts.get(counts.size() - 1) );
	}
	
	public static int move( Board board , Knight knight )
	{
		int count = 1;
		
		while( !knight.isStuck(board) && !board.isFull() ) {
			if ( knight.move( board, 1 + randomMove.nextInt(8)) ) {
				count++;
			}
		}
		
		return count;
	}
}