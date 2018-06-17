import static org.junit.Assert.*;


import org.junit.Test;
import java.util.Arrays;

public class HandEvaluationIsStraight {
	
	Card tempCard1 = new Card("Three", "Diamonds");
	Card tempCard2 = new Card("Four", "Diamonds");
	Card tempCard3 = new Card("Five", "Diamonds");
	Card tempCard4 = new Card("Six", "Diamonds");
	Card tempCard5 = new Card("Seven", "Diamonds");
	Card tempCard6 = new Card("Five", "Hearts");
	Card tempCard7 = new Card("Five", "Spades");
	
	public boolean isStraight(Card[] hand){
		boolean isStraight = false;
		
		int[] score = Hand.faceScore(hand);
		
		//loop through scores, see if any 5 in a row.  end at index 8, lowest index of highest possible straight
		for(int i = 0; i <= 8; i++){
			if(score[i] == 1 && score[i +1] == 1 && score[i + 2] == 1 && score[i + 3] == 1 && score[i + 4] == 1){
				isStraight = true;
				break;
			}
			
		}
		
		return isStraight;
	}

	/*
	 * Scenario:  hand is a straight
	 */
	@Test
	public void isStraight1() {
		Card [] hand = {tempCard1, tempCard2, tempCard3, tempCard4, tempCard5};
		
		assertTrue(isStraight(hand));
	}
	
	/*
	 * Scenario:  hand is a pair, not a straight
	 */
	@Test
	public void isStraigth2(){
		Card[] hand = {tempCard1, tempCard1, tempCard3,tempCard4, tempCard5};
		
		assertTrue(!isStraight(hand));
	}

}
