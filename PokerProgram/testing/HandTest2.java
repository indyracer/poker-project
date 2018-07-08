import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest2 {

	public static class Hand{
		Card card1, card2, card3, card4, card5;
		
		Card [] hand = new Card[5];


		public Hand(){
			Deck gameDeck = new Deck();
			gameDeck.shuffle();

			card1 = gameDeck.dealCard();
			card2 = gameDeck.dealCard();
			card3 = gameDeck.dealCard();
			card4 = gameDeck.dealCard();
			card5 = gameDeck.dealCard();

			//place cards in an array for evaluations
			hand[0] = card1;
			hand[1] = card2;
			hand[2] = card3;
			hand[3] = card4;
			hand[4] = card5;


		}

		public static int[] suitScore(Hand hand){
			//score hand based on suits
			int diamondScore = 0, heartScore = 0, clubScore = 0, spadeScore = 0;
			
			Card [] cards = {hand.card1, hand.card2, hand.card3, hand.card4, hand.card5};
			
			//loop thru cards, score the suit value
			for(int i = 0; i < cards.length; i++){
				switch(cards[i].suit){
				case "Diamonds":
					diamondScore++;
					break;
				case "Hearts":
					heartScore++;
					break;
				case "Clubs":
					clubScore++;
					break;
				case "Spades":
					spadeScore++;
					break;
				}
			}
			
			//place suit score into an array
			int [] suitScore = {diamondScore, heartScore, clubScore, spadeScore};
			
			return suitScore;		
		}
		
		
		public static int[] faceScore(Hand hand){
			//score the hand
			//setup face scores
			int deuceScore = 0, threeScore = 0, fourScore = 0, fiveScore = 0, sixScore = 0, sevenScore = 0,
					eightScore = 0, nineScore = 0, tenScore = 0, jackScore = 0, queenScore = 0, kingScore = 0, aceScore = 0;
			
			Card [] cards = {hand.card1, hand.card2, hand.card3, hand.card4, hand.card5};
			//loop thru cards, score the face values
			for(int i = 0; i < cards.length; i++){
				switch(cards[i].face){
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
		Card tempCard8 = new Card("Six", "Diamonds");
		Card tempCard9 = new Card("Seven", "Diamonds");
		Card tempCard10 = new Card("Nine", "Diamonds");

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
			Hand hand = new Hand();
			
			hand.card1 = tempCard1;
			hand.card2 = tempCard2;
			hand.card3 = tempCard3;
			hand.card4 = tempCard4;
			hand.card5 = tempCard5;
			
			int [] score = faceScore(hand);
			//face values in the hand:  three(2x), Four, jack, queen

			assertEquals(2, score[1]);
			assertEquals(1, score[2]);
			assertEquals(1, score[9]);
			assertEquals(1, score[10]);
			assertEquals(0, score[0]);
		}
		
		/*
		 * Scenario:  create hand, test that suit scoring is happening
		 */
		@Test
		public void testSuitScoring(){
			
			Hand hand = new Hand();
			
			hand.card1 = tempCard1;
			hand.card2 = tempCard2;
			hand.card3 = tempCard3;
			hand.card4 = tempCard4;
			hand.card5 = tempCard5;
			//Card [] hand1 = {tempCard1, tempCard2, tempCard3, tempCard4, tempCard5}; 
		
			int [] score = suitScore(hand);
			
			System.out.println(score[0]);
			System.out.println(score[1]);
			System.out.println(score[2]);
			System.out.println(score[3]);
			
			assertEquals(1,	score[0]); //diamonds score
			assertEquals(2,	score[1]); //hearts score
			assertEquals(1, score[2]);//clubs score
			assertEquals(1, score[3]);//spades score
			
			
		}

	}

}
