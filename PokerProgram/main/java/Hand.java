
public class Hand {

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
	
	//methods for hand
	
	//calculate suit score
	public static int[] suitScore(Card [] hand){
		//score hand based on suits
		int diamondScore = 0, heartScore = 0, clubScore = 0, spadeScore = 0;
		
		//loop thru cards, score the suit value
		for(int i = 0; i < hand.length; i++){
			switch(hand[i].suit){
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
	//calculate score of hand
	public static int[] faceScore(Card [] hand){
		int deuceScore = 0, threeScore = 0, fourScore = 0, fiveScore = 0, sixScore = 0, sevenScore = 0,
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
	
	//method to evaluate if hand is a pair
	public boolean isPair(Card[] hand){
		boolean pair = false;
		int [] score = Hand.faceScore(hand);
		
		//place scores in an array, look at length of array, should be 4 (1 card with 2 points, 3 cards with 1 point)
		int countTwo = 0, countOne = 0, countOther = 0;
		
		for(int i = 0; i < score.length; i++){
			if(score[i] == 2){
				countTwo++;
			}
			else if(score[i] == 1){
				countOne++;
			}
			else{
				countOther++;
			}			
		}
		
		int [] pairSequence = {countTwo, countOne, countOther};
		
		//sequence to determine there is only 1 pair
		if(pairSequence[0] == 1 && pairSequence[1] == 3){
			pair = true;
		}
		
		return pair;
	}
	
	//method to evaluate if hand is three of a kind
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
	
	//method to evaluate if two pair
	public boolean isTwoPair(Card[] hand){
		boolean twoPair = false;
		int [] score = Hand.faceScore(hand);
		
		//place scores in an array, look at length of array, for two pair countTwo == 2, countOne = 1
		int countTwo = 0, countOne = 0, countOther = 0;
		
		for(int i = 0; i < score.length; i++){
			if(score[i] == 2){
				countTwo++;
			}
			if(score[i] == 1){
				countOne++;
			}
		}
		
		int [] pairSequence = {countTwo, countOne, countOther};
		
		//sequence to determine there is only 1 pair
		if(pairSequence[0] == 2 && pairSequence[1] == 1){
			twoPair = true;
		}
		
		return twoPair;
		
	}
	
	//method to evaluate if full house
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
	
	//method to evaluate if four of a kind
	public boolean isFourKind(Card[] hand){
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
	
	//method to evaluate straight
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

	
	

}
