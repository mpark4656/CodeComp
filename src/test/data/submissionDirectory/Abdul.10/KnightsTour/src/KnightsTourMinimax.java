import java.util.ArrayList;

public class KnightsTourMinimax
{
	public static void main( String[] args )
	{
		// Create Position, Knight and Board instance
		Position initialPosition = new Position( 2 , 2 );
		Knight knight = new Knight( initialPosition );
		Board board = new Board( 3 , 3 , knight );
		
		// Print the number of maximum total moves the knight was able
		// to make on the given board dimension. Knight's initial position
		// does counts as a move.
		System.out.println( 1 + moveKnight(board , knight) + "\n" );
		
		System.out.println( "Chess Board with Knight's Initial Position" );
		System.out.println( board );
	}
	
	/**
	 * Recursive method to simulate all possible moves that knight can make
	 * on the board from the initial position. Return the maximum number of moves
	 * that the knight is able to make when moving in any possible combination 
	 * of directions
	 * @param board
	 * @param knight
	 * @return Int number of moves for each simulation
	 */
	public static int moveKnight( Board board , Knight knight )
	{
		// If the board is full or knight is stuck, return to caller
		if( knight.isStuck(board) || board.isFull() ) {
			return 0;
		}
		
		// Store number of moves for each direction
		ArrayList<Integer> counts = new ArrayList<>();
		
		for( int move = 1 ; move <= 8 ; move++ ) {
			// Simulate knight's single move on the board
			if( knight.move(board, move) ) {
				// count is 1 because knight just successfully made a movement
				int count = 1;
				
				// Recursively call this method to simulate the next move
				count += moveKnight( board , knight );
				
				// Add count to array
				counts.add( count );
				
				// Move the knight back to original position after simulation
				// For example, if the knight moved to Direction 1, to move the knight
				// back to the original position, it would have to move to Direction 5
				// See Move.java for more information
				if( move < 5 ) {
					knight.step_back( board, move + 4 );
				}
				else {
					knight.step_back( board, move - 4 );
				}
			}
		}
		
		// Sort the elements from smallest to largest
		counts.sort(null);
		
		// Return the maximum possible moves
		return counts.get(counts.size() - 1);
	}
}