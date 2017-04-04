
public class Knight
{
	/**
	 * Constructor that requires Initial Position of the knight on the board
	 * @param initialPosition Starting Position of the knight
	 */
	public Knight( Position initialPosition )
	{
		currentPos = new Position( initialPosition.row , initialPosition.col );
	}
	
	/**
	 * Method to check if knight is stuck in its current position
	 * @return True if the knight is stuck
	 */
	public boolean isStuck( Board board )
	{
		return board.isKnightStuck( this );
	}
	
	/**
	 * Method to return the current Position of the knight
	 * @return currentPos current Position of the knight
	 */
	public Position getCurrentPosition()
	{
		return currentPos;
	}
	
	/**
	 * Public method to move the knight to the specified Position on the board
	 * @param board Board object
	 * @param move Int Move Number
	 * @return True if the move was successful
	 */
	public boolean move( Board board , int move )
	{
		Position destination = Move.nextPos(move).toPosition( currentPos );
		if ( board.move(this , destination) ) {
			currentPos = destination;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Public method for moving the knight to a previous position
	 * @param board
	 * @param move
	 * @return True if the move was successful
	 */
	public boolean step_back( Board board , int move )
	{
		Position destination = Move.nextPos(move).toPosition( currentPos );
		if( board.step_back(this , destination) ) {
			currentPos = destination;
			return true;
		}
		else {
			return false;
		}
	}
	
	// Current Position of the Knight
	private Position currentPos;
}