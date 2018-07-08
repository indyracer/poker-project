import static org.junit.Assert.*;

import org.junit.Test;

public class HandEvaluationFlushTest {
	
	Card tempCard1 = new Card("Three", "Diamonds");
	Card tempCard2 = new Card("Four", "Diamonds");
	Card tempCard3 = new Card("Five", "Diamonds");
	Card tempCard4 = new Card("Six", "Diamonds");
	Card tempCard5 = new Card("Eight", "Diamonds");
	Card tempCard6 = new Card("Five", "Hearts");
	Card tempCard7 = new Card("Five", "Spades");
	

	public boolean isFlush(Hand hand){
		boolean isFlush = false;
		
		
		int [] score = Hand.suitScore(hand);
		
		if(score[0] == 5 || score[1] == 5 || score[2] == 5 || score[3] == 5){
			isFlush = true;
		}
		
		return isFlush;
	}

	/*
	 * Scenario:  hand is a flush
	 */
	@Test
	public void test() {
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard1;
		hand.card4 = tempCard1;
		hand.card5 = tempCard1;
		
		Card [] cards = {tempCard1, tempCard1, tempCard1, tempCard1, tempCard1};
		
		assertTrue(isFlush(hand));
	}
	
	/*
	 * Scenario:  hand is not a flush
	 */
	@Test
	public void testIsFlush2(){
		
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard2;
		hand.card3 = tempCard3;
		hand.card4 = tempCard4;
		hand.card5 = tempCard6;
		
		Card [] cards = {tempCard1, tempCard2, tempCard3, tempCard4, tempCard6};
		
		assertTrue(!isFlush(hand));
	}

}
