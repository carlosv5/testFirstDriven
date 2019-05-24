package klondike.models;

public class Card {

    private Suit suit;

    private Number number;

    private boolean facedUp;

    public Card(Suit suit, Number number) {
        assert suit != null;
        assert number != null;
        this.suit = suit;
        this.number = number;
        this.facedUp = false;
    }

    public Card flip() {
        this.facedUp = !this.facedUp;
        return this;
    }

    public boolean isNextTo(Card card) {
        return (this.getNumber().getValue() - 1) == card.getNumber().getValue();
    }

    public boolean isFacedUp() {
        return facedUp;
    }

    public Number getNumber() {
        return this.number;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Color getColor() {
        return this.suit.getColor();
    }

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", number=" + number + ", facedUp=" + facedUp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (facedUp ? 1231 : 1237);
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (facedUp != other.facedUp)
			return false;
		if (number != other.number)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
	
	

}
