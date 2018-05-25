import static org.junit.Assert.*;

import org.junit.Test;


public class DeckTest2 {

	public class Deck{
		private Card deck[];
		protected int currentCard = -1;
		

		//constructor
		public Deck(){
			String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
			String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};

			deck = new Card[52];

			//populate deck with cards
			for (int count = 0; count < deck.length; count++){
				deck[count] = new Card(faces[count % 13], suits[count / 13]);
			}
		}

		public void shuffle(){
			//for each card, pick another random card and swap them
			for(int first = 0; first < deck.length; first++){
				int second = (int)(Math.random() * 52);
				Card temp = deck[first];
				deck[first] = deck[second];
				deck[second] = temp;
			}
		}
		
		public Card dealCard(){
			Card tempCard = deck[++currentCard];
			return tempCard;
		}
	}

	/*
	 *verify deck has been populated with 52 cards
	 */
	@Test
	public void deckSizeTest() {
		Deck deck1 = new Deck();
		assertEquals(52, deck1.deck.length);
	}

	/*
	 * Confirm there are 13 cards with of each suit
	 */
	@Test
	public void suitCountTest(){
		
		int numberHearts = 0, numberDiamonds = 0, numberClubs = 0, numberSpades = 0;

		Deck deck = new Deck();

		for(int count = 0; count < deck.deck.length; count++){
			Card card = deck.deck[count];
			switch(card.getCardSuit()){
			case "Hearts":
				numberHearts++;
				break;
			case "Diamonds":
				numberDiamonds++;
				break;
			case "Clubs":
				numberClubs++;
				break;
			case "Spades":
				numberSpades++;
				break;
			}
		}

		assertEquals(13, numberHearts);
		assertEquals(13, numberDiamonds);
		assertEquals(13, numberClubs);
		assertEquals(13, numberSpades);

	}
	
	/*
	 * Verify there are 4 cards of every face
	 */
	public void faceCountTest(){
		Deck deck = new Deck();
		int ace = 0, duece = 0, three = 0, four = 0, five = 0, six =0,
				seven = 0, eight =0, nine = 0, ten = 0, jack = 0, queen = 0, king = 0;
		for(int count = 0; count < deck.deck.length; count++){
			Card card = deck.deck[count];
			switch(card.getCardFace()){
			case "Ace":
				ace++;
				break;
			case "Duece":
				duece++;
				break;
			case "Three":
				three++;
				break;
			case "Four":
				four++;
				break;
			case "Five":
				five++;
				break;
			case "Six":
				six++;
				break;
			case "Seven":
				seven++;
				break;
			case "Eight":
				eight++;
				break;
			case "Nine":
				nine++;
				break;
			case "Ten":
				ten++;
				break;
			case "Jack":
				jack++;
				break;
			case "Queen":
				queen++;
				break;
			case "King":
				king++;
				break;
			}
		}
		
		assertEquals(4, ace);
		assertEquals(4, duece);
		assertEquals(4, three);
		assertEquals(4, four);
		assertEquals(4, five);
		assertEquals(4, six);
		assertEquals(4, seven);
		assertEquals(4, eight);
		assertEquals(4, nine);
		assertEquals(4, ten);
		assertEquals(4, jack);
		assertEquals(4, queen);
		assertEquals(4, king);
	}

	/*
	 * Test that deck has been shuffled.  compare pre/post deck order
	 */
	@Test
	public void shuffleTest(){
		Deck deck = new Deck();
		
		Deck temp = deck; //snap shot of deck before being shuffled
		
		deck.shuffle();  //deck after being shuffled
		
		int count = 0;
		
		//first card of each deck
		Card tempCard = temp.deck[count];
		Card deckCard = deck.deck[count];
		
		//flag to set to true once different card values found, indicates deck has been shuffled
		boolean isShuffled = false;
		
		//loop to compare cards in order
		while(isShuffled){
			if(tempCard.equals(deckCard)){
				isShuffled = true;
			}
		}
				
	}
	
	/*
	 * test that a card has been dealt
	 */
	@Test
	public void testDealCard(){
		Deck tempDeck = new Deck();
		tempDeck.shuffle();
		Card card1 = tempDeck.dealCard(); //card at 0 index
		Card card2 = tempDeck.dealCard(); //card at 1 index
		Card card3 = tempDeck.dealCard(); //card at 2 index
		Card card4 = tempDeck.dealCard(); //card at 3 index
		Card card5 = tempDeck.dealCard(); //card at 4 index
		
		assertEquals(card1, tempDeck.deck[0]);
		assertEquals(card2, tempDeck.deck[1]);
		assertEquals(card3, tempDeck.deck[2]);
		assertEquals(card4, tempDeck.deck[3]);
		assertEquals(card5, tempDeck.deck[4]);
	}

}
