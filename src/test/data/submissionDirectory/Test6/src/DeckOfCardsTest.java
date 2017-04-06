
public class DeckOfCardsTest
{
	public static void main( String[] args )
	{
		Deck myDeckOfCards = new Deck();
		myDeckOfCards.shuffle();
	
	for( int j = 0 ; j < 1 ; j++ ) {
		
	
		Card[] pokerHand = new Card[5];
		
		pokerHand[0] = new Card( "Deuce" , "Diamonds" );
		pokerHand[1] = new Card( "Three" , "Diamonds" );
		pokerHand[2] = new Card( "Nine" , "Diamonds" );
		pokerHand[3] = new Card( "Six" , "Diamonds" );
		pokerHand[4] = new Card( "Five" , "Diamonds" );
		
		if( myDeckOfCards.isFlush(pokerHand) ) {
			for( int i = 0 ; i < 5 ; i++ ) {
				System.out.println( pokerHand[i] );
			}
		}
		else {
			System.out.println( "" );
		}
	}
		
	}
}