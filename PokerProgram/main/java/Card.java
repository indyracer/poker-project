
public class Card {

	protected String face;
	protected String suit;

	//constructor to initialize a card
	public Card(String cardFace, String cardSuit){
		face = cardFace;
		suit = cardSuit;
	}
	
	public String getCardFace(){
		return face;
	}
	
	public String getCardSuit(){
		return suit;
	}
	
}
