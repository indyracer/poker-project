
public class Hand {

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
	
	//methods for hand
	//calculate score of hand
	public int[] faceScore(Card [] hand){
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
	
	

}
