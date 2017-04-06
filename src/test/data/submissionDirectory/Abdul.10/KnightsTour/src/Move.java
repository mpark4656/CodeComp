
/**
 * Move ADT
 * Move stores how many steps or squares that a knight have to
 * jump horizontally and vertically
 * @author mpark
 *
 */
public class Move
{
	public Move( int rowToMove , int colToMove )
	{
		this.rowToMove = rowToMove;
		this.colToMove = colToMove;
	}
	
	/**
	 * Static method to return one of the 8 possible moves a knight 
	 * 	can make on the board
	 *                  
	 *    3   2          
	 *   4     1         
	 *      K
	 *   5     8      
	 *    6   7            
	 * 
	 * @param posNumber
	 * @return Move Knight Move specified by the Position Number
	 */
	public static Move nextPos( int posNumber )
	{
		switch( posNumber ) {
			case 1:
				return new Move( -1 , 2);
			case 2: 
				return new Move( -2 , 1 );
			case 3:
				return new Move( -2 , -1 );
			case 4:
				return new Move( -1 , -2 );
			case 5:
				return new Move( 1 , -2 );
			case 6:
				return new Move( 2 , -1 );
			case 7:
				return new Move( 2 , 1 );
			case 8:
				return new Move( 1 , 2 );
			default:
				return new Move( 0 , 0 );
		}
	}
	
	/**
	 * Given the starting position, this method returns the destination position
	 * @param start
	 * @return Position destination
	 */
	public Position toPosition( Position start )
	{
		return new Position( start.row + rowToMove , start.col + colToMove );
	}
	
	/**
	 * Public Get method to return rowToMove
	 * @return Int number of rows to jump
	 */
	public int getRowToMove()
	{
		return rowToMove;
	}
	
	/**
	 * Public Get method to return colToMove
	 * @return Int number of cols to jump
	 */
	public int getColToMove()
	{
		return colToMove;
	}
	
	private int rowToMove;
	private int colToMove;
}