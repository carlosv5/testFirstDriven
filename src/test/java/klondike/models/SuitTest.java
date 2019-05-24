package klondike.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuitTest {

	private char[] getInitials() {
		char[] initials = new char[Suit.values().length];
		for (Suit suit : Suit.values()) {
			initials[suit.ordinal()] = suit.name().charAt(0);
		}
		return initials;
	}

	@Test
	public void testInitials() {
		for (int i = 0; i < this.getInitials().length; i++) {
			assertEquals(this.getInitials()[i], Suit.initials()[i]);
		}
	}

	@Test
	public void testFind() {
		for (int i = 0; i < this.getInitials().length; i++) {
			assertEquals(Suit.values()[i], Suit.find(this.getInitials()[i]));
		}
	}

	@Test
	public void testFindNull() {
		assertEquals(null, Suit.find(' '));
	}

}
