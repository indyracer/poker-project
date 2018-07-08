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
 	
	public String handEvaluation(Card[] hand){
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
		assertTrue(handEvaluation(hand1).equals("Pair"));
		assertTrue(!handEvaluation(hand2).equals("Pair"));  //check that two pair does not come up as a pair
		System.out.println("Pair Evaluation is " + handEvaluation(hand1));
	}
	
	/*
	 * Scenario:  hand is two pair
	 */
	@Test
	public void twoPairTest(){
		assertTrue(handEvaluation(hand2).equals("Two Pair"));
		assertTrue(!handEvaluation(hand1).equals("Two Pair")); //check that pair does not come up as two pair
		System.out.println("Two Pair Evaluation is " + handEvaluation(hand2));
	}
	
	/*
	 * Scenario:  hand is three of a kind
	 */
	@Test
	public void threeOfAKindTest(){
		assertTrue(handEvaluation(hand3).equals("Three of a Kind"));
		System.out.println("Three of a Kind Evaluation is " + handEvaluation(hand3));
	}
	
	/*
	 * Scenario:  hand is four of a kind
	 */
	@Test
	public void fourOfAKindTest(){
		assertTrue(handEvaluation(hand4).equals("Four of a Kind"));
		assertTrue(!handEvaluation(hand3).equals("Four of a Kind")); //confirm that 3 of kind does not match four of a kind
		System.out.println("Four of a Kind Evaluation is " + handEvaluation(hand4));
	}
	
	/*
	 * Scenario:  hand is full house
	 */
	@Test
	public void fullHouseTest(){
		assertTrue(handEvaluation(hand5).equals("Full House"));
		assertTrue(!handEvaluation(hand3).equals("Full House")); //confirm that 3 of kind does not match full house 
		assertTrue(!handEvaluation(hand2).equals("Full House"));  //confirm that 2 pair does not match full house
		assertTrue(!handEvaluation(hand1).equals("Full House")); //confirm that a pair does not match full house
		System.out.println("Full House Evaluation is " + handEvaluation(hand5));		
	}
	
	/*
	 * Scenario:  hand is straight no flush
	 */
	@Test
	public void striaghtNoFlushTest(){
		assertTrue(handEvaluation(hand6).equals("Straight"));
		assertTrue(!handEvaluation(hand7).equals("Straight")); //confirm that straight flush does not match straight 
		System.out.println("Straight no Flush Evaluation is " + handEvaluation(hand6));		
	}
	
	/*
	 * Scenario:  hand is straight flush
	 */
	@Test
	public void flushTest(){
		assertTrue(handEvaluation(hand8).equals("Flush")); 
		assertTrue(!handEvaluation(hand7).equals("Flush")); //confirm straight flush does not match flush
		System.out.println("Flush Evaluation is " + handEvaluation(hand8));		
	}
	
	/*
	 * Scenario:  hand is straight flush
	 */
	@Test
	public void striaghtFlushTest(){
		assertTrue(!handEvaluation(hand6).equals("Straight Flush")); //confirm straight no flush does not match straight flush
		assertTrue(handEvaluation(hand7).equals("Straight Flush")); 
		System.out.println("Straight Flush Evaluation is " + handEvaluation(hand7));		
	}
	
	/*
	 * Scenario:  hand is high card
	 */
	@Test
	public void highCardTest(){
		assertTrue(handEvaluation(hand9).equals("High Card")); 
		assertTrue(!handEvaluation(hand8).equals("High Card")); 
		System.out.println("High Card Evaluation is " + handEvaluation(hand9));		
	}

}

