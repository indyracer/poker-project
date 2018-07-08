import static org.junit.Assert.*;

import org.junit.Test;

public class HandEvaluationIsFourKind {
	
	Card tempCard1 = new Card("Three", "Diamonds");
	Card tempCard2 = new Card("Three", "Hearts");
	Card tempCard3 = new Card("Four", "Spades");
	Card tempCard4 = new Card("Jack", "Clubs");
	Card tempCard5 = new Card("Queen", "Hearts");
	Card tempCard6 = new Card("Five", "Diamonds");
	Card tempCard7 = new Card("Five", "Spades");
	
	public boolean isFourKind(Hand hand){
		boolean isFourKind = false;
		
		int [] score = Hand.faceScore(hand);
		
		int countFour = 0;
		
		for(int i = 0; i < score.length; i++){
			if(score[i] == 4){
				countFour++;
			}
		}
		
		if(countFour == 1){
			isFourKind = true;
		}
		
		return isFourKind;
	}
	
	/*
	 * Scenario 1:  hand has 4 of a kind
	 */
	@Test
	public void isFourKindTest1() {
		
		Hand hand1 = new Hand();
		hand1.card1 = tempCard1;
		hand1.card2 = tempCard1;
		hand1.card3 = tempCard1;
		hand1.card4 = tempCard1;
		hand1.card5 = tempCard5;
		
		//Card [] hand1 = {tempCard1, tempCard1, tempCard1, tempCard1, tempCard5};
		
		assertTrue(isFourKind(hand1));
	}
	
	/*
	 * Scenario 2:  hand is full house, should return false
	 */
	@Test
	public void isFourKindTest2(){
		
		Hand hand2 = new Hand();
		hand2.card1 = tempCard1;
		hand2.card2 = tempCard1;
		hand2.card3 = tempCard1;
		hand2.card4 = tempCard4;
		hand2.card5 = tempCard4;
		
		//Card [] hand2 = {tempCard1, tempCard1, tempCard1, tempCard4, tempCard4};
		
		assertTrue(!isFourKind(hand2));
	}
	
	/*
	 * Scenario 3:  hand is three of a kind, should return false
	 */
	@Test
	public void isFourKindTest3(){
		
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard1;
		hand.card4 = tempCard4;
		hand.card5 = tempCard5;
		
		//Card [] hand3 = {tempCard1, tempCard1, tempCard1, tempCard4, tempCard5};
		
		assertTrue(!isFourKind(hand));
	}

}
