import static org.junit.Assert.*;

import org.junit.Test;

public class HandEvalutionIsThreeKind {
	
	Card tempCard1 = new Card("Three", "Diamonds");
	Card tempCard2 = new Card("Three", "Hearts");
	Card tempCard3 = new Card("Four", "Spades");
	Card tempCard4 = new Card("Jack", "Clubs");
	Card tempCard5 = new Card("Queen", "Hearts");
	Card tempCard6 = new Card("Five", "Diamonds");
	Card tempCard7 = new Card("Five", "Spades");
	
	Card [] hand1 = {tempCard1, tempCard1, tempCard1, tempCard4, tempCard5}; //hand with 3 of a kind
	Card [] hand2 = {tempCard1, tempCard2, tempCard3, tempCard6, tempCard7}; //hand with 2 pairs
	Card [] hand3 = {tempCard1, tempCard3, tempCard4, tempCard5, tempCard6}; //hand with no pairs
	
	public boolean isThreeKind(Card[] hand){
		boolean isThreeKind = false;
		
		int [] score = Hand.faceScore(hand);
		
		//place scores in an array, looking for sequence that scoreThree = 1, scoreOne = 2
		int countThree = 0, countOne = 0;
		for(int i = 0; i < score.length; i++){
			if(score[i] == 3){
				countThree++;
			}
			
			if(score[i] == 1){
				countOne++;
			}
		}
		
		if(countThree == 1 && countOne == 2){
			isThreeKind = true;
		}
		
		return isThreeKind;
	}

	/*
	 * Scenario 1:  hand is three of a kind, result should return true
	 */
	@Test
	public void isThreeKind1(){
		Card [] hand1 = {tempCard1, tempCard1, tempCard1, tempCard4, tempCard5}; //hand with 3 of a kind
		
		assertTrue(isThreeKind(hand1));
		
		;
	}
	
	/*
	 * Scenario 2:  hand is a pair, result should return false
	 */
	@Test
	public void isThreeKind2(){
		Card [] hand1 = {tempCard1, tempCard1, tempCard3, tempCard4, tempCard5}; //hand with a pair
		
		assertTrue(!isThreeKind(hand1));
	}
	
	/*
	 * Scenario 3:  hand is full house, should return false
	 */
	@Test
	public void isThreeKind3(){
		Card [] hand1 = {tempCard1, tempCard1, tempCard1, tempCard4, tempCard4}; //hand with full house
		
		assertTrue(!isThreeKind(hand1));
	}

}
