
public class PlayPoker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hand hand = new Hand();
		
		Card [] cards = {hand.card1, hand.card2, hand.card3, hand.card4, hand.card5};
		
		System.out.println(hand.toString());
		System.out.println(Hand.handEvaluation(cards));
	}

}
