
/**
 * Board ADT
 * If a square has been "toured" by the knight, it is 1
 * If a square has not been visited, it is 0
 * @author mpark
 * @date 9/23/2016
 */
public class Board
{
	/**
	 * Accepts the number of rows and columns
	 * @param rows Int number of rows
	 * @param cols Int number of columns
	 * @param knight Knight object
	 */
	public Board( int rows , int cols , Knight knight )
	{
		board = new int[rows][cols];
		
		for( int row = 0 ; row < rows ; row++ ) {
			for( int col = 0 ; col < cols ; col++ ) {
				board[row][col] = 0;
			}
		}
		
		board[knight.getCurrentPosition().row][knight.getCurrentPosition().col] = 1;
	}
	
	/**
	 * This public method will mainly used by Knight to move
	 * 	the knight to a new position.
	 * @param knight
	 * @param destination
	 * @return True if the move was successful
	 */
	public boolean move( Knight knight , Position destination )
	{
		if( isMoveValid(destination) ) {
			board[destination.row][destination.col] = 1;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This public method will be called when a knight has to step back
	 * 	to a previous position. This method will be used during tour simulation
	 * @param knight
	 * @param destination
	 * @return True if the move was successful
	 */
	public boolean step_back( Knight knight , Position destination )
	{
		if( isStepBackMoveValid(destination) ) {
			board[knight.getCurrentPosition().row][knight.getCurrentPosition().col] = 0;
			board[destination.row][destination.col] = 1;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This public method will determine if the knight is stuck.
	 * This function will mainly be called by Knight.
	 * @param knight
	 * @return True if the knight is stuck and there can be no more moves
	 */
	public boolean isKnightStuck( Knight knight )
	{
		for( int i = 1 ; i <= 8 ; i++ ) {
			if ( isMoveValid(Move.nextPos(i).toPosition( knight.getCurrentPosition())) ) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This public method will determine if the board is full and
	 * all square has been visited by the knight.
	 * @return True if the board is full or all square has been toured
	 */
	public boolean isFull()
	{
		for( int row = 0 ; row < board.length ; row++ ) {
			for( int col = 0 ; col < board[row].length ; col++ ) {
				if( board[row][col] == 0 ) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Given a destination position, this public method will
	 * determine if the destination is a valid square on the board
	 * @param destination
	 * @return True if the move is valid
	 */
	private boolean isMoveValid( Position destination )
	{
		return ( destination.row >= 0 && 
				 destination.col >= 0 &&
				 destination.row < board.length && 
				 destination.col < board[0].length &&
				 board[destination.row][destination.col] == 0 );
	}
	
	/**
	 * Given a destination position, this public method will
	 * determine if the destination is valid for stepping back
	 * @param destination
	 * @return
	 */
	private boolean isStepBackMoveValid( Position destination )
	{
		return ( destination.row >= 0 && 
				 destination.col >= 0 &&
				 destination.row < board.length && 
				 destination.col < board[0].length );
	}
	
	/**
	 * Overloaded toString() method to print the board
	 * @return String formatted board output
	 */
	public String toString()
	{
		String printedBoard = "";
		
		for( int row = 0 ; row < board.length ; row++ ) {
			for( int col = 0 ; col < board[row].length ; col++ ){
				printedBoard = printedBoard + board[row][col] + " ";
			}
			printedBoard += "\n";
		}
		return printedBoard;
	}
	
	// 2D Array for simulating the chess board
	private int[][] board;
}