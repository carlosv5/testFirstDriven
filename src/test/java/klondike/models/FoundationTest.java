package klondike.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import klondike.models.builders.CardBuilder;
import klondike.models.builders.FilledFoundationBuilder;
import klondike.models.builders.FoundationBuilder;

public class FoundationTest {

	private Suit suit = Suit.PIKES;
	
	private Foundation createFoundation() {
		return new FoundationBuilder().suit(this.suit).build();
	}
	
	private List<Card> getCards(){
		List<Card> cards = new ArrayList<Card>();
		cards.add(new CardBuilder().number(Number.AS).suit(this.suit).facedUp().build());
		cards.add(new CardBuilder().number(Number.TWO).suit(this.suit).facedUp().build());
		return cards;
	}
	
	@Test 
	public void testIsCompleted() {
		assertTrue(new FilledFoundationBuilder().number(Number.KING).build().isComplete());
	}
	
	@Test 
	public void testIsNotCompleted() {
		Foundation foundation = new FilledFoundationBuilder().number(Number.QUEEN).build();
		assertFalse(foundation.isComplete());
	}

	@Test 
	public void testFitsInEmptyWithAs() {
		Foundation foundation = new FoundationBuilder().suit(this.suit).build();
		assertTrue(foundation.fitsIn(new CardBuilder().number(Number.AS).suit(this.suit).build()));
	}
	
	@Test 
	public void testFitsInEmptyWithAsWrongSuit() {
		Foundation foundation = new FoundationBuilder().suit(this.suit).build();
		assertFalse(foundation.fitsIn(new CardBuilder().number(Number.AS).suit(Suit.CLOVERS).build()));
	}
	
	@Test 
	public void testFitsInEmptyWithWrongNumber() {
		Foundation foundation = new FoundationBuilder().suit(this.suit).build();
		assertFalse(foundation.fitsIn(new CardBuilder().number(Number.QUEEN).suit(this.suit).build()));
	}
	
	@Test 
	public void testFitsInWithNotEmpty() {
		Foundation foundation = this.createFoundationWithCards();
		assertTrue(foundation.fitsIn(new CardBuilder().number(Number.THREE).suit(this.suit).build()));
	}
	
	@Test 
	public void testFitsInNotEmptyWithWrongNumber() {
		Foundation foundation = this.createFoundationWithCards();
		assertFalse(foundation.fitsIn(new CardBuilder().number(Number.FOUR).suit(this.suit).build()));
	}
	
	@Test 
	public void testFitsInNotEmptyWithWrongSuit() {
		Foundation foundation = this.createFoundationWithCards();
		assertFalse(foundation.fitsIn(new CardBuilder().number(Number.THREE).suit(Suit.CLOVERS).build()));
	}

	private Foundation createFoundationWithCards() {
		Foundation foundation = new FoundationBuilder().suit(this.suit).
				card(this.getCards().get(0)).
				card(this.getCards().get(1)).build();
		return foundation;
	}

	@Test
	public void testEmptyWithEmpty() {
		Foundation foundation = this.createFoundation();
		assertTrue(foundation.empty());
	}

	@Test
	public void testEmptyWithNotEmpty() {
		Foundation foundation = this.createFoundation();
		foundation.push(this.getCards().get(0));
		assertFalse(foundation.empty());
	}

	@Test
	public void testPushWithEmpty() {
		Foundation foundation = this.createFoundation();
		foundation.push(this.getCards().get(0));
		assertEquals(this.getCards().get(0), foundation.peek());
	}

	@Test
	public void testPushWithNotEmpty() {
		Foundation foundation = this.createFoundation();
		foundation.push(this.getCards().get(0));
		foundation.push(this.getCards().get(1));
		assertEquals(this.getCards().get(1), foundation.peek());
	}

	@Test
	public void testPopEmpty() {
		Foundation foundation = this.createFoundation();
		foundation.push(this.getCards().get(0));
		assertEquals(this.getCards().get(0), foundation.pop());
		assertTrue(foundation.empty());
	}

	@Test
	public void testPopNotEmpty() {
		Foundation foundation = this.createFoundation();
		foundation.push(this.getCards().get(0));
		foundation.push(this.getCards().get(1));
		assertEquals(this.getCards().get(1), foundation.pop());
		assertEquals(this.getCards().get(0), foundation.peek());
	}

}
