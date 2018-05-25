
public class Deck {
	protected Card deck[];
	protected int currentCard = -1;
	

	//constructor
	public Deck(){
		String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
		

		deck = new Card[52];

		//populate deck with cards
		for (int count = 0; count < deck.length; count++){
			deck[count] = new Card(faces[count % 13], suits[count / 13]);
		}
	}

	public void shuffle(){
		//for each card, pick another random card and swap them
		for(int first = 0; first < deck.length; first++){
			int second = (int)(Math.random() * 52);
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	
	public Card dealCard(){
		Card tempCard = deck[++currentCard];
		return tempCard;
	}
	
	public static boolean isPair(Card card1, Card card2, Card card3, Card card4, Card card5){
		boolean pair = false;
		int score = 0;

		if(card1.face.equals(card2.face) || card1.face.equals(card3.face) || card1.face.equals(card4.face) || card1.face.equals(card5.face)){
			score++;
		}
		if(card2.face.equals(card3.face) || card2.face.equals(card4.face) || card2.face.equals(card5.face)){
			score++;
		}
		if(card3.face.equals(card4.face) || card3.face.equals(card5.face)){
			score++;
		}
		if(card4.face.equals(card5.face)){
			score++;
		}

		//if score == 1, then only one pair
		if(score == 1){
			pair = true;
		}

		return pair;
	}
	
	

}
