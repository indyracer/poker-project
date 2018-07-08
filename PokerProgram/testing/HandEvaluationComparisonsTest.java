import static org.junit.Assert.*;

import org.junit.Test;

public class HandEvaluationComparisonsTest {
	
	Card tempCard1 = new Card("Three", "Diamonds");
	Card tempCard2 = new Card("Three", "Hearts");
	Card tempCard3 = new Card("Four", "Spades");
	Card tempCard4 = new Card("Jack", "Clubs");
	Card tempCard5 = new Card("Queen", "Hearts");
	Card tempCard6 = new Card("Five", "Diamonds");
	Card tempCard7 = new Card("Five", "Spades");
	Card tempCard8 = new Card("Seven", "Spades");
	Card tempCard9 = new Card("Eight", "Spades");
	Card tempCard10 = new Card("Nine", "Spades");
	Card tempCard11 = new Card("Ten", "Spades");
	Card tempCard12 = new Card("Jack", "Spades");
	Card tempCard13 = new Card("Jack", "Diamonds");
	
	Card [] hand1 = {tempCard1, tempCard2, tempCard3, tempCard4, tempCard5}; //hand with 1 pair
	Card [] hand2 = {tempCard1, tempCard2, tempCard3, tempCard6, tempCard7}; //hand with 2 pairs
	Card [] hand3 = {tempCard1, tempCard1, tempCard1, tempCard5, tempCard6}; // hand with three of a kind
	Card [] hand4 = {tempCard1, tempCard1, tempCard1, tempCard1, tempCard6}; //hand with four of a kind
	Card [] hand5 = {tempCard1, tempCard1, tempCard1, tempCard6, tempCard6}; //hand is full house
	Card [] hand6 = {tempCard8, tempCard9, tempCard10, tempCard11, tempCard13}; //hand is straight, no flush
	Card [] hand7 = {tempCard8, tempCard9, tempCard10, tempCard11, tempCard12};  //hand is straight flush
	Card [] hand8 = {tempCard3, tempCard8, tempCard9, tempCard10, tempCard12};  //hand is flush, no straight
	Card [] hand9 = {tempCard1, tempCard8, tempCard9, tempCard11, tempCard12};  //hand is high card
 	
	public String handEvaluation(Hand hand){
		//put in logic to evaluate the various evaluations and display the evalution
		String evaluation = "";
		
		if(Hand.isPair(hand)){
			evaluation = "Pair";
		}
		
		else if(Hand.isTwoPair(hand)){
			evaluation =  "Two Pair"; 
		}
		
		else if (Hand.isThreeKind(hand)){
			evaluation = "Three of a Kind";
		}
		
		else if (Hand.isFourKind(hand)){
			evaluation = "Four of a Kind";
		}
		
		else if(Hand.isFullHouse(hand)){
			evaluation = "Full House";
		}
		
		else if (Hand.isStraight(hand) && !Hand.isFlush(hand)){
			evaluation = "Straight";
		}
		
		else if (Hand.isStraight(hand) && Hand.isFlush(hand)){
			evaluation = "Straight Flush";
		}
		else if (Hand.isFlush(hand) && !Hand.isStraight(hand)){
			evaluation = "Flush";
		}
		else {
			evaluation = "High Card";
		}
		
		return evaluation;
	}


	/*
	 * Scenario:  hand is a pair
	 */
	@Test
	public void pairTest() {
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard2;
		hand.card3 = tempCard3;
		hand.card4 = tempCard4;
		hand.card5 = tempCard5;
		
		assertTrue(handEvaluation(hand).equals("Pair"));
		System.out.println("Pair Evaluation is " + handEvaluation(hand));
	}
	
	/*
	 * Scenario:  hand is two pair
	 */
	@Test
	public void twoPairTest(){
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard2;
		hand.card3 = tempCard3;
		hand.card4 = tempCard6;
		hand.card5 = tempCard7;
		
		assertTrue(handEvaluation(hand).equals("Two Pair"));
		System.out.println("Two Pair Evaluation is " + handEvaluation(hand));
	}
	
	/*
	 * Scenario:  hand is three of a kind
	 */
	@Test
	public void threeOfAKindTest(){
		
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard1;
		hand.card4 = tempCard5;
		hand.card5 = tempCard6;
		
		assertTrue(handEvaluation(hand).equals("Three of a Kind"));
		System.out.println("Three of a Kind Evaluation is " + handEvaluation(hand));
	}
	
	/*
	 * Scenario:  hand is four of a kind
	 */
	@Test
	public void fourOfAKindTest(){
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard1;
		hand.card4 = tempCard1;
		hand.card5 = tempCard6;
		
		assertTrue(handEvaluation(hand).equals("Four of a Kind"));
		System.out.println("Four of a Kind Evaluation is " + handEvaluation(hand));
	}
	
	/*
	 * Scenario:  hand is full house
	 */
	@Test
	public void fullHouseTest(){
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard1;
		hand.card4 = tempCard6;
		hand.card5 = tempCard6;
		
		assertTrue(handEvaluation(hand).equals("Full House"));
		
		System.out.println("Full House Evaluation is " + handEvaluation(hand));		
	}
	
	/*
	 * Scenario:  hand is straight no flush
	 */
	@Test
	public void striaghtNoFlushTest(){
		Hand hand = new Hand();
		hand.card1 = tempCard8;
		hand.card2 = tempCard9;
		hand.card3 = tempCard10;
		hand.card4 = tempCard11;
		hand.card5 = tempCard13;
		assertTrue(handEvaluation(hand).equals("Straight"));
		System.out.println("Straight no Flush Evaluation is " + handEvaluation(hand));		
	}
	
	/*
	 * Scenario:  hand is straight flush
	 */
	@Test
	public void flushTest(){
		Hand hand = new Hand();
		hand.card1 = tempCard3;
		hand.card2 = tempCard8;
		hand.card3 = tempCard9;
		hand.card4 = tempCard10;
		hand.card5 = tempCard12;
		assertTrue(handEvaluation(hand).equals("Flush")); 
		System.out.println("Flush Evaluation is " + handEvaluation(hand));		
	}
	
	/*
	 * Scenario:  hand is straight flush
	 */
	@Test
	public void striaghtFlushTest(){
		Hand hand = new Hand();
		hand.card1 = tempCard8;
		hand.card2 = tempCard9;
		hand.card3 = tempCard10;
		hand.card4 = tempCard11;
		hand.card5 = tempCard12;
		assertTrue(handEvaluation(hand).equals("Straight Flush")); 
		System.out.println("Straight Flush Evaluation is " + handEvaluation(hand));		
	}
	
	/*
	 * Scenario:  hand is high card
	 */
	@Test
	public void highCardTest(){
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard8;
		hand.card3 = tempCard9;
		hand.card4 = tempCard11;
		hand.card5 = tempCard12;
		assertTrue(handEvaluation(hand).equals("High Card")); 
		System.out.println("High Card Evaluation is " + handEvaluation(hand));		
	}

}

