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
	
	public boolean isThreeKind(Hand hand){
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
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard1;
		hand.card4 = tempCard4;
		hand.card5 = tempCard5;
		
		assertTrue(isThreeKind(hand));
	}
	
	/*
	 * Scenario 2:  hand is a pair, result should return false
	 */
	@Test
	public void isThreeKind2(){
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard3;
		hand.card4 = tempCard4;
		hand.card5 = tempCard5;
		
		assertTrue(!isThreeKind(hand));
	}
	
	/*
	 * Scenario 3:  hand is full house, should return false
	 */
	@Test
	public void isThreeKind3(){
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard1;
		hand.card4 = tempCard4;
		hand.card5 = tempCard4;
		
		assertTrue(!isThreeKind(hand));
	}

}
