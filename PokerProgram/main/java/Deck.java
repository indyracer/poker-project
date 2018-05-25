
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
	
	

}
