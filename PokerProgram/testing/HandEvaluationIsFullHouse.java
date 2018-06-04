import static org.junit.Assert.*;

import org.junit.Test;

public class HandEvaluationIsFullHouse {
	
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
	
	
	public boolean isFullHouse(Card[] hand){
		boolean isFullHouse = false;
		
		int [] score = Hand.faceScore(hand);
		
		//place scores in an array, look at length of array, should be 4 (1 card with 2 points, 3 cards with 1 point)
		int countTwo = 0, countThree = 0;
		
		for(int i = 0; i < score.length; i++){
			
			if(score[i] == 2){
				countTwo++;
			}
			if(score[i] == 3){
				countThree++;
			}
		}
		
		if(countTwo == 1 && countThree == 1){
			isFullHouse = true;
		}
		
		return isFullHouse;
		
		
	}

	
	/*
	 * Scenario 1:  hand is a full house, with 1 pair and 1 three of a kind
	 */
	@Test
	public void isFullHouseTest1() {
		
		Card [] hand1 = {tempCard1, tempCard1, tempCard3, tempCard3, tempCard3};
		
		assertTrue(isFullHouse(hand1));
		
	}
	
	/*
	 * Scenario 2:  hands is two pair, should return false
	 */
	@Test
	public void isFullHouseTest2(){
		Card [] hand2 = {tempCard1, tempCard1, tempCard3, tempCard4, tempCard4};
		
		assertTrue(!isFullHouse(hand2));
	}
	
	/*
	 * Scenario 3:  hand is three of a kind, should return false
	 */
	@Test
	public void isFullHouseTest3(){
		Card [] hand3 = {tempCard1, tempCard1, tempCard1, tempCard3, tempCard4};
		
		assertTrue(!isFullHouse(hand3));
	}

}
