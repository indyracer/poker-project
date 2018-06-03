import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	public static class Hand{
		Card card1, card2, card3, card4, card5;


		public Hand(){
			Deck gameDeck = new Deck();
			gameDeck.shuffle();

			card1 = gameDeck.dealCard();
			card2 = gameDeck.dealCard();
			card3 = gameDeck.dealCard();
			card4 = gameDeck.dealCard();
			card5 = gameDeck.dealCard();

			//place cards in an array for evaluations
			Card [] hand = {card1, card2, card3, card4, card5};


		}


		public static int[] faceScore(Card [] hand){
			//score the hand
			//setup face scores
			int deuceScore = 0, twoScore = 0, threeScore = 0, fourScore = 0, fiveScore = 0, sixScore = 0, sevenScore = 0,
					eightScore = 0, nineScore = 0, tenScore = 0, jackScore = 0, queenScore = 0, kingScore = 0, aceScore = 0;

			//loop thru cards, score the face values
			for(int i = 0; i < hand.length; i++){
				switch(hand[i].face){
				case "Deuce":
					deuceScore++;
					break;
				case "Three":
					threeScore++;
					break;
				case "Four":
					fourScore++;
					break;
				case "Five":
					fiveScore++;
					break;
				case "Six":
					sixScore++;
					break;
				case "Seven":
					sevenScore++;
					break;
				case "Eight":
					eightScore++;
					break;
				case "Nine":
					nineScore++;
					break;
				case "Ten":
					tenScore++;
					break;
				case "Jack":
					jackScore++;
					break;
				case "Queen":
					queenScore++;
					break;
				case "King":
					kingScore++;
					break;
				default:
					aceScore++;
				}
			}
			//place face scores in an array
			int [] faceScore = {deuceScore, threeScore, fourScore, fiveScore, sixScore, sevenScore,
					eightScore, nineScore, tenScore, jackScore, queenScore, kingScore, aceScore};

			return faceScore;			
		}

		Card tempCard1 = new Card("Three", "Diamonds");
		Card tempCard2 = new Card("Three", "Hearts");
		Card tempCard3 = new Card("Four", "Spades");
		Card tempCard4 = new Card("Jack", "Clubs");
		Card tempCard5 = new Card("Queen", "Hearts");
		Card tempCard6 = new Card("Five", "Diamonds");
		Card tempCard7 = new Card("Five", "Spades");

		/*
		 * Scenario:  create a hand, check that each card has a face and suit value
		 */
		@Test
		public void testHandCreation(){
			Hand hand = new Hand();
			assertTrue(hand.card1.getCardFace() != null);
			assertTrue(hand.card1.getCardSuit() != null);
			assertTrue(hand.card2.getCardFace() != null);
			assertTrue(hand.card2.getCardSuit() != null);
			assertTrue(hand.card3.getCardFace() != null);
			assertTrue(hand.card3.getCardSuit() != null);
			assertTrue(hand.card4.getCardFace() != null);
			assertTrue(hand.card4.getCardSuit() != null);
			assertTrue(hand.card5.getCardFace() != null);
			assertTrue(hand.card5.getCardSuit() != null);
		}

		/*
		 * Scenario:  create hand, test that face scoring is happening
		 */
		@Test
		public void testHandFaceScoring(){
			Card [] hand = {tempCard1, tempCard2, tempCard3, tempCard4, tempCard5};

			int [] score = Hand.faceScore(hand);
			//face values in the hand:  three(2x), Four, jack, queen
			System.out.println(score[1]);

			assertEquals(2, score[1]);
			assertEquals(1, score[2]);
			assertEquals(1, score[9]);
			assertEquals(1, score[10]);
			assertEquals(0, score[0]);


		}

	}

}
