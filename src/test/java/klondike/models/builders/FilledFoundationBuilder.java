package klondike.models.builders;

import klondike.models.Foundation;
import klondike.models.Number;
import klondike.models.Suit;

public class FilledFoundationBuilder {
	
	private Suit suit;
	
	private Number number;
	
	public FilledFoundationBuilder() {
		this.suit = Suit.PIKES;
	}
	
	public FilledFoundationBuilder suit(Suit suit) {
		this.suit = suit;
		return this;
	}
	
	public FilledFoundationBuilder number(Number number) {
		this.number = number;
		return this;
	}
	
	public Foundation build() {
		FoundationBuilder foundationBuilder = new FoundationBuilder();
		for(int i=0; i<=this.number.ordinal(); i++) {
			foundationBuilder.card(new CardBuilder().number(Number.values()[i]).suit(this.suit).build());
		}
		return foundationBuilder.build();
	}

}
