
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
	
	public String toString(){
		return card1.toString() + ", " + card2.toString() + ", " + card3.toString() + ", " + card4.toString() + ", " + card5.toString();
	}
	
	//calculate suit score
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
	//calculate score of hand
	public static int[] faceScore(Hand hand){
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
	
	//method to display evaluation results
	public static String handEvaluation(Hand hand){
		//put in logic to evaluate the various evaluations and display the evalution
		String evaluation = "";
		
		if(Hand.isPair(hand)){
			evaluation = "Pair";
		}
		
		else if(Hand.isTwoPair(hand)){
			evaluation =  "Two Pair"; 
		}
		
		else if (Hand.isThreeKind(hand)){
			evaluation = "Three of a Kind";
		}
		
		else if (Hand.isFourKind(hand)){
			evaluation = "Four of a Kind";
		}
		
		else if(Hand.isFullHouse(hand)){
			evaluation = "Full House";
		}
		
		else if (Hand.isStraight(hand) && !Hand.isFlush(hand)){
			evaluation = "Straight";
		}
		
		else if (Hand.isStraight(hand) && Hand.isFlush(hand)){
			evaluation = "Straight Flush";
		}
		else if (Hand.isFlush(hand) && !Hand.isStraight(hand)){
			evaluation = "Flush";
		}
		else {
			evaluation = "High Card";
		}
		
		return evaluation;
	}
	
	
	//method to evaluate if hand is a pair
	public static boolean isPair(Hand hand){
		boolean pair = false;
		int [] score = faceScore(hand);
		
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
	public static boolean isThreeKind(Hand hand){
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
	public static boolean isTwoPair(Hand hand){
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
	public static boolean isFullHouse(Hand hand){
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
	public static boolean isFourKind(Hand hand){
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
	public static boolean isStraight(Hand hand){
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
	
	public static boolean isFlush(Hand hand){
		boolean isFlush = false;
		
		int [] score = Hand.suitScore(hand);
		
		if(score[0] == 5 || score[1] == 5 || score[2] == 5 || score[3] == 5){
			isFlush = true;
		}
		
		return isFlush;
	}

	
	

}
