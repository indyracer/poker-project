import static org.junit.Assert.*;

import org.junit.Test;

public class HandEvaluationIsTwoPair {
	
	Card tempCard1 = new Card("Three", "Diamonds");
	Card tempCard2 = new Card("Three", "Hearts");
	Card tempCard3 = new Card("Four", "Spades");
	Card tempCard4 = new Card("Jack", "Clubs");
	Card tempCard5 = new Card("Queen", "Hearts");
	Card tempCard6 = new Card("Five", "Diamonds");
	Card tempCard7 = new Card("Five", "Spades");
	
	Card [] hand1 = {tempCard1, tempCard2, tempCard3, tempCard4, tempCard5}; //hand with 1 pair
	Card [] hand2 = {tempCard1, tempCard2, tempCard3, tempCard6, tempCard7}; //hand with 2 pairs
	Card [] hand3 = {tempCard1, tempCard3, tempCard4, tempCard5, tempCard6}; //hand with no pairs
	
	public boolean isTwoPair(Card[] hand){
		boolean twoPair = false;
		int [] score = Hand.faceScore(hand);
		
		//place scores in an array, look at length of array, for two pair countTwo == 2, countOne = 1
		int countTwo = 0, countOne = 0, countOther = 0;
		
		for(int i = 0; i < score.length; i++){
			if(score[i] == 2){
				countTwo++;
			}
			if(score[i] == 1){
				countOne++;
			}
		}
		
		int [] pairSequence = {countTwo, countOne, countOther};
		
		//sequence to determine there is only 1 pair
		if(pairSequence[0] == 2 && pairSequence[1] == 1){
			twoPair = true;
		}
		
		return twoPair;
		
	}

	/*
	 * Scenario 1:  hand has two pair should return true
	 */
	@Test
	public void isTwoPair1() {
		Card [] hand2 = {tempCard1, tempCard2, tempCard3, tempCard6, tempCard7}; //hand with 2 pairs
		assertTrue(isTwoPair(hand2));
	}
	
	/*
	 * Scenario 2:  hand is one pair, should return false
	 */
	@Test
	public void isTwoPair2(){
		Card [] hand2 = {tempCard1, tempCard2, tempCard3, tempCard4, tempCard7}; //hand with 1 pairs
		assertTrue(!isTwoPair(hand2));
	}
	
	/*
	 * Scenario 3:  had is full house, should return false
	 */
	@Test
	public void isTwoPair3(){
		Card [] hand2 = {tempCard1, tempCard1, tempCard1, tempCard4, tempCard4}; 
		assertTrue(!isTwoPair(hand2));
	}
	
	/*
	 * Scenario 4:  is four of a kind, should return false
	 */
	@Test
	public void isTwoPair4(){
		Card [] hand2 = {tempCard1, tempCard2, tempCard2, tempCard2, tempCard7}; 
		assertTrue(!isTwoPair(hand2));
	}
	
	/*
	 * Scenario 5:  no pair, high card, return false
	 */
	@Test
	public void isTwoPair5(){
		Card [] hand2 = {tempCard1, tempCard5, tempCard3, tempCard4, tempCard7}; //hand with 1 pairs
		assertTrue(!isTwoPair(hand2));
	}

}
