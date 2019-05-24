package klondike.models.builders;

import java.util.ArrayList;
import java.util.List;

import klondike.models.Card;
import klondike.models.Pile;

public class PileBuilder {

	private List<Card> cardList;
	
	public PileBuilder() {
		this.cardList = new ArrayList<Card>();
	}
	
	public PileBuilder card(Card card) {
		this.cardList.add(card);
		return this;
	}
	
	public PileBuilder card() {
		this.cardList.add(new CardBuilder().build());
		return this;
	}
	
	public Pile build() {
		if (cardList.isEmpty()) {
			List<Card> cards = new ArrayList<Card>();
			cards.add(new CardBuilder().build());
			Pile pile = new Pile(0, cards);
			pile.pop();
			return pile;
		}
		return new Pile(0, this.cardList);
	}
	
	
}
