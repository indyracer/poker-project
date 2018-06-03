import static org.junit.Assert.*;

import org.junit.Test;



public class HandEvaluationTestsIsPair {
	
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
	
	public boolean isPair(Card[] hand){
		boolean pair = false;
		int [] score = Hand.faceScore(hand);
		
		//place scores in an array, look at length of array, should be 4 (1 card with 2 points, 3 cards with 1 point)
		int countTwo = 0, countOne = 0, countOther = 0;
		
		for(int i = 0; i < score.length; i++){
			if(score[i] == 2){
				countTwo++;
			}
			else if(score[i] == 1){
				countOne++;
			}
			else{
				countOther++;
			}			
		}
		
		int [] pairSequence = {countTwo, countOne, countOther};
		
		//sequence to determine there is only 1 pair
		if(pairSequence[0] == 1 && pairSequence[1] == 3){
			pair = true;
		}
		
		return pair;
	}
	
	/*
	 * Scenario 1:  hand has 1 pair
	 */
	@Test
	public void isPairTest1() {
		Card [] hand1 = {tempCard1, tempCard2, tempCard3, tempCard4, tempCard5};
			
		assertTrue(isPair(hand1));		
	}
	
	/*
	 * Scenario 2:  hand has 2 pairs, should return false
	 */
	@Test
	public void isPairTest2(){
		
		Card [] hand2 = {tempCard1, tempCard2, tempCard3, tempCard6, tempCard7}; //hand with 2 pairs
		
		assertTrue(!isPair(hand2));
	}
	
	/*
	 * Scenario 3:  hand has no pairs
	 */
	@Test
	public void isPairTest3(){
		Card [] hand3 = {tempCard1, tempCard3, tempCard4, tempCard5, tempCard6}; //hand with no pairs
		
		assertTrue(!isPair(hand3));
	}
	
	/*
	 * Scenrio 4:  hand has 3 of a kind, should return false
	 */
	@Test
	public void isPairTest4(){
		Card [] hand4 = {tempCard1, tempCard2, tempCard2, tempCard4, tempCard5}; //hand has 3 pair
		
		assertTrue(!isPair(hand4));
		
	}
	
	/*
	 * Scenario 5:  hand is full house, should return false
	 */
	@Test
	public void isPairTest5(){
		Card [] hand5 = {tempCard1, tempCard2, tempCard2, tempCard6, tempCard7}; //hand with 2 pairs
		
		assertTrue(!isPair(hand5));
	}

}
