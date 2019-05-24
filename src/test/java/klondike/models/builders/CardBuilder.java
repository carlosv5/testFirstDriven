package klondike.models.builders;

import klondike.models.Card;
import klondike.models.Number;
import klondike.models.Suit;

public class CardBuilder {

    private Suit suit;

    private Number number;

    private boolean facedUp;
    
    public CardBuilder() {
    	this.suit = Suit.CLOVERS;
    	this.number = Number.AS;
    	this.facedUp = false;
    }
    
    public CardBuilder suit(Suit suit) {
    	this.suit = suit;
    	return this;
    }
    
    public CardBuilder number(Number number) {
    	this.number = number;
    	return this;
    }
    
    public CardBuilder facedUp() {
    	this.facedUp = true;
    	return this;
    }
    
    public Card build() {
    	Card card = new Card(this.suit, this.number);
    	if (this.facedUp) {
    		card.flip();
    	}
    	return card;
    }

}
