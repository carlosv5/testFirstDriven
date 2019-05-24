package klondike.models.builders;

import java.util.ArrayList;
import java.util.List;

import klondike.models.Card;

public class CardListBuilder {

	private List<Card> cards;
	
	public CardListBuilder() {
		this.cards = new ArrayList<Card>();
	}
	
	public CardListBuilder card(Card card) {
		this.cards.add(card);
		return this;
	}
	
	public List<Card> build(){
		return this.cards;
	}
	
}
