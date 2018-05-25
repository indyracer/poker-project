import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {
	
	public class Card{
		private String face;
		private String suit;

		//constructor to initialize a card
		public Card(String cardFace, String cardSuit){
			face = cardFace;
			suit = cardSuit;
		}
		
		public String toString(){
			return face + " of " + suit;
		}
		
		public String getCardFace(){
			return face;
		}
		
		public String getCardSuit(){
			return suit;
		}
		
	}

	/*
	 * checks that a card has a face value
	 */
	@Test
	public void FaceTest() {
		Card card1 = new Card("Three", "Diamond");
		
		assertEquals("Three", card1.face);
		assertFalse(card1.face.equalsIgnoreCase("Two")); //checks that face isn't another value than Three
		assertEquals("Three", card1.getCardFace());
	}
	
	/*
	 * checks that a card has a suit value
	 */
	@Test
	public void SuitTest(){
		Card card = new Card("Five", "Hearts");
		
		assertEquals("Hearts", card.suit);
		assertFalse(card.suit.equals("diamond"));
		assertEquals("Hearts", card.getCardSuit());
	}
	
	/*
	 * checks that the toString value is set correctly
	 */
	@Test
	public void ToStringTest(){
		Card card1 = new Card("Two", "Spade");
		
		assertEquals("Two of Spade", card1.toString());
	}
	
	

}
