import java.security.SecureRandom;
import java.util.ArrayList;

public class Deck
{
	private static final SecureRandom randomNumber = new SecureRandom();
	
	private static final int NUMBER_OF_CARDS = 52;
	private Card[] deck;
	private int currentCard;
	
	public Deck()
	{
		String[] faces = { "Ace" , "Deuce" , "Three" , "Four" , "Five" , "Six" , "Seven" ,
						   "Eight" , "Nine" , "Ten" , "Jack" , "Queen" , "King"};
		
		String[] suits = { "Hearts" , "Diamond" , "Clubs" , "Spades" };
		
		deck = new Card[NUMBER_OF_CARDS];
		currentCard = 0;
		
		for( int count = 0 ; count < deck.length ; count++ ) {
			deck[count] = new Card( faces[count % 13] , suits[count / 13] );
		}
	}
	
	public void shuffle()
	{
		currentCard = 0;
		
		for( int first = 0 ; first < deck.length ; first++ ) {
			Card temp = deck[first];
			int second = randomNumber.nextInt(NUMBER_OF_CARDS);
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	
	public Card dealCard()
	{
		if( currentCard < deck.length ) {
			return deck[currentCard++];
		}
		else {
			return null;
		}
	}
	
	public boolean isStraight( Card[] cards )
	{
		String[] faces = { "Ace" , "Deuce" , "Three" , "Four" , "Five" , "Six" , "Seven" ,
				   "Eight" , "Nine" , "Ten" , "Jack" , "Queen" , "King"};
		
		ArrayList<Integer> faceIndices = new ArrayList<>();
		
		for( int i = 0 ; i < cards.length ; i++ ) {
			for( int j = 0 ; j < faces.length ; j++ ) {
				if( cards[i].getFace().equals(faces[j]) ) {
					faceIndices.add(j);
				}
			}
		}
		
		faceIndices.sort(null);
		
		for( int i = 0 ; i < faceIndices.size() - 1 ; i++ ) {
			if( faceIndices.get(i) + 1 != faceIndices.get(i + 1) ) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isFullHouse( Card[] cards )
	{
		int[] counts = new int[cards.length];
		
		for( int i = 0 ; i < cards.length ; i++ ) {
			int count = 0;
			for( int j = 0 ; j < cards.length ; j++ ) {
				if( cards[i].equals(cards[j]) ) {
					count++;
				}
			}
			counts[i] = count;
		}
		
		int sum = 0;
		for( int x : counts ) {
			sum += x;
		}
		
		return sum == cards.length + 8;
	}
	
	public boolean isFlush( Card[] cards )
	{
		Card temp = cards[0];
		
		for( Card x : cards ) {
			if( x.getSuit() != temp.getSuit() ) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isFourOfAKind( Card[] cards )
	{
		int[] counts = new int[cards.length];
		
		for( int i = 0 ; i < cards.length ; i++ ) {
			int count = 0;
			for( int j = 0 ; j < cards.length ; j++ ) {
				if( cards[i].equals(cards[j]) ) {
					count++;
				}
			}
			counts[i] = count;
		}
		
		int sum = 0;
		for( int x : counts ) {
			sum += x;
		}
		
		return sum == cards.length + 12;
	}
	
	public boolean isThreeOfAKind( Card[] cards )
	{
		int[] counts = new int[cards.length];
		
		for( int i = 0 ; i < cards.length ; i++ ) {
			int count = 0;
			for( int j = 0 ; j < cards.length ; j++ ) {
				if( cards[i].equals(cards[j]) ) {
					count++;
				}
			}
			counts[i] = count;
		}
		
		int sum = 0;
		for( int x : counts ) {
			sum += x;
		}
		
		return sum == cards.length + 6;
	}
	
	public boolean isTwoPair( Card[] cards )
	{
		int[] counts = new int[cards.length];
		
		for( int i = 0 ; i < cards.length ; i++ ) {
			int count = 0;
			for( int j = 0 ; j < cards.length ; j++ ) {
				if( cards[i].equals(cards[j]) ) {
					count++;
				}
			}
			counts[i] = count;
		}
		
		int sum = 0;
		for( int x : counts ) {
			sum += x;
		}
		
		return sum == cards.length + 4;
	}
	
	public boolean isPair( Card[] cards )
	{
		int[] counts = new int[cards.length];
		
		for( int i = 0 ; i < cards.length ; i++ ) {
			int count = 0;
			for( int j = 0 ; j < cards.length ; j++ ) {
				if( cards[i].equals(cards[j]) ) {
					count++;
				}
			}
			counts[i] = count;
		}
		
		int sum = 0;
		for( int x : counts ) {
			sum += x;
		}
		
		return sum == cards.length + 2;
	}
}