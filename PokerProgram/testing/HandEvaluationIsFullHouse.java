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
	
	
	public boolean isFullHouse(Hand hand){
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
		
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard3;
		hand.card4 = tempCard3;
		hand.card5 = tempCard3;
		
		assertTrue(isFullHouse(hand));
		
	}
	
	/*
	 * Scenario 2:  hands is two pair, should return false
	 */
	@Test
	public void isFullHouseTest2(){
		
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard3;
		hand.card4 = tempCard4;
		hand.card5 = tempCard4;
		
		assertTrue(!isFullHouse(hand));
	}
	
	/*
	 * Scenario 3:  hand is three of a kind, should return false
	 */
	@Test
	public void isFullHouseTest3(){
		
		Hand hand = new Hand();
		hand.card1 = tempCard1;
		hand.card2 = tempCard1;
		hand.card3 = tempCard1;
		hand.card4 = tempCard3;
		hand.card5 = tempCard4;
		
		assertTrue(!isFullHouse(hand));
	}

}
