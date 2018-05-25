import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	public static class Hand{
		Card card1, card2, card3, card4, card5;


		public Hand(){
			Deck gameDeck = new Deck();
			gameDeck.shuffle();

			card1 = gameDeck.dealCard();
			card2 = gameDeck.dealCard();
			card3 = gameDeck.dealCard();
			card4 = gameDeck.dealCard();
			card5 = gameDeck.dealCard();
		}

		public static boolean isPair(Card card1, Card card2, Card card3, Card card4, Card card5){
			boolean pair = false;
			int score = 0;

			if(card1.face.equals(card2.face) || card1.face.equals(card3.face) || card1.face.equals(card4.face) || card1.face.equals(card5.face)){
				score++;
			}
			if(card2.face.equals(card3.face) || card2.face.equals(card4.face) || card2.face.equals(card5.face)){
				score++;
			}
			if(card3.face.equals(card4.face) || card3.face.equals(card5.face)){
				score++;
			}
			if(card4.face.equals(card5.face)){
				score++;
			}

			//if score == 1, then only one pair
			if(score == 1){
				pair = true;
			}

			return pair;
		}
	}	

	Card tempCard1 = new Card("Three", "Diamonds");
	Card tempCard2 = new Card("Three", "Hearts");
	Card tempCard3 = new Card("Four", "Spades");
	Card tempCard4 = new Card("Jack", "Clubs");
	Card tempCard5 = new Card("Queen", "Hearts");
	Card tempCard6 = new Card("Five", "Diamonds");
	Card tempCard7 = new Card("Five", "Spades");
	
	
	 /*
	  * Scenario: only 1 Pair in hand, should result in returning true
	  */
	@Test 
	public void testIsPair() {
		boolean testPair = Hand.isPair(tempCard1, tempCard2, tempCard3, tempCard4, tempCard5);
		assertTrue(testPair);
	}
	
	/*
	 * Scenario:  no pairs in the hand, should return false
	 */
	@Test
	public void testIsPair2(){
		boolean testPair = Hand.isPair(tempCard1, tempCard6, tempCard3, tempCard4, tempCard5);
		assertTrue(!testPair);
	}
	
	/*
	 * Scenario:  two pairs in the hand, should return false
	 */
	@Test
	public void testIsPair3(){
		boolean testPair = Hand.isPair(tempCard1, tempCard2, tempCard3, tempCard6, tempCard7);
		assertTrue(!testPair);
	}


}
